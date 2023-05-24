package prenotazione;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bernardi.nicola
 */
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket sSocket = new ServerSocket(50000);
        Socket clientSocket;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        double costoPren, costoTot = 0, prezzoMag = 0;
        PrenotazioneAerea pa, paPm = null;     // paPM: prenotazione con prezzo maggiore
        
        while (true) {
            costoPren = 0;
            
            clientSocket = sSocket.accept();
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
            
            pa = (PrenotazioneAerea)ois.readObject();
            if(pa.getnBiglietti()==0){
                System.out.println("\n\t Costo complessivo: " + costoTot);
                System.out.println("Prenotazione con costo maggiore: \n");
                if(paPm==null)
                    System.out.println("Nessuna prenotazione registrata.");
                else
                    System.out.println(paPm);
                System.out.println("Prezzo maggiore: " + prezzoMag);
                oos.writeDouble(costoTot);
                oos.flush();
                oos.writeObject(paPm);
                oos.flush();
                clientSocket.close();
                System.out.println("\n\n\t\tSocket chiuso");
                pa = null;
                paPm = null;
                costoTot = 0; prezzoMag = 0;
                continue;
            }
            
            costoPren += pa.getnBiglietti() * pa.getPrezzoSingoloBiglietto();        // calcolo prezzo biglietti
            costoPren += pa.getPesoBagaglio() * pa.getPrezzoBagaglioAlKg();
            costoPren += pa.getPrezzoSingolaPolizza() * pa.getnPolizeA();
            
            System.out.println("\nCodice prenotazione: " + pa.getCodiceP());
            System.out.println("Numero biglietti: " + pa.getnBiglietti());
            System.out.println("Prezzo a biglietto: " + pa.getPrezzoSingoloBiglietto());
            System.out.println("Peso bagaglio: " + pa.getPesoBagaglio());
            System.out.println("Prezzo al kg di bagaglio: " + pa.getPrezzoBagaglioAlKg());
            System.out.println("Numero polizze assicurative: " + pa.getnPolizeA());
            System.out.println("Prezzo a polizza: " + pa.getPrezzoSingolaPolizza());
            System.out.println("\n\t Costo totale prenotazione: " + costoPren + " Euro.");
            
            costoTot += costoPren;
            if(costoPren > prezzoMag) {
                prezzoMag = costoPren;
                paPm = pa;
            }
            
            oos.writeDouble(costoPren);
            oos.flush();
            
        }
    }
}

package prenotazione;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author bernardi.nicola
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        Scanner sc = new Scanner(System.in);
        PrenotazioneAerea pa;
        //DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        String cP = ""; // codice prenotazione
        byte numBig, kgBag, numPolizze;
        float prezzoBig, prezzoBagKg, prezzoPolizza;
        
        while (true) {
            socket = new Socket(InetAddress.getLocalHost(), 50000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            numBig = -1;
            
            while(numBig<0){
                System.out.println("\nInserisci numero biglietti (0 per uscire)");
                numBig = sc.nextByte();
            }
            if(numBig==0){
                pa= new PrenotazioneAerea((byte)0);
                oos.writeObject(pa);
                oos.flush();
                break;
            }
            
            System.out.println("Inserire il codice di prenotazione");
            cP = sc.next();
            System.out.println("Inserire la quantità totale (in Kg) di bagaglio in stiva");
            kgBag = sc.nextByte();
            System.out.println("Inserire il numero di polizze assicurative");
            numPolizze = sc.nextByte();
            System.out.println("Inserire il prezzo del singolo biglietto");
            System.out.print("Euro: ");
            prezzoBig = (float)sc.nextFloat();
            System.out.println("Inserire il prezzo del bagaglio in stiva al chilogrammo");
            System.out.print("Euro: ");
            prezzoBagKg = (float)sc.nextFloat();
            System.out.println("Inserire il prezzo di una polizza");
            System.out.print("Euro: ");
            prezzoPolizza = (float)sc.nextFloat();
            
            pa = new PrenotazioneAerea(cP, numBig, kgBag, numPolizze, prezzoBig, prezzoBagKg, prezzoPolizza);
            oos.writeObject(pa);
            oos.flush();
            
            double prezzoTotPren = ois.readDouble();
            System.out.println("\n\t Prezzo totale prenotazione: Euro: " + prezzoTotPren);
        }
        double prezzoComp = ois.readDouble();
        PrenotazioneAerea paPm = (PrenotazioneAerea)ois.readObject();
        System.out.println("\n\t Prezzo complessivo: Euro: " + prezzoComp);
        if(paPm==null)
            System.out.println("Nessuna prenotazione ha il costo maggiore");
        else
            System.out.println("\nPrenotazione col costo maggiore: \n " + paPm);
        socket.close();
    }
}

package prenotazione;

import java.io.Serializable;

/**
 *
 * @author bernardi.nicola
 */
public class PrenotazioneAerea implements Serializable {
    private String codiceP;
    private byte nBiglietti;
    private byte pesoBagaglio;
    private byte nPolizeA;
    private float prezzoSingoloBiglietto;
    private float prezzoBagaglioAlKg;
    private float prezzoSingolaPolizza;

    public PrenotazioneAerea(String codiceP, byte nBiglietti, byte pesoBagaglio, byte nPolizeA, float prezzoSingoloBiglietto, float prezzoBagaglioAlKg, float prezzoSingolaPolizza) {
        this.codiceP = codiceP;
        this.nBiglietti = nBiglietti;
        this.pesoBagaglio = pesoBagaglio;
        this.nPolizeA = nPolizeA;
        this.prezzoSingoloBiglietto = prezzoSingoloBiglietto;
        this.prezzoBagaglioAlKg = prezzoBagaglioAlKg;
        this.prezzoSingolaPolizza = prezzoSingolaPolizza;
    }

    /**
     * Questo costruttore serve per creare l'oggetto per uscire.
     * @param nBiglietti va impostato a 0
     */
    public PrenotazioneAerea(byte nBiglietti) {
        this.nBiglietti = nBiglietti;
        this.codiceP = null;
        this.pesoBagaglio = 0;
        this.nPolizeA = 0;
        this.prezzoSingoloBiglietto = 0;
        this.prezzoBagaglioAlKg = 0;
        this.prezzoSingolaPolizza = 0;
    }

    public String getCodiceP() {
        return codiceP;
    }

    public byte getnBiglietti() {
        return nBiglietti;
    }

    public byte getPesoBagaglio() {
        return pesoBagaglio;
    }

    public byte getnPolizeA() {
        return nPolizeA;
    }

    public float getPrezzoSingoloBiglietto() {
        return prezzoSingoloBiglietto;
    }

    public float getPrezzoBagaglioAlKg() {
        return prezzoBagaglioAlKg;
    }

    public float getPrezzoSingolaPolizza() {
        return prezzoSingolaPolizza;
    }

    public void setCodiceP(String codiceP) {
        this.codiceP = codiceP;
    }

    public void setnBiglietti(byte nBiglietti) {
        this.nBiglietti = nBiglietti;
    }

    public void setPesoBagaglio(byte pesoBagaglio) {
        this.pesoBagaglio = pesoBagaglio;
    }

    public void setnPolizeA(byte nPolizeA) {
        this.nPolizeA = nPolizeA;
    }

    public void setPrezzoSingoloBiglietto(float prezzoSingoloBiglietto) {
        this.prezzoSingoloBiglietto = prezzoSingoloBiglietto;
    }

    public void setPrezzoBagaglioAlKg(float prezzoBagaglioAlKg) {
        this.prezzoBagaglioAlKg = prezzoBagaglioAlKg;
    }

    public void setPrezzoSingolaPolizza(float prezzoSingolaPolizza) {
        this.prezzoSingolaPolizza = prezzoSingolaPolizza;
    }

    @Override
    public String toString() {
        return "Codice prenotazione: " + codiceP + "\nNumero biglietti: " + nBiglietti + "\nPeso bagaglio: " + pesoBagaglio + 
                "\nNumero polizze: " + nPolizeA + "\nPrezzo a biglietto: " + prezzoSingoloBiglietto + "\nPrezzo al kg del bagaglio: " + prezzoBagaglioAlKg + 
                "\nPrezzo singola polizza: " + prezzoSingolaPolizza;
    }
    
    
    
}

# TCPCompagniaAerea
Di seguito il testo della verifica:
## Problema
Un’agenzia di viaggi (client) invia una o più prenotazioni aeree (oggetti) ad una compagnia aerea (server).
Ogni prenotazione deve avere le seguenti caratteristiche:
- codice prenotazione (stringa);
- numero di biglietti (numero byte);
- quantità di chili del bagaglio da stiva (numero byte);
- numero di polizze assicurative (numero byte);
- prezzo del singolo biglietto (numero con la virgola);
- prezzo del singolo chilo di bagaglio (numero con la virgola);
- prezzo della singola polizza assicurativa (numero con la virgola).
### Prima parte (voto fino a 7)
Il client invia di volta in volta al server la singola prenotazione, fino a quando gli invierà come
condizione di uscita il numero di biglietti uguale a 0.
Il server, ricevuta ogni prenotazione dal client, ne visualizza i dati e invia al client il costo totale
della singola prenotazione (numero con la virgola) che viene visualizzato dal client.
Quando il server riceve l’oggetto che ha numero di biglietti uguale a 0, chiude la connessione col
client.
### Seconda parte (voto da 7 a 10)
Il server calcola il costo totale delle prenotazioni e, quando il client gli invia la prenotazione con
numero di biglietti uguale a 0, glielo invia. Il client lo visualizza.
Il server determina la prenotazione dal costo maggiore e la invia al client che ne visualizza i dati.


- Vi invito a [Visitare il mio sito](https://nbernardi.tk)

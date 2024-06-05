package pratica;

import java.util.*;

public class Pratica {

    //IL GIOCO E' IMPOSTATO SU 5 LIVELLI, NON 6,  SENZA L'IMPICCATO
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        String[] livelliCompletati = new String[6];
        String[] livelliNonCompletati = new String[6];
        livelliNonCompletati[0] = "1. I numeri fortunati";
        livelliNonCompletati[1] = "2. La prova del brusco coraggio";
        livelliNonCompletati[2] = "3. Conosci bene o male Bruschi?";
        livelliNonCompletati[3] = "4. Trova il numero";
        livelliNonCompletati[4] = "5. L'anagramma";
        livelliNonCompletati[5] = "6. L'impiccato";
        /* Ho impostati "livelliNonCompletati" in questo modo per poter poi eliminare ad ogni ciclo di livello completato 
        l'opzione di scelta del gioco che si è recentemente completato, nel caso l'utente rischiacci lo stesso gioco, gli darà errore */
        int vittorie = 0;
        int risultato1 = 0, risultato2 = 0, risultato4 = 0, risultato5 = 0;
        int risultato3, risultato6 = 0;
        int finale = 0;
        System.out.println("Benvenuto nel gioco di Daniele Bruschi! ");
        System.out.println("");
        for (int i = 0; i < livelliCompletati.length; i++) { //Inizializzazione dell'array livelliCompletati per mostrare i giochi completati
            livelliCompletati[i] = "";
        }

        do {
            risultato3 = 0;
            System.out.println("Scegli il gioco:");
            System.out.println("---------------------------------------------");
            // Per risparmiare un po' di S.o.p.
            for (String livelliNonCompletati1 : livelliNonCompletati) {
                System.out.println(livelliNonCompletati1);
            }
            System.out.println("---------------------------------------------");
            System.out.println("ATTENZIONE! Per giocare al terzo gioco, e' necessario completarli tutti.");
            System.out.println("");
            System.out.println("Giochi completati:");

            for (String livelliCompletati1 : livelliCompletati) {
                System.out.println(livelliCompletati1);
            }
            System.out.println("---------------------------------------------");
            System.out.println(" ");
            int scelta = tastiera.nextInt();

            switch (scelta) {

                case 1:
                    if (risultato1 > 0) {
                        System.out.println("Hai gia' completato il gioco: I NUMERI FORTUNATI");

                    }
                    if (risultato1 == 0) {

                        System.out.println("Hai scelto il gioco: I NUMERI FORTUNATI, la prova comincia: ");
                        risultato1 = Bruschiniano.primogioco(vittorie, livelliCompletati, livelliNonCompletati);
                    }
                    break;
                case 2:
                    if (risultato2 == 1) {
                        System.out.println("Hai gia' completato il gioco: LA PROVA DEL BRUSCO CORAGGIO, scegli un altro gioco:");
                    }
                    if (risultato2 == 0) {

                        System.out.println("Hai scelto il gioco: LA PROVA DEL BRUSCO CORAGGIO, iniziamo!: ");
                        risultato2 = Bruschiniano.secondogioco(vittorie, livelliCompletati, livelliNonCompletati);
                    }
                    break;
                case 3:
                    risultato3 = risultato1 + risultato2 + risultato4 + risultato5 + risultato6;
                    if (risultato3 != 4) {
                        System.out.println("EHI!! Non hai completato tutti i giochi a tema Bruschi");
                        System.out.println(" ");
                        finale = 0; // Serve per azzerare risultato3 nel caso l'utente riprovi ad accedere al gioco finale
                    } else if (risultato3 == 4) {
                        System.out.println("Hai scelto il gioco: CONOSCI BENE O MALE BRUSCHI?, la prova comincia: ");
                        finale = Bruschiniano.giocoFinale(vittorie, livelliCompletati, livelliNonCompletati);
                    }
                    break;
                case 4:
                    if (risultato4 == 1) {
                        System.out.println("Hai gia' completato il gioco: TROVA IL NUMERO, scegli un altro gioco:");
                    }
                    if (risultato4 == 0) {
                        System.out.println("Hai scelto il gioco: TROVA IL NUMERO, lessgo!");
                        risultato4 = Bruschiniano.quartogioco(vittorie, livelliCompletati, livelliNonCompletati);
                    }
                    break;
                case 5:
                    if (risultato5 == 1) {
                        System.out.println("Hai gia' completato il gioco: ANAGRAMMA, scegli un altro gioco:");
                    }
                    if (risultato5 == 0) {
                        System.out.println("Hai scelto il gioco: ANAGRAMMA, lessgo!");
                        risultato5 = Bruschiniano.quintogioco(vittorie, livelliCompletati, livelliNonCompletati);
                    }
                    break;
                case 6:
                    if (risultato6 == 1) {
                        System.out.println("Hai gia' completato il gioco: L'IMPICCATO, scegli un altro gioco:");

                    }
                    if (risultato6 == 0) {
                        System.out.println("Hai scelto il gioco: L'IMPICCATO, woww!");
                        risultato6 = Bruschiniano.sestogioco(vittorie, livelliCompletati, livelliNonCompletati);

                    }
                    break;
                default:
                    System.out.println("---------------------------------------------");
                    System.out.println("SCEGLI TRA LE SEGUENTI OPZIONI DISPONIBILI QUI SOPRA ELENCATE:");
                    System.out.println("---------------------------------------------");

            }
            if (risultato1 < 0 || risultato2 < 0 || finale < 0 || risultato4 < 0 || risultato5 < 0 || risultato6 < 0) {
                break;
            }

        } while (finale == 0);
        if (finale == 1) {
            Bruschiniano.finale();
        }
        tastiera.close(); //Chiudo la classe Scanner
    }
}

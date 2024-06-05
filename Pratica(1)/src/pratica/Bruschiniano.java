package pratica;

import java.util.*;
import static pratica.Secondaria.paroleAnagrammaDelPC;

public class Bruschiniano {

    private static int i;
    private static String prova1 = "";
    private static final Scanner tastiera = new Scanner(System.in);

    public static int primogioco(int vittorie, String[] livelliCompletati, String livelliNonCompletati[]) {
        boolean x = false;
        int numeri;
        char risposta1 = 0;
        char risposta2;
        int risposteGiuste = 0;
        int rispostaSbagliata;
        int[] numeriUsciti = new int[4];
        int[] numeriUtente = new int[4];
        int[] numeriGioco = {0, 1, 2, 3};
        numeriGioco[0] = 3;
        numeriGioco[1] = 5;
        numeriGioco[2] = 7;
        numeriGioco[3] = 28;
        System.out.println("---------------------------------------------");
        System.out.println("Benvenuto! Il gioco e' semplice: indovina i numeri fortunati di Daniele");
        System.out.println(" ");
        do {
            tastiera.nextInt(); //Buffer per la tastiera
            if (risposta1 == 's' || risposta1 == 'S') {
                for (i = 0; i < numeriUtente.length; i++) { //buffer per i numeri dell'utente e quelli usciti
                    numeriUtente[i] = 0;
                    numeriUsciti[i] = 0;
                }
                x = false; //buffer per il primo ciclo
                risposta1 = 0; //buffer per la scelta di voler ricominciare o no il primo gioco
                System.out.println("SI RICOMINCIA!");
                System.out.println("---------------------------------------------");
                String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                System.out.println(faccina);
                System.out.println();
            }

            // INIZIO GIOCO
            System.out.println("Scegli i numeri: (sono 4)");
            for (i = 0; i < numeriGioco.length; i++) {
                rispostaSbagliata = 0; //buffer se l'utente ha sbagliato
                System.out.print("Scegli il " + (i + 1) + " numero fortunato di Daniele: ");
                numeriUtente[i] = tastiera.nextInt();
                while (x) { //x=false perché deve fare prima un ciclo

                    for (int j = 0; j < numeriUtente.length; j++) { //controllo se l'utente ha già inserito quel numero
                        if (numeriUtente[i] == numeriUsciti[j]) { // controllo tutti i numeri da k

                            System.out.print("Numero gia' inserito, scegli un altro numero: ");
                            numeri = tastiera.nextInt();

                            while (numeriUtente[i] == numeri) { //controllo se l'utente ha di nuovo inserito uno stesso numero
                                System.out.println("Non puoi inserire di nuovo lo stesso numero, rifai");
                                numeriUtente[i] = tastiera.nextInt();

                            }
                            numeriUtente[i] = numeri; //Per risolvere il problema del secondo while, se no mi blocca qualsiasi nuovo/vecchio numero(spero sia così)
                            j = 0; // per rivedere tutti i numeri, se l'utente ha inserito 1 e 2, e verifico solamente uno dei due, con l'altro passerà
                        }
                    }
                    break;
                }
                x = true; //per fare poi il cotrollo delle parole col for sopra
                for (int j = 0; j < numeriGioco.length; j++) {

                    if (numeriUtente[i] == numeriGioco[j]) {
                        System.out.println(" --> WOW! Conosci un numero fortunato di Daniele! <-- ");
                        System.out.println("---------------------------------------------");
                        risposteGiuste++;

                    } else {
                        rispostaSbagliata++;
                    }
                }
                if (rispostaSbagliata == 4) {
                    System.out.println("Cavolo... non conosci abbastanza Daniele, vergognati!");
                    System.out.println("---------------------------------------------");
                }
                numeriUsciti[i] = numeriUtente[i];

            }
            if (risposteGiuste == 1) {
                System.out.println("Hai indovinato SOLAMENTE " + risposteGiuste + " numero");
                System.out.println("SONO MOLTO DELUSO, non meriti la mia amicizia.");
                risposteGiuste = 0; //reset se vuole ritentare il gioco
                System.out.println(" ");
                System.out.println("Sono magnanimo,[;)] vuoi ritentare? (Si/No):");
                risposta1 = tastiera.next().toLowerCase().charAt(0);
                while (risposta1 != 's' && risposta1 != 'n') { //Risposta non adeguata, riscrittura di si o no (

                    /* l'operatore || nel loop, se l'utente inseriva qualsiasi carattere diverso da 's', il ciclo continuava a iterare. 
   Cambiando l'operatore a &&, il ciclo continuerà a chiedere all'utente di inserire una risposta 
   finché non inserisce 's' o 'n', che sono le uniche due risposte accettabili. */
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta1 = tastiera.next().toLowerCase().charAt(0);
                }
            } else if (risposteGiuste != 4) {
                System.out.println("Hai indovinato SOLAMENTE " + risposteGiuste + " numeri");
                System.out.println("SONO MOLTO DELUSO, non meriti la mia amicizia.");
                risposteGiuste = 0; //reset se vuole ritentare il gioco
                System.out.println(" ");
                System.out.println("Sono magnanimo,[;)] vuoi ritentare? (Si/No):");
                risposta1 = tastiera.next().toLowerCase().charAt(0);

                while (risposta1 != 's' && risposta1 != 'n') { // Stessa operazione della precedente
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta1 = tastiera.next().toLowerCase().charAt(0);
                }
            }
        } while (risposta1 == 's');
        System.out.println();
        if (risposteGiuste == 4) {
            System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
            System.out.println("Congratulazioni! Hai superato il primo gioco.");
            System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
            vittorie = vittorie + 1;
            prova1 = "";
            livelliNonCompletati[0] = prova1;
            for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai "giochi completati" degli spazi vuoti, che sono brutti da vedere
                if (livelliCompletati[i].equals("")) {
                    livelliCompletati[i] = (i + 1) + ". I numeri fortunati";
                    break;
                }

            }
            return vittorie;
        } else {
            System.out.println("Non hai completato il primo gioco.");
            System.out.println("Vuoi smettere completamente? Si/No");
            risposta2 = tastiera.next().charAt(0);
            while (risposta2 != 's' && risposta2 != 'n') { // Stessa operazione della precedente
                System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                risposta2 = tastiera.next().toLowerCase().charAt(0);
            }

            if (risposta2 == 's' || risposta2 == 'S') {
                vittorie = vittorie - 1;

                return vittorie;
            } else {
                return 0;
            }

        }
    }

    static int secondogioco(int vittorie, String[] livelliCompletati, String[] livelliNonCompletati) {
        int risposta = 0;
        int ritenta = 0;
        System.out.println("---------------------------------------------");
        System.out.println("Benvenuto! Il tutto e' semplice:");
        do {
            tastiera.nextInt(); //Buffer per la tastiera
            do {
                if (risposta < 0) {
                    System.out.println("Hai perso, vuoi ritentare? (Si/No):");//PER RITENTAREEEEEEEEEEEEEEEEEEEEEE
                    char risposta0 = tastiera.next().toLowerCase().charAt(0);
                    while (risposta0 != 's' && risposta0 != 'n') { // Stessa operazione delle precedenti
                        System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                        risposta0 = tastiera.next().toLowerCase().charAt(0);
                    }
                    if (risposta0 == 'S') {
                        System.out.println("---------------------------------------------");
                        System.out.println("SI RICOMINCIA, da capo:");
                        System.out.println("---------------------------------------------");
                        String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                        System.out.println(faccina);
                    } else {
                        System.out.println("Non hai completato il secondo gioco.");
                        System.out.println("Vuoi smettere completamente? Si/No");

                        char risposta2 = tastiera.next().toLowerCase().charAt(0);
                        while (risposta2 != 's' && risposta2 != 'n') { // Stessa operazione delle precedenti
                            System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                            risposta2 = tastiera.next().toLowerCase().charAt(0);
                        }
                        if (risposta2 == 's') {
                            vittorie = vittorie - 1; // necessario per il while-do alla fine del main

                            return vittorie;

                        } else {
                            return 0;
                        }
                    }

                }
                System.out.println("Devi capire come pensa Daniele, e in quali momenti migliori mostrare il proprio coraggio!");
                System.out.println("---------------------------------------------");
                if (ritenta == 0) {
                    System.out.println("Sono 2 domande molto difficili... VEDIAMO!");
                }
                System.out.println(" ");
                System.out.println("Come reputi la tua amicizia Bruschiniana??");
                System.out.println("");
                System.out.println("1. Rose e fiori, la vita e' composta solamente da felicita', armonia e zucchero filato;");
                System.out.println("2. Un'amicizia che e' come una strada tortuosa: con alti e bassi, ma ancora viaggiabile.");
                System.out.println("3. Si possono migliorare alcune cose, ma con impegno e pratica, si puo' sempre fare meglio.");
                System.out.println("4. Una schifo totale, era meglio non parlarci con quel RIFIUTO UMANO");
                int scelta = tastiera.nextInt();
                switch (scelta) {
                    case 1 -> {
                        System.out.println("ERRATO! Secondo te si puo' mai avere un'amicizia cosi' bella?? Magari...");
                        System.out.println("---------------------------------------------");
                        risposta = risposta - 1;
                        ritenta = ritenta + 1;
                    }
                    case 2 -> {
                        System.out.println("Sbagliato! E' vero che niente e' perfetto, non e' altro come l'equilibrio tra l'impossibile e il possibile.");
                        System.out.println("---------------------------------------------");
                        risposta = risposta - 1;
                        ritenta += 1;
                    }
                    case 3 -> {
                        System.out.println("Fallace! Non e' la risposta che volevo.");
                        System.out.println("---------------------------------------------");
                        risposta = risposta - 1;
                        ritenta += 1;
                    }
                    case 4 -> {
                        System.out.println("Giustoo! Cos'e' la prova del coraggio se non hai il coraggio di dire la genuina verita'?? GRANDE!");
                        System.out.println("---------------------------------------------");
                        risposta = 0;
                    }
                    default -> {
                        System.out.println("---------------------------------------------");
                        System.out.println("Scegliere tra le opzioni seguenti elencate:");
                        System.out.println("---------------------------------------------");
                    }
                }
            } while (risposta != 0);
            System.out.println("SECONDA DOMANDA:");
            System.out.println("C'e' la verifica d'informatica e a Daniele sta andando male, che fai per aiutarlo??");
            System.out.println("");
            System.out.println("1. Provi compassione per lui e vi confortate a vicenda;");
            System.out.println("2. Te ne sbatti e gli mostri il dito medio;");
            System.out.println("3. Ti accorgi del problema e cerchi di passargli un biglietto;");
            System.out.println("4. Vedi la sua preoccupazione e, senza pensarci, ti alzi davanti a tutti e lo aiuti");
            int scelta = tastiera.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Nahh, sei molto dolce, ma non e' quello che gli serve.");
                    risposta = -1;
                    ritenta += 1;
                    break;
                case 2:
                    System.out.println("Mi dispiace constatare che hai deluso le mie aspettative. La tua scelta non è all'altezza di ciò che mi aspettavo da te.");
                    risposta = -1;
                    ritenta += 1;
                    break;
                case 3:
                    System.out.println("Ottima scelta, ma non abbastanza per superare la domanda.");
                    risposta = -1;
                    ritenta += 1;
                    break;
                case 4:
                    System.out.println("Corretto! E' un po' imbarazzante, ma non c'e' niente di piu' coraggioso.");
                    risposta = 0;
                    ritenta += 1;
                    break;
            }
        } while (risposta != 0);
        System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        System.out.println("Complimenti! Hai superato il secondo gioco.");
        System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai giochi completati spazi vuoti, che sono brutti da vedere
            if (livelliCompletati[i].equals("")) {
                livelliCompletati[i] = (i + 1) + ". La prova del brusco coraggio";
                break;
            }

        }
        prova1 = "";
        livelliNonCompletati[1] = prova1;
        vittorie += 1;

        return vittorie;
    }

    static int quartogioco(int vittorie, String[] livelliCompletati, String[] livelliNonCompletati) {
        int numCasuale;
        int numUtente;
        int indovinato = 0;
        int giusto = 0;
        Random num = new Random();
        System.out.println("---------------------------------------------");
        System.out.println("Benvenuto! Il tutto e' semplice:");
        System.out.println("Devi trovare il numero generato casualmente dal PC!");
        System.out.println("La quantita' di tentativi e' proporzionata alla difficolta'");
        System.out.println("Per ogni numero sbagliato, verra' in tuo soccorso un indice che ti chiede se il numero casuale e' piu' piccolo o viceversa!");
        System.out.println("Completane uno per avanzare!");
        System.out.println("---------------------------------------------");
        System.out.println(" /|\\ INIZIAMO!! /|\\ ");
        do {
            tastiera.nextInt(); //Buffer per la tastiera
            if (indovinato < 0) {
                indovinato = 0;
                System.out.println("Hai perso, vuoi ritentare? (Si/No):");//PER RITENTAREEEEEEEEEEEEEEEEEEEEEE
                char risposta0 = tastiera.next().toLowerCase().charAt(0);
                while (risposta0 != 's' && risposta0 != 'n') { // Stessa operazione delle precedenti
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta0 = tastiera.next().toLowerCase().charAt(0);
                }
                if (risposta0 == 's') {
                    System.out.println("---------------------------------------------");
                    System.out.println("SI RICOMINCIA, da capo:");
                    System.out.println("---------------------------------------------");
                    String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                    System.out.println(faccina);
                } else {
                    System.out.println("Non hai completato il quarto gioco.");
                    System.out.println("Vuoi smettere completamente? Si/No");

                    char risposta1 = tastiera.next().toLowerCase().charAt(0);
                    while (risposta1 != 's' && risposta1 != 'n') { // Stessa operazione delle precedenti
                        System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                        risposta1 = tastiera.next().toLowerCase().charAt(0);
                    }
                    if (risposta1 == 's') {
                        vittorie = vittorie - 1; // necessario per il while-do alla fine del main

                        return vittorie;

                    } else {
                        return 0;
                    }
                }
            }
            System.out.println("Scegli la difficolta': ");
            System.out.println("1. Facile");
            System.out.println("2. Medio");
            System.out.println("3. Difficile");
            System.out.println("4. Impossibile");
            int scelta = tastiera.nextInt();
            switch (scelta) {
                case 1:
                    numCasuale = num.nextInt(10) + 1;
                    System.out.println("Trova il numero tra 1 a 10");
                    System.out.println("Hai 4 tentativi disponibili, usali bene!");
                    for (i = 0; i < 4; i++) {
                        System.out.print((i + 1) + ". tentativo: ");
                        numUtente = tastiera.nextInt();
                        if (numCasuale > numUtente) {
                            System.out.println("Il tuo numero e' troppo basso");
                        } else if (numCasuale < numUtente) {
                            System.out.println("Il tuo numero e' troppo alto");
                        } else {
                            System.out.println("");
                            System.out.println("Hai indovinato il numero!!");
                            giusto++;
                            indovinato++;
                            break;
                        }
                    }

                    if (giusto == 0) {
                        indovinato--;
                    }
                    break;
                case 2:
                    numCasuale = num.nextInt(100) + 1;
                    System.out.println("Trova il numero tra 1 a 100");
                    System.out.println("Hai 7 tentativi disponibili, usali bene!");
                    for (i = 0; i < 7; i++) {
                        System.out.print((i + 1) + ". tentativo: ");
                        numUtente = tastiera.nextInt();
                        if (numCasuale > numUtente) {
                            System.out.println("Il tuo numero e' troppo basso");
                        } else if (numCasuale < numUtente) {
                            System.out.println("Il tuo numero e' troppo alto");
                        } else {
                            System.out.println("");
                            System.out.println("Hai indovinato il numero!!");
                            giusto++;
                            indovinato++;
                            break;
                        }
                    }
                    if (giusto == 0) {
                        indovinato--;
                    }
                    break;
                case 3:
                    numCasuale = num.nextInt(1000) + 1;
                    System.out.println("Trova il numero tra 1 a 1000");
                    System.out.println("Hai 10 tentativi disponibili, usali bene!");
                    for (i = 0; i < 10; i++) {
                        System.out.print((i + 1) + ". tentativo: ");
                        numUtente = tastiera.nextInt();
                        if (numCasuale > numUtente) {
                            System.out.println("Il tuo numero e' troppo basso");
                        } else if (numCasuale < numUtente) {
                            System.out.println("Il tuo numero e' troppo alto");
                        } else {
                            System.out.println("");
                            System.out.println("Hai indovinato il numero!!");
                            giusto++;
                            indovinato++;
                            break;
                        }
                    }
                    if (giusto == 0) {
                        indovinato--;
                    }
                    break;
                case 4:
                    numCasuale = num.nextInt(10000) + 1;
                    System.out.println("Trova il numero tra 1 a 10000");
                    System.out.println("Hai 15 tentativi disponibili, usali bene!");
                    for (i = 0; i < 15; i++) {
                        System.out.print((i + 1) + ". tentativo: ");
                        numUtente = tastiera.nextInt();
                        if (numCasuale > numUtente) {
                            System.out.println("Il tuo numero e' troppo basso");
                        } else if (numCasuale < numUtente) {
                            System.out.println("Il tuo numero e' troppo alto");
                        } else {
                            System.out.println("");
                            System.out.println("Hai indovinato il numero!!");
                            giusto++;
                            indovinato++;
                            break;
                        }
                    }
                    if (giusto == 0) {
                        indovinato--;
                    }
                    break;
                default:
                    System.out.println("Scegliere tra le opzioni seguenti.");

            }
        } while (indovinato < 0);

        if (indovinato > 0) {
            System.out.println("Congratulazioni! Hai completato il gioco: INDOVINA IL NUMERO");
            System.out.println("---------------------------------------------");
            System.out.println("");
            vittorie += 1;
            for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai "giochi completati" degli spazi vuoti, che sono brutti da vedere
                if (livelliCompletati[i].equals("")) {
                    livelliCompletati[i] = (i + 1) + ". Indovina il numero";
                    break;
                }
            }
            prova1 = "";
            livelliNonCompletati[3] = prova1;
            return vittorie;
        } else {
            return 0;
        }
    }

    static int quintogioco(int vittorie, String[] livelliCompletati, String[] livelliNonCompletati) {
        int anagrammaPerso = 0;
        String generazione1;
        String generazione2;
        Random random = new Random();
        System.out.println("---------------------------------------------");
        System.out.println("Benvenuto nel gioco dell'anagramma!");
        do {
            if (anagrammaPerso == -1) {
                System.out.println("Vuoi ritentare? (Si/No):");//PER RITENTAREEEEEEEEEEEEEEEEEEEEEE
                char risposta0 = tastiera.next().toLowerCase().charAt(0);
                while (risposta0 != 's' && risposta0 != 'n') { // Stessa operazione della precedente
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta0 = tastiera.next().toLowerCase().charAt(0);
                }
                if (risposta0 == 's') {

                    tastiera.nextLine(); // Per pulire il buffer di parola
                    System.out.println("---------------------------------------------");
                    System.out.println("SI RICOMINCIA, da capo:");
                    System.out.println("---------------------------------------------");
                    String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                    System.out.println(faccina);

                } else {
                    System.out.println("Non hai completato il sesto gioco.");
                    System.out.println("Vuoi smettere completamente? Si/No");

                    char risposta1 = tastiera.next().toLowerCase().charAt(0);
                    while (risposta1 != 's' && risposta1 != 'n') { // Stessa operazione della precedente
                        System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                        risposta1 = tastiera.next().toLowerCase().charAt(0);
                    }
                    if (risposta1 == 's') {
                        vittorie = vittorie - 1; // necessario per il while-do alla fine del main
                        return vittorie;

                    } else {
                        return 0;
                    }
                }
            }
            System.out.println("Il tuo obiettivo e' trovare il giusto anagramma della parola che genero");
            System.out.println("Esempio:ROMA --> AMOR");
            System.out.println("Buona fortuna!");
            System.out.println("---------------------------------------------");
            int numeroCasuale = random.nextInt(paroleAnagrammaDelPC.length);
            generazione1 = Secondaria.paroleAnagrammaDelPC(livelliNonCompletati, numeroCasuale);// necessario per scrivere lo stesso anagramma che l'utente deve indovinare
            generazione2 = Secondaria.paroleAnagrammaDaScoprire(livelliNonCompletati, numeroCasuale); // anagramma che l'utente deve scrivere per completare il gioco
            System.out.println("L'anagramma e': " + generazione1);
            System.out.print("Inserisci la parola che pensi sia l'anagramma corretto: ");
            tastiera.nextLine(); //Buffer per la tastiera, se completa un qualsiasi gioco prima, mi dà sbagliato già a prescindere
            String parola = tastiera.nextLine().toLowerCase();
            System.out.println();
            if (parola.equals(generazione2)) {
                System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
                System.out.println("Complimenti! Hai trovato l'anagramma corretto");
                System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
                break; //mi serve perché se l'utente sbaglia l'anagramma e ritenta, gli dà completato il gioco ma gli c hiede di ritentare
            } else {
                System.out.println(":( Sbagliato! :(");
                anagrammaPerso = -1;

            }

        } while (anagrammaPerso == -1);

        for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai "giochi completati" degli spazi vuoti, che sono brutti da vedere
            if (livelliCompletati[i].equals("")) {
                livelliCompletati[i] = (i + 1) + ". L'anagramma";
                break;
            }
        }
        prova1 = "";
        livelliNonCompletati[4] = prova1;
        vittorie += 1;
        return vittorie;

    }

      static int sestogioco(int vittorie, String[] livelliCompletati, String[] livelliNonCompletati) {
        String[] paroleScelte = new String[50];
        char carattere;
        char lettera;
        int corretto;
        int partitaPersa = 0;
        System.out.println("Benvenuto nel gioco dell'impiccato! Ecco delle parole generate casualmente dal programmatore che dovrai indovinare.");
        System.out.println("Tentativi totali: 15");
        System.out.println("Buona fortuna!");
        do {

            if (partitaPersa == -1) {

                System.out.println("Vuoi ritentare? (Si/No):");//PER RITENTAREEEEEEEEEEEEEEEEEEEEEE
                char risposta = tastiera.next().toLowerCase().charAt(0);
                while (risposta != 's' && risposta != 'n') { // Stessa operazione delle precedenti
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta = tastiera.next().toLowerCase().charAt(0);
                }
                if (risposta == 's') {
                    System.out.println("---------------------------------------------");
                    System.out.println("SI RICOMINCIA, da capo:");
                    System.out.println("---------------------------------------------");
                    String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                    System.out.println(faccina);
                } else {
                    System.out.println("Non hai completato il sesto gioco.");
                    System.out.println("Vuoi smettere completamente? Si/No");

                    char risposta1 = tastiera.next().toLowerCase().charAt(0);
                    while (risposta1 != 's' && risposta1 != 'n') { // Stessa operazione delle precedenti
                        System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                        risposta1 = tastiera.next().toLowerCase().charAt(0);
                    }
                    if (risposta1 == 's') {
                        vittorie = vittorie - 1; // necessario per il while-do alla fine del main

                        return vittorie;

                    } else {
                        return 0;
                    }
                }
            }

            String generazioneCasuale2 = Secondaria.paroleImpiccato(paroleScelte); //Generazione della parola casuale
            System.out.println(generazioneCasuale2);

            int dimensione2 = 0;
            int lettere = 1;
            char[] lettereScritte = new char[lettere];
            char[] lettereIndovinate = new char[dimensione2];
            char[] caratteriStringa = new char[generazioneCasuale2.length()];
            for (i = 0; i < generazioneCasuale2.length(); i++) {
                System.out.print("_ ");

            }

            System.out.println();

            for (i = 0; i < generazioneCasuale2.length(); i++) { //for per memorizzare le lettere della parola generata casualmente
                carattere = generazioneCasuale2.charAt(i);
                caratteriStringa[i] = carattere;
            }

            for (i = 0; i < 15; i++) {
                System.out.println();

                corretto = 0;
                // INIZIO
                System.out.println();
                System.out.println("Numero tentativo: " + (i + 1));
                System.out.print("Scegli la lettera: ");
                lettera = tastiera.next().toLowerCase().charAt(0);
                
                lettereScritte[lettere++] = lettera;  // Incremento per l'array di lettereScritte

                System.out.println("---------------------------------------------");
                for (int j = 0; j < generazioneCasuale2.length(); j++) { //for per verificare se la lettera inserita dall'utente è presente nell'ArrayList della lettera da indovinare
                    if (caratteriStringa[j] == lettera) {
                        dimensione2++;
                        lettereIndovinate[j] = lettera;
                        corretto = 1;
                    }
                }
                if (corretto > 0) {
                    System.out.println("La lettera " + " '" + lettera + "' " + "e' presente nella parola!");
                    i++;
                } else {
                    System.out.println("Nada, riprova");
                }
                for (int j = 0; j < generazioneCasuale2.length(); j++) {
                    carattere = generazioneCasuale2.charAt(j);
                    if (lettereIndovinate.equals(carattere)) {
                        System.out.print(carattere + " ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println(lettereIndovinate.length + "" + generazioneCasuale2.length());
                if (lettereIndovinate.length == generazioneCasuale2.length()) {
                    System.out.println();
                    System.out.println("Complimenti! Hai completato il gioco");
                    System.out.print("Lettere scritte: ");
                    for (int j = 0; j < lettereScritte.length; j++) {
                        System.out.print(lettereScritte[j] + " - ");
                    }
                    System.out.println();
                    partitaPersa = 1;
                    break;
                }
                System.out.print("Lettere scritte: ");

                for (int j = 0; j < lettereScritte.length; j++) {

                    System.out.print(lettereScritte[j] + " -");
                }
            }
            if (partitaPersa == 1) {
                break;
            }
            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("Hai perso! La parola era: " + generazioneCasuale2);
            System.out.println("---------------------------------------------");
            for (i = 0; i < lettereIndovinate.length; i++) {
                lettereIndovinate[i] = 0;
            } // Pulisci gli elementi dell'array

            partitaPersa = partitaPersa - 1;

        } while (partitaPersa == -1);
        for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai giochi completati spazi vuoti, che sono brutti da vedere
            if (livelliCompletati[i].equals("")) {
                livelliCompletati[i] = (i + 1) + ". L'impiccato";
                break;
            }

        }
        prova1 = "";
        livelliNonCompletati[5] = prova1;
        vittorie += 1;
        return vittorie;
    }
     
    static int giocoFinale(int vittorie, String[] livelliCompletati, String[] livelliNonCompletati) {
        int risposta = 0;
        int ritenta = 0;
        do {
            tastiera.nextInt(); //Buffer per la tastiera
            if (ritenta > 0) {
                System.out.println("Purtroppo non hai superato la domanda finale, vuoi riprovarci? (Si/No):");
                char risposta0 = tastiera.next().toLowerCase().charAt(0);
                while (risposta0 != 's' && risposta0 != 'n') { // Stessa operazione delle precedenti
                    System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                    risposta0 = tastiera.next().toLowerCase().charAt(0);
                }
                if (risposta0 == 's') {
                    System.out.println("---------------------------------------------");
                    System.out.println("SI RICOMINCIA, da capo:");
                    System.out.println("---------------------------------------------");
                    String faccina = """
                                         (^.^)
                                       <(  _  )>
                                         /   \\ """;

                    System.out.println(faccina);
                } else {
                    System.out.println("Non hai completato il gioco finale.");
                    System.out.println("Vuoi smettere completamente? (Si/No)");
                    char risposta2 = tastiera.next().toLowerCase().charAt(0);
                    while (risposta2 != 's' && risposta2 != 'n') { // Stessa operazione delle precedenti
                        System.out.println("Risposta non accettata, digitare nuovamente: (Si/No)");
                        risposta2 = tastiera.next().toLowerCase().charAt(0);
                    }
                    if (risposta2 == 's') {
                        vittorie = vittorie - 1; // necessario per il while-do alla fine del main

                        return vittorie;

                    } else {
                        return 0;
                    }
                }
            }
            if (ritenta > 0) {
                System.out.println("---------------------------------------------");
                System.out.println("Benvenuto! Il tutto e' semplicente un'UNICA domanda:");
            }
            System.out.println("Conosci veramente il tuo amico? Let's check!");
            System.out.println("---------------------------------------------");
            System.out.println("Cosa preferirebbe? ");
            System.out.println("1. Entrambi");
            System.out.println("2. Avere i proprio spazi nei momenti giusti con le persone giuste, cercare di parlare senza pregiudizi e per un lungo tempo senza interruzioni");
            System.out.println("3. Cercare di approndire se stessi e relazionarsi con gli altri aprendo il proprio cuore");
            int scelta = tastiera.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Scontato, vero? ;)");
                    risposta = risposta + 1;
                    break;
                case 2:
                    System.out.println("Solo?");
                    ritenta += 1;
                    break;
                case 3:
                    System.out.println("Solo?");
                    ritenta += 1;
                    break;
                default:
                    System.out.println("---------------------------------------------");
                    System.out.println("Scegliere tra le opzioni seguenti elencate:");
                    System.out.println("---------------------------------------------");
            }
        } while (risposta == 0);
        for (i = 0; i < livelliCompletati.length; i++) { //Mi dà ai "giochi completati" degli spazi vuoti, che sono brutti da vedere
            if (livelliCompletati[i].equals("")) {
                livelliCompletati[i] = (i + 1) + ". Conosci bene o male Bruschi?";
                break;
            }
        }
        prova1 = "";
        livelliNonCompletati[2] = prova1;
        vittorie += 1;
        return vittorie;
    }

    static void finale() {
        System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        System.out.println("COMPLIMENTI! HAI COMPLETATO IL GIOCO DI DANIELE BRUSCHI!!!!");
        System.out.println("Come premio per aver dedicato il tuo tempo a questo mio lavoro, ti daro' una salda stretta di mano! XD");
        System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");

    }
}

class Secondaria {

    static Random random = new Random();
    private static final String[] parole = {"totem", "computer", "programmazione", "java", "impiccato",
        "gatto", "cane", "casa", "scuola", "bicicletta",
        "sole", "mare", "montagna", "foresta", "musica",
        "libro", "telefono", "tavolo", "sedia", "finestra",
        "porta", "cielo", "terra", "luna", "stella",
        "nuvola", "fiore", "giardino", "strada", "auto",
        "treno", "aereo", "barca", "giornale", "magazzino",
        "pizza", "pasta", "riso", "pane", "insalata",
        "frutta", "verdura", "formaggio", "vino", "birra",
        "acqua", "succo", "caffè", "fumetto"};
    private static final String[] paroleAnagrammaDaScoprire = {"ares", "mare", "viola", "ratto", "donna", "forno", "pianto", "torre"};
    static final String[] paroleAnagrammaDelPC = {"sera", "rema", "oliva", "torta", "nando", "ronfo", "patina", "retro"};

    static String paroleImpiccato(String[] parol) {

        return parole[random.nextInt(parole.length)];

    }

    static String paroleAnagrammaDaScoprire(String[] parolAnagrammaDaScoprire, int numeroCasuale) {

        return paroleAnagrammaDaScoprire[numeroCasuale];

    }

    static String paroleAnagrammaDelPC(String[] parolAnagrammaDelPC, int numeroCasuale) {

        return paroleAnagrammaDelPC[numeroCasuale];
    }
}

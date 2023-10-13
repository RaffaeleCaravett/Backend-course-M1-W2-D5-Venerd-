package raffaelecaravetta;

import raffaelecaravetta.Elemento.Elemento;
import raffaelecaravetta.Elemento.Libro.Libro;
import raffaelecaravetta.Elemento.Riviste.Riviste;
import raffaelecaravetta.Enum.Periodicità;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int year = 2013;
        String[] strings = new String[3];
        strings[0] = "Thriller";
        strings[1] = "Azione";
        strings[2] = "Fantasy";


        Periodicità[] periodicitàs = new Periodicità[3];
        periodicitàs[0] = Periodicità.MENSILE;
        periodicitàs[1] = Periodicità.SEMESTRALE;
        periodicitàs[2] = Periodicità.SETTIMANALE;

        Map<Long, Elemento> Archivio = new HashMap<Long, Elemento>();


        Libro libro = null;
        Riviste rivista = null;

        File file = new File("src/output.txt");

        for (int i = 0; i <= 10; i++) {
            libro = new Libro(random.nextLong(), "titolo" + i, year + i, 30 + (i / 2), "John", strings[random.nextInt(3)]);
            rivista = new Riviste(random.nextLong(), "titolo" + i, year + 10 - i, 10 + (i * 2), periodicitàs[random.nextInt(3)]);
            aggiungiElemento(Archivio, libro);
            aggiungiElemento(Archivio, rivista);

            if (i == 10) {
                System.out.println("Ricerca elemento per Chiave:");
                ricercaElementoPerKey(Archivio, rivista.getCodiceISBN());
                System.out.println("Ricerca elemento per anno pubblicazione:");
                ricercaElementoPerValueAnno(Archivio, libro.getAnnoPubblicazione());
                System.out.println("Ricerca elemento per autore:");
                ricercaElementoPerValueAutore(Archivio, libro.getAutore());
                System.out.println("Size dell'archivio prima della rimozione : " + Archivio.size());
                rimuoviElemento(Archivio, libro.getCodiceISBN());
                System.out.println("Size dell'archivio dopo della rimozione : " + Archivio.size() + "Elemento rimosso : " + libro.getCodiceISBN());
            }
        }


        try {
            Archivio.forEach((s, elemento) -> System.out.println("Chiave : " + s + ", elemento : " + elemento.toString()));
            salvaArchivioSuDisco(Archivio,file);

           leggiArchivioDaDisco(file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    //Metodo per aggiungere un elemento all'Archivio
    private static void aggiungiElemento(Map<Long, Elemento> archivio, Elemento elemento) {
        try {
            archivio.put(elemento.getCodiceISBN(), elemento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo per rimuovere un elemento dall'Archivio con la chiave
    private static void rimuoviElemento(Map<Long, Elemento> archivio, Long codiceISBN) {
        try {
            archivio.remove(codiceISBN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //Metodo per cercare un elemento dall'archivio con la chiave
    private static void ricercaElementoPerKey(Map<Long, Elemento> archivio, Long codiceISBN) {
        boolean archivioContains = archivio.containsKey(codiceISBN);
        if (archivioContains) {
            try {
                for (Map.Entry<Long, Elemento> entry : archivio.entrySet()) {
                    if (entry.getKey().equals(codiceISBN)) {
                        System.out.println("Chiave : " + entry.getKey() + ", elemento : " + entry.toString());
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void ricercaElementoPerValueAnno(Map<Long, Elemento> archivio, int annoPubblicazione) {
        try {
            for (Elemento element : archivio.values()) {
                if (element.getAnnoPubblicazione() == annoPubblicazione) {
                    System.out.println("Elemento : " + element.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ricercaElementoPerValueAutore(Map<Long, Elemento> archivio, String autore) {
        try {
            for (Elemento element : archivio.values()) {
                if (element instanceof Libro && ((Libro) element).getAutore().equals(autore)) {
                    System.out.println("Elemento : " + element.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void salvaArchivioSuDisco(Map<Long, Elemento> archivio,File file) throws IOException {

        FileUtils.write(file, ""
            + "#", StandardCharsets.UTF_8);
        archivio.forEach((K, V) -> {
            try {
                FileUtils.writeStringToFile(file, "Chiave : " + K + ", Valore : "+
                    V
                    + " --- ", StandardCharsets.UTF_8, true);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            }
        );
    }


    private static void leggiArchivioDaDisco(File file) throws IOException {
        String contenuto = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        System.out.println("Lettura archivio dal disco : " + contenuto);
    }
}

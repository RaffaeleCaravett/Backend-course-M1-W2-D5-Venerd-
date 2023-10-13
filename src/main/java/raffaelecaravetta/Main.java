package raffaelecaravetta;

import raffaelecaravetta.Elemento.Elemento;
import raffaelecaravetta.Elemento.Libro.Libro;
import raffaelecaravetta.Elemento.Riviste.Riviste;
import raffaelecaravetta.Enum.Periodicità;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int year = 2013;
        String[] strings=new String[3];
        strings[0]= "Thriller";
        strings[1]= "Azione";
        strings[2]= "Fantasy";


        Periodicità[] periodicitàs=new Periodicità[3];
        periodicitàs[0]= Periodicità.MENSILE;
        periodicitàs[1]= Periodicità.SEMESTRALE;
        periodicitàs[2]= Periodicità.SETTIMANALE;

        Map<Long, Elemento> Archivio = new HashMap<Long,Elemento>();


        Libro libro = null;
        Riviste rivista = null;

        for(int i =0;i<=10;i++){
            libro = new Libro(random.nextLong(),"titolo"+i,year+i,30+(i/2),"John",strings[random.nextInt(3)]);
            rivista = new Riviste(random.nextLong(),"titolo"+i,year+10-i,10+(i*2),periodicitàs[random.nextInt(3)]);
            aggiungiElemento(Archivio,libro);
            aggiungiElemento(Archivio,rivista);

            if(i==10){
                System.out.println("Size dell'archivio prima della rimozione : " + Archivio.size());
                    rimuoviElemento(Archivio,libro.getCodiceISBN());
                    System.out.println("Size dell'archivio dopo della rimozione : " + Archivio.size() + "Elemento rimosso : " + libro.getCodiceISBN());
            }
        }




    try {
            Archivio.forEach((s, elemento) -> System.out.println("Chiave : " + s + ", elemento : " + elemento.toString()));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }






    }


    //Metodo per aggiungere un elemento all'Archivio
    private static void aggiungiElemento(Map<Long,Elemento> archivio,Elemento elemento){
        archivio.put(elemento.getCodiceISBN(),elemento);
    }
    private static void rimuoviElemento(Map<Long,Elemento> archivio,Long codiceISBN){
        archivio.remove(codiceISBN);
    }

}

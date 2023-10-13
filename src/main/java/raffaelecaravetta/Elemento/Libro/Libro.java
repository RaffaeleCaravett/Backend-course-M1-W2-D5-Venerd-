package raffaelecaravetta.Elemento.Libro;

import raffaelecaravetta.Elemento.Elemento;
import raffaelecaravetta.Enum.Periodicità;

public class Libro extends Elemento {

    String autore;
    String genere;
    public Libro(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,String autore, String genere){
        super(codiceISBN, titolo,annoPubblicazione, numeroPagine);
        this.autore=autore;
        this.genere=genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    @Override
    public String toString() {
        return "Libro{" +
            "CodiceISBN=" + getCodiceISBN() +
            ", Titolo='" + getTitolo() + '\'' +
            ", AnnoPubblicazione=" + getAnnoPubblicazione() +
            ", NumeroPagine=" + getNumeroPagine() +
            ", Autore='" + autore + '\'' +
            ", Genere='" + genere + '\'' +
            '}';
    }
}

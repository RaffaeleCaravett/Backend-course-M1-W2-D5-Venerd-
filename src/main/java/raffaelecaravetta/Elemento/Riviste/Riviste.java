package raffaelecaravetta.Elemento.Riviste;

import raffaelecaravetta.Elemento.Elemento;
import raffaelecaravetta.Enum.Periodicità;

public class Riviste extends Elemento {

    Periodicità periodicità;
    public Riviste(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,Periodicità periodicità){
        super(codiceISBN, titolo,annoPubblicazione, numeroPagine);
        this.periodicità=periodicità;
    }


    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità=periodicità;
    }
    @Override
    public String toString() {
        return "Rivista{" +
            "CodiceISBN=" + getCodiceISBN() +
            ", Titolo='" + getTitolo() + '\'' +
            ", AnnoPubblicazione=" + getAnnoPubblicazione() +
            ", NumeroPagine=" + getNumeroPagine() +
            ", Periodicità='" + periodicità + '\'' +
            '}';
    }
}

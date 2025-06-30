package Modeli;

public class Artikal {
    private String naziv;
    private String opis;
    private double cena;

    public Artikal(String naziv, String opis, double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return naziv + " - " + opis + "( " + cena + "RSD )";
    }
}

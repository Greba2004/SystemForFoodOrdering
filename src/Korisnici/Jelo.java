package Korisnici;
import Modeli.StavkaZaKorpu;
public class Jelo implements StavkaZaKorpu{
    public int id;
    public static int brojac = 1;
    private String naziv;
    private double cena;
//Konstruktor
    public Jelo(String naziv, double cena) {
        this.id = brojac++;
        this.naziv = naziv;
        this.cena = cena;
    }
//Geteri i seteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = brojac++;
    }

    @Override
    public String getOpis() {
        return naziv + " - " + cena + "RSD";
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return String.format(getId() +  " " + getNaziv() + " -  "  + getCena() + " RSD " );
    }
    public static void main(String [] args){
        Jelo j1 = new Jelo("Burger", 980);
        Jelo j2 = new Jelo("Pizza", 1100);
        System.out.println(j1);
        System.out.println(j2);
    }
}

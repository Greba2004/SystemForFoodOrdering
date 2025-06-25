package Korisnici;
import Modeli.StavkaZaKorpu;
public class Pice implements StavkaZaKorpu {
    private String vrsta;
    private String velicina;
    private double cena;

    public Pice(String vrsta, String velicina, double cena) {
        this.vrsta = vrsta;
        this.velicina = velicina;
        this.cena = cena;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    @Override
    public String getOpis() {
        return vrsta + " - " + velicina + "( " + cena + " RSD )";
    }

    @Override
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}


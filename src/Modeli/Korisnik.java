package Modeli;

import java.util.Iterator;

public class Korisnik {
    private String korisnickoIme;
    private String lozinka;
    private String uloga; // kupac ili admin

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getUloga() {
        return uloga;
    }
    public boolean proveriLozinku(String lozinka){
        return this.lozinka.equals(lozinka);
    }
    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return korisnickoIme + "( " + uloga + ") ";
    }

    }


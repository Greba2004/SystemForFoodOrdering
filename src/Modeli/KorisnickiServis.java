package Modeli;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class KorisnickiServis {
    private static final String FAJL_KORISNIKA = "korisnici.txt";
    private List<Korisnik> korisnici = new ArrayList<>();

    public boolean registruj(String korisnickoIme, String lozinka) {
        for (Korisnik k : korisnici) {
            if (k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)) {
                return false; // korisnik već postoji
            }
        }
        korisnici.add(new Korisnik(korisnickoIme, lozinka));
        upisiKorisnikaUFajl(korisnickoIme, lozinka);
        return true;
    }

    private void upisiKorisnikaUFajl(String korisnickoIme, String lozinka) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FAJL_KORISNIKA, true))) {
            bw.write(korisnickoIme + ";" + lozinka);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Greška pri upisu korisnika u fajl.");
        }
    }

    public Korisnik login(String korisnickoIme, String lozinka) {
        for (Korisnik k : korisnici) {
            if (k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && k.getLozinka().equals(lozinka)) {
                return k;
            }
        }
        return null; // neuspesan login
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    private void ucitajKorisnikeIzFajla() {
        File fajl = new File(FAJL_KORISNIKA);
        if (!fajl.exists()) {
            return;//ako ne postoji nema sta da se ucita
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FAJL_KORISNIKA))) {
            String linija;
            while ((linija = br.readLine()) != null) {
                String[] delovi = linija.split(";");
                if (delovi.length == 2) {
                    korisnici.add(new Korisnik(delovi[0], delovi[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Nema fajla sa korisnicima(prvi put pokreces?)");
        }
    }

    public KorisnickiServis() {
        ucitajKorisnikeIzFajla();
    }
    public boolean promeniLozinku(String korisnickoIme, String staraLozinka, String novaLozinka) {
        for (Korisnik k : korisnici) {
            if (k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && k.getLozinka().equals(staraLozinka)) {
                k.setLozinka(novaLozinka);
                azurirajFajl();
                return true;
            }
        }
        return false;
    }

    private void azurirajFajl() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FAJL_KORISNIKA))) {
            for (Korisnik k : korisnici) {
                bw.write(k.getKorisnickoIme() + ";" + k.getLozinka());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Greška pri ažuriranju fajla sa korisnicima.");
        }
    }

    public boolean obrisiKorisnika(String korisnickoIme, String lozinka) {
        Iterator<Korisnik> iterator = korisnici.iterator();
        boolean obrisan = false;

        while (iterator.hasNext()) {
            Korisnik k = iterator.next();
            if (k.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && k.getLozinka().equals(lozinka)) {
                iterator.remove();
                obrisan = true;
                break;
            }
        }

        if (obrisan) {
            azurirajFajl();
            return true;
        } else {
            return false;
        }

    }
}

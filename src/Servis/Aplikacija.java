package Servis;
import Modeli.*;
import java.util.Scanner;
import java.util.*;

public class Aplikacija {
    private Scanner scan = new Scanner(System.in);
    private KorisnickiServis korisnickiServis = new KorisnickiServis();
    private Korisnik ulogovanKorisnik = null;
    private MeniServis meniServis = new MeniServis();
//pokretanje aplikacije
    public void pokreni() {
        System.out.println("Dobrodosli u Sistem za Narucivanje hrane!");
        while (true) {
            System.out.println("\n1. Prijavi se");
            System.out.println("2. Registruj se");
            System.out.println("0. Izlaz");
            System.out.println("Izaberite opciju: ");
            String izbor = scan.nextLine();

            switch (izbor) {
                case "1":
                    login();
                    break;
                case "2":
                    registracija();
                    break;
                case "0":
                    System.out.println("Hvala na korišćenju!");
                    return;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }
    }
    //Dodavanje artikla rucno
    private void dodajArtikalRucno() {
        System.out.print("Naziv artikla: ");
        String naziv = scan.nextLine();
        System.out.print("Opis: ");
        String opis = scan.nextLine();
        System.out.print("Cena: ");
        double cena = Double.parseDouble(scan.nextLine());
        meniServis.dodajArtikal(naziv, opis, cena);
        System.out.println("✅ Artikal dodat.");
    }
// login korisnika
    private void login() {
        System.out.println("Korisnicko ime: ");
        String korisnickoIme = scan.nextLine();
        System.out.println("Lozinka: ");
        String lozinka = scan.nextLine();
        Korisnik k = korisnickiServis.login(korisnickoIme, lozinka);
        if (k != null) {
            ulogovanKorisnik = k;
            System.out.println("Uspesna prijava.Dobrodosao, " + k.getKorisnickoIme() + " ! ");
         if(k.getKorisnickoIme().equalsIgnoreCase("admin")){
             adminMeni();// pozivamo admin meni ako se uloguje admin
         }else{
             korisnickiMeni();
         }
        } else {
            System.out.println("Uneli ste pogresno korisnicko ime ili lozinku, pokusajte ponovo");

        }
    }
// registracija novog korisnika
    private void registracija() {
        System.out.print("Unesite korisničko ime: ");
        String korisnickoIme = scan.nextLine();
        System.out.print("Unesite lozinku: ");
        String lozinka = scan.nextLine();
        boolean uspesno = korisnickiServis.registruj(korisnickoIme, lozinka);
        if (uspesno) {
            System.out.println("Uspesna registracija! Sada se mozete prijaviti.");
        } else {
            System.out.println("Korisnicko ime vec postoji");
        }
    }
// korisnicki meni nakon logovanja
    private void korisnickiMeni() {
        while (true) {
            System.out.println("\n === KORISNICKI MENI ===");
            System.out.println("1. Prikazi meni hrane i pica");
            System.out.println("2. Dodaj u korpu");
            System.out.println("3. Pogledaj korpu");
            System.out.println("4. Kreiraj narudzbinu");
            System.out.println("5. Brisanje korisnika");
            System.out.println("6. Promena lozinke");
            System.out.println("0. Odjavi se");
            System.out.println("Izaberite opciju: ");
            String izbor = scan.nextLine();

//SWITCH NA OSNOVU BROJEVA OD GORE
            switch (izbor) {
                case "1":
                    System.out.println("Ovde će ići prikaz menija...");
                    break;
                case "2":
                    System.out.println("Ovde će se dodavati u korpu...");
                    break;
                case "3":
                    System.out.println("Ovde će se prikazati sadržaj korpe...");
                    break;
                case "4":
                    System.out.println("Ovde će se kreirati narudžbina...");
                    break;
                case "0":
                    ulogovanKorisnik = null;
                    System.out.println("Uspešno ste se odjavili.");
                    break;
                case "5":
                    System.out.print("Unesite korisničko ime: ");
                    String userZaBrisanje = scan.nextLine();
                    System.out.print("Unesite lozinku: ");
                    String passZaBrisanje = scan.nextLine();
                    if (korisnickiServis.obrisiKorisnika(userZaBrisanje, passZaBrisanje)) {
                        System.out.println("✅ Uspešno ste obrisali nalog.");
                        ulogovanKorisnik = null;
                        return;
                    } else {
                        System.out.println("❌ Neuspešno brisanje naloga. Proverite podatke.");
                    }
                    break;
                case "6":
                    System.out.print("Unesite korisničko ime: ");
                    String userZaPromenu = scan.nextLine();
                    System.out.print("Unesite staru lozinku: ");
                    String stara = scan.nextLine();
                    System.out.print("Unesite novu lozinku: ");
                    String nova = scan.nextLine();
                    if (korisnickiServis.promeniLozinku(userZaPromenu, stara, nova)) {
                        System.out.println("✅ Lozinka je uspešno promenjena.");
                    } else {
                        System.out.println("❌ Pogrešni podaci. Promena lozinke nije uspela.");
                    }
                    break;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }
    }
    private void adminMeni() {
        while (true) {
            System.out.println("\n=== ADMIN MENI ===");
            System.out.println("1. Prikaz svih korisnika");
            System.out.println("2. Brisanje korisnika po korisničkom imenu");
            System.out.println("3. Prikaz menija");
            System.out.println("4. Dodavanje artikla (ručno)");
            System.out.println("5. Dodavanje artikla iz globalne baze");
            System.out.println("6. Brisanje artikla");
            System.out.println("7. Odjava");
            System.out.print("Izaberite opciju: ");

            String izbor = scan.nextLine();
            switch (izbor) {
                case "1":
                    for (Korisnik k : korisnickiServis.getKorisnici()) {
                        System.out.println("- " + k.getKorisnickoIme());
                    }
                    break;
                case "2":
                    System.out.print("Unesite korisničko ime za brisanje: ");
                    String korisnikZaBrisanje = scan.nextLine();
                    if (korisnickiServis.obrisiKorisnikaPoImenu(korisnikZaBrisanje)) {
                        System.out.println("✅ Korisnik obrisan.");
                    } else {
                        System.out.println("❌ Korisnik nije pronađen.");
                    }
                    break;
                case "3":
                    meniServis.prikaziMeni();
                    break;
                case "4":
                    dodajArtikalRucno();
                    break;
                case "5":
                    dodajArtikalIzBaze();
                    break;
                case "6":
                    System.out.print("Unesite naziv artikla za brisanje: ");
                    String nazivZaBrisanje = scan.nextLine();
                    if (meniServis.obrisiArtikal(nazivZaBrisanje)) {
                        System.out.println("✅ Artikal obrisan.");
                    } else {
                        System.out.println("❌ Artikal nije pronađen.");
                    }
                    break;
                case "7":
                    System.out.println("Admin odjavljen.");
                    return;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }
    }
    private void prikaziGlobalnuBazu() {
        List<Artikal> baza = GlobalnaBazaArtikala.getSviArtikli();
        for (int i = 0; i < baza.size(); i++) {
            System.out.println((i + 1) + ". " + baza.get(i));
        }
    }
    private void dodajArtikalIzBaze() {
        prikaziGlobalnuBazu();
        System.out.print("Unesite broj artikla koji želite da dodate: ");
        int index = Integer.parseInt(scan.nextLine()) - 1;
        List<Artikal> baza = GlobalnaBazaArtikala.getSviArtikli();
        if(index < 0 || index >= baza.size()) {
            System.out.println("Nepostojeci artikal.");
            return;
        }
        Artikal izabrani = baza.get(index);
        System.out.print("Unesite cenu za artikal (" + izabrani.getNaziv() + "): ");
        double cena = Double.parseDouble(scan.nextLine());
        System.out.print("Unesite opis (ostavite prazno za podrazumevani): ");
        String opis = scan.nextLine();
        if(opis.isEmpty()) {
            opis = izabrani.getOpis();
        }
        meniServis.dodajArtikal(izabrani.getNaziv(), opis, cena);
        System.out.println("Artikal dodat u meni.");
    }
}
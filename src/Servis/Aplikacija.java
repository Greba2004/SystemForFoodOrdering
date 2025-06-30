package Servis;
import Modeli.KorisnickiServis;
import Modeli.Korisnik;
import java.util.Scanner;


public class Aplikacija {
    private Scanner scan = new Scanner(System.in);
    private KorisnickiServis korisnickiServis = new KorisnickiServis();
    private Korisnik ulogovanKorisnik = null;
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
    private void adminMeni(){
        while (true){
            System.out.println("\n ===ADMIN MENI===");
            System.out.println("1. Prikaz svih korisnika");
            System.out.println("2. Brisanje korisnika po imenu");
            System.out.println("3. Odjava");
            System.out.println("Izaberite opciju");
            String izbor = scan.nextLine();

            switch (izbor) {
                case "1":
                    for (Korisnik k : korisnickiServis.getKorisnici()) {
                        System.out.println("- " + k.getKorisnickoIme());
                    }
                    break;
                case "2":
                    System.out.print("Unesite korisničko ime koje želite da obrišete: ");
                    String korisnikZaBrisanje = scan.nextLine();
                    if (korisnickiServis.obrisiKorisnikaPoImenu(korisnikZaBrisanje)) {
                        System.out.println("✅ Korisnik je obrisan.");
                    } else {
                        System.out.println("❌ Korisnik nije pronađen.");
                    }
                    break;
                case "3":
                    System.out.println("Odjava admina.");
                    return;
                default:
                    System.out.println("Nepoznata opcija.");
            }

        }
    }
}
import Korisnici.*;
import Modeli.*;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String [] args){
        Korisnik korisnik = new Korisnik("Aleksa123", "sifra123");
        Jelo j1 = new Jelo("Pizza", 1200);
        Jelo j2 = new Jelo("Burger", 950);
        Jelo j3 = new Jelo("Palacinka", 420);
        Jelo j4 = new Jelo("Pljeskavica", 550);
        Pice p1 = new Pice("Koka kola", "mala", 220);
        Pice p2 = new Pice("Sprite", "veliki", 300);
        Pice p3 = new Pice("Pepsi", "mala", 220);
        Pice p4 = new Pice("Fanta", "velika", 300);
        Korpa korpa = new Korpa();
        korpa.dodaj(j1);
        korpa.dodaj(j2);
        korpa.dodaj(j3);
        korpa.dodaj(j4);
        korpa.dodaj(p1);
        korpa.dodaj(p2);
        korpa.dodaj(p3);
        korpa.dodaj(p4);
        korpa.prikaziKorpu();
        List<StavkaZaKorpu> stavke = new ArrayList<>();
        stavke.add(j1);
        stavke.add(j3);
        stavke.add(p3);
        Narudzbina narudzbina = new Narudzbina(korisnik, stavke);
        System.out.println(narudzbina);
    }
}
package Modeli;

import java.util.List;

public class GlobalnaBazaArtikala {
    private static final List<Artikal> sviArtikli = List.of(
            new Artikal("Pizza Margherita", "Paradajz, sir, origano", 0),
            new Artikal("Coca-Cola 0.5L", "Bezalkoholno piće", 0),
            new Artikal("Kafa", "Crna kafa", 0),
            new Artikal("Čorba", "Pileća domaća čorba", 0),
            new Artikal("Palačinke", "Slatke sa eurokremom", 0)
    );

    public static List<Artikal> getSviArtikli() {
        return sviArtikli;
    }
}

package Korisnici;
import java.util.List;
import java.util.ArrayList;
import Modeli.StavkaZaKorpu;

public class Korpa {
    private List<StavkaZaKorpu> stavke = new ArrayList<>();
    public void dodaj(StavkaZaKorpu stavka){
        stavke.add(stavka);
    }
    public void prikaziKorpu(){
        System.out.println("===KORPA===");
        for(StavkaZaKorpu s :stavke){
            System.out.println((s.getOpis()));
        }
        System.out.println("Ukupno: " + izracunajUkupno() + " RSD");
    }
    public double izracunajUkupno(){
        double suma = 0;
        for(StavkaZaKorpu s : stavke){
            suma += s.getCena();
        }
        return suma;
    }
}

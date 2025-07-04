package Modeli;
import java.util.ArrayList;
import java.util.List;
public class MeniServis {
    private List<Artikal> artikli = new ArrayList<>();
    public void dodajArtikal(String naziv, String opis, double cena){
        artikli.add(new Artikal(naziv,opis,cena));
    }
    public void prikaziMeni(){
        for(Artikal a : artikli){
            System.out.println("- " + a);
        }
    }
    public boolean obrisiArtikal(String naziv){
        return artikli.removeIf( a-> a.getNaziv().equalsIgnoreCase(naziv));
    }
    public List<Artikal>getArtikli(){
        return artikli;
    }


}

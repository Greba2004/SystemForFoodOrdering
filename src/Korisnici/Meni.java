package Korisnici;
import java.util.*;
public class Meni {
    private List <Jelo>jela;

    public Meni() {
        this.jela = new ArrayList<>();
    }
    //Dodavanje jela u meni
    public void dodajJelo(Jelo jelo){
        jela.add(jelo);
    }
    public void prikaziMeni(){
        if(jela.isEmpty()){
            System.out.println("Meni je trenutno prazan");
            return;
        }
        System.out.println("===MENI===");
        for(Jelo j : jela){
            System.out.println(j);
        }

    }
    // NALAZENJE JELA PO ID
    public Jelo nadjiJeloPoId(int id){
        for(Jelo j : jela){
            if(j.getId() == id){
                return j;
            }
        }
        return null;
    }
    //BRISANJE JELA
    public boolean obrisiJelo(int id){
        Jelo zaBrisanje = nadjiJeloPoId(id);
        if(zaBrisanje!=null){
            jela.remove(zaBrisanje);
            return true;
        }
        return false;
    }

    public List<Jelo> getJela() {
        return jela;
    }
    public static void main(String [] args){
        Meni meni = new Meni ();
        meni.dodajJelo(new Jelo("Pizza", 1200));
        meni.dodajJelo(new Jelo("Sarma", 720));
        meni.dodajJelo(new Jelo("Burger", 950));
        meni.dodajJelo(new Jelo("Pljeskavica", 540));
        meni.dodajJelo(new Jelo("Cevapi", 620));
        meni.prikaziMeni();

    }
}


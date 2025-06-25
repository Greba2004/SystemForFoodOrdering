package Modeli;
import java.util.List;
public class Narudzbina {
    private static int brojac = 1;
    private int id;
    private Korisnik korisnik;
    private List<StavkaZaKorpu>stavke;
    private String status; //npr u pripremi, spremno, isporuceno

    public Narudzbina(Korisnik korisnik, List<StavkaZaKorpu>stavke) {
        this.id = brojac++;
        this.korisnik = korisnik;
        this.stavke = stavke;
        this.status = "U pripremi";
    }
    public double ukupnaCena (){
        return stavke.stream().mapToDouble(StavkaZaKorpu::getCena).sum();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Narudzbina #").append(id).append( " - ").append(korisnik.getKorisnickoIme()).append("\n");
        for(StavkaZaKorpu s : stavke){
            sb.append(" - ").append(s.getOpis()).append("\n");
        }
        sb.append("Ukupno: ").append(ukupnaCena()).append(" RSD\n");
        sb.append("Status: ").append(status);
        return sb.toString();
    }
}

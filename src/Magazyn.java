import java.util.ArrayList;

public class Magazyn {

    private String adres;
    private  double powierzchnia;

    public static int GlobalMagazynID=100;
    private int ID;

    ArrayList <Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();

    public Magazyn (String adres, double powierzchnia){
        this.adres= adres;
        this.powierzchnia=powierzchnia;
        GlobalMagazynID++;
        this.ID=GlobalMagazynID;
    }

    public Magazyn (String adres, double powierzchnia, int ID){
        this.adres= adres;
        this.powierzchnia=powierzchnia;
        this.ID=ID;
    }

    public String getAdres() {
        return adres;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public int getID() {
        return ID;
    }

    public boolean dodajPrzedmiot(Przedmiot przedmiot){
        double zajetaPowierzchnia=0;
        for (Przedmiot tmp:listaPrzedmiotow) {
            zajetaPowierzchnia = zajetaPowierzchnia + tmp.getPowierzchnia();
        }
        if (zajetaPowierzchnia + przedmiot.getPowierzchnia() <= this.powierzchnia){
            this.listaPrzedmiotow.add(przedmiot);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Magazyn, "+ this.getAdres() + " (" + getID()+ ")";
    }
}

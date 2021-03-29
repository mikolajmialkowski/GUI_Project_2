public class Przedmiot {

   private String nazwa;
   private String opis;

    private   double powierzchnia;

    public static int GlobalPrzedmiotID=2000;
    private int ID;


    public Przedmiot(String nazwa, String opis, double powierzchnia){
        this.nazwa= nazwa;
        this.opis=opis;
        this.powierzchnia = powierzchnia;
        GlobalPrzedmiotID++;
        this.ID = GlobalPrzedmiotID;
    }

    public Przedmiot(String nazwa, String opis, double powierzchnia,int ID){
        this.nazwa= nazwa;
        this.opis=opis;
        this.powierzchnia = powierzchnia;
        this.ID =ID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return "Przedmiot, "+ this.getNazwa() + " (" + this.getID()+ ")";
    }

    public void zwikeszGlobalID(int nowa){
        GlobalPrzedmiotID = nowa;
    }
}




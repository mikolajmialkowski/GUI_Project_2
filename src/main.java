import javax.swing.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        User user1 = new User("Tomasz","Karolak1337");
        User user2 = new User("Ala","Piesek12");
        User user3 = new User("worker22","password33");

        Magazyn magazyn1 = new Magazyn("Lawendowa 15", 150);
        Magazyn magazyn2 = new Magazyn("Malinowa 8", 205);
        Magazyn magazyn3 = new Magazyn("Tulipanowa 4", 175);
        Magazyn magazyn4 = new Magazyn("Klonowa 30", 260);
        Magazyn magazyn5 = new Magazyn("Akacjowa 21", 290);

        Magazyn magazynWIDMO = new Magazyn("NIE MA MNIE", 99999,0);

        Przedmiot przedmiot1 = new Przedmiot("Telefon","Samsung",12);
        Przedmiot przedmiot2 = new Przedmiot("Kosiarka","Elektryczna",42);
        Przedmiot przedmiot3 = new Przedmiot("Kamera","FULLHD 1080p",20);
        Przedmiot przedmiot4 = new Przedmiot("Klawiatura","Mechaniczna",6);
        Przedmiot przedmiot5 = new Przedmiot("Laptop","Asus",16);
        Przedmiot przedmiot6 = new Przedmiot("Samochod","Polonez",50);
        Przedmiot przedmiot7 = new Przedmiot("Rower","Dla dziecka",35);
        Przedmiot przedmiot8 = new Przedmiot("Dywan","Kolowowy, w pasy",35);
        Przedmiot przedmiot9 = new Przedmiot("Latarka","wodoodporna",4);
        Przedmiot przedmiot10 = new Przedmiot("Zestaw Szklanek","30 X 250 [ml]",40);
        Przedmiot przedmiot11 = new Przedmiot("Cukierki","Karmelowe",9);
        Przedmiot przedmiot12 = new Przedmiot("Pasta do butow","Czarna",15);
        Przedmiot przedmiot13 = new Przedmiot("TV","55 cali LG",30);
        Przedmiot przedmiot14 = new Przedmiot("Pralka","\"Frania\"",20);
        Przedmiot przedmiot15 = new Przedmiot("Karma dla psa","pelno wartosciowa",10);

        magazyn1.dodajPrzedmiot(przedmiot1);
        magazyn1.dodajPrzedmiot(przedmiot2);
        magazyn1.dodajPrzedmiot(przedmiot3);
        magazyn1.dodajPrzedmiot(przedmiot5);
        magazyn2.dodajPrzedmiot(przedmiot4);
        magazyn1.dodajPrzedmiot(przedmiot6);
        magazyn1.dodajPrzedmiot(przedmiot7);
        magazyn3.dodajPrzedmiot(przedmiot8);
        magazyn4.dodajPrzedmiot(przedmiot9);
        magazyn3.dodajPrzedmiot(przedmiot10);
        magazyn4.dodajPrzedmiot(przedmiot11);
        magazyn4.dodajPrzedmiot(przedmiot12);
        magazyn4.dodajPrzedmiot(przedmiot13);
        magazyn5.dodajPrzedmiot(przedmiot14);
        magazyn5.dodajPrzedmiot(przedmiot15);

        ArrayList <Magazyn> listaMagazynow = new ArrayList<Magazyn>();
        listaMagazynow.add(magazyn1);
        listaMagazynow.add(magazyn2);
        listaMagazynow.add(magazyn3);
        listaMagazynow.add(magazyn4);
        listaMagazynow.add(magazyn5);
        listaMagazynow.add(magazynWIDMO);

        ArrayList <Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();
        listaPrzedmiotow.add(przedmiot1);
        listaPrzedmiotow.add(przedmiot2);
        listaPrzedmiotow.add(przedmiot3);
        listaPrzedmiotow.add(przedmiot4);
        listaPrzedmiotow.add(przedmiot5);
        listaPrzedmiotow.add(przedmiot6);
        listaPrzedmiotow.add(przedmiot7);
        listaPrzedmiotow.add(przedmiot8);
        listaPrzedmiotow.add(przedmiot9);
        listaPrzedmiotow.add(przedmiot10);
        listaPrzedmiotow.add(przedmiot11);
        listaPrzedmiotow.add(przedmiot12);
        listaPrzedmiotow.add(przedmiot13);
        listaPrzedmiotow.add(przedmiot14);
        listaPrzedmiotow.add(przedmiot15);

        ArrayList <User> listaUzytkownikow = new ArrayList<User>();
        listaUzytkownikow.add(user1);
        listaUzytkownikow.add(user2);
        listaUzytkownikow.add(user3);

        SwingUtilities.invokeLater(() -> new OknoLogowania("Logowanie",listaUzytkownikow, listaMagazynow, listaPrzedmiotow));
    }
}

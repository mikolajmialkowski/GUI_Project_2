import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    ArrayList <Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;

    JLabel mainNapis;

    JButton przycisk1;
    JButton przycisk2;
    JButton przycisk3;
    JButton przycisk4;
    JButton przycisk5;
    JButton przycisk6;

    public MainMenu(String name, ArrayList <Magazyn> lisaMagazynow, ArrayList <Przedmiot> listaPrzedmiotow){
        super(name);

        this.listaMagazynow = lisaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));

        setIconImage(new ImageIcon("MainMenuIcon.png").getImage());

        panelN = new JPanel();
        panelC = new JPanel(new GridLayout(0,3,20,20));
        panelS = new JPanel();
        panelE = new JPanel();
        panelW = new JPanel();

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("MENU GŁÓWNE");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        panelC.setPreferredSize(new Dimension(700,400));
        przycisk1 = new JButton("STAN MAGAZYNÓW");
        przycisk2 = new JButton("<html>LISTA PRZEDMIOTÓW <br/> LISTA MAGAZYNÓW</html>");
        przycisk3 = new JButton("DODAJ NOWY MAGAZYN");
        przycisk4 = new JButton("<html>UTWÓRZ NOWY <br/> PRZEDMIOT</html>");
        przycisk5 = new JButton("<html>DODAJ PRZEDMIOT <br/> DO MAGAZYNU</html>");
        przycisk6 = new JButton("ZAPISZ / WCZYTAJ DANE");

        przycisk1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        przycisk2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        przycisk3.setFont(new Font("TimesRoman", Font.BOLD, 15));
        przycisk4.setFont(new Font("TimesRoman", Font.BOLD, 15));
        przycisk5.setFont(new Font("TimesRoman", Font.BOLD, 15));
        przycisk6.setFont(new Font("TimesRoman", Font.BOLD, 15));


        przycisk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StanMagazynow stanMagazynow = new StanMagazynow("STAN MAGAZYNOW",listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        przycisk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaPrzedmiotowMagazynow listaPrzedmiotowMagazynow = new ListaPrzedmiotowMagazynow("LISTA PRZEDMIOTY " +
                        "/ MAGAZYNY",listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        przycisk3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajMagazyn dodajMagazyn = new DodajMagazyn("DODAJ MAGAZYN", listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        przycisk4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NowyPrzedmiot nowyPrzedmiot = new NowyPrzedmiot("UTWÓRZ NOWY PRZEDMIOT", listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        przycisk5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajPrzedmiot dodajPrzedmiot = new DodajPrzedmiot("DODAJ PRZEDMIOT DO MAGAZYNU", listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        przycisk6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZapiszWczytajDane zapiszWczytajDane = new ZapiszWczytajDane("ZAPISZ / WCZYTAJ DANE", listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        panelC.add(przycisk1); // STAN MAGAZYNOW
        panelC.add(przycisk2); // LISTA PRZEDMIOTOW
        panelC.add(przycisk3); // DODAJ NOWY MAGAZYN
        panelC.add(przycisk4); // UTWÓRZ NOWY PRZEDMIOT
        panelC.add(przycisk5); // DODAJ PRZEDMIOT DO MAGAZYNU
        panelC.add(przycisk6); // ZAPISZ / WCZYTAJ DANE

        getContentPane().add(panelN,BorderLayout.NORTH);
        getContentPane().add(panelC,BorderLayout.CENTER);
        getContentPane().add(panelS,BorderLayout.SOUTH);
        getContentPane().add(panelW,BorderLayout.WEST);
        getContentPane().add(panelE,BorderLayout.EAST);

        setSize(1000,600);
        setLocation(600,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

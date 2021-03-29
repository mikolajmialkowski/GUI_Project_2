import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaPrzedmiotowMagazynow extends JFrame {

    ArrayList<Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;

    JLabel stanMagazynowLabel;
    JButton stanMagazynowButton;

    JLabel stanPrzedmiotowLabel;
    JButton stanPrzedmiotowButton;



    public ListaPrzedmiotowMagazynow(String name, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow){
        super(name);

        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow=listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));

        setIconImage(new ImageIcon("ListaPrzedmiotowMagazynowIcon.png").getImage());

        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();
        //panelC =new JPanel(new FlowLayout(10,10,70));
        panelC =new JPanel(new GridLayout(0,2,0,30));

        stanMagazynowLabel = new JLabel("Zestawienie wszystkich Magazynow:");
        stanMagazynowLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        stanMagazynowButton = new JButton("Magazyny");
        stanMagazynowButton.setPreferredSize(new Dimension(200,30));
        stanMagazynowButton.setFont(new Font("TimesRoman", Font.BOLD, 16));
        stanMagazynowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZestawienieMagazynow zestawienieMagazynow = new ZestawienieMagazynow("ZESTAWIENIE MAGAZYNOW",listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        stanPrzedmiotowLabel = new JLabel("Zestawienie wszytskich Przedmiotow:");
        stanPrzedmiotowLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        stanPrzedmiotowButton = new JButton("Przedmioty");
        stanPrzedmiotowButton.setPreferredSize(new Dimension(200,30));
        stanPrzedmiotowButton.setFont(new Font("TimesRoman", Font.BOLD, 16));
        stanPrzedmiotowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaPrzedmiotow listaPrzedmiotow1 = new ListaPrzedmiotow("ZESTAWIENIE PRZEDMIOTOW",listaMagazynow, listaPrzedmiotow);
                setVisible(false);
            }
        });

        panelC.add(stanMagazynowLabel);
        panelC.add(stanMagazynowButton);
        panelC.add(stanPrzedmiotowLabel);
        panelC.add(stanPrzedmiotowButton);

        panelN = new JPanel(); // GORA
        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("LISTA MAGAZYNOW / PRZEDMIOTOW");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),42));
        panelN.add(mainNapis);

        powrot = new JButton("MENU GŁÓWNE"); // DOL
        powrot.setPreferredSize(new Dimension(200,50));
        powrot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu("MENU GŁOWNE",listaMagazynow, listaPrzedmiotow );
                setVisible(false);
            }
        });

        panelS.add(powrot);

        getContentPane().add(panelN,BorderLayout.NORTH);
        getContentPane().add(panelC,BorderLayout.CENTER);
        getContentPane().add(panelE,BorderLayout.EAST);
        getContentPane().add(panelW,BorderLayout.WEST);
        getContentPane().add(panelS,BorderLayout.SOUTH);

        setSize(1000,600);
        setLocation(600,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

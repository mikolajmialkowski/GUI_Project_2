import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NowyPrzedmiot extends JFrame {

    ArrayList<Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;
    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;
    JButton zatwierdz;

    JLabel przedmiotNazwaLabel;
    JTextField przedmiotNazwaText;
    JLabel przedmiotOpisLabel;
    JTextField przedmiotOpisText;
    JLabel przedmiotPowierzchniaLabel;
    JSlider przedmiotPowierzchniaSlider;
    JLabel przedmiotWybranaPowierzchnia;
    JLabel przedmiotWybranaPowierzchniaINT;

    public NowyPrzedmiot(String name,ArrayList <Magazyn> listaMagazynow, ArrayList <Przedmiot> listaPrzedmiotow) {

        super(name);
        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));
        setIconImage(new ImageIcon("NowyPrzedmiotIcon.png").getImage());

        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();
        panelC = new JPanel(new GridLayout(0,2,0,10));
        panelN = new JPanel();

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("UTWÓRZ NOWY PRZEDMIOT");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        przedmiotNazwaLabel = new JLabel("Podaj Nazwę:");
        przedmiotNazwaLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotNazwaText = new JTextField();
        przedmiotNazwaText.setPreferredSize(new Dimension(100,30));
        przedmiotNazwaText.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotOpisLabel = new JLabel("Podaj krótki Opis:");
        przedmiotOpisLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotOpisText = new JTextField();
        przedmiotOpisText.setPreferredSize(new Dimension(100,30));
        przedmiotOpisText.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotPowierzchniaLabel = new JLabel("Ustaw Powierzchnię");
        przedmiotPowierzchniaLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotPowierzchniaSlider = new JSlider(1,50,1);

        przedmiotPowierzchniaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                przedmiotWybranaPowierzchniaINT.setText(String.valueOf(przedmiotPowierzchniaSlider.getValue()));
            }
        });

        przedmiotWybranaPowierzchnia = new JLabel("Wybrana Powierzchnia:");
        przedmiotWybranaPowierzchnia.setFont(new Font("TimesRoman", Font.BOLD, 16));

        przedmiotWybranaPowierzchniaINT = new JLabel("1");
        przedmiotWybranaPowierzchniaINT.setFont(new Font("TimesRoman", Font.BOLD, 16));

        panelC.add(przedmiotNazwaLabel);
        panelC.add(przedmiotNazwaText);
        panelC.add(przedmiotOpisLabel);
        panelC.add(przedmiotOpisText);
        panelC.add(przedmiotPowierzchniaLabel);
        panelC.add(przedmiotPowierzchniaSlider);
        panelC.add(przedmiotWybranaPowierzchnia);
        panelC.add(przedmiotWybranaPowierzchniaINT);

        zatwierdz = new JButton("ZATWIERDŹ NOWY PRZEDMIOT");
        zatwierdz.setPreferredSize(new Dimension(220,50));

        panelS.add(zatwierdz);

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if((!przedmiotNazwaText.getText().equals("")) && (!przedmiotOpisText.getText().equals(""))){
                for (Magazyn tmp:listaMagazynow) {
                    if (tmp.getID()==0){
                        Przedmiot nowyprzedmiot = new Przedmiot(przedmiotNazwaText.getText(),przedmiotOpisText.getText(),przedmiotPowierzchniaSlider.getValue());
                        tmp.dodajPrzedmiot(nowyprzedmiot);
                        listaPrzedmiotow.add(nowyprzedmiot);
                        zatwierdz.setBackground(new Color(0x28B800));
                        zatwierdz.setText("UTWORZONO NOWY PRZEDMIOT");
                        przedmiotNazwaText.setText("");
                        przedmiotOpisText.setText("");
                        przedmiotPowierzchniaSlider.setValue(1);
                        }
                    }
                }
            }
        });

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

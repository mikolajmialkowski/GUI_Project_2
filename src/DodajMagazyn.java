import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodajMagazyn extends JFrame {

    ArrayList <Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;

    JLabel adresLabel;
    JLabel powierzchniaLabel;
    JTextField adresText;
    JSlider powierzchniaSlider;

    JLabel wybranaWartoscLabel;
    JLabel wybranaWartoscInt;

    JButton zatwierdz;
    JButton powrot;

    public DodajMagazyn(String name, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow){
        super(name);

        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow=listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));

        setIconImage(new ImageIcon("DodajMagazynIcon.png").getImage());

        panelN = new JPanel();
        panelC = new JPanel(new GridLayout(0,2));
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("DODAJ MAGAZYN");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        adresLabel = new JLabel("Podaj Adres:");
        adresLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        adresText = new JTextField();
        adresText.setPreferredSize(new Dimension(100,30));
        adresText.setFont(new Font("TimesRoman", Font.BOLD, 16));

        powierzchniaLabel = new JLabel("Ustaw Powierzchnie:");
        powierzchniaLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        powierzchniaSlider = new JSlider(50,300,50);

        powierzchniaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wybranaWartoscInt.setText(String.valueOf(powierzchniaSlider.getValue())+ " [m²]");
            }
        });

        wybranaWartoscLabel = new JLabel("Wybrana Powierzchnia:");
        wybranaWartoscLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        wybranaWartoscInt = new JLabel("50 [m²]");
        wybranaWartoscInt.setFont(new Font("TimesRoman", Font.BOLD, 16));

        zatwierdz = new JButton("ZATWIERDZ NOWY MAGAZYN");
        zatwierdz.setPreferredSize(new Dimension(200,50));

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!adresText.getText().equals("")){
                    listaMagazynow.add(new Magazyn(adresText.getText(),powierzchniaSlider.getValue()));
                    zatwierdz.setText("DODANO NOWY MAGAZYN!");
                    zatwierdz.setBackground(new Color(0x28B800));
                    adresText.setText("");
                    powierzchniaSlider.setValue(50);
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

        panelC.add(adresLabel);
        panelC.add(adresText);
        panelC.add(powierzchniaLabel);
        panelC.add(powierzchniaSlider);
        panelC.add(wybranaWartoscLabel);
        panelC.add(wybranaWartoscInt);

        panelS.add(zatwierdz);
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

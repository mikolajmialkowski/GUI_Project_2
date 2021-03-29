import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodajPrzedmiot extends JFrame {

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

    JLabel wybierzMagazyn;
    JLabel wybierzPrzedmiot;

    JList <Magazyn> JMagazyny;
    DefaultListModel<Magazyn> modelMagazyny;
    JScrollPane scrollMagazyny;

    JList <Przedmiot> JPrzedmioty;
    DefaultListModel<Przedmiot> modelPrzedmioty;
    JScrollPane scrollPrzedmioty;


    public DodajPrzedmiot(String name,ArrayList <Magazyn> listaMagazynow, ArrayList <Przedmiot> listaPrzedmiotow) {

        super(name);
        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));
        setIconImage(new ImageIcon("DodajPrzedmiotIcon.png").getImage());

        panelN = new JPanel();
        panelC = new JPanel(new GridLayout(0,2,0,20));
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("DODAJ DO MAGAZYNU");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        ArrayList <Magazyn> listaDoWyswietleniaMagazyny = new ArrayList<>();

        for (Magazyn tmp :listaMagazynow ) {
            if (tmp.getID() != 0) {
                listaDoWyswietleniaMagazyny.add(tmp);
            }
        }

        modelMagazyny = new DefaultListModel<>();
        modelMagazyny.addAll(listaDoWyswietleniaMagazyny);
        JMagazyny = new JList<>(modelMagazyny);
        JMagazyny.setFont(new Font("TimesRoman", Font.BOLD, 16));

        scrollMagazyny = new JScrollPane();
        scrollMagazyny.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollMagazyny.setViewportView(JMagazyny);

        ArrayList <Przedmiot> listaDoWyswietleniaPrzedmioty = new ArrayList<>();

        for (Magazyn tmp :listaMagazynow ) {
            if (tmp.getID() == 0) {
                for (Przedmiot PrzedmiotTMP :tmp.listaPrzedmiotow) {
                    listaDoWyswietleniaPrzedmioty.add(PrzedmiotTMP);
                }
            }
        }

        modelPrzedmioty = new DefaultListModel<>();
        modelPrzedmioty.addAll(listaDoWyswietleniaPrzedmioty);
        JPrzedmioty = new JList<>(modelPrzedmioty);
        JPrzedmioty.setFont(new Font("TimesRoman", Font.BOLD, 16));

        scrollPrzedmioty = new JScrollPane();
        scrollPrzedmioty.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPrzedmioty.setViewportView(JPrzedmioty);

        wybierzMagazyn = new JLabel("Wybierz Magazyn:");
        wybierzMagazyn.setFont(new Font("TimesRoman", Font.BOLD, 16));

        wybierzPrzedmiot = new JLabel("Wybierz Przedmiot:");
        wybierzPrzedmiot.setFont(new Font("TimesRoman", Font.BOLD, 16));

        panelC.add(wybierzPrzedmiot);
        panelC.add(scrollPrzedmioty);
        panelC.add(wybierzMagazyn);
        panelC.add(scrollMagazyny);

        zatwierdz = new JButton("DODAJ DO MAGAZYNU");
        zatwierdz.setPreferredSize(new Dimension(200,50));
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((JMagazyny.getSelectedValue() != null) && (JPrzedmioty.getSelectedValue() != null)) {

                    boolean czyDodanoPrzedmiot = false;
                    Przedmiot wybranyPrzedmiot = JPrzedmioty.getSelectedValue();
                    Magazyn wybranyMagazyn = JMagazyny.getSelectedValue();
                    for (Magazyn tmp : listaMagazynow) {
                        if (tmp.getID() == wybranyMagazyn.getID()) {
                            czyDodanoPrzedmiot = tmp.dodajPrzedmiot(wybranyPrzedmiot);
                            if (czyDodanoPrzedmiot)
                                listaDoWyswietleniaPrzedmioty.remove(wybranyPrzedmiot);
                        }

                    }
                    for (Magazyn tmp : listaMagazynow) {
                        if ((tmp.getID() == 0) && czyDodanoPrzedmiot) {
                            tmp.listaPrzedmiotow.remove(wybranyPrzedmiot);
                        }
                    }
                    if (czyDodanoPrzedmiot) {
                        zatwierdz.setBackground(new Color(0x28B800));
                        zatwierdz.setText("DODANO PRZEDMIOT");

                        panelC.remove(scrollPrzedmioty);
                        panelC.remove(wybierzMagazyn);
                        panelC.remove(wybierzPrzedmiot);
                        panelC.remove(scrollMagazyny);

                        modelMagazyny = new DefaultListModel<>();
                        modelMagazyny.addAll(listaDoWyswietleniaMagazyny);
                        JMagazyny = new JList<>(modelMagazyny);
                        JMagazyny.setFont(new Font("TimesRoman", Font.BOLD, 16));

                        scrollMagazyny = new JScrollPane();
                        scrollMagazyny.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollMagazyny.setViewportView(JMagazyny);

                        modelPrzedmioty = new DefaultListModel<>();
                        modelPrzedmioty.addAll(listaDoWyswietleniaPrzedmioty);
                        JPrzedmioty = new JList<>(modelPrzedmioty);
                        JPrzedmioty.setFont(new Font("TimesRoman", Font.BOLD, 16));

                        scrollPrzedmioty = new JScrollPane();
                        scrollPrzedmioty.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollPrzedmioty.setViewportView(JPrzedmioty);


                        panelC.add(wybierzPrzedmiot);
                        panelC.add(scrollPrzedmioty);
                        panelC.add(wybierzMagazyn);
                        panelC.add(scrollMagazyny);
                        czyDodanoPrzedmiot=false;
                    } else {
                        zatwierdz.setBackground(new Color(0xEE4141));
                        zatwierdz.setText("BRAK MIEJSCA");
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

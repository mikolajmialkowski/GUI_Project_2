import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZestawienieMagazynow extends JFrame {

    ArrayList<Magazyn> listaMagazynow;
    ArrayList<Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;

    JList <Magazyn> JMagazyn;
    DefaultListModel <Magazyn> modelMagazyny;
    JScrollPane scrollMagazyny;

    JList <Przedmiot> JPrzedmioty;
    DefaultListModel <Przedmiot> modelPrzedmioty;
    JScrollPane scrollPrzedmioty;

    JLabel wynikiMagazyn;
    JLabel wynikiPrzedmiot;

    public ZestawienieMagazynow(String name, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow) {
        super(name);

        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;

        panelC = new JPanel(new GridLayout(0,2,20,20));
        panelN = new JPanel();
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();

        setLayout(new BorderLayout(100, 100));
        setIconImage(new ImageIcon("ZestawienieMagazynowIcon.png").getImage());
        mainNapis = new JLabel("ZESTAWIENIE MAGAZYNÓW"); // GORA
        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        ArrayList<Magazyn> magazynyDoWyswietlenia = new ArrayList<>();

        for (Magazyn tmp :listaMagazynow) {
            if(tmp.getID()!=0){
                magazynyDoWyswietlenia.add(tmp);
            }
        }

        modelMagazyny = new DefaultListModel<>();
        modelMagazyny.addAll(magazynyDoWyswietlenia);
        JMagazyn = new JList<>(modelMagazyny);
        JMagazyn.setFont(new Font("TimesRoman", Font.BOLD, 16));

        scrollMagazyny = new JScrollPane();
        scrollMagazyny.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollMagazyny.setViewportView(JMagazyn);

        modelPrzedmioty = new DefaultListModel<>();
        JPrzedmioty = new JList<>(modelPrzedmioty);
        JPrzedmioty.setFont(new Font("TimesRoman", Font.BOLD, 16));

        scrollPrzedmioty = new JScrollPane();
        scrollPrzedmioty.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPrzedmioty.setViewportView(JPrzedmioty);

        wynikiMagazyn = new JLabel("",SwingConstants.LEFT);;
        wynikiPrzedmiot = new JLabel("",SwingConstants.LEFT);

        panelC.add(scrollMagazyny);
        panelC.add(scrollPrzedmioty);
        panelC.add(wynikiMagazyn);
        panelC.add(wynikiPrzedmiot);

        JMagazyn.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // TYLKO RAZ EVENT

                    modelPrzedmioty.clear();
                    modelPrzedmioty.addAll(JMagazyn.getSelectedValue().listaPrzedmiotow);

                    wynikiMagazyn.setFont(new Font("TimesRoman", Font.BOLD, 16));
                    wynikiMagazyn.setText("<html>ADRES: " +JMagazyn.getSelectedValue().getAdres() + "<br/> POWIERZCHNIA: "+ JMagazyn.getSelectedValue().getPowierzchnia()+ "<br/> ID: " +JMagazyn.getSelectedValue().getID() +"</html>");

                    wynikiPrzedmiot.setText("");

                    //repaint();
                }
            }
        });

        JPrzedmioty.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // TYLKO RAZ EVENT

                        wynikiPrzedmiot.setFont(new Font("TimesRoman", Font.BOLD, 16));
                        wynikiPrzedmiot.setText("<html>NAZWA: " +JPrzedmioty.getSelectedValue().getNazwa() + "<br/> OPIS: "+ JPrzedmioty.getSelectedValue().getOpis()+ "<br/> POWIERZCHNIA: " +JPrzedmioty.getSelectedValue().getPowierzchnia()+ "<br/> ID: "+ JPrzedmioty.getSelectedValue().getID()+"</html>");

                }
            }
        });

        powrot = new JButton("WRÓĆ"); // DOL
        powrot.setPreferredSize(new Dimension(200,50));
        powrot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaPrzedmiotowMagazynow listaPrzedmiotowMagazynow = new ListaPrzedmiotowMagazynow("LISTA PRZEDMIOTY / MAGAZYNY",listaMagazynow, listaPrzedmiotow );
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

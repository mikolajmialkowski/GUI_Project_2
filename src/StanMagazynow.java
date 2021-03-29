import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StanMagazynow extends JFrame {
    ArrayList <Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;
    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;
    JLabel labelTMP;

    public StanMagazynow(String name,ArrayList <Magazyn> listaMagazynow, ArrayList <Przedmiot> listaPrzedmiotow){

        super(name);
        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));

        setIconImage(new ImageIcon("StanMagazynowIcon.png").getImage());

        panelN = new JPanel();
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();
        panelC = new JPanel(new GridLayout(0,3,20,20));

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("STAN MAGAZYNÓW");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        for (Magazyn magazynTMP:listaMagazynow) {
            if(magazynTMP.getID()!=0) {

                labelTMP = new JLabel("",SwingConstants.CENTER);
                double zajetaPowierzchnia = 0;

                for (Przedmiot przedmiotTMP : magazynTMP.listaPrzedmiotow) {
                    zajetaPowierzchnia = zajetaPowierzchnia + przedmiotTMP.getPowierzchnia();
                }
                labelTMP.setFont(new Font("TimesRoman", Font.BOLD, 16));
                labelTMP.setText("<html>"+magazynTMP.getAdres() + " <br/>  " + Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) + "%</html>");

                if (Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) < 25) {
                    labelTMP.setBackground(new Color(0x28B800));
                    labelTMP.setOpaque(true);
                } else if (Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) < 50) {
                    labelTMP.setBackground(new Color(0xFFE600));
                    labelTMP.setOpaque(true);

                }
                else if (Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) < 75) {
                    labelTMP.setBackground(new Color(0xE58B05));
                    labelTMP.setOpaque(true);
                }

                else if (Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) < 90) {
                    labelTMP.setBackground(new Color(0xE8590C));
                    labelTMP.setOpaque(true);
                }

                else if (Math.round(zajetaPowierzchnia / magazynTMP.getPowierzchnia() * 100) >= 90) {
                    labelTMP.setBackground(new Color(0xEE4141));
                    labelTMP.setOpaque(true);
                }
                panelC.add(labelTMP);
            }
        }

        powrot = new JButton("MENU GŁÓWNE");
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

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaPrzedmiotow extends JFrame {


    ArrayList<Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;
    JScrollPane scroll;

    TableModel modelDanych;
    JTable tabelaPrzedmiotow;

    public ListaPrzedmiotow(String name, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow) {
        super(name);

        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow = listaPrzedmiotow;
        this.modelDanych = new ModelTabeliPrzedmioty(listaMagazynow,listaPrzedmiotow);

        setLayout(new BorderLayout(100, 100));

        setIconImage(new ImageIcon("ListaPrzedmiotowMagazynowIcon.png").getImage());


        panelC = new JPanel(new GridLayout(0, 1, 0, 30));
        panelN = new JPanel();
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();


        tabelaPrzedmiotow = new JTable();
        tabelaPrzedmiotow.setModel(modelDanych);

        DefaultTableCellRenderer srodek = new DefaultTableCellRenderer();
        srodek.setHorizontalAlignment( JLabel.CENTER );

        for (int i = 0; i < 4 ; i++) {
            tabelaPrzedmiotow.getColumnModel().getColumn(i).setCellRenderer(srodek);

        }

        JTableHeader naglowek = tabelaPrzedmiotow.getTableHeader();
        naglowek.setBackground(new Color(0xEE4141));
        naglowek.setForeground(Color.WHITE);
        naglowek.setFont(new Font("TimesRoman", Font.BOLD, 15));

        scroll = new JScrollPane(tabelaPrzedmiotow);
        tabelaPrzedmiotow.setFillsViewportHeight(true);
        scroll.setViewportView(tabelaPrzedmiotow);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        panelC.add(scroll);

        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis = new JLabel("ZESTAWIENIE PRZEDMIOTÓW");
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

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

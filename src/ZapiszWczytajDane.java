import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ZapiszWczytajDane extends JFrame {

    ArrayList<Magazyn> listaMagazynow;
    ArrayList <Przedmiot> listaPrzedmiotow;

    JPanel panelN;
    JPanel panelC;
    JPanel panelW;
    JPanel panelE;
    JPanel panelS;
    JLabel mainNapis;
    JButton powrot;

    JLabel zapiszLabel;
    JTextField zapiszText;
    JButton zapiszButton;

    JLabel odczytLabel;
    JTextField odczytText;
    JButton odczytButton;

    public ZapiszWczytajDane(String name, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow){
        super(name);

        this.listaMagazynow = listaMagazynow;
        this.listaPrzedmiotow=listaPrzedmiotow;

        setLayout(new BorderLayout(100,100));
        setIconImage(new ImageIcon("ZapiszWczytajDaneIcon.png").getImage());

        panelC = new JPanel(new FlowLayout(10,10,65)); // panelC = new JPanel(new FlowLayout(10,10,65));
        //panelC = new JPanel(new GridLayout(0,3,20,20));
        panelN = new JPanel();
        panelE = new JPanel();
        panelW = new JPanel();
        panelS = new JPanel();

        mainNapis = new JLabel("ZAPISZ / WCZYTAJ DANE"); // GORA
        panelN.setBackground(Color.LIGHT_GRAY);
        mainNapis.setFont(new Font(mainNapis.getFont().getName(),mainNapis.getFont().getStyle(),52));
        panelN.add(mainNapis);

        zapiszLabel = new JLabel("Podaj adres zapisu: ");
        zapiszLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        zapiszText = new JTextField();
        zapiszText.setPreferredSize(new Dimension(350,30));
        zapiszText.setFont(new Font("TimesRoman", Font.BOLD, 16));

        zapiszButton = new JButton(" ZAPISZ DANE  ");
        zapiszButton.setFont(new Font("TimesRoman", Font.BOLD, 16));
        zapiszButton.setPreferredSize(new Dimension(200,30));
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean czyZapisOk = false;
                if(!zapiszText.getText().equals("")){
                    StringBuilder zapis = new StringBuilder();
                    try {
                        FileWriter fileWriter = new FileWriter(zapiszText.getText()+".txt");
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        for ( Magazyn tmpMagazyn :listaMagazynow) {
                            zapis.append("@\n");
                            zapis.append(tmpMagazyn.getAdres()).append("\n");
                            zapis.append(tmpMagazyn.getPowierzchnia()).append("\n");
                            zapis.append(tmpMagazyn.getID()).append("\n");

                            for (Przedmiot tmpPrzedmiot :tmpMagazyn.listaPrzedmiotow) {
                                zapis.append("!\n");
                                zapis.append(tmpPrzedmiot.getNazwa()).append("\n");
                                zapis.append(tmpPrzedmiot.getOpis()).append("\n");
                                zapis.append(tmpPrzedmiot.getPowierzchnia()).append("\n");
                                zapis.append(tmpPrzedmiot.getID()).append("\n");
                            }
                        }

                    bufferedWriter.append(zapis);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    fileWriter.close();
                    czyZapisOk = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
                if (czyZapisOk){
                    zapiszButton.setBackground(new Color(0x28B800));
                    zapiszButton.setText(" DANE ZAPISANO");
                }
            }
        });

        panelC.add(zapiszLabel);
        panelC.add(zapiszText);
        panelC.add(zapiszButton);

        odczytLabel = new JLabel("Podaj adres odczytu:");
        odczytLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));

        odczytText = new JTextField();
        odczytText.setPreferredSize(new Dimension(350,30));
        odczytText.setFont(new Font("TimesRoman", Font.BOLD, 16));

        odczytButton = new JButton(" WCZYTAJ DANE ");
        odczytButton.setFont(new Font("TimesRoman", Font.BOLD, 16));
        odczytButton.setPreferredSize(new Dimension(200,30));
        odczytButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean czyOdczytOK = false;
                if(!odczytText.getText().equals("")){
                    try {
                        String odczyt = "";


                        Magazyn tmpMagazyn = new Magazyn("tmp",100,1000);
                        Przedmiot tmpPrzedmiot;

                        ArrayList <Magazyn> listaTMPMagazyn = new ArrayList<Magazyn>();
                        ArrayList <Przedmiot> listaTMPPrzedmiot = new ArrayList<Przedmiot>();

                        int liccznikMagazyn=0;
                        String magazynAdres="";
                        double magazynPowierzchnia=0;
                        int magazynID=0;


                        int licznikPrzedmiot=0;
                        String przedmiotNazwa="";
                        String przedmiotOpis="";
                        double przedmiotPowierzchnia=0;
                        int przedmiotID=0;


                        FileReader fileReader = new FileReader(odczytText.getText()+".txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        while ((odczyt = bufferedReader.readLine()) != null){

                            if (liccznikMagazyn==1){
                                magazynAdres = odczyt;
                                liccznikMagazyn++;
                            }
                            else if (liccznikMagazyn==2){
                                magazynPowierzchnia = Double.parseDouble(odczyt);
                                liccznikMagazyn++;
                            }
                           else if (liccznikMagazyn==3){
                                magazynID = Integer.parseInt(odczyt);
                                liccznikMagazyn++;
                            }
                            if (licznikPrzedmiot==1){
                                przedmiotNazwa = odczyt;
                                licznikPrzedmiot++;
                            }
                           else if (licznikPrzedmiot==2){
                                przedmiotOpis = odczyt;
                                licznikPrzedmiot++;
                            }
                           else if (licznikPrzedmiot==3){
                                przedmiotPowierzchnia = Double.parseDouble(odczyt);
                                licznikPrzedmiot++;
                            }

                            else if (licznikPrzedmiot==4){
                                przedmiotID = Integer.parseInt(odczyt);
                                licznikPrzedmiot++;
                            }
                           if (liccznikMagazyn==4){
                               tmpMagazyn = new Magazyn(magazynAdres,magazynPowierzchnia,magazynID);
                               listaTMPMagazyn.add(tmpMagazyn);
                               liccznikMagazyn=0;
                                magazynAdres="";
                                magazynPowierzchnia=0;
                                magazynID=0;
                           }

                            if (licznikPrzedmiot==5){
                                tmpPrzedmiot = new Przedmiot(przedmiotNazwa,przedmiotOpis,przedmiotPowierzchnia,przedmiotID);
                                listaTMPPrzedmiot.add(tmpPrzedmiot);

                                tmpMagazyn.listaPrzedmiotow.add(tmpPrzedmiot);

                                licznikPrzedmiot=0;
                                przedmiotNazwa="";
                                przedmiotOpis="";
                                przedmiotPowierzchnia=0;
                                przedmiotID=0;

                            }

                            if (odczyt.charAt(0)=='@'){ // MAGAZYN W NEXT
                                liccznikMagazyn++;
                            }
                            if (odczyt.charAt(0)=='!'){ // PRZEDMIOT W NEXT
                                licznikPrzedmiot++;
                            }
                        }

                        czyOdczytOK =true;

                        if (czyOdczytOK){
                            listaMagazynow.clear();
                            for (Magazyn tmp:listaTMPMagazyn) {
                                listaMagazynow.add(tmp);
                            }
                            listaPrzedmiotow.clear();
                            for (Przedmiot tmp:listaTMPPrzedmiot) {
                                listaPrzedmiotow.add(tmp);
                            }
                            int max=0;
                            for (Przedmiot tmp :listaPrzedmiotow) {
                                if (tmp.getID()>max){
                                    max=tmp.getID();
                                }
                                tmp.zwikeszGlobalID(max);
                            }


                            odczytButton.setBackground(new Color(0x28B800));
                            odczytButton.setText("WCZYTANO DANE");
                        }

                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    if(!czyOdczytOK) {
                        odczytButton.setBackground(new Color(0xEE4141));
                        odczytButton.setText("BLAD ODCZYTU");
                    }
                }
            }
        });

        panelC.add(odczytLabel);
        panelC.add(odczytText);
        panelC.add(odczytButton);

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

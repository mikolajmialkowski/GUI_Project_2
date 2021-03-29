import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.ArrayList;

public class OknoLogowania extends JFrame {

    JLabel Juser;
    JTextField userText;
    JLabel Jpassword;
    JPasswordField jPasswordField;
    JButton login;

    public OknoLogowania(String name, ArrayList<User> listaUzytkownikow, ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow){
        super(name);

        setIconImage(new ImageIcon("OknoLogowaniaIcon.png").getImage());

        setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        Juser = new JLabel("user:");
        panel1.add(Juser);

        userText = new JTextField();
        panel1.add(userText);
        userText.setPreferredSize(new Dimension(100,30));

        Jpassword = new JLabel("passoword:");
        panel1.add(Jpassword);

        jPasswordField = new JPasswordField();
        panel1.add(jPasswordField);
        jPasswordField.setPreferredSize(new Dimension(100,30));

        login = new JButton("LOGIN");
        panel2.add(login);
        login.setPreferredSize(new Dimension(200,50));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean prawidlowe = false;
                String nametmp="";
                for (User tmp:listaUzytkownikow) {
                    if ((tmp.getNickname().equals(userText.getText())) && (tmp.getPassword().equals(jPasswordField.getText()))){
                        prawidlowe = true;
                        nametmp = tmp.getNickname();
                    }
                }
                if (prawidlowe){
                    MainMenu MainMenu = new MainMenu("Zalogowano jako: "+nametmp, listaMagazynow, listaPrzedmiotow);
                    login.setText("Zalogowano pomyslnie");
                    panel2.setBackground(new Color(0x28B800));
                    setVisible(false);
                }
                else{
                    login.setText("Błąd - spróbuj jeszcze raz");
                    panel2.setBackground(new Color(0xEE4141));
                    userText.setText("");
                    jPasswordField.setText("");
                }
            }
        });

        getContentPane().add(panel1);
        panel1.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(panel2);
        panel2.setBackground(Color.LIGHT_GRAY);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(350,180);
        setVisible(true);
        setLocation(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Lab extends JFrame implements ActionListener {

    JTextArea textArea = new JTextArea();

    public Lab() {

        setTitle("Notatnik");
        Toolkit zestaw = Toolkit.getDefaultToolkit();
        Dimension rozmiarEkranu = zestaw.getScreenSize();
        int szerEkranu = rozmiarEkranu.width;
        int wysEkranu = rozmiarEkranu.height;
        setBounds(szerEkranu / 4, wysEkranu / 4, szerEkranu / 2, wysEkranu / 2);
        setResizable(false);

        ImageIcon image = new ImageIcon(getClass().getResource("/lab/logo.jpg"));
        setIconImage(image.getImage());
        
        JMenuBar pasekMenu = new JMenuBar();

        JMenu mPlik = new JMenu("Plik");

        JMenuItem otworz = new JMenuItem("Otworz");
        JMenuItem zapisz = new JMenuItem("Zapisz");
        JMenuItem zakoncz = new JMenuItem("Zakoncz");

        otworz.addActionListener(this);
        otworz.setActionCommand("11");
        zapisz.addActionListener(this);
        zapisz.setActionCommand("12");
        zakoncz.addActionListener(this);
        zakoncz.setActionCommand("13");

        JMenu mEdycja = new JMenu("Edycja");

        JMenuItem powieksz = new JMenuItem("Powieksz czcionke");
        JMenuItem pomniejsz = new JMenuItem("Pomniejsz czcionke");
        JMenuItem czysc = new JMenuItem("Wyczysc okno");
        JMenuItem kolory = new JMenuItem("Kolory: ");

        String[] czKolory = {"czerwona", "zielona", "niebieska", "czarna", "biała"};
        JLabel etyKolory = new JLabel("Kolory:  ");
        JComboBox kolorList = new JComboBox(czKolory);
        kolorList.setSelectedIndex(0);

        powieksz.addActionListener(this);
        powieksz.setActionCommand("21");
        pomniejsz.addActionListener(this);
        pomniejsz.setActionCommand("22");
        czysc.addActionListener(this);
        czysc.setActionCommand("23");

        kolorList.addActionListener(this); // Dodajemy ActionListener do JComboBox
        kolorList.setActionCommand("24");

        JMenu mPomoc = new JMenu("Pomoc");

        JMenuItem oautorze = new JMenuItem("O Autorze");
        JMenuItem jpomoc = new JMenuItem("Jak Wyjść Z Programu");

        oautorze.addActionListener(this);
        oautorze.setActionCommand("31");
        jpomoc.addActionListener(this);
        jpomoc.setActionCommand("32");

        pasekMenu.add(mPlik);
        pasekMenu.add(mEdycja);
        pasekMenu.add(mPomoc);

        mPlik.add(otworz);
        mPlik.add(zapisz);
        mPlik.addSeparator();
        mPlik.add(zakoncz);
        mPlik.addSeparator();

        mEdycja.add(powieksz);
        mEdycja.add(pomniejsz);
        mEdycja.addSeparator();
        mEdycja.add(czysc);
        mEdycja.addSeparator();

        mPomoc.add(oautorze);
        mPomoc.add(jpomoc);

        setJMenuBar(pasekMenu);

        textArea = new JTextArea();
        JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setLayout(new BorderLayout());

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);

        JPanel panelLewy = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelPrawy = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelPrzyciski = new JPanel(new GridLayout(1, 2));
        panelPrzyciski.add(panelLewy);
        panelPrzyciski.add(panelPrawy);
        panelPrawy.add(kolorList);
        add(panelPrzyciski, BorderLayout.SOUTH);

        // Tworzenie obramowania
        Border obramowanieL = BorderFactory.createLineBorder(Color.BLACK);  // Obramowanie linii czarną krawędzią
        panelLewy.setBorder(obramowanieL);
        panelPrawy.setBorder(obramowanieL);

        JButton tytul = new JButton("tytuł");
        JButton podpis = new JButton("podpis");

        tytul.addActionListener(this);
        tytul.setActionCommand("41");
        podpis.addActionListener(this);
        podpis.setActionCommand("42");

        panelLewy.add(tytul);

        panelLewy.add(podpis);

        JRadioButton bi = new JRadioButton("biały", true);
        JRadioButton zo = new JRadioButton("żółty");
        JRadioButton zi = new JRadioButton("zielony");

        bi.addActionListener(this);
        zo.addActionListener(this);
        zi.addActionListener(this);

        bi.setActionCommand("51");
        zo.setActionCommand("52");
        zi.setActionCommand("53");

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(bi);
        bg1.add(zo);
        bg1.add(zi);

        panelPrawy.add(bi);
        panelPrawy.add(zo);
        panelPrawy.add(zi);

        JPopupMenu menuPopup = new JPopupMenu(); // Corrected variable name
        JMenuItem metal = new JMenuItem("metal look-and-feel");
        JMenuItem windows = new JMenuItem("windows look-and-feel");
        JMenuItem motif = new JMenuItem("motif look-and-feel");
        menuPopup.add(metal); // Corrected variable name
        menuPopup.add(windows); // Corrected variable name
        menuPopup.add(motif); // Corrected variable name
        textArea.setComponentPopupMenu(menuPopup); // Corrected variable name
        metal.addActionListener(this);
        metal.setActionCommand("61");
        windows.addActionListener(this);
        windows.setActionCommand("62");
        motif.addActionListener(this);
        motif.setActionCommand("63");

    }

    public static void main(String[] args) throws Exception {

        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        Lab nt = new Lab();
        nt.setVisible(true);
        nt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //sprawdzenie ktory przycisk zostal wcisniety i wykonanie odpowiedniej akcji
        switch (Integer.parseInt(e.getActionCommand())) {
            case 11: {
                JFileChooser pliki = new JFileChooser(".");
                if (JFileChooser.APPROVE_OPTION == pliki.showOpenDialog(this))
		try {
                    File f = pliki.getSelectedFile();
                    setTitle(f.getAbsolutePath() + " Notatnik");
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String temp = "";
                    while (br.ready()) {
                        temp += br.readLine() + "\n";
                    }
                    textArea.setText(temp);
                } catch (IOException ex) {
                    System.out.println("Brak pliku");
                }
                break;
            }
            case 12: {
                JFileChooser pliki = new JFileChooser(".");
                if (JFileChooser.APPROVE_OPTION == pliki.showSaveDialog(this))
		try {
                    File f = pliki.getSelectedFile();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                        bw.write(textArea.getText());
                        bw.flush();
                    }
                } catch (IOException ee) {
                    System.out.println("Problemy z zapisem");
                }
                break;
            }
            case 13: {
                System.exit(0);
                break;
            }
            case 21: {
                Font f = new Font("Arial", Font.PLAIN, 38);
                textArea.setFont(f);
                break;
            }
            case 22: {
                Font f = new Font("Arial", Font.PLAIN, 10);
                textArea.setFont(f);
                break;
            }
            case 23: {
                textArea.setText("");
                break;
            }
            case 24: {
                JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                String selectedColor = (String) comboBox.getSelectedItem();
                System.out.println("Wybrany kolor: " + selectedColor); // Sprawdź, czy wartość jest prawidłowo wybierana
                switch (selectedColor) {
                    case "czerwona":
                        textArea.setForeground(Color.RED);
                        break;
                    case "zielona":
                        textArea.setForeground(Color.GREEN);
                        break;
                    case "niebieska":
                        textArea.setForeground(Color.BLUE);
                        break;
                    case "czarna":
                        textArea.setForeground(Color.BLACK);
                        break;
                    case "biała":
                        textArea.setForeground(Color.WHITE);
                        break;
                }
                break;
            }
            case 31: {
                JOptionPane.showMessageDialog(this, "Autor: Mikołaj Walasiewicz");
                break;
            }
            case 32:{
                JOptionPane.showMessageDialog(this, "Plik->Zakończ");
                break;
            }
            case 41: {
                textArea.setText("Szanowny Panie \n\n" + textArea.getText());
                break;
            }
            case 42: {
                textArea.setText(textArea.getText() + "\n\n Z poważaniem");
                break;
            }
            case 51: {
                textArea.setBackground(Color.WHITE);
                break;
            }
            case 52: {
                textArea.setBackground(Color.YELLOW);
                break;
            }
            case 53: {
                textArea.setBackground(Color.GREEN);
                break;
            }
            case 61: {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                }
                SwingUtilities.updateComponentTreeUI(this);
                break;
            }
            case 62: {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                }

                SwingUtilities.updateComponentTreeUI(this);
                break;
            }
            case 63: {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                }
                SwingUtilities.updateComponentTreeUI(this);
                break;
            }
        }
    }
}

# java3
AplikacjeOkienkowe

0. Proste okienko
-----------------

import javax.swing.JFrame;

public class Okienko extends JFrame {
    
    public Okienko() {
        
        setSize(400,400);
        setLocation(400,400);
        setTitle("Okieneczko");
        
    }
        
    public static void main(String[] args) {
        
        Okienko o = new Okienko();
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    
}



1. Stworzenie standardowego okienka Notatnika
---------------------------------------------
   
	package notatnik;

	import java.awt.Dimension;
	import java.awt.Toolkit;
	import javax.swing.JFrame;

	public class Notatnik extends JFrame {

		public Notatnik() {

			setTitle("Notatnik");

			Toolkit zestaw = Toolkit.getDefaultToolkit();
			Dimension rozmiarEkranu = zestaw.getScreenSize();
			int szerEkranu = rozmiarEkranu.width;
			int wysEkranu = rozmiarEkranu.height;
			setBounds(szerEkranu/4,wysEkranu/4,szerEkranu/2,wysEkranu/2);

			setResizable(false);

		}


		public static void main(String[] args) {
			Notatnik nt = new Notatnik();
			nt.setVisible(true);
			nt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
2. Tworzenie menu wyboru
------------------------


    Plik          Edycja          Pomoc		
    |             |               |		 
    Otworz        PowiekszC       OAutorze     	
    |             |		
    Zapisz        PomniejszC
    |             |
    -------       ---------
    |             |
    Zakoncz       Wyczysc
	
a)  Tworzenie paska menu
    --------------------

	JMenuBar pasekMenu = new JMenuBar();

b)  Tworzenie elementow menu
    ------------------------- 

	JMenu mPlik = new JMenu("Plik");
	...
	
c)  Tworzenie podelementow menu
    ----------------------------

	JMenuItem otworz = new JMenuItem("Otworz");
	JMenuItem zapisz = new JMenuItem("Zapisz");
	JMenuItem zakoncz = new JMenuItem("Zakoncz");
	...
    
d)  Dodawanie do paska menu elementow menu
    --------------------------------------

	pasekMenu.add(mPlik);
	pasekMenu.add(mEdycja);
	...
	
e)  Dodanie do elementow menu ich podelementow 
    ------------------------------------------

	mPlik.add(otworz);
	mPlik.add(zapisz);
	mPlik.addSeparator();
	mPlik.add(zakoncz);
	....
	
f)  Podlaczanie paska menu do okna 
    -------------------------------

	setJMenuBar(pasekMenu);
	
g)  Tworzenie przyciskow opcjonalnych w menu
    ----------------------------------------

	JRadioButtonMenuItem powiekszC = new JRadioButtonMenuItem("powiekszC");
	JRadioButtonMenuItem pomniejszC = new JRadioButtonMenuItem("pomniejszC");


h)  Tworzenie wspolnej grupy i podlaczenie do niej przyciskow opcjonalnych
    ----------------------------------------------------------------------

	ButtonGroup bg = new ButtonGroup();

	bg.add(powiekszC);
	bg.add(pomniejszC);	
   	
i)  Tworzenie klawiszy skrotow
    --------------------------

	otworz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
	zapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
	...
	
j)  Tworzenie mnemonikow
    --------------------

	mPlik.setMnemonic('P');
	mEdycja.setMnemonic('E');

	
3. Tworzenie obszaru tekstowego do pisania i dolnego panelu
   ---------------------------------------------------------
    	
a)  Tworzenie obszaru tekstowego
    ----------------------------

	textArea = new JTextArea();

b)  Tworzenie panelu przewijalnego z obszarem tekstowym
    ---------------------------------------------------

	JScrollPane sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

c)  Ustawiamy layout dla calego okna
    --------------------------------

	setLayout(new BorderLayout());

d)  Dodajemy panel przewijalny na centrum okna
    ------------------------------------------
	
	add(sp,BorderLayout.CENTER);

e)  Tworzymy panel lewy i prawy na przyciski
    ----------------------------------------
	
	JPanel panelLewy = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel panelPrawy = new JPanel(new FlowLayout(FlowLayout.CENTER));

f)  Tworzymy panel Zbiorczy na panele lewy i prawy
    ----------------------------------------------
	
	JPanel panelPrzyciski = new JPanel(new GridLayout(1,2));

g)  Na panel zbiorczy dodajemy panele lewy i prawy
    -----------------------------------------------

	panelPrzyciski.add(panelLewy);
	panelPrzyciski.add(panelPrawy);	
	
h)  Dodajemy panel zbiorczy na przyciski na dole okna
    -------------------------------------------------

	add(panelPrzyciski,BorderLayout.SOUTH);

i)  Tworzymy przyciski tytul i podpis i wrzucamy je na panel lewy
    --------------------------------------------------------------

	JButton tytul = new JButton("tytuł");
	JButton podpis = new JButton("podpis");
	panelLewy.add(tytul);
	panelLewy.add(podpis);	
	
j)  Tworzymy przyciski opcjonalne zielony, zolty i bialy i wrzucamy je na panel prawy
    ---------------------------------------------------------------------------------

	JRadioButton bi = new JRadioButton("biały");
	JRadioButton zo = new JRadioButton("żółty");
	JRadioButton zi = new JRadioButton("zielony");

	ButtonGroup bg1 = new ButtonGroup();
        
	bg1.add(bi);
	bg1.add(zo);
	bg1.add(zi);
        
	panelPrawy.add(bi);
	panelPrawy.add(zo);
	panelPrawy.add(zi);

4. Ustawianie stylu okna
   ---------------------
   
a)  Styl Metal (domyslny)
    ---------------------
	
	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

b)  Styl Motif
    ----------
	
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        
c)  Styl Windows
    ------------

	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	
d)  Styl  Nimbus	
    ------------
   
	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

4'. Ustawianie ikony

    -- Ustawic ikone Notatnika okna
	
	WSK. Wykorzystac klase ImageIcon.
	
5.  Ustawianie akcji
    ----------------
	
a)  Rozszerzenie klasy o implementacje interfejsu ActionListener
    ------------------------------------------------------------	
	
	public class Notatnik extends JFrame implements ActionListener

b)  Przypisanie numeru akcji do odpowiednich przyciskow
    ---------------------------------------------------
	
	bi.setActionCommand("51");
	zo.setActionCommand("52");
	zi.setActionCommand("53");

c)  Powiazanie obiektu nasluchujacego (biezacej klasy) ze zrodlem wystapienia zdarzenia
    -----------------------------------------------------------------------------------
    
	bi.addActionListener(this);
	zo.addActionListener(this);
	zi.addActionListener(this);

d)  Implementowanie metody nasluchujacej
    ------------------------------------
	
	
	public void actionPerformed(ActionEvent e)
	{
		//sprawdzenie ktory przycisk zostal wcisniety i wykonanie odpowiedniej akcji
		switch (Integer.parseInt(e.getActionCommand()))
		{
			case 11:
			{
				break;
			}
			case 12:
			{
				break;
			}
			case 13:
			{
				break;
			}
			case 21:
			{
				break;
			}
			case 22:
			{
				break;
			}
			case 23:
			{
				break;
			}
			case 31:
			{
				break;
			}
			case 41:
			{
				break;
			}		
			case 42:
			{
				break;
			}			
			case 51:
			{
				textArea.setBackground(Color.WHITE);
				break;
			}
			case 52:
			{
				textArea.setBackground(Color.YELLOW);
				break;
			}
			case 53:
			{
				textArea.setBackground(Color.GREEN);
				break;
			}
		}
	}

6.  Ustawianie akcji na dodatkowe elementy okna
    -------------------------------------------   

a)  Odczyt z pliku
    --------------

	JFileChooser pliki = new JFileChooser(".");
	if (JFileChooser.APPROVE_OPTION==pliki.showOpenDialog(this))
		try
		{
			File f=pliki.getSelectedFile();
			setTitle(f.getAbsolutePath()+" Notatnik");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String temp="";
			while (br.ready())
			{
				temp+=br.readLine()+"\n";
			}
			textArea.setText(temp);
		}
		catch (IOException ex)
		{
			System.out.println("Brak pliku");
		}

b) Zapis do pliku
   --------------

	JFileChooser pliki = new JFileChooser(".");
	if (JFileChooser.APPROVE_OPTION==pliki.showSaveDialog(this))
		try
		{
			File f=pliki.getSelectedFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(textArea.getText());
			bw.flush();
			bw.close();
		}
		catch (IOException ee)
		{
			System.out.println("Problemy z zapisem");
		}
		
c) Zamykanie aplikacji
   -------------------

	System.exit(0);   

d) Powiekszenie i pomniejszenie czcionki
   --------------------------------------
    
	Font f = new Font("Arial",Font.PLAIN,10);
	Font f = new Font("Arial",Font.PLAIN,18);

    a nastepnie:

	textArea.setFont(f);

e)  Czyszczenie okna
    ----------------
	
	textArea.setText("");
	
	
f)  Okienko dialogowe oAutorze
    ---------------------------
	
	JOptionPane.showMessageDialog(this,"Autor: Jan Kowalski");
	
g)  Wstawianie wstawek "Tytul" i "Podpis"

	textArea.setText("Szanowny Panie \n\n"+textArea.getText());
	textArea.setText(textArea.getText()+"\n\n Z poważaniem"); 	

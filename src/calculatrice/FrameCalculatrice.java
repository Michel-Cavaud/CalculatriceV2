package calculatrice;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class FrameCalculatrice {

	private JFrame frame;
	private Calculatrice cal = new Calculatrice();
	
	JPanel panel_principal;
	JLabel ecran;
	
	Image img = null;
	
	//Liste des boutons
	String[] boutons = {"leMRC","le7", "le4", "le1", "le0", "leMPlus", "le8", "le5", "le2", "lePoint", "leMmoins", "le9", "le6",
			"le3", "leSigne", "leCE", "lePourcent", "leMultiplier", "lePlus", "leON", "leRacine", "leDiviser", "leMoins", "leEgal" };
	
	MesBoutons[] mesBoutons = new MesBoutons[24];
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCalculatrice window = new FrameCalculatrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public FrameCalculatrice() {
		this.initialize();
		this.creerBoutons();
		this.ajouterFond();
		this.ecouteClavier();
	}
	
	/**
	 * Créer les boutons
	 */
	private void creerBoutons() {
		int imgBouton = 0;
		for(int i = 16; i <= 296; i = i + 70) {
			for(int j = 270; j <= 520; j = j + 60) {
				if(j == 330) { //Plus d'écart à la 2ème ligne
					j = j + 10;
				}
				if(imgBouton == 18) { //Gestion de la touche + double hauteur
					mesBoutons[imgBouton] = new MesBoutons(cal , panel_principal, ecran, boutons[imgBouton], i, j , 60, 110);
					panel_principal.add(mesBoutons[imgBouton]);
					j = 510;
				}else {
					mesBoutons[imgBouton] = new MesBoutons(cal , panel_principal, ecran, boutons[imgBouton], i, j , 60, 50);
					panel_principal.add(mesBoutons[imgBouton]);
				}
				imgBouton++;
			}
		}
	}

	/**
	 * Création de la frame, du panel principal et de l'écran
	 */
	private void initialize() {
		frame = new JFrame("Calculatrice");
		frame.setPreferredSize(new Dimension(387, 646));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	
		try {
			img = ImageIO.read(getClass().getResource("./images/icone.png"));
			frame.setIconImage(img);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		panel_principal = new JPanel();
		panel_principal.setLayout(null);
		panel_principal.setFocusable(true);
		frame.getContentPane().add(panel_principal, BorderLayout.CENTER);
		
		ecran = new JLabel("");
		ecran.setBounds(45, 133, 282, 60);
		ecran.setFont(new Font("Arial", Font.BOLD, 40));
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		panel_principal.add(ecran);
	}
	
	/**
	 * Ajout de l'image de fond
	 */
	private void ajouterFond() {
		JLabel fondLabel = new JLabel();
		fondLabel.setBounds(0, 0, 372, 607);
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/fond.png"));
			fondLabel.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panel_principal.add(fondLabel);
	}
	
	/**
	 * Ecoute du clavier
	 */
	private void ecouteClavier(){
		// Les saisies clavier
		panel_principal.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        	if(cal.isOnOff()) {
		        	switch(e.getKeyChar()) {
		        	case '0': 
		        		ecran.setText(cal.affichage("0"));
		        		mesBoutons[4].doClick();
		        		break;
		        	case '1': 
		        		ecran.setText(cal.affichage("1"));
		        		mesBoutons[3].doClick();
		        		break;
		        	case '2': 
		        		ecran.setText(cal.affichage("2"));
		        		mesBoutons[8].doClick();
		        		break;
		        	case '3': 
		        		ecran.setText(cal.affichage("3"));
		        		mesBoutons[13].doClick();
		        		break;
		        	case '4': 
		        		ecran.setText(cal.affichage("4"));
		        		mesBoutons[2].doClick();
		        		break;
		        	case '5': 
		        		ecran.setText(cal.affichage("5"));
		        		mesBoutons[7].doClick();
		        		break;
		        	case '6': 
		        		ecran.setText(cal.affichage("6"));
		        		mesBoutons[12].doClick();
		        		break;
		        	case '7': 
		        		ecran.setText(cal.affichage("7"));
		        		mesBoutons[1].doClick();
		        		break;
		        	case '8': 
		        		ecran.setText(cal.affichage("8"));
		        		mesBoutons[6].doClick();
		        		break;
		        	case '9': 
		        		ecran.setText(cal.affichage("9"));
		        		mesBoutons[11].doClick();
		        		break;
		        	case '.': 
		        		ecran.setText(cal.affichage("."));
		        		mesBoutons[9].doClick();
		        		break;
		        	case '+':
		        		ecran.setText(cal.operations("+"));
		        		mesBoutons[18].doClick();
		        		break;
		        	case '-':
		        		ecran.setText(cal.operations("-"));
		        		mesBoutons[22].doClick();
		        		break;
		        	case '*':
		        		ecran.setText(cal.operations("x"));
		        		mesBoutons[17].doClick();
		        		break;
		        	case '/':
		        		ecran.setText(cal.operations("/"));
		        		mesBoutons[21].doClick();
		        		break;
		        	case '=':
		        		ecran.setText(cal.resultat());
		        		mesBoutons[23].doClick();
		        		break;
		        	}
	        	}
	        }
	        @Override
	        public void keyPressed(KeyEvent e) {}
	        @Override
	        public void keyReleased(KeyEvent e) {
	        	if(e.getKeyCode()==KeyEvent.VK_ENTER){
	        		if(cal.isOnOff()) {
		        		ecran.setText(cal.resultat());
		        		mesBoutons[23].doClick();
	        		}
	            }
	        }
	    });
	}
	
}

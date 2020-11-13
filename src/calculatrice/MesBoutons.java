package calculatrice;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MesBoutons extends JButton{
	private Image img = null;
	private Calculatrice cal;
	private JPanel panel;
	private JLabel ecran;
	private String image;
	private int x;
	private int y;
	private int tailleX;
	private int tailleY;
	
	private final int numero;
	private static int nombreObjet = 0;
	
	public MesBoutons(Calculatrice cal, JPanel panel_principal, JLabel ecran, String image, int x, int y, int tailleX, int tailleY) {
		setCal(cal);
		setEcran(ecran);
		setPanel(panel_principal);
		setImage(image);
		setX(x);
		setY(y);
		setTailleX(tailleX);
		setTailleY(tailleY);
		
		setNombreObjet(getNombreObjet() + 1);
		this.numero = getNombreObjet();
		
		this.setBorder(null);
		this.setBackground(new Color(34, 43, 03));
		try {
			img = ImageIO.read(getClass().getResource("./images/" + getImage() + ".png"));
			
			this.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBounds(getX(), getY(), getTailleX(), getTailleY());	
		this.mouse();
	}
	
	public void mouse() {
		this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	getEcran().setText(getCal().quelBouton(getNumero()));
            	getPanel().requestFocus();
            }
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});	
	}
	
	/**
	 * @return the ecran
	 */
	public JLabel getEcran() {
		return ecran;
	}
	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}
	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	/**
	 * @param ecran the ecran to set
	 */
	public void setEcran(JLabel ecran) {
		this.ecran = ecran;
	}
	/**
	 * @return the nombreObjet
	 */
	public static int getNombreObjet() {
		return nombreObjet;
	}
	/**
	 * @param nombreObjet the nombreObjet to set
	 */
	public static void setNombreObjet(int nombreObjet) {
		MesBoutons.nombreObjet = nombreObjet;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @return the tailleX
	 */
	public int getTailleX() {
		return tailleX;
	}
	/**
	 * @param tailleX the tailleX to set
	 */
	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}
	/**
	 * @return the tailleY
	 */
	public int getTailleY() {
		return tailleY;
	}
	/**
	 * @param tailleY the tailleY to set
	 */
	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}
	/**
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(Image img) {
		this.img = img;
	}
	/**
	 * @return the cal
	 */
	public Calculatrice getCal() {
		return cal;
	}
	/**
	 * @param cal the cal to set
	 */
	public void setCal(Calculatrice cal) {
		this.cal = cal;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
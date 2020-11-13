package calculatrice;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MesBoutons extends JButton implements KeyListener{
	private Image img = null;
	private Calculatrice cal;
	private JLabel ecran;
	private String image;
	private int x;
	private int y;
	private int tailleX;
	private int tailleY;
	public MesBoutons(Calculatrice cal, JLabel ecran, String image, int x, int y, int tailleX, int tailleY) {
		setCal(cal);
		setEcran(ecran);
		setImage(image);
		setX(x);
		setY(y);
		setTailleX(tailleX);
		setTailleY(tailleY);
		
		this.setBorder(null);
		this.setBackground(new Color(34, 43, 03));
		try {
			img = ImageIO.read(getClass().getResource("./images/" + getImage() + ".png"));
			
			this.setIcon(new ImageIcon(img));
			this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	getEcran().setText(getCal().affichage("7"));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBounds(getX(), getY(), getTailleX(), getTailleY());
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	 * @return the ecran
	 */
	public JLabel getEcran() {
		return ecran;
	}




	/**
	 * @param ecran the ecran to set
	 */
	public void setEcran(JLabel ecran) {
		this.ecran = ecran;
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

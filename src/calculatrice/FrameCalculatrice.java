package calculatrice;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameCalculatrice {

	private JFrame frame;
	private Calculatrice cal = new Calculatrice();
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image img = null;
		
		frame = new JFrame();
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
		
		JPanel panel_principal = new JPanel();
		panel_principal.setLayout(null);
		panel_principal.setFocusable(true);
		frame.getContentPane().add(panel_principal, BorderLayout.CENTER);
		
		JLabel ecran = new JLabel("");
		ecran.setBounds(45, 133, 282, 60);
		ecran.setFont(new Font("Arial", Font.BOLD, 40));
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		panel_principal.add(ecran);
		
		JButton leCE = new JButton();
		leCE.setBorder(null);
		leCE.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leCE.png"));
			leCE.setIcon(new ImageIcon(img));
			leCE.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.leCE());
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leCE.setBounds(226, 270, 60, 50);
		panel_principal.add(leCE);
		
		JButton leONC = new JButton();
		leONC.setBorder(null);
		leONC.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leON.png"));
			leONC.setIcon(new ImageIcon(img));
			leONC.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean retour = cal.onOff();
    				if(retour) {
    					ecran.setText(cal.affichage("0"));
    				}
    				panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leONC.setBounds(296, 270, 60, 50);
		panel_principal.add(leONC);
		
		JButton le7 = new JButton();
		le7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		le7.setBorder(null);
		le7.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le7.png"));
			le7.setIcon(new ImageIcon(img));
			le7.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("7"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le7.setBounds(16, 340, 60, 50);
		panel_principal.add(le7);
		
		JButton le8 = new JButton();
		le8.setBorder(null);
		le8.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le8.png"));
			le8.setIcon(new ImageIcon(img));
			le8.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("8"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le8.setBounds(86, 340, 60, 50);
		panel_principal.add(le8);
		
		JButton le9 = new JButton();
		le9.setBorder(null);
		le9.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le9.png"));
			le9.setIcon(new ImageIcon(img));
			le9.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("9"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le9.setBounds(156, 340, 60, 50);
		panel_principal.add(le9);
		
		JButton le4 = new JButton();
		le4.setBorder(null);
		le4.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le4.png"));
			le4.setIcon(new ImageIcon(img));
			le4.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("4"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le4.setBounds(16, 400, 60, 50);
		panel_principal.add(le4);
		
		JButton le5 = new JButton();
		le5.setBorder(null);
		le5.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le5.png"));
			le5.setIcon(new ImageIcon(img));
			le5.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("5"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le5.setBounds(86, 400, 60, 50);
		panel_principal.add(le5);
		
		JButton le6 = new JButton();
		le6.setBorder(null);
		le6.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le6.png"));
			le6.setIcon(new ImageIcon(img));
			le6.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("6"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le6.setBounds(156, 400, 60, 50);
		panel_principal.add(le6);
		
		JButton le1 = new JButton();
		le1.setBorder(null);
		le1.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le1.png"));
			le1.setIcon(new ImageIcon(img));
			le1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("1"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le1.setBounds(16, 460, 60, 50);
		panel_principal.add(le1);
		
		JButton le2= new JButton();
		le2.setBorder(null);
		le2.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le2.png"));
			le2.setIcon(new ImageIcon(img));
			le2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("2"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le2.setBounds(86, 460, 60, 50);
		panel_principal.add(le2);
		
		JButton le3 = new JButton();
		le3.setBorder(null);
		le3.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le3.png"));
			le3.setIcon(new ImageIcon(img));
			le3.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("3"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le3.setBounds(156, 460, 60, 50);
		panel_principal.add(le3);
		
		JButton le0 = new JButton();
		le0.setBorder(null);
		le0.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/le0.png"));
			le0.setIcon(new ImageIcon(img));
			le0.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("0"));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		le0.setBounds(16, 520, 60, 50); 
		panel_principal.add(le0);
		
		JButton lePoint= new JButton();
		lePoint.setBorder(null);
		lePoint.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./Images/lePoint.png"));
			lePoint.setIcon(new ImageIcon(img));
			lePoint.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.affichage("."));
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lePoint.setBounds(86, 520, 60, 50);
		panel_principal.add(lePoint);
		
		JButton leSigne= new JButton();
		leSigne.setBorder(null);
		leSigne.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./Images/leSigne.png"));
			leSigne.setIcon(new ImageIcon(img));
			leSigne.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.changementSigne());
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leSigne.setBounds(156, 520, 60, 50);
		panel_principal.add(leSigne);
		
		JButton lePourcent = new JButton();
		lePourcent.setBorder(null);
		lePourcent.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/lePourcent.png"));
			lePourcent.setIcon(new ImageIcon(img));
			lePourcent.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ecran.setText(cal.pourcentage());
                    panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lePourcent.setBounds(226, 340, 60, 50);
		panel_principal.add(lePourcent);
		
		JButton leRacine = new JButton();
		leRacine.setBorder(null);
		leRacine.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leRacine.png"));
			leRacine.setIcon(new ImageIcon(img));
			leRacine.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.racine());
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leRacine.setBounds(296, 340, 60, 50);
		panel_principal.add(leRacine);
		
		JButton leMultiplier = new JButton();
		leMultiplier.setBorder(null);
		leMultiplier.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leMultiplier.png"));
			leMultiplier.setIcon(new ImageIcon(img));
			leMultiplier.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	cal.operations("x");
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leMultiplier.setBounds(226, 400, 60, 50);
		panel_principal.add(leMultiplier);
		
		JButton leDiviser = new JButton();
		leDiviser.setBorder(null);
		leDiviser.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leDiviser.png"));
			leDiviser.setIcon(new ImageIcon(img));
			leDiviser.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	cal.operations("/");
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leDiviser.setBounds(296, 400, 60, 50);
		panel_principal.add(leDiviser);
		
		JButton lePlus = new JButton();
		lePlus.setBorder(null);
		lePlus.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/lePlus.png"));
			lePlus.setIcon(new ImageIcon(img));
			lePlus.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	cal.operations("+");
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lePlus.setBounds(226, 460, 60, 110);
		panel_principal.add(lePlus);
		
		JButton leMoins= new JButton();
		leMoins.setBorder(null);
		leMoins.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leMoins.png"));
			leMoins.setIcon(new ImageIcon(img));
			leMoins.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	cal.operations("-");
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leMoins.setBounds(296, 460, 60, 50);
		panel_principal.add(leMoins);
		
		JButton leEgal = new JButton();
		leEgal.setBorder(null);
		leEgal.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leEgal.png"));
			leEgal.setIcon(new ImageIcon(img));
			leEgal.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.resultat());
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leEgal.setBounds(296, 520, 60, 50);
		panel_principal.add(leEgal);
		
		JButton leMRC = new JButton();
		leMRC.setBorder(null);
		leMRC.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leMRC.png"));
			leMRC.setIcon(new ImageIcon(img));
			leMRC.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.memoires("MRC"));
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leMRC.setBounds(16, 270, 60, 50);
		panel_principal.add(leMRC);
		
		JButton leMPlus = new JButton();
		leMPlus.setBorder(null);
		leMPlus.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leMPlus.png"));
			leMPlus.setIcon(new ImageIcon(img));
			leMPlus.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.memoires("M+"));
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leMPlus.setBounds(86, 270, 60, 50);
		panel_principal.add(leMPlus);
		
		JButton leMMoins = new JButton();
		leMMoins.setBorder(null);
		leMMoins.setBackground(new Color(34, 43, 03));
		img = null;
		try {
			img = ImageIO.read(getClass().getResource("./images/leMMoins.png"));
			leMMoins.setIcon(new ImageIcon(img));
			leMMoins.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	ecran.setText(cal.memoires("M-"));
                	panel_principal.requestFocus();
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		leMMoins.setBounds(156, 270, 60, 50);
		panel_principal.add(leMMoins);
		
		
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
		
		JPanel panel_ecran = new JPanel();
		panel_ecran.setBounds(33, 123, 303, 79);
		panel_principal.add(panel_ecran);
		panel_ecran.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 56, 321, 41);
		panel_principal.add(panel);
		
		// Les saisies clavier
		panel_principal.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        	if(cal.isOnOff()) {
		        	switch(e.getKeyChar()) {
		        	case '0': 
		        		ecran.setText(cal.affichage("0"));
		        		le0.doClick();
		        		break;
		        	case '1': 
		        		ecran.setText(cal.affichage("1"));
		        		le1.doClick();
		        		break;
		        	case '2': 
		        		ecran.setText(cal.affichage("2"));
		        		le2.doClick();
		        		break;
		        	case '3': 
		        		ecran.setText(cal.affichage("3"));
		        		le3.doClick();
		        		break;
		        	case '4': 
		        		ecran.setText(cal.affichage("4"));
		        		le4.doClick();
		        		break;
		        	case '5': 
		        		ecran.setText(cal.affichage("5"));
		        		le5.doClick();
		        		break;
		        	case '6': 
		        		ecran.setText(cal.affichage("6"));
		        		le6.doClick();
		        		break;
		        	case '7': 
		        		ecran.setText(cal.affichage("7"));
		        		le7.doClick();
		        		break;
		        	case '8': 
		        		ecran.setText(cal.affichage("8"));
		        		le8.doClick();
		        		break;
		        	case '9': 
		        		ecran.setText(cal.affichage("9"));
		        		le9.doClick();
		        		break;
		        	case '.': 
		        		ecran.setText(cal.affichage("."));
		        		lePoint.doClick();
		        		break;
		        	case '+':
		        		cal.operations("+");
		        		lePlus.doClick();
		        		break;
		        	case '-':
		        		cal.operations("-");
		        		leMoins.doClick();
		        		break;
		        	case '*':
		        		cal.operations("x");
		        		leMultiplier.doClick();
		        		break;
		        	case '/':
		        		cal.operations("/");
		        		leDiviser.doClick();
		        		break;
		        	case '=':
		        		ecran.setText(cal.resultat());
		        		leEgal.doClick();
		        		break;
		        	}
	        	}
	        }
	        @Override
	        public void keyPressed(KeyEvent e) {}
	        @Override
	        public void keyReleased(KeyEvent e) {
	        	if(e.getKeyCode()==KeyEvent.VK_ENTER){
	        		ecran.setText(cal.resultat());
	        		leEgal.doClick();
	            }
	        }
	    });
	}
}

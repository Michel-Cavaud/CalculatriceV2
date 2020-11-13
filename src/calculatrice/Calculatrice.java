package calculatrice;

import java.math.BigDecimal;
import java.math.MathContext;


/**
 * Les fonctions de calcules 
 * @author Michel CAVAUD
 *
 */
public class Calculatrice {
	private boolean onOff = false; //Calculatrice ON ou OFF
	private String chaineAffiche = ""; // La chaine renvoyée pour l'affichage 
	private String operation =  ""; //Une opération est demandé ( +, -, *, /)
	private String resultats; //Le 1er nombre tapé ou le resultat précédent
	private boolean posNombre = true; //Possibilité de faire un calcul
	private boolean signe = true; //Possibilité de changer le signe du nombre
	private String memoire = "0"; //La mémoire
	
	/**
	 * Allume la calculette ou efface les données si déjà sur ON
	 * @return isOnOff() Si ON ou OFF
	 */
	public boolean onOff() {
		if (!isOnOff()) {
			setOnOff(!isOnOff());
			setChaineAffiche("");
			
		}else {
			setChaineAffiche("");
			setOperation("");
			setResultats("");
			setPosNombre(true);
			setMemoire("0");
		}
		return isOnOff();
	}
	
	/**
	 * Efface le dernier nombre rentré
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String leCE() {
		setChaineAffiche("0");
		return getChaineAffiche();
	}
	
	/**
	 * Gestion des touches mémoires
	 * @param mem La touche mémoire activé (MRC, M+ ou M-)
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String memoires(String mem) {
		if(isOnOff() & !isPosNombre()) {
			BigDecimal valeur1 = new BigDecimal(getMemoire());
			BigDecimal valeur2 = new BigDecimal(getChaineAffiche());
			MathContext precision = new MathContext(10); 
			switch (mem) {		
				case "M+":
					setMemoire("" + valeur1.add(valeur2, precision));			
					break;
				case "M-":
					setMemoire("" + valeur1.subtract(valeur2, precision));
					break;
				case "MRC":
					setChaineAffiche(getMemoire());
					break;
			}
			setOperation("");
			setResultats("");
			setPosNombre(false);
		}
		return getChaineAffiche();
	}

	/**
	 * Gestion des chiffres pour contituer la chaine à afficher
	 * @param touche la valeur entré dans la calculette (0 à 9 et le .)
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String affichage(String touche) {
		if(isOnOff()) {
			if(isPosNombre()) {
				if(touche.equals("0") & getChaineAffiche().equals("0")) {
					setChaineAffiche("0");
				}else {
					if(getChaineAffiche().indexOf('.') != -1 & touche.equals(".")) {
						touche = "";
					}
					setChaineAffiche(getChaineAffiche() + touche);
				}
			}else {
				setChaineAffiche(touche);
				setPosNombre(true);
				setSigne(true);
			}
		}
		//Suprimer le 1er zéro ou ajouter un zéro si le point est au début
		if(getChaineAffiche().length() > 1) {
			if(getChaineAffiche().charAt(0) == '0' & getChaineAffiche().charAt(1) != '.') {
				setChaineAffiche(getChaineAffiche().substring(1, getChaineAffiche().length()));
			}
			if(getChaineAffiche().charAt(0) == '.') {
				setChaineAffiche("0" + getChaineAffiche());
			}
		}
		return getChaineAffiche();
	}
	
	/**
	 * Gestion du changement de signe
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String changementSigne() {
		if(isSigne()){
			if(getChaineAffiche().charAt(0) == '-') {
				setChaineAffiche(getChaineAffiche().substring(1, getChaineAffiche().length()));
			}else {
				setChaineAffiche("-" + getChaineAffiche());
			}
		}
		return getChaineAffiche();
	}
	
	/**
	 * Calcul du pourcentation
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String pourcentage() {
		BigDecimal valeur1 = new BigDecimal(getChaineAffiche());
		BigDecimal valeur2 = new BigDecimal("100");
		MathContext precision = new MathContext(10); 
		setChaineAffiche("" + valeur1.divide(valeur2, precision));
		setOperation("");
		setPosNombre(false);
		
		return getChaineAffiche();
	}
	
	/**
	 * Calcul de la racine carré
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String racine() {
		Float f = Float.parseFloat(getChaineAffiche());
		Float result = (float) Math.sqrt(f);
		if(result.isNaN()) {
			setChaineAffiche("Erreur");
		}else {
			setChaineAffiche("" + result);
		}
		setOperation("");
		setPosNombre(false);
		
		return afficheInt();
	}
	
	/**
	 * Enregistre l'opération à faire
	 * @param touche Quelle Opération (+, -, *, /)
	 */
	public void operations(String touche) {
		setSigne(false);
		setPosNombre(false);
		if(getOperation() != "") {
			this.resultat();
		}
		setOperation(touche);
		setResultats(getChaineAffiche());
	}
	
	/**
	 * Suite au égal ou entrer du clavier fait l'opération demandée
	 * @return getChaineAffiche() La chaine à afficher
	 */
	public String resultat() {
		if(getOperation() != "" & isPosNombre()) {
			BigDecimal valeur1 = new BigDecimal(resultats);
			BigDecimal valeur2 = new BigDecimal(getChaineAffiche());
			MathContext precision = new MathContext(10); 
			switch (getOperation()) {
			case "+":
				setChaineAffiche("" + valeur1.add(valeur2, precision));
				break;
			case "-":
				setChaineAffiche("" + valeur1.subtract(valeur2, precision));
				break;	
			case "x":
				setChaineAffiche("" + valeur1.multiply(valeur2, precision));
				break;	
			case "/":
				if(valeur2.compareTo(BigDecimal.ZERO) != 0) {
					setChaineAffiche("" + valeur1.divide(valeur2, precision));
				}else {
					setChaineAffiche("/ par 0");
				}
				break;	
			}
			setOperation("");
			setPosNombre(false);
		}
	
		return afficheInt();
	}
		
	/**
	 * Transforme le résultat en int si pas de valeur après le .
	 * @return getChaineAffiche() La chaine à afficher
	 */
	private String afficheInt() {
		try {
			float fFloat = Float.parseFloat(getChaineAffiche());
			int fInt = (int)fFloat;
			if (fFloat - fInt == 0) {
				setChaineAffiche("" + fInt);
			}
		}catch(Exception e) {
				
		}
		return getChaineAffiche();
	}
	

	/**
	 * @return the resultats
	 */
	public String getResultats() {
		return resultats;
	}

	/**
	 * @param resultats the resultats to set
	 */
	public void setResultats(String resultats) {
		this.resultats = resultats;
	}

	/**
	 * @return the posNombre
	 */
	public boolean isPosNombre() {
		return posNombre;
	}

	/**
	 * @param posNombre the posNombre to set
	 */
	public void setPosNombre(boolean posNombre) {
		this.posNombre = posNombre;
	}

	/**
	 * @return the signe
	 */
	public boolean isSigne() {
		return signe;
	}

	/**
	 * @param signe the signe to set
	 */
	public void setSigne(boolean signe) {
		this.signe = signe;
	}

	/**
	 * @return the memoire
	 */
	public String getMemoire() {
		return memoire;
	}

	/**
	 * @param memoire the memoire to set
	 */
	public void setMemoire(String memoire) {
		this.memoire = memoire;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param touche the operation to set
	 */
	public void setOperation(String touche) {
		this.operation = touche;
	}

	/**
	 * @return the chaineAffiche
	 */
	public String getChaineAffiche() {
		if(chaineAffiche.length() > 12) {
			chaineAffiche = "Trop Grand";
			setOperation("");
			setPosNombre(false);
		}
		return chaineAffiche;
	}

	/**
	 * @param chaineAffiche the chaineAffiche to set
	 */
	public void setChaineAffiche(String chaineAffiche) {
		this.chaineAffiche = chaineAffiche;
	}

	/**
	 * @return the onOff
	 */
	public boolean isOnOff() {
		return onOff;
	}

	/**
	 * @param onOff the onOff to set
	 */
	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}
	


}

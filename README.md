## Projet Pédagogique *`La calculatrice`*

 **Formation Concepteur Développeur D'Applications (CDA) 2020 - 2021 GRETA Montpellier.**
 
**Le projet :** 
Concevoir une calculatrice en JAVA et Swing suivant les consignes ([Voir consignes](https://github.com/Michel-Cavaud/CalculatriceV2/blob/master/Dossier_Conception/Projet-calculatrice.pdf))
Utiliser la méthode [KANBAN](https://cda.needemand.com/2020/11/04/kanban-une-methode-agile-en-developpement-it/) et fournir les copies d'écran ou document sur le déroulé du projet.  Il est proposé d'utiliser le site [TRELLO](https://cda.needemand.com/2020/11/03/trello/) pour cette méthode "agile" 

**La conception :**
J'ai d'abord fait une version 1 avec une interface "simple" en bouton et une création des boutons individuelle. Cette version était fonctionnelle pour les calculs de la calculatrice.
**La version 2** a une interface plus proche du travail demandé (utilisation d'image pour les boutons),
![Capture d'écran calculatrice](https://github.com/Michel-Cavaud/CalculatriceV2/blob/master/Dossier_Conception/Capture-ecran_calculatricepng.png)

une class spécifique pour créer des boutons. Chaque bouton est un nouvel objet de cette class créé par une boucle.
   

       /**
        	 * Créer les boutons
        	 */
        	private void creerBoutons() {
        		int imgBouton = 0;
        		for(int i = 16; i <= 296; i = i + 70) {
        			for(int j = 270; j <= 520; j = j + 60) {
        				if(j == 330) { //Plus d'Ã©cart Ã  la 2Ã¨me ligne
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

Au fur et à mesure du projet les fiches Kanban ont avancé dans le tableau. Avec de nouvelles fiches créées suivant le besoin. ([Dossier Kanban](https://github.com/Michel-Cavaud/CalculatriceV2/tree/master/Dossier_Conception/Kanban))

Un jeu de test à été créé pour tester toutes les fonctionnalités de la calculatrice ([Jeu de test](https://github.com/Michel-Cavaud/CalculatriceV2/blob/master/Dossier_Conception/Jeux%20de%20test.pdf)) 

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTg2NjM5ODA0OV19
-->
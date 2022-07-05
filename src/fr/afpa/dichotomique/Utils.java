package fr.afpa.dichotomique;

import javax.swing.*;

public class Utils {



    // déclaration du tableau d'entiers de 10 cases avec des valeurs définies
    public static int [] declarerTableau() {
        return new int[]{-2, -1, 0, 13, 24, 37, 44, 56, 99, 117};
    }

    // saisie de la valeur recherchée x par l'utilisateur
    public static int demanderNombre() {
        String nb = JOptionPane.showInputDialog(
                null,
                "Saisissez un nombre",
                "Valeur de X",
                JOptionPane.QUESTION_MESSAGE);

        return Integer.parseInt(nb);
    }

    // recherche dichotomique de la valeur x dans le tableau TabEntiers
    public static int rechercherEntier(int[] TabEntiers, int indiceBas, int indiceHaut, int x) {
        // initialisation de la valeur de resultat à -1 afin que si la saisie n'est pas dans le tableau on ait
        // directement la valeur "erreur"
        int resultat = -1;  // on définit la valeur par défaut qui correspond au fait que
                            // nous ne trouvons pas le nombre recherché

        // modification de la "balise" indiceMilieu pour changer le min ou le max du tableau si la valeur n'est pas trouvée
        int indiceMilieu = indiceBas + (indiceHaut - indiceBas) / 2;

        // on cherche si x est égal à un des 3 indices
        if (x == TabEntiers[indiceHaut]) {
            resultat = indiceHaut;
        } else if (x == TabEntiers[indiceBas]) {
            resultat = indiceBas;
        } else if (x == TabEntiers[indiceMilieu]) {
            resultat = indiceMilieu;
        } else if (indiceBas < indiceHaut){// condition permettant de sortir des boucles
            if (TabEntiers[indiceMilieu] > x) {
            /* on créé un nouveau tableau avec comme bornes :
            case début = indiceBas
            case fin = indiceMilieu -1
            */
                resultat = rechercherEntier(TabEntiers, indiceBas, indiceMilieu - 1, x);
            } else if (TabEntiers[indiceMilieu] < x) {
            /* on créé un nouveau tableau avec comme bornes :
            case début = indiceMilieu+1
            case fin = indiceHaut
             */
                resultat = rechercherEntier(TabEntiers, indiceMilieu + 1, indiceHaut, x);
            }
        }

        return resultat;

    }

    public static void afficherResultat(final int x, int resultat){
        String message;
        if (resultat != -1) {
            message = "Le nombre " + x + " est à la position n° " + resultat ;
        } else {
            message = "Le nombre " + x + " n'est pas dans le tableau" ;
        }
        JOptionPane.showMessageDialog(
                null,
                message,
                "Résultat",
                JOptionPane.INFORMATION_MESSAGE);
    }

}

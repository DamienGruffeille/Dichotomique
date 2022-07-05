package fr.afpa.dichotomique;

public class Main {

    private static int [] TabEntiers = new int[] {};

    static int resultat;

    static int x;

    public static int getResultat() {return resultat;}
    public static void setResultat(int valeur) {resultat = valeur;}

    public static int getX() {return x;}
    public static void setX(int valeur) {x = valeur;}

    public static void main(String[] args) {
        TabEntiers = Utils.declarerTableau(); //TabEntiers prend la valeur du tableau de la fonction declarerTableau
        // affichage du tableau
        for (int nb : TabEntiers) {
            System.out.print(nb + ", ");
        }
        System.out.println("");
        setX(Utils.demanderNombre());
        setResultat(Utils.rechercherEntier(TabEntiers, 0, TabEntiers.length -1, getX()));
//        System.out.println(result);
        Utils.afficherResultat(getX(),getResultat());
    }
}

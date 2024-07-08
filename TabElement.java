/**
 * @author Halmi ilias
 * @author Maha Bengrab
 * @version Février 2024
 */
import java.util.Random;
public class TabElement{
    //Attributs
    private int taille ;
    private Element[] tab ;
    //Constructeurs
    public TabElement(){
        this.taille = 0;
    }
    /**
     * Ce constructeur crée un tableau avec la taille qu'on passe en paramètre
     */
    public TabElement(int taille){
        this.taille = taille;
        this.tab = new Element[taille];
    }
    /**
     * Ce constructeur prend en paramètre un tableau d'élément
     */
    public TabElement(Element[] tab){
        this.tab = tab;
        this.taille = tab.length;
    }
    //Accesseurs
    /**
     * Accesseur retournant la taille
     * @return taille
     */
    public int getTaille(){
        return taille;
    }
    /**
     * Accesseur retournant un tableau
     * @return tab
     */
    public Element[] getTabElement(){
        return tab;
    }
    //Modificateurs
    /**
     * La méthode setTaille modifie la taille
     */
    public void setTaille(int n){
        this.taille = n;
    }
    /**
     * setTab modifie un tableau
     */
    public void setTab(Element[] tab){
        this.tab = tab;
    }
    /**
     * Representation sous forme d'une chaine de caractères
     */
    public String toString() {
        String res = "";
        for(int i = 0 ; i < taille-1 ; i++) {
            res += tab[i] + "\n";
        }
        return res + tab[taille - 1 ] ;
    }
    /**
     * Méthode responsable de la génération aléatoire des nombres
     * @param n
     * @return elements
     */
    public Element[] initAleatoire(int n) {
        Element[] elements = new Element[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(100); // Clé aléatoire entre 0 et 99
            String value = "value" + i; // Valeur simple pour l'exemple
            elements[i] = new Element(key, value);
        }
        return elements;
    }
    /**
     * La méthode du tri par insertion
     * @param Tab
     */
    public void triInsertion(Element[] Tab) {
        for (int i = 1; i < Tab.length; i++) {
            Element cle = Tab[i];
            int j = i - 1;
            while (j >= 0 && Tab[j].getCle() > cle.getCle()) {
                Tab[j + 1] = Tab[j];
                j = j - 1;
            }
            Tab[j + 1] = cle;
        }
    }
    /**
     * La méthode du tri fusion
     * @param T
     */
     public void triFusion(Element[] T) {
        triFusion(T, 0, T.length - 1);
    }
    //La méthode tri fusion est responsable de la division du tableau en sous parties
    private void triFusion(Element[] T, int deb, int fin) {
        if (deb < fin) {
            int milieu = (deb + fin) / 2;
            triFusion(T, deb, milieu);
            triFusion(T, milieu + 1, fin);
            fusionner(T, deb, milieu, fin);
        }
    }
    //La methode fusionner se charge de la fusion des sous parties jusqu'a l'obtention du tableau trié en entier

    private void fusionner(Element[] T, int debut, int milieu, int fin) {
    int taille1 = milieu - debut + 1;
    int taille2 = fin - milieu;

    Element[] tableauGauche = new Element[taille1];
    Element[] tableauDroit = new Element[taille2];

    // Remplir les sous-tableaux gauche et droit
    for (int i = 0; i < taille1; i++) {
        tableauGauche[i] = T[debut + i];
    }
    for (int j = 0; j < taille2; j++) {
        tableauDroit[j] = T[milieu + 1 + j];
    }

    // Fusionner les deux sous-tableaux dans le tableau principal T
    int i = 0, j = 0, k = debut;
    while (i < taille1 && j < taille2) {
        if (tableauGauche[i].getCle() <= tableauDroit[j].getCle()) {
            T[k++] = tableauGauche[i++];
        } else {
            T[k++] = tableauDroit[j++];
        }
    }

    // Copier les éléments restants du sous-tableau gauche, si nécessaire
    while (i < taille1) {
        T[k++] = tableauGauche[i++];
    }

    // Copier les éléments restants du sous-tableau droit, si nécessaire
    while (j < taille2) {
        T[k++] = tableauDroit[j++];
    }
}
    /**
     * La méthode du tri par dénombrement
     * @param T
     * @param k
     */
    public void triDenombrement(Element[] T, int k) {
        int n = T.length;
        int[] nb = new int[k];
        int[] pos = new int[k];
        Element[] R = new Element[n];

        // Initialisations
        for (int i = 0; i < k; i++) {
            nb[i] = 0;
        }

        // Calcul des nombres d’apparitions
        for (int i = 0; i < n; i++) {
            nb[T[i].getCle()]++;
        }

        // Calcul des indices du premier élément de chaque catégorie
        pos[0] = 0;
        for (int i = 1; i < k; i++) {
            pos[i] = pos[i - 1] + nb[i - 1];
        }

        // Recopie des éléments originaux du tableau T dans R
        for (int i = 0; i < n; i++) {
            R[pos[T[i].getCle()]] = T[i];
            pos[T[i].getCle()]++;
        }

        //return R;
        System.arraycopy(R, 0, T, 0, n);
    }

    /**
     * Méthode qui affiche le tableau
     * @param tableau
     */
    public static void afficherTableau(Element[] tableau)  {
        for (Element elem : tableau) {
            System.out.println(elem.getCle() + ": " + elem.getValeur());
        }
    }

}
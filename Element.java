/**
 * @author Halmi ilias
 * @author Maha Bengrab
 * @version Février 2024
 */
import java.util.Scanner;

public class Element{
    //Attributs
    private int cle;
    private String valeur;
    //Constructeurs
    /**
     * Constructeur créant un element sans cle et sans valeur
     */
    public Element(){
        cle = 0;
        valeur = null;
    }
    public Element(int a, String b){
        cle = a;
        valeur = b;
    }
    //Accesseurs
    /**
     * getCle retourne la cle de l'élément
     * @return cle
     */
    public int getCle(){
        return cle;
    }
    /**
     * getValeur retourne la valeur de l'élément
     * @return valeur
     */
    public String getValeur(){
        return valeur;
    }
    //Modificateurs
    /**
     * setCle cette méthode modifie la cle d'un élément
     */
    public void setCle(int c){
        cle = c;
    }
    /**
     * modifie la valeur d'un élément
     */
    public void setValeur(String val){
        valeur = val;
    }
    /**
     * Représentation sous forme d'une chaine de caractères
     */
    public String toString() {
        return "La clé est: " + cle + "  -->  La valeur est : " + valeur ;
    }


    /*Cette méthode est facultative, elle est responsable de la lecture d'un element du tableau,
     voici ci dessous le main permettant l'exécution de cette méthode,
     et tout au début le import necessaire */

    /*    public static Element[] litElement() {
        System.out.println("nombre d'élements est : ");
        Scanner entrer = new Scanner(System.in);
        Element[] t = new Element[entrer.nextInt()];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Element();
            System.out.print("la clé  : ");
            t[i].setCle(entrer.nextInt());
            System.out.print("la valeur " + " : ");
            t[i].setValeur(entrer.next());

        }
        return t;
    }
    //La méthode Main
    public static void main(String[] args) {
        //Element[] t1 = litElement() ;
        Element t = new Element(4 , "val");
        System.out.println(t);

    }*/
}
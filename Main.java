/**
 * @author Halmi ilias 
 * @author Maha Bengrab
 * @version Février 2024
 */

public class Main {
    public static void main(String[] args) {
        TabElement tri = new TabElement();
        int n = 100; // Nombre d'éléments dans le tableau
        Element[] T = tri.initAleatoire(n); // Génère un tableau d'éléments aléatoires
        /*Pour des tableaux de très grande taille, il est preferable de tester uniquement un seul tri
        en mettant les deux autres en commentaires pour faciliter la lecture sur la console. */
        /**
         * Test du tri par insertion
         */

        System.out.println("Tableau avant le tri par insertion : ");
        tri.afficherTableau(T); // Affiche le tableau avant le tri

        long startTime = System.currentTimeMillis(); // Temps de début

        tri.triInsertion(T); // Trie le tableau par insertion

        long endTime = System.currentTimeMillis(); // Temps de fin



        System.out.println("Tableau trié par insertion : ");
        tri.afficherTableau(T); // Affiche le tableau trié par insertion
        long insertionTime = endTime - startTime; // Temps d'exécution du tri en millisecondes
        System.out.println("Le temps d'exécution du tri par insertion: " + insertionTime + " ms");

        /**
         * Test du tri fusion
         */
        Element[] T1 = tri.initAleatoire(n);
        System.out.println("Tableau avant le tri fusion :");

        tri.afficherTableau(T1);
        long startTime1 = System.currentTimeMillis();
        tri.triFusion(T1);
        long endTime1 = System.currentTimeMillis();



        System.out.println("Tableau trié par fusion : ");
        tri.afficherTableau(T1); // Affiche le tableau trié par fusion
        long insertionTime1 = endTime1 - startTime1;

        System.out.println("Le temps d'exécution du tri fusion: " + insertionTime1 +" ms");


        /**
         * Test du tri par dénombrement
          */
        Element[] TDenombrement = tri.initAleatoire(n); // Génère un nouveau tableau d'éléments aléatoires
        System.out.println("Tableau avant le tri par dénombrement : ");
        tri.afficherTableau(TDenombrement); // Affiche le tableau avant le tri par dénombrement
        long startTime2 = System.currentTimeMillis();
        tri.triDenombrement(TDenombrement, 100); // Trie le tableau par dénombrement
        long endTime2 = System.currentTimeMillis();

        System.out.println("Tableau trié par dénombrement : ");
        tri.afficherTableau(TDenombrement); // Affiche le tableau trié par dénombrement
        long insertionTime2 = endTime2 - startTime2;

        System.out.println("Le temps d'exécution du tri par dénombrement: " + insertionTime2 +" ms");



    }
}
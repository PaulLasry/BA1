public class CombiPermu {
    private static int factorielle (int n){
        int nFactorielle = 1;
        for(int i = n; i >= 1; --i){
            nFactorielle *= i;
        }
        return nFactorielle;
    }

	public static void main(String[] args) {
		/* Formule math'ematique calculant le nombre de  permutations de k
		 * 'elements parmis n: (n!)/(n-k)!
		 * Formule math'ematique calculant le nombre de combinaisons de k
		 * 'elements parmis n: (n!)/(k!*(n-k)!) 
		 */
		//valeurs à définir
		int n = 10;
		int k = 6;


		//Réaliser le calcul du nombre de permutations et de combinaisons
		//avec les deux valeurs n et k et les formules données
        System.out.println("Le nombre de permutation de " + k + " éléments parmis " + n + " est " +
                (factorielle(n))/factorielle(n-k));
        System.out.println("Le nombre de combinaisons de " + k + " éléments parmis " + n + " est " +
                (factorielle(n))/(factorielle(k)*factorielle(n-k)));
	}
}

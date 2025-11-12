class Benford {

	/* METHODES UTILTAIRES FOURNIES*/

	// affichage  d'un tableau d'entiers
	public static void print(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	// affichage  d'un tableau de doubles
	public static void print(double[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

    public static void fillWithSquare(double[] numbers){
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = ((i + 1) * (i + 1))/100.0;
        }
    }

    /**
     * This function return the first left digit of a double without using String or ArrayList.
     * @param number is a double
     * @return First digit of the number
     */

    public static int extractLeftDigit(double number){
        if(number == 0) return 0;
        //Reformat number
        number = Math.abs(number);
        if(number < 1){
            do{
                number *= 10;
            } while (number < 1);
        }

        //Remove decimal part
        int intPart = (int) number;

        while(intPart >= 10){
            intPart /= 10;
        }

        return intPart;
    }

    /**
     * Store in a table the number of occurences of the first left digit of a list of double.
     *
     * @param numbers Table of double that are analyzed
     * @param occurences Table where the occurrences of digits are stored
     */
    public static void analyze (double[] numbers, int[] occurences){
        for (double number : numbers) {
            int firstDigit = extractLeftDigit(number);
            occurences[firstDigit - 1] += 1;
        }
    }

    public static void testBenford (int[] occurences, int longueur){
        System.out.println("Pourcentage effectif / Prédictions de la loi de Benford : ");
        double[] frequencesBenfort = new double[9];

        for (int i = 0; i< frequencesBenfort.length; i++){
            frequencesBenfort[i] = Math.log10(1 + (double) 1/(i+1)) * 100.0;
        }

        for(int i = 0; i < occurences.length; i++){
            double pourcentageApparition = (double) (occurences[i] * 100) /longueur;
            System.out.println("\t" + (i+1) + " : " + pourcentageApparition + "%, Benford : " +
                    frequencesBenfort[i] + "%");
        }
    }

	public static void main(String[] args) {
		int[] frequencies = new int[9];
		double[] numbers = new double[25];

		//  TEST 1.1
		System.out.println("Test 1.1 : ");
		fillWithSquare(numbers);
		print(numbers);
		System.out.println();
		// FIN TEST 1.1 

		//TEST 1.2
		System.out.println("Test 1.2 : ");
		System.out.println(extractLeftDigit(0));
		System.out.println(extractLeftDigit(632));
		System.out.println(extractLeftDigit(-221));
		System.out.println(extractLeftDigit(-554.15));
		System.out.println(extractLeftDigit(0.00421));
		System.out.println();
		// FIN TEST 1.2

		//  TEST 1.3
		System.out.println("Test 1.3 : ");
		analyze(numbers, frequencies);
		print(frequencies);
		System.out.println();
		// FIN TEST 1.3

		// TEST 1.4
		System.out.println("Test 1.4 : ");
		testBenford(frequencies, numbers.length);
		// FIN TEST 1.4
	}
}


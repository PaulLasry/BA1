import java.util.Scanner;

class BouclesFor {
    final private static Scanner KBD = new Scanner(System.in);

    private static void next(){
	System.out.println("\n");
	System.out.println("(Tapez Enter pour passer à la boucle suivante)");
	KBD.nextLine();
    }
    
    public static void main(String[] args){

	// Exemple 1
    // 0 1 2 3 4    ok!
	for (int i = 0; i < 5; i++) {
	    System.out.print(i + " ");
	}
	next();
	
	// Exemple 2
    // 3 4 5 6 7    Err :: 8
	for (int i = 3; i <= 8; i++) {
	    System.out.print(i + " ");
	}
	next();
	
	// Exemple 3
    // 2 1 0 -1     ok!
	for (int i = 2; i > -2; i--) {
	    System.out.print(i + " ");
	}
	next();
		
	// Exemple 4
    //  rien        ok!
	for (int i = 0; i > 5; i--) {
	    System.out.print(i + " ");
	}
	next();
	
	// Exemple 5
    // 0 5 * 1 6 *
	for (int i = 0, j = 5; (i <= 10 && j < 7); i++, j++) {
	    System.out.print(i + " " + j + " * ");
	}
	next();
	
	// Exemple 6
    // 0 5 * 1 6 * 2 7 * 3 8 * 4 9 * 5 10 * 6 11 * 7 12 * 8 13 * 9 14 * 10 15 * ok!
	for (int i = 0, j = 5; i <= 10 || j < 7; i++, j++) {
	    System.out.print(i + " " + j + " * ");
	}
	next();
		
	// Exemple 7
    // 3 true * 4 true * 5 true * 6 true *
	boolean b = true;
	for (int i = 3; b; i++) {
	    System.out.print(i + " " + b + " * ");
	    b = (i < 6);
	}
	next();
		
	// Exemple 8
	for (int i = 0, j = 6; i != j; i++, j--) {
	    System.out.print(i + " " + j + " * ");
	}
	next();
	
	// Exemple 9
	for (int i = 0; i < 3; i++) {
	    System.out.print(i + " ");
	    for (int j = 0; j < 3; j++) {
		System.out.print(j + " ");
	    }
	    System.out.print(" * ");
	}
        next();
	
	// Exemple 10
	for (int i = 3; i < 15; i--) {
	    System.out.print(i + " ");
	}
    }
}

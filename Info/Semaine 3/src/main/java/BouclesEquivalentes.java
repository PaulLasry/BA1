class BouclesEquivalentes {

  /**
   * Ceci est une fonction de test
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Boucle for :");
    for (int a = 3; a <= 10; a++) {
      System.out.println("a : " + a);
    }

    System.out.println("Boucle while :");
    // A compléter. Ecrivez une boucle while qui fait la même chose
    // que la boucle for ci-dessus
    int a = 3;
    while (a <= 10) {
      System.out.println("a : " + a);
      ++a;
    }

    System.out.println("Boucle do..while :");
    // A compléter. Ecrivez une boucle do..while qui fait la même
    // chose que la boucle for ci-dessus.
    a = 3;
    do {
      System.out.println("a : " + a);
      ++a;
    } while (a <= 10);
  }
}

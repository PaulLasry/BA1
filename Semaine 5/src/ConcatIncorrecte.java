/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
class ConcatIncorrecte {
    public static void main(String[] args) {
        String s = "China Blue";
        System.out.println(s);
        s = concatener(s, " Express");
        System.out.println(s);
    }

    /* Version Fausse
    public static void concatener(String s, String s2) {
        s +=s2;
    }
    *///Version corrigée
    public static String concatener(String s, String s2) {
        return s + s2;
    }

}
import java.util.Scanner;

public class Napoleon {
    private static Scanner kyb = new Scanner(System.in);

    private static int countString(String names){
        boolean fini = false;
        int count = 0;
        int i = 0;
        while(!fini){
            if(names.indexOf(' ', i) != -1){
                i = names.indexOf(' ', i) + 1;
                count+=1;
            }
            else fini = true;
        }
        return count;
    }

    public static void main(String[] args) {
        final String noms = "Napoleon Bonaparte Bill Gates Claudia Schiffer Martina Hingis ";

        System.out.print("Entrez un nom : ");
        String prenom = kyb.nextLine();

        int nombreNom = countString(noms);

        for (int i =0; i<noms.length(); i++){
            if(prenom.length() + i < noms.length() && prenom.equals(noms.substring(i, prenom.length() + i))){
                    System.out.println(noms.substring(i + prenom.length() + 1,
                            noms.indexOf(' ', i + prenom.length() + 1)));
            }
        }

    }
}

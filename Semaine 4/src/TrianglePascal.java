import java.util.Scanner;
public class TrianglePascal {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Combien de ligne voulez-vouz ? ");
        int nombreLigne = kyb.nextInt();

        int[][] trianglePascal = new int[nombreLigne][];

        for (int i = 0; i < nombreLigne; i++){
            trianglePascal[i] = new int[i+1];
            for (int k = 0; k <= i; k++){
                if(k==0 || k == i){
                    trianglePascal[i][k]=1;
                }
                else{
                    trianglePascal[i][k] = trianglePascal[i-1][k] + trianglePascal[i-1][k-1];
                }
            }
        }

        for(int[] table : trianglePascal){
            for (int i : table){
                System.out.print(i + " ");
            }
            System.out.print('\n');
        }
    }

}
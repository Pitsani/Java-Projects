import java.util.ArrayList;
import java.util.Scanner;

public class zad7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n<0){
            n = scan.nextInt();
        }
        int[][] A = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                A[i][j] = scan.nextInt();
                while(A[i][j]<-1000||A[i][j]>1000){
                    A[i][j] = scan.nextInt();
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("A[%d][%d] = %d\t\t",i,j,A[i][j]);
            }
            System.out.println();
        }

        ArrayList<Integer> C = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j){
                    C.add(A[i][j]);
                }
            }
        }

        System.out.println("Sum of elements in columns:");
        for (int i = 0; i < C.size(); i++) {
            System.out.printf("C[%d] = %d\n", i, C.get(i));
        }

        scan.close();
    }
}

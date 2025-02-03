import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] A = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                A[i][j] = scan.nextInt();
                while(A[i][j]<-500||A[i][j]>1000){
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

        int[] C = new int[n];
        int max;

        for(int i=0;i<n;i++){
            max = A[i][0];
            for(int j=0;j<n;j++){
                if(A[i][j]>max){
                    max = A[i][j];
                }
            }
            C[i]=max;
        }

        System.out.println("Maximum elements in each row:");
        for (int i = 0; i < n; i++) {
            System.out.printf("C[%d] = %d\n", i, C[i]);
        }

    }
}

import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] A = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j]=scan.nextInt();
                while (A[i][j] < -10 ||A[i][j]>10) {
                    System.out.println("Enter number again!(between -10 and 10)");
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
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]*A[i][j]>50){
                    count++;
                }
            }
        }
        int k=0;
        int[] C = new int[count];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]*A[i][j]>50){
                    C[k] = A[i][j]*A[i][j];
                    k++;
                }
            }
        }

        for(int j=0;j<count;j++){
            System.out.printf("C[%d] = %d\t",j,C[j]);
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(C[j]>C[j+1]){
                    int temp = C[j];
                    C[j] = C[j+1];
                    C[j+1] = temp;
                }
            }
        }
        System.out.println();
        for(int j=0;j<count;j++){
            System.out.printf("C[%d] = %d\t",j,C[j]);
        }

    }
}

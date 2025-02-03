import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of rows and columns:\t");
        int n = scan.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[] C = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Enter element A[%d][%d]\n",i,j);
                A[i][j] = scan.nextInt();
                while(A[i][j]<-1000||A[i][j]>1000){
                    System.out.printf("Enter again element A[%d][%d]\n",i,j);
                    A[i][j] = scan.nextInt();
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("Enter element B[%d][%d]\n",i,j);
                B[i][j] = scan.nextInt();
                while(B[i][j]<-1000||B[i][j]>1000){
                    System.out.printf("Enter new element B[%d][%d]\n",i,j);
                    B[i][j] = scan.nextInt();
                }
            }
        }

        for(int i=0;i<n;i++){
            C[i] = A[i][i]+B[i][i];
        }

        for(int i=0;i<n;i++){
            System.out.printf("C[%d] = %d\t",i,C[i]);
        }

        System.out.println();

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(C[j]>C[j+1]){
                    int temp = C[j];
                    C[j] = C[j+1];
                    C[j+1] = temp;
                }
            }
        }

        System.out.println("After sorting: ");

        for(int i=0;i<n;i++){
            System.out.printf("C[%d] = %d\t",i,C[i]);
        }
    }
}
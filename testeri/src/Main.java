import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[5];
        int a;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            a = scan.nextInt();
            arr2[i] = a;
        }
        float suma = 0;
        for (int i = 0; i < 5; i++) {
            suma += arr2[i];
        }
        System.out.println(suma / arr2.length);
        int k = zad3(arr2);
        System.out.println(k);
        zad4(arr);

        String[] arrStr = {"wfrfsrf", "ryeh", "0oe0dserrf", "10owpe", "re"};
        zad5(arrStr);
    }


    static int zad3(int[] array) {
        int max = array[0];
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    static void zad4(int[] array) {
        int suma = 0;
        for (int j : array) {
            suma += j;
        }
        System.out.println(suma);
    }

    static void zad5(String[] array) {
        Arrays.sort(array, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(array));
    }
}
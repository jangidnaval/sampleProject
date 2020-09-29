import java.util.Scanner;

public class quickSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr, int l, int r) {

        if (l < r) {
            int q = partition(arr, l, r);
            sort(arr, l, q - 1);
            sort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r], lw = l - 1;

        for (int i = l; i < r ; i++) {
            if (arr[i] < pivot) {
                lw++;
                swap(arr, lw, i);
            }
        }
        lw++;
        swap(arr, lw, r );

        return lw;
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

}

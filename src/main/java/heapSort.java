import java.util.Scanner;

public class heapSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr,  arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr, int n) {

        buildMaxHeap(arr,n);

        for(int i=n-1;i>=2;i--){
            int tmp=arr[1];
            arr[1]=arr[n-1];
            arr[n-1]=tmp;


            n--;
            maxHeapify(arr,1,n);
        }


    }

    private static void buildMaxHeap(int arr[],int n){

        for(int i=n/2;i>=0;i--){
            maxHeapify(arr,i,n);
        }

    }

    private static void maxHeapify(int[] arr, int i, int n) {
       int l=2*i,r=2*i+1;
       int max=i;

       if(l<n && arr[l]>arr[max]){
           max=l;
       }
       if(r<n && arr[r]>arr[max])
       {
           max=r;
       }

       if(max!=i){
           int tmp=arr[i];
           arr[i]=arr[max];
           arr[max]=tmp;
       }
    }
}








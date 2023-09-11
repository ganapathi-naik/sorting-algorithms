package sorting;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int whole = i;
            int value = arr[whole];

            while (whole > 0 && arr[whole - 1] > value) {
                arr[whole] = arr[whole - 1];
                whole--;
            }
            arr[whole] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        new InsertionSort().sort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }
}

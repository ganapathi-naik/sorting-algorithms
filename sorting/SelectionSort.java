package sorting;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            swap(arr, minPos, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, -1};
        new SelectionSort().sort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }
}

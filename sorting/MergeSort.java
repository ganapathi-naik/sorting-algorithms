package sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            for (int i = 0; i < left.length; i++) {
                left[i] = arr[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = arr[mid + i];
            }
            sort(left);
            sort(right);
            merge(left, right, arr);
        }
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0, n1 = left.length, n2 = right.length;

        while (i < n1 && j < n2) {
            if (left[i] > right[j]) {
                arr[k++] = right[j++];
            } else {
                arr[k++] = left[i++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        new MergeSort().sort(arr);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }
}

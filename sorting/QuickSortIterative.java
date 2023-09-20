package sorting;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortIterative {
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void sort(int[] arr, int left, int right) {
        // Create an auxiliary stack
        Stack<Integer> s = new Stack<>();

        // push initial values of left and right to stack
        s.push(left);
        s.push(right);

        // Keep popping from stack while is not empty
        while (!s.empty()) {
            // Pop right and left
            right = s.pop();
            left = s.pop();

            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, left, right);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > left) {
                s.push(left);
                s.push(p - 1);
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < right) {
                s.push(p + 1);
                s.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, -3, -1, 2};
        new QuickSortIterative().sort(arr, 0, 4);
        System.out.println("Sorted array = " + Arrays.toString(arr));
    }
}

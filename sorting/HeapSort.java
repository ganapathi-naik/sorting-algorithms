package sorting;

import java.util.Arrays;

public class HeapSort {

    private int size;
    private int[] arr;

    public void sort(int[] input) {
        int n = input.length;
        size = n;
        arr = input;

        buildHeap();

        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            size--;
            heapifyDown(0);
        }
    }

    public void buildHeap() {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }

            if (arr[index] > arr[largerChildIndex]) {
                break;
            } else {
                swap(largerChildIndex, index);
                index = largerChildIndex;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private int getLeftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return arr[getRightChildIndex(index)];
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 50, 20, 35, 15};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

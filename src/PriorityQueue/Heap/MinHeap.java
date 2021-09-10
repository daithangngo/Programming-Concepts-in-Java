package PriorityQueue.Heap;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] args) {
        int[] arr = {0, 0, 22, 33, 19, 3, 1999, 1};

    }

    static int min(int[] arr) {
        buildHeap(arr);
        return arr[0];
    }

    static void buildHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            shiftDown(i, arr);
        }
    }

    //right child index = i * 2 + 2
    //left child index = i * 2 + 1
    static void shiftDown(int i, int[] arr) {
        if (i * 2 + 1 > arr.length - 1) return;
        int min = i;
        if (i * 2 + 2 <= arr.length - 1) {
            if (arr[i * 2 + 2] < arr[i]) min = i * 2 + 2; //right smaller
        }
        if (arr[i * 2 + 1] < arr[i]) min = i * 2 + 1; //left smaller
        if (min == i) return; // no changes
        swap(min, i, arr);
        shiftDown(min, arr);
    }

    static void swap(int i1, int i2, int[] arr) {
        int val = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = val;
    }

    static void minHeapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(0, i, arr);
            shiftDown(0, i - 1, arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void shiftDown(int i, int indexLast, int[] arr) {
        if (i * 2 + 1 > indexLast) return;
        int min = i;
        if (i * 2 + 2 <= indexLast) {
            if (arr[i * 2 + 2] < arr[i]) min = i * 2 + 2; //right smaller
        }
        if (arr[i * 2 + 1] < arr[i]) min = i * 2 + 1; //left smaller
        if (min == i) return; // no changes
        swap(min, i, arr);
        shiftDown(min, indexLast, arr);
    }
}

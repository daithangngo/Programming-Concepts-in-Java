package SearchAlgo;

// input: 2 Listen , output: 1 gemeinsame Liste
// input: 1 unsortierte Liste , output 1 sortierte Liste
// rekursiv
// mit Threads
import java.util.Arrays;

public class MergeSort {
  public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
    int i = left, j = mid + 1, t = 0;
    while (i <= mid && j <= right) tmp[t++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
    while (i <= mid) tmp[t++] = arr[i++];
    while (j <= right) tmp[t++] = arr[j++];
    t = 0;
    while (left <= right) arr[left++] = tmp[t++];
  }

  // Recursive
  //we start with left = 0 ; right = arr.length-1; int[] tmp = new int[arr.length]
  public static void recursiveSort(int[] arr, int left, int right, int[] tmp) {
    if (left < right) {
      int mid = (left + right) / 2;
      recursiveSort(arr, left, mid, tmp);
      recursiveSort(arr, mid + 1, right, tmp);
      merge(arr, left, mid, right, tmp);
    }
  }

  // non-recursive
  public static void nonRecursiveSort(int[] arr) {
    int[] tmp = new int[arr.length];
    for (int size = 1; size < arr.length; size *= 2) {
      int left, mid, right;
      for (left = 0; left + size < arr.length; left = right + 1) {
        mid = left + size - 1;
        right = Math.min(mid + size, arr.length - 1);
        merge(arr, left, mid, right, tmp);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {8, 1, 4, 9, 6, 0, 7, 2, 5, 3};
    MergeSort.recursiveSort(arr, 0, arr.length - 1, new int[arr.length]);
    // MergeSort.nonRecursiveSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}

package SearchAlgo;

import java.util.Arrays;

public class InsertionSort {
  // erstes Element wird am Anfang zu der sortierten Liste hinzugefügt
  // es wird immer aus dem unsortierten Array das erste Element entnommen und in das sortierte Array
  // eingefügt
  // Best: Iteration- O(n), Shift Items- O(1)--> O(n)
  // Worst: Iteration- (n), Shift Items- O(n)--> O(n^2)

  public int[] insertionSort(int[] arr) {
    int[] sortedArr = new int[arr.length];
    sortedArr[0] = arr[0];

    // goes through every element of the unsorted array
    for (int i = 0; i < arr.length; i++) {
      A:
      // goes through every element of the sorted array
      for (int j = 0; j < sortedArr.length; j++) {
        // if the element is >= than we push every element to the right
        if (sortedArr[j] >= arr[i]) {
          for (int k = j; k < sortedArr.length - 1; k++) {
            // we move every element and then pass the new value
            sortedArr[k + 1] = sortedArr[k];
            sortedArr[j] = arr[i];
            break A;
          }
        }
        for (int k = 0; k < sortedArr.length; k++) {
          if (sortedArr[k] == 0) {
            sortedArr[k] = arr[i];
            break A;
          }
        }
      }
    }
    return sortedArr;
  }

  public void sort(int[] arr) {
    for (var i = 1; i < arr.length; i++) {
      int current = arr[i];
      int j = i - 1;
      // shift all elements, while the left element is bigger than the right element
      while (j >= 0 && arr[j] > current) {
        arr[j + 1] = arr[j];
        j--;
      }
      // j would be -1 when
      //why is arr[j +1] = arr[i] not possible
      arr[j + 1] = current;
    }
  }



  public static void main(String[] args) {
    int[] numbers = {7, 30, 8, 5, 1};
    var sorter = new InsertionSort();
    sorter.insertionSort(numbers);
    System.out.println(Arrays.toString(numbers));


    sorter.sort(numbers);
    System.out.println(Arrays.toString(numbers));
  }
}

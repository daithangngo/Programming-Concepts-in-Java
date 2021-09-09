package SearchAlgo;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
      int[]arr = {40, 32, 243, 32, 45, 11, 2};
    System.out.println(Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

    public static void bubbleSort(int [] numbs){
    for (int i = 0; i < numbs.length; i++) {
      for (int j = 0; j < numbs.length-1; j++) {
          if(numbs[j+1]<numbs[j]){
              int tmp = numbs[j];
              numbs[j] = numbs[j+1];
              numbs[j+1] = tmp;
          }
      }
    }
    }

}

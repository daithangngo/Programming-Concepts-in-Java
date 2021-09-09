package SearchAlgo;

public class MergeSort2 {
  public static void mergeSort(int[] array) {
    // (1.) Abbruchbedingung: nichts zu sortieren
    if (array.length <= 1) return;

    // (2.) Array in linke und rechte Hälfte teilen:
    // Statt der for-Schleifen geht alternativ auch System.arraycopy

    int middle = array.length / 2;
    int[] leftHalf = new int[middle];
    for (int i = 0; i < leftHalf.length; i++) leftHalf[i] = array[i];
    int[] rightHalf = new int[array.length - middle];
    for (int i = 0; i < rightHalf.length; i++) rightHalf[i] = array[middle + i];

    // (3.) Beide Hälften sortieren:
    mergeSort(leftHalf);
    mergeSort(rightHalf);

    // (4.) Die sortierten Hälften in das Ursprungsarray mergen:
    int left = 0, right = 0;
    for (int merge = 0; merge < array.length; merge++) {
      // eine der beiden bereits komplett übernommen?
      if (right >= rightHalf.length) {
        array[merge] = leftHalf[left];
        left++;
      } else if (left >= leftHalf.length) {
        array[merge] = rightHalf[right];
        right++;
      }

      // ansonsten Hälfte mit kleinerem Element verwenden
      else if (leftHalf[left] < rightHalf[right]) {
        array[merge] = leftHalf[left];
        left++;
      } else {
        array[merge] = rightHalf[right];
        right++;
      }
    }
  }
}

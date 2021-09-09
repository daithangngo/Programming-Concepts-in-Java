package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfNumber {
    public static Set<Integer> mostFrequentElementss(int[] arr) {
        HashMap<Integer,Integer> counts = new HashMap<>(); // Element→Häufigkeit
// Elemente zählen in der HashMap aufsummieren:
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (counts.containsKey(element)) { // Element zuvor bereits gefunden
                int oldCount = counts.get(element); // wie oft bisher gefunden?
                counts.put(element, oldCount + 1); // jetzt einmal mehr gefunden
            } else {
                counts.put(element, 1); // zum ersten Mal gefunden
            }
        }
// Finde die maximale Häufigkeit:
        int max = 0; // möglich, weil Häufigkeiten immer > 0
        for (int elem : counts.keySet()) { // über Schlüsselmenge iterieren
            int count = counts.get(elem); // Häufigkeit für dieses Element auslesen
            if (count > max) {
                max = count;
            }
        }
// Finde die Elemente (Keys) mit der größten Häufigkeit (Value)
        HashSet<Integer> mostFrequent = new HashSet<>();
        for (int elem : counts.keySet()) {
            if (counts.get(elem) == max) {
                mostFrequent.add(elem);
            }
        }
        return mostFrequent;
    }

    //get(key)--> get the value of the key
    //put (element, elementValue)
}

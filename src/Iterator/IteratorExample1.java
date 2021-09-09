package Iterator;

import java.util.*;

public class IteratorExample1 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Jane");
    list.add("Jason");
    list.add("Marlene");

    Iterator<String> iterator = list.iterator();

    Set<String> set = new HashSet<>();
    set.add("Bob");
    set.add("Lene");
    set.add("Hanna");
    set.add("Luise");

    Iterator<String> iterator2 = set.iterator();
    while (iterator2.hasNext()) System.out.println(iterator2.next());
  }
}

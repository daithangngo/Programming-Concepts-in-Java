package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample2 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Jane");
    list.add("Jason");
    list.add("Marlene");

    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      String next = iterator.next();
      System.out.println(next);
    }
  }
}

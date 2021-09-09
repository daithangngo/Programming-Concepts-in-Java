package MathAlgo;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;

public class PartitionsgrößenErmittlung {
  public static void main(String[] args) {
      ArrayList<String> numbers = new ArrayList<>();
    for (int drei = 0; drei<= 6; drei++){
        for(int vier =0; vier <=6;vier++ ){
            for (int fuenf = 0; fuenf<=6; fuenf++){
                int num = 3*drei + 4*vier + 5*fuenf;
                numbers.add( drei + " 3er, " + vier + " 4er, " + fuenf + " 5er" + " = " + num);
            }
        }
    }
    numbers.stream().filter(s -> s.contains("19")).forEach(System.out::println);
  }
}

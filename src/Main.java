import MathAlgo.EuklidischerAlgorithmus;
import SearchAlgo.BubbleSort;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    //System.out.println("accaccabccd".matches("(a(a|b)?cc)*d"));

    /*
    1byte   byte    (-128) bis (127)
    2bytes  short   (-32 768) bis (32 767)
    4bytes  int     (-2 147 483 648) bis (-2 147 483 647)    -- 1 byte char(über int)

    8bytes  long    (64 Bit (8 Byte))  9.223.372.036.854.755.808 bis +9.223.372.036.854.755.807
    4bytes  float   (-3.4e + 38) bis (3.4e + 38)
    8bytes  double  (-1.7e + 308) bis (1.7e + 308)

    es gibt Zahlen die von long, aber nicht von double dargestellt werden können. Double hat größeren Wertebereich,
    aber gleich viele bytes wie long. Daher gibt es Lächer
     */

    /*
    Erlaubte Namen
    letter:= $| _ | a| ...|Z|
    digit:= 0-9
     */

    // Java immer Call-by value

  }

  public static char[] converter(char[] charArr){
    for(int i = 0; i< charArr.length; i++){
      switch (charArr[i]){
        case 'A'-> charArr[i] = 'B';
        case 'B'-> charArr[i] = 'C';
      }
    }
    return charArr;
  }
}

package MathAlgo;

import java.util.Scanner;

public class EuklidischerAlgorithmus {
  // Nimm zwei Zahlen a und b, so dass a > b ist.
  // Dividiere a / b mit Rest.
  // Wenn der Rest 0 ist, bist du fertig. Der größte gemeinsame Teiler ist dann genau b.
  // Wenn der Rest größer als 0 ist, wiederhole die Rechnung für b und den Rest

  static int ggT(int a, int b) {
    int rest = a % b;
    if (rest == 0) return b;
    return ggT(b, rest);
  }


  public static void main(String[] args) {
    System.out.println("Größter gemeinsamer Teiler ist: " + ggT(1491,935  ));
    //System.out.println("Größter gemeinsamer Teiler ist: " + ggT(3929299 % 22134,22134  ));
    //3929299
    //ggT(a,b) = ggT(b,a) = ggT(-a,b) = ggT(a,-b) = ggT(-a,-b)
  }
}

package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
  public static void main(String[] args) {
    String a = "Apfel Zuckerguss Affe Ampel Label";
    String b = "Das sind mehrere Saetze. Es soll immer das letzte Wort gefunden werden. Okay.";
    String time= "00:02:10-Err mah Gawd! 00:02:12-Everything makes boom!00:02:14-Ded : -(";
    String time2= "23:02:10-Err mah Gawd! 00:02:12-Everything makes boom!00:02:14-Ded : -(";
    String halloWelt = "Hallo Merkel Hallo Welt Hallo Welt Java Hallo      Welt HalloWelt";


    // backslash muss man \\ machen
    // beginnt mit A und endet mit l
    // \w = wordcharacter- alle KleinBuchstaben, Großbuchstaben und Ziffern (Engl)
    Pattern patterdn = Pattern.compile("A(\\w*)l");

    //Regex suchen immer den größten String und das wäre in dem Fall- Apfel Zuckerguss Affe Ampel Label
    Pattern pattern = Pattern.compile("A(.*)l");

    // . ist ein komplett beliebiges Zeichen- alles
    //man muss \\. machen, weil sonst jedes beliebige Wort vorkommen kann
    Pattern letzteWort = Pattern.compile("\\w*\\.");

    // \\d sind alle Ziffern von 0-9
    //würde auch ungülige Timestemps ausgeben- Lösung:
    Pattern timeStemp = Pattern.compile("\\d\\d:\\d\\d:\\d\\d");

    //zulässige Zeitstempel
    //für das erste Digit nur Zahlen von 0, 1, 2
    //kann man mit ranges machen []
    //wir erlauben für das erste Digit nur Zahlen von 0-2
    Pattern timeStemp2 = Pattern.compile("[0-2]\\d:\\d\\d:\\d\\d");

    //um es komplett richit zu machen weil laut timeStemp2 kann man auch mit 29 anfangen
    //Ziffer fängt mit 0/1 an und dann ein Zahl von 0-9  ODER   wir haben eine Zigger, die mit 2 anfängt und dann eine Zahl von 0-3
    //muss alles ohne Leerzeichen sein
    Pattern validtimeStemp = Pattern.compile("(([0-1]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d");

    //*s space, aber auch kein Leerzeichen erlaubt
    //S+ kein wordCharacter, D+ kein DigitCharacter
    //s ? 0 oder 1mal
    //s{5} Space muss exakt 5 mal vorkommen sein
    //s{6,} heißt 6 oder mehr s{0,6} höchstens 6
    Pattern halloWeltFil = Pattern.compile("Hallo(\\s{0,6})Welt");

    //ranges kann man erweitern zu einem Set und diese beinhalten beliebige Characters


    Matcher matcher = halloWeltFil.matcher(halloWelt);
    while (matcher.find()) {
      //matcher rausbekommen mit matcher.group() und matcher finden, der dem Pattern entspricht mit matcher.find
      //matcher.start() und matcher.end() gibt die Position im String an wo das Wort anfängt und aufhört
      System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end() );
    }
  }
}

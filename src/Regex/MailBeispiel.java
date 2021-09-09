package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailBeispiel {
  public static void main(String[] args) {
      String mails = "Hallo@Welt.de" +
              "\njgwang@live.com\n" +
              "cyrus@sbcglobal.net\n" +
              "drhyde@mac.com\n" +
              "sfoskett@yahoo.ca\n" +
              "frosal@att.net\n" +
              "pkilab@mac.com\n" +
              "gilmoure@outlook.com\n" +
              "milton@msn.com\n" +
              "ribet@icloud.com\n" +
              "sinclair@yahoo.com+\n" +
              "tedrlord@sbcglobal.\n" +
              "hellfire@mac.com";

      //wir haben ein Menge an Elementen die wir erlauben
      //im Set heißt der . auch wirklich ein Punkt
      //+ heißt es matcht 1 bis beliebig viele
      //^_ bedeutet nicht _
      Pattern pattern = Pattern.compile("[\\w.%+-]+@[[\\w.-]&&[^_]]+\\.[a-z]{2,}");
      Matcher matcher = pattern.matcher(mails);
      Pattern pat = Pattern.compile("a|g|(adss)*hallo(e|k|d)?");

      while(matcher.find()){
      System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
      }
  }
}

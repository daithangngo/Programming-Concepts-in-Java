package CSV.Example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CSVReader {
  public static void main(String[] args) {
    String path = "src/CSV/Datenbanksätze/schueler.csv";
    String line = "";
    Pattern isW = Pattern.compile("\\;w\\;");

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      while ((line = br.readLine()) != null) {
        Matcher matcher = isW.matcher(line);
        while (matcher.find()) {
          String[]row = line.split(";");

          for(String word: row){
            //we allocate 10 spaces of room for the word
            System.out.printf("%-5s", word);
          }
          System.out.println();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

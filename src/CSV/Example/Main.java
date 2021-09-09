package CSV.Example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    // CSV = Comma-Seperated Values
    // text file that uses a comma to seperate values

    String file = "src/CSV/Example/Students_CSV.csv";
    BufferedReader reader = null;
    String line = "";

    try{
      reader = new BufferedReader(new FileReader(file));
      // continously reads the next line
      while ((line = reader.readLine()) != null) {
        //Split the lines at all commas
        String[]row = line.split(";");

        for(String word: row){
          //we allocate 10 spaces of room for the word
          System.out.printf("%-10s", word);
        }
        System.out.println();
      }

    }catch (Exception e){
      e.printStackTrace();
    }finally{
      //good practice to close a reader or scanner
      reader.close();
    }
  }
}


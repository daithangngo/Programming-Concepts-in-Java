package CSV.Datenbanksätze;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SchoolModel {
  public static final String FILE_PUPILS = "src/CSV/Datenbanksätze/schueler.csv";
  public static final String FILE_GRADES = "src/CSV/Datenbanksätze/noten.csv";
  public static final String FILE_SUBJECTS = "src/CSV/Datenbanksätze/faecher.csv";

  /** Öffnet unter dem Dateipfad filePath befindliche Datei als BufferedReader. */
  public static BufferedReader open(String filePath) {
    try {
      return new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Schließt den BufferedReader br. Dieser kann anschließend nicht weiterverwendet werden (auch
   * nicht als Stream, selbst wenn dieser vor dem Schließen von br erzeugt wurde).
   */
  public static void close(BufferedReader br) {
    try {
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gibt für einen Schüler die Liste seiner Noten in einem bestimmten Fach zurück.
   *
   * @param pupilNr die Nummer des Schülers
   * @param subjectNr die nummer des Schulfachs
   * @return eine Liste von Noten, die der Schüler im jeweiligen Fach erhalten hat
   */
  private static List<Integer> parseGrades(int pupilNr, int subjectNr) {
    BufferedReader gradesReader = open(FILE_GRADES);

    List<Integer> grades = gradesReader.lines()
            .skip(1)
            .map(line -> line.split(";"))
            .filter(arr -> Integer.parseInt(arr[0]) == pupilNr &&
                    Integer.parseInt(arr[1]) == subjectNr)
            .map(arr -> Integer.parseInt(arr[2]))
            .collect(Collectors.toList());

    close(gradesReader);
    return grades;
  }

  /**
   * Gibt für einen Schüler eine Zuordnung von Fächernamen auf Notenlisten zurück.
   *
   * @param pupilNr die Nummer des Schülers
   * @return eine Abbildung aller möglicher Fächernamen auf Noten des Schülers im entsprechenden
   *     Fach
   */
  private static Map<String, List<Integer>> parseGrades(int pupilNr) {
    BufferedReader subjectsReader = open(FILE_SUBJECTS);

    Map<String, List<Integer>> allGrades = subjectsReader.lines()
            .skip(1)
            .map(line -> line.split(";"))
            .collect(Collectors.toMap(
                    arr -> arr[1],
                    arr -> parseGrades(pupilNr, Integer.parseInt(arr[0]))
            ));

    close(subjectsReader);
    return allGrades;
  }

  /** @return die Menge aller Schüler (repräsentiert durch Pupil-Objekte) */
  public static Set<Pupil> parsePupils() {
    return null; // TODO: Teilaufgabe (d)
  }

  /**
   * Ermittelt den Schüler (ggf. mehrere), der am häufigsten die (Einzel-)Note 1 erhalten hat.
   *
   * @param pupils die Menge aller Schüler
   * @return die Schüler mit den meisten Einsen
   */
  public static List<Pupil> mostOnes(Set<Pupil> pupils) {
    return null; // TODO: Teilaufgabe (f)
  }

  /**
   * Erstellt für jeden Schüler der Menge pupils ein Zeugnis, welches eine Zuordnung von allen
   * belegten(!) Fächern auf eine Durchschnittsnote im jeweiligen Fach speichert. Das Zeugnis eines
   * Schülers wird im Schüler-Objekt (Report-Attribut aus Aufgabe (g)) gespeichert.
   *
   * @param pupils die Menge aller Schüler
   * @return die Menge erzeugter Zeugnisse
   */
  public static Set<Report> createReports(Set<Pupil> pupils) {
    return null; // TODO: Teilaufgabe (h)
  }

  /**
   * Berechnet die Zeugnisgesamtnote, also die Durchschnittsnote aller Zeugnisnoten, für einen
   * bestimmten Schüler. Zuvor muss selbstverständlich das Zeugnis erzeugt worden sein.
   */
  private static double finalGrade(Pupil pupil) {
    return 0; // TODO: Teilaufgabe (j)
  }

  /**
   * Berechnet die durchschnittliche Zeugnisgesamtnote aller weiblichen bzw. männlichen Schüler.
   *
   * @param pupils die Menge aller Schüler
   * @param female ist true, falls die Durchschnittsnote von weiblichen Schülern gesucht ist, false
   *     sonst
   * @return der Mittelwert der Zeugnisdurchschnitte
   */
  public static double averageFinalGrade(Set<Pupil> pupils, boolean female) {
    return 0; // TODO: Teilaufgabe (k)
  }

  /**
   * Ermittelt die Schüler mit der besten Zeugnisgesamtnote aus dem gegebenen Kontext
   * (Klasse/Stufe/Schule). Als Kontext kann eine spezielle Schulklasse (z. B. "4A") oder eine ganze
   * Stufe (z. B. "4" = alle Viertklässler) oder alle Schüler (context = "") angegeben werden.
   *
   * @param pupils die Menge aller Schüler
   * @param context die Bezeichnung der Schulklasse/Stufe, auf die sich die Rückgabe beschränkt
   * @return nach Namen sortierte Liste der Schüler mit der besten Zeugnisgesamtnote
   */
  public static List<Pupil> bestOf(Set<Pupil> pupils, String context) {
    return null; // TODO: Teilaufgabe (l)
  }

  /**
   * Legt für jedes Zeugnis, das für einen Viertklässler ausgestellt wurde, eine
   * Schullaufbahnempfehlung basierend auf dem Durchschnitt der Zeugnisnoten in den Fächern Deutsch,
   * Mathematik und Heimat- und Sachkundeunterricht (HSU) fest. Die Empfehlung wird direkt in das
   * Zeugnis eingetragen. Gymnasium wird bis zu 2.333333, Realschule bis 2.666667, Mittelschule ab
   * 3.0 empfohlen.
   *
   * @param pupils die Menge aller Schüler (aller Schulklassen)
   */
  public static void setRecommendations(Set<Pupil> pupils) {
    // TODO: Teilaufgabe (n)
  }

  public static void main(String[] args) {
    // TODO: Teilaufgabe (o)
  }
}

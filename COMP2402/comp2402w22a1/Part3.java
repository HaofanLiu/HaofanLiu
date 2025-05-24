package comp2402w22a1;
// Thank you Pat Morin for the basic skeleton of this file.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morin
 * @author sharp
 * 
 */
public class Part3 {
	
	/**
	 * @param x the number of lines to take parity of
     * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException, NumberFormatException
	 */
	public static void doIt(int x, BufferedReader r, PrintWriter w)
            throws IOException, NumberFormatException {
      // TODO(student): Put your code here.
      List<Integer> l = new ArrayList<>();
      for (String line = r.readLine(); line != null; line = r.readLine()) {
        l.add(Integer.parseInt(line));
      }
      int sum = 0;
      int output = 0;
      if (l.size() < x) {
        w.println(output);
      }
      else {
        for (int i = 0; i < x; i++) {
          sum += l.get(i);
        }
        for (int j = 0; j < (l.size() - x + 1); j++) {
          if (sum % 2 == 0) {
            output += l.get(j + x - 1);
          }
          if (j + x == l.size()) {
            break;
          }
          sum = sum - l.get(j) + l.get(j + x);
        }
        w.println(output % 2402);
      }
    }
  // YOU SHOULD NOT NEED TO MODIFY BELOW THIS LINE

  /**
   * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
   * and System.out or from filenames specified on the command line, then call doIt.
   * @param args
   */
  public static void main(String[] args) {
    try {
      BufferedReader r;
      PrintWriter w;
      int x;
      if (args.length == 0) {
        x = 3;
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);
      } else if (args.length == 1) {
        x = Integer.parseInt(args[0]);
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);				
      } else if (args.length == 2) {
        x = Integer.parseInt(args[0]);
        r = new BufferedReader(new FileReader(args[1]));
        w = new PrintWriter(System.out);
      } else {
        x = Integer.parseInt(args[0]);
        r = new BufferedReader(new FileReader(args[1]));
        w = new PrintWriter(new FileWriter(args[2]));
      }
      long start = System.nanoTime();
      try {
        doIt(x, r, w);
      } catch (NumberFormatException e) {
        System.out.println( "Your input must be integer only");
        System.out.println(e);
      }      w.flush();
      long stop = System.nanoTime();
      System.out.println("Execution time: " + 1e-9 * (stop-start));
    } catch (IOException e) {
      System.err.println(e);
      System.exit(-1);
    }
  }
}

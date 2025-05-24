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
 * @author morin
 * @author sharp
 */
public class Part2 {

    /**
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException, NumberFormatException
     */
    public static void doIt(BufferedReader r, PrintWriter w)
            throws IOException, NumberFormatException {
        // TODO(student): Put your code here.
        List<Integer> l = new ArrayList<>();
        int output = 0;
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            l.add(Integer.parseInt(line));
        }
        for (int i = 0; i < l.size(); i++) {
            int temp = l.get(i);
            boolean a = true;
            for (int j = i + 1; j < l.size(); j++) {
                if (temp <= l.get(j)) {
                    a = false;
                }
            }
            if (a && i != l.size()-1) {
                output = l.get(i)%2402;
            }
        }
        w.println(output);
    }

    // YOU SHOULD NOT NEED TO MODIFY BELOW THIS LINE

    /**
     * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
     * and System.out or from filenames specified on the command line, then call doIt.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            BufferedReader r;
            PrintWriter w;
            if (args.length == 0) {
                r = new BufferedReader(new InputStreamReader(System.in));
                w = new PrintWriter(System.out);
            } else if (args.length == 1) {
                r = new BufferedReader(new FileReader(args[0]));
                w = new PrintWriter(System.out);
            } else {
                r = new BufferedReader(new FileReader(args[0]));
                w = new PrintWriter(new FileWriter(args[1]));
            }
            long start = System.nanoTime();
            try {
                doIt(r, w);
            } catch (NumberFormatException e) {
                System.out.println("Your input must be integer only");
                System.out.println(e);
            }
            w.flush();
            long stop = System.nanoTime();
            System.out.println("Execution time: " + 1e-9 * (stop - start));
        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
    }
}

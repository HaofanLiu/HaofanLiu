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


public class Part4 {

    /**
     * Your code goes here - see Part0 for an example
     *
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException, NumberFormatException
     */
    public static void doIt(int x, BufferedReader r, PrintWriter w) throws IOException {
        // TODO(student): Put your code here.
        List<Integer> l = new ArrayList<>();
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            l.add(Integer.parseInt(line));
        }
        int output = 0;
        int last = l.get(l.size() - 1);
        List<Integer> l_1 = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) < l.get(l.size() - 1)) {
                l_1.add(l.get(i));
            }
        }
        if (l_1.size() == 0) {
            output = 0;
        } else {
            int size = l_1.size();
            int count = 0;
            int j = 0;
            int sum = 0;
            while (true) {
                int location = j % size;
                if (j % x == 0) {
                    count++;
                    sum += l_1.get(location);
                }
                if (count == 24022022) {
                    break;
                }
                j++;
            }
            output = sum % 2402;
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
            int x;
            if (args.length == 0) {
                x = 2402;
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

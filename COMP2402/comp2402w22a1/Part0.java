package comp2402w22a1;
// Thank you Pat Morin for the basic skeleton of this file.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Part0 {
	
	/**
	 * Read lines one at a time from r.  After reading all lines, output
	 * all lines to w.  This assumes every line is an integer. If not, it
	 * throws a NumberFormatException.
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException, NumberFormatException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException, NumberFormatException {
        List<Integer> l = new ArrayList<>();

        for (String line = r.readLine(); line != null; line = r.readLine()) {
			l.add(Integer.parseInt(line));
        }

        for (Integer num : l) {
            w.println(num);
        }
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
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
				System.out.println( "Your input must be integer only");
				System.out.println(e);
			}
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}

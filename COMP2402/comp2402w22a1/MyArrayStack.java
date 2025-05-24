package comp2402w22a1;
// Thank you Pat Morin for the basic skeleton of this file.


import java.util.AbstractList;
import java.util.Collection;

/**
 * This class implements the MyList interface as a single array a.
 * Elements are stored at positions a[0],...,a[size()-1].
 * Doubling/halving is used to resize the array a when necessary.
 *
 * @param <T> the type of objects stored in the List
 * @author morin
 * @author sharp
 */
public class MyArrayStack<T> implements MyList<T> {

    /**
     * The array used to store elements
     */
    T[] a;

    /**
     * The number of elements stored
     */
    int n;

    /**
     * Resize the internal array
     */
    protected void resize() {
        @SuppressWarnings("unchecked")
        T[] b = (T[]) new Object[Math.max(n * 2, 1)];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        //System.out.printf( "resize from %d to %d\n", a.length, b.length);
        a = b;
    }

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public MyArrayStack() {
        a = (T[]) new Object[1];
        n = 0;
    }

    /**
     * Constructor
     *
     * @param cap
     */
    @SuppressWarnings("unchecked")
    public MyArrayStack(int cap) {
        a = (T[]) new Object[cap];
        n = 0;
    }

    public int size() {
        return n;
    }

    public T get(int i) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        return a[i];
    }

    public T set(int i, T x) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        T y = a[i];
        a[i] = x;
        return y;
    }

    public void add(int i, T x) {
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        if (n + 1 > a.length) resize();
        for (int j = n; j > i; j--)
            a[j] = a[j - 1];
        a[i] = x;
        n++;
    }

    public T remove(int i) {
        if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
        T x = a[i];
        for (int j = i; j < n - 1; j++)
            a[j] = a[j + 1];
        n--;
        if (a.length >= 3 * n) resize();
        return x;
    }


    // You should not need to modify anything above this line.


    public MyList<MyList<T>> blockify() {
        MyList<MyList<T>> blocks = new MyArrayStack<MyList<T>>();
        // TODO(student): Fill in the blockify code.
        return blocks;
    }
    // This is the default behaviour of toString.
    // Override this with more useful behaviour for debugging.
    public String toString() {
        String s = "[";
        for (int i = 0; i < n - 1; i++) {
            s += a[i];
            s += ", ";
        }
        if (n > 0) {
            s += a[n - 1];
        }
        s += "]";
        return s;
    }


    // This main method is provided for you for testing purposes.
    // You will want to add to this for local testing.
    public static void main(String[] args) {
        // These tests are not at all sufficient. They are just examples.
        testBlockify(10);
        testBlockify(15);
        testBlockify(30);
    }

    // Creates a MyList of n elements, then calls
    // blockify on that list. Prints out the blocks that
    // are returned.
    public static void testBlockify(int n) {
        System.out.println("Test Blockify------");
        MyList<Integer> mal = new MyArrayStack<Integer>();

        // Create a MyArrayStack with n elements 0, 1, 2, ..., n-1.
        for (int i = 0; i < n; i++) {
            mal.add(i, mal.size());
        }
        System.out.println(mal);

        // Call blockify on it. Print out the results.
        MyList<MyList<Integer>> blocks = mal.blockify();
        for (int i = 0; i < blocks.size(); i++) {
            System.out.println(blocks.get(i));
        }

        System.out.println("Done Test Blockify------");
    }

}

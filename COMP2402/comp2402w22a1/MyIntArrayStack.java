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
public class MyIntArrayStack extends MyArrayStack<Integer> { //implements MyNumList<Integer> {

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public MyIntArrayStack() {
        a = (Integer[]) new Integer[1];
        n = 0;
    }

    /**
     * Constructor
     *
     * @param cap
     */
    @SuppressWarnings("unchecked")
    public MyIntArrayStack(int cap) {
        a = (Integer[]) new Integer[cap];
        n = 0;
    }

    // TODO(student): Fill this method in.
    public void shift(int k) {
        for (int i = 0; i < a.length; i++){
            a[i] = a[i] + k;
        }
    }
    // TODO(student): Fill this method in.
    public void sum(MyIntArrayStack other) {
        for (int i = 0; i < a.length; i++){
            a[i] =a[i] + other.get(i%other.n);
        }

    }

    // TODO(student): Fill this method in.
    public void intervalInsert(MyIntArrayStack other) {
        int n = 0;
        int num = 0;
        int k = 0;
        while(true) {
            num += other.a[k%other.a.length];
            if(num >= a.length) {
                break;
            }
            n++;
            k++;
        }
        Integer[] a2 =  new Integer[a.length + n];
        Integer[] a3 =  new Integer[n];
        for (int i = 0; i < a3.length; i++) {
            if (i == 0) {
                a3[i] = other.a[i];
            }else {
                a3[i] = a3[i-1] + other.a[i%other.a.length] + 1;
            }
        }
        boolean x = false;
        int count = 0;
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a3.length; j++) {
                x = a3[j].equals(i);
                if(x) break;
            }
            if (x) {
                a2[i] = -1;
                count ++;
            }else {
                a2[i] = a[i-count];
            }
        }
        a=a2;
    }


    // This main method is provided for you for testing purposes.
    // You will want to add to this for local testing.
    public static void main(String[] args) {
        // These tests are not at all sufficient. They are just examples.
        testShift(10, 0);
        testShift(10, 3);
        testShift(10, -3);
        testSum(10, 10);
        testSum(10, 3);
        testSum(10, 5);
        testIntervalInsert(10, 2);
        testIntervalInsert(10, 4);
        testIntervalInsert(10, 9);
    }

    // Creates a MyIntArrayStack of size n, then shifts by k.
    public static void testShift(int n, int k) {
        System.out.println("Test Shift by " + k + " ------");
        MyIntArrayStack mal = new MyIntArrayStack();
        for (int i = 0; i < n; i++) {
            mal.add(i, mal.size());
        }
        System.out.println(mal);
        mal.shift(k);
        System.out.println(mal);
        System.out.println("Done Test Shift by " + k + " ------");
    }

    // Creates a MyIntArrayStack of size n and one of size k.
    // Then it calls sum on the first, passing in the second.
    public static void testSum(int n, int k) {
        System.out.println("Test Sum------");
        MyIntArrayStack mal = new MyIntArrayStack();
        for (int i = 0; i < n; i++) {
            mal.add(i, mal.size());
        }
        System.out.println(mal);
        MyIntArrayStack other = new MyIntArrayStack();
        for (int i = 0; i < k; i++) {
            other.add(i, other.size());
        }
        System.out.println(other);
        mal.sum(other);
        System.out.println(mal);
        System.out.println("Done Test Sum------");
    }

    // Creates a MyIntArrayStack of size n and of size k.
    // Calls intervalInsert on the first, passing in the second.
    public static void testIntervalInsert(int n, int k) {
        System.out.println("Test IntervalInsert------");
        MyIntArrayStack mal = new MyIntArrayStack();
        for (int i = 0; i < n; i++) {
            mal.add(i, mal.size());
        }
        System.out.println(mal);
        MyIntArrayStack other = new MyIntArrayStack();
        for (int i = 0; i < k; i++) {
            other.add(i, other.size()+1);
        }
        System.out.println(other);
        mal.intervalInsert(other);
        System.out.println(mal);
        System.out.println("Done Test IntervalInsert------");
    }

}

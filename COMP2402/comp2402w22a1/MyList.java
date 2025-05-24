package comp2402w22a1;
// Thank you Pat Morin for the basic skeleton of this file.

import java.util.Comparator;
import java.util.Iterator;

/**
 * The MyList<T> interface is a simple interface that allows a class to implement
 * all the functionality of the (more complicated) List<T> interface.
 *
 * @param <T>
 * @author sharp
 * @see List<T>
 */
public interface MyList<T> {

    /**
     * @return the number of elements in this MyList
     */
    public int size();

    /**
     * Get the element at index i of the MyList
     *
     * @param i
     * @return the element at index i in this MyList
     */
    public T get(int i);

    /**
     * Set the element at index i to x to the MyList
     *
     * @param i
     * @param x
     * @return the value at index i prior to the call
     */
    public T set(int i, T x);

    /**
     * Add the element x at index i of the MyList
     *
     * @param i
     * @param x
     */
    public void add(int i, T x);

    /**
     * Remove the element x from the MyList
     *
     * @param i
     * @return the element x removed from position i
     */
    public T remove(int i);

    /**
     * Return the list split into blocks of sizes 1, 2, 3, 4, ...
     * Return them as a list of lists.
     *
     * @return the list of blocks
     */
    public MyList<MyList<T>> blockify();

    /**
     * Clear the MyList, removing all elements from the set
     */
//	public void clear();

}

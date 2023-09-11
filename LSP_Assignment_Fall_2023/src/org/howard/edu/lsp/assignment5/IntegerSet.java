package org.howard.edu.lsp.assignment5;

import java.util.*;

/**
 * A class that represents an integer set. This class allows you to perform various operations
 * on sets of integers, such as union, intersection, addition, removal, and more.
 * 
 * @author Camryn Turner-Markes
 */
public class IntegerSet {

    List<Integer> int_set;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        int_set = new ArrayList<Integer>();
    }

    /**
     * Clears the internal representation of the set, making it empty.
     */
    public void clear() {
        int_set.clear();
    }
    
    /**
     * Sets the internal representation of the set to a new list.
     * 
     * @param new_set The new list to set as the internal representation of the set.
     */
    public void set_set(List<Integer> new_set) {
        int_set = new_set;
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return The number of elements in the set.
     */
    public int length() {
        return int_set.size();
    }

    /**
     * Checks if two IntegerSet objects are equal. Two sets are equal if they contain
     * the same values in any order.
     * 
     * @param a Another IntegerSet to compare.
     * @return true if the sets are equal, false otherwise.
     */
    public boolean equals(IntegerSet a) {
        if (int_set.size() != a.length()) {
            return false;
        } else {
            return int_set.containsAll(a.int_set);
        }
    }

    /**
     * Checks if the set contains a specific value.
     * 
     * @param value The integer value to check for.
     * @return true if the value is in the set, false otherwise.
     */
    public boolean contains(int value) {
        return int_set.contains(value);
    }

    /**
     * Returns the largest integer in the set.
     * 
     * @return The largest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (int_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        } else {
            int large = int_set.get(0);
            for (int i = 0; i < int_set.size(); i++) {
                if (int_set.get(i) > large) {
                    large = int_set.get(i);
                }
            }
            return large;
        }
    }

    /**
     * Returns the smallest integer in the set.
     * 
     * @return The smallest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (int_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        } else {
            int small = int_set.get(0);
            for (int i = 0; i < int_set.size(); i++) {
                if (int_set.get(i) < small) {
                    small = int_set.get(i);
                }
            }
            return small;
        }
    }

    /**
     * Adds an integer to the set if it is not already present.
     * 
     * @param item The integer to add to the set.
     */
    public void add(int item) {
        if (!int_set.contains(item)) {
            int_set.add(item);
        }
    }

    /**
     * Removes an integer from the set if it is present.
     * 
     * @param item The integer to remove from the set.
     */
    public void remove(int item) {
        if (int_set.contains(item)) {
            int_set.remove(Integer.valueOf(item));
        }
    }

    /**
     * Calculates the union of two sets.
     * 
     * @param b Another IntegerSet to perform the union with.
     */
    public void union(IntegerSet b) {
        for (int i = 0; i < b.length(); i++) {
            if (!int_set.contains(b.int_set.get(i))) {
                int_set.add(b.int_set.get(i));
            }
        }
    }

    /**
     * Calculates the intersection of two sets.
     * 
     * @param b Another IntegerSet to perform the intersection with.
     */
    public void intersect(IntegerSet b) {
        int_set.retainAll(b.int_set);
    }

    /**
     * Calculates the difference between two sets (s1 - s2).
     * 
     * @param b Another IntegerSet to calculate the difference with.
     */
    public void diff(IntegerSet b) {
        for (int i = 0; i < b.length(); i++) {
            if (int_set.contains(b.int_set.get(i))) {
                int_set.remove(Integer.valueOf(b.int_set.get(i)));
            }
        }
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return int_set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return A string containing the elements of the set.
     */
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < int_set.size(); i++) {
            list.append(int_set.get(i));
            if (i < int_set.size() - 1) {
                list.append(", ");
            }
        }
        return list.toString();
    }

    /**
     * A custom exception class for IntegerSet operations.
     */
    public class IntegerSetException extends Exception {
        /**
         * Constructs an IntegerSetException with a specified error message.
         * 
         * @param error The error message.
         */
        public IntegerSetException(String error) {
            super(error);
        }
    }
}

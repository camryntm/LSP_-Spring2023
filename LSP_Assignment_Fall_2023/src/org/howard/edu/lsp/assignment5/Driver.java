package org.howard.edu.lsp.assignment5;

import org.howard.edu.lsp.assignment5.IntegerSet.IntegerSetException;

/**
 * A driver class to test the IntegerSet class and its methods.
 * 
 * @author Camryn Turner-Markes
 */
public class Driver {

    /**
     * The main method that runs tests on the IntegerSet class methods.
     * 
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            // Declaring and initializing our first set
            IntegerSet set1 = new IntegerSet();
            
            // Adding integers to set1 with a for loop
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            
            // Testing toString(), smallest(), and largest()
            System.out.println("Value of Set 1 is: " + set1.toString() + "\n");
            System.out.println("Smallest value in Set 1 is: " + set1.smallest()); // Result of smallest on set1
            System.out.println("Largest value in Set 1 is: " + set1.largest() + "\n"); // Result of largest on set1
            
            // Testing remove()
            System.out.println("Removed 3 from Set 1.");
            set1.remove(3);
            System.out.println("New value of Set 1: " + set1.toString() + "\n"); // Result of removing 3 from set1
            
            System.out.println("Removed 8 from Set 1.");
            set1.remove(8);
            System.out.println("New value of Set 1: " + set1.toString() + "\n"); // Result of removing 8 from set1
            
            System.out.println("Remove 100 from Set 1.");
            set1.remove(100);
            System.out.println("New value of Set 1: " + set1.toString() + "\n"); // Result of removing 100 from set1
            
            // Testing isEmpty()
            System.out.println("Set 1 is Empty (true/false)");
            System.out.println(set1.isEmpty() + "\n"); // Result of isEmpty on set1
            
            // Testing contains()
            System.out.println("Set 1 contains 9? (true/false)");
            System.out.println(set1.contains(9) + "\n"); // Result of contains(9) on set1
            
            // Testing length()
            System.out.println("Length of Set 1: " + set1.length() + "\n"); // Result of length() on set1
            
            // "Resetting" the set
            set1.clear();
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            
            // Declaring and initializing our second set
            IntegerSet set2 = new IntegerSet();
            
            // Adding integers to set2 with a for loop
            for (int i = 0; i <= 20; i += 2) {
                set2.add(i);
            }
            
            System.out.println("Value of Set 1 is: " + set1.toString());
            System.out.println("Value of Set 2 is: " + set2.toString());
            System.out.println("We will reset the values of each list after every test." + "\n");
            
            // Testing union()
            System.out.println("Union of Set 1 and Set 2");
            set1.union(set2);	// Union of set1 and set2
            System.out.println(set1.toString() + "\n");	// Result of union of set1 and set2
            
            set1.clear();
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            set2.clear();
            for (int i = 0; i <= 20; i += 2) {
                set2.add(i);
            }
            
            System.out.println("Difference of Set 1 and Set 2");
            set1.diff(set2); // Difference of set1 and set2
            System.out.println(set1.toString() + "\n"); // Result of difference of set1 and set2
            
            set1.clear();
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            set2.clear();
            for (int i = 0; i <= 20; i += 2) {
                set2.add(i);
            }
            
            System.out.println("Difference of Set 2 and Set 1");
            set2.diff(set1); // Difference of set2 and set1
            System.out.println(set2.toString() + "\n"); // Result of difference of set2 and set1
            
            set1.clear();
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            set2.clear();
            for (int i = 0; i <= 20; i += 2) {
                set2.add(i);
            }
            
            System.out.println("Intersection of Set 1 and Set 2");
            set1.intersect(set2); // Intersection of set1 and set2
            System.out.println(set1.toString() + "\n"); // Result of intersection of set1 and set2
            
            set1.clear();
            for (int i = 1; i <= 10; i++) {
                set1.add(i);
            }
            set2.clear();
            for (int i = 0; i <= 20; i += 2) {
                set2.add(i);
            }
            
            System.out.println("Are Set 1 and Set 2 equal?");
            System.out.println(set1.equals(set2) + "\n"); // Result of equal on set1 and set 2
            
            System.out.println("Catching the exception");
            set1.clear(); // Need the list to be empty
            set1.largest(); // Largest throws the exception when the set is empty
        } catch (IntegerSetException e) {
            System.out.println(e); // Prints the exception
        }
    }
}

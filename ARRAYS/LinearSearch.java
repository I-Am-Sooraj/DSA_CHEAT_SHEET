import java.util.*;

/**
 * LinearSearch
 * -------------
 * A simple demonstration of the linear (sequential) search algorithm.
 *
 * How it works:
 * - Scan the array from left to right.
 * - Compare each element with the target value.
 * - Return the index on the first match; if not found, return -1.
 *
 * Time Complexity:
 * - Best:  O(1)   (first element matches)
 * - Worst: O(n)   (target at end or absent)
 * - Average: O(n)
 */
public class LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size with a friendly prompt
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        // Basic input validation for size
        if (size < 0) {
            System.out.println("Size cannot be negative. Exiting.");
            sc.close();
            return;
        }

        // Initialize array
        int[] arr = new int[size];

        // Fill the array with user input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        // Show the constructed array
        System.out.println("\nArray: " + Arrays.toString(arr));

        // Read target value
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Perform linear search
        int result = linearSearch(arr, target);

        // Report result
        if (result == -1) {
            System.out.println("Result: Element not found");
        } else {
            System.out.println("Result: Element found at index " + result);
        }

        sc.close();
    }

    /**
     * Returns the index of the first occurrence of target in arr, or -1 if absent.
     */
    public static int linearSearch(int[] arr, int target) {
        // Guard against null arrays
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found the target at index i
            }
        }
        return -1; // not found
    }
}

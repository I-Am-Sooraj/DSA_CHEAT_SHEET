import java.util.*;
/**
 * BinarySearch
 * ------------
 * Demonstrates binary search on a sorted array. Supports both ascending and
 * descending sorted arrays by detecting the order.
 *
 * Time Complexity:
 * - Best:  O(1)    (mid equals target on first check)
 * - Worst: O(log n)
 * - Avg:   O(log n)
 *
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size with a friendly prompt
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        if (size < 0) {
            System.out.println("Size cannot be negative. Exiting.");
            sc.close();
            return;
        }

        // Initialize array
        int[] arr = new int[size];

        // Fill the array with user input while encouraging sorted order
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for index " + i + ": ");
            arr[i] = sc.nextInt();

            if (i > 0) {
                // Enforce consistent order as values are entered to keep array sorted
                while (true) {
                    int dir = detectOrder(arr, i); // 1 asc, -1 desc, 0 unknown (all equal so far)

                    boolean ok = true;
                    if (dir == 1) {
                        ok = arr[i] >= arr[i - 1]; // non-decreasing for ascending
                    } else if (dir == -1) {
                        ok = arr[i] <= arr[i - 1]; // non-increasing for descending
                    }

                    if (ok) break;

                    System.out.print(
                        "Invalid order. Re-enter value for index " + i + " to keep " +
                        (dir == -1 ? "descending" : "ascending") + " order: "
                    );
                    arr[i] = sc.nextInt();
                }
            }
        }

        // Show the constructed array
        System.out.println("\nArray: " + Arrays.toString(arr));

        // Read target value
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Perform binary search (order-agnostic)
        int result = binarySearch(arr, target);

        // Report result
        if (result == -1) {
            System.out.println("Result: Element not found");
        } else {
            System.out.println("Result: Element found at index " + result);
        }

        sc.close();
    }

    /**
     * Order-agnostic binary search.
     * Returns the index of the target in a sorted array (ascending or descending), or -1 if absent.
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;
        boolean ascending = isAscending(arr);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid; // found
            }

            if (ascending) {
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { // descending
                if (arr[mid] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // Detect if the array (up to index endInclusive) is ascending or descending, or unknown if all equal
    private static int detectOrder(int[] arr, int endInclusive) {
        for (int j = 1; j <= endInclusive; j++) {
            if (arr[j] != arr[j - 1]) {
                return arr[j] > arr[j - 1] ? 1 : -1;
            }
        }
        return 0; // unknown (all equal so far)
    }

    // Determine if the whole array is ascending (non-decreasing); if all equal, treat as ascending
    private static boolean isAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                return arr[i] > arr[i - 1];
            }
        }
        return true;
    }
}

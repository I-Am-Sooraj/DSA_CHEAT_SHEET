# 📚 Arrays in Java

Arrays are fixed-size, contiguous collections of elements of the same type. They provide O(1) random access by index and are commonly used as the foundational data structure for many algorithms.

---

## 🧠 Definition
- An array stores a fixed number of values of a single type (e.g., `int`, `String`).
- Elements are indexed from `0` to `length - 1`.
- Memory is contiguous; indexing is constant time.

```java
int[] arr;              // declaration
arr = new int[5];       // allocation (default values: 0)
int[] nums = {1, 2, 3}; // declaration + initialization (size inferred)
```

---

## 🏗️ Initialization Patterns

- With size only (default values):
```java
int[] a = new int[3];           // [0, 0, 0]
String[] s = new String[2];     // [null, null]
```

- With values (array literal):
```java
int[] b = {10, 20, 30};
```

- After declaration:
```java
int[] c;
c = new int[]{4, 5, 6};
```

---

## 🔑 Core Properties and Common APIs

- `arr.length` — number of elements (final, not a method)
- `Arrays.toString(arr)` — pretty-print 1D arrays
- `Arrays.deepToString(objArr)` — pretty-print nested arrays
- `Arrays.sort(arr)` — in-place sort (ascending)
- `Arrays.binarySearch(sortedArr, key)` — binary search on sorted array
- `Arrays.fill(arr, value)` — fill all elements
- `System.arraycopy(src, srcPos, dest, destPos, length)` — fast copy

```java
import java.util.Arrays;
int[] arr = {3, 1, 2};
Arrays.sort(arr);                    // [1, 2, 3]
int idx = Arrays.binarySearch(arr, 2); // 1
Arrays.fill(arr, 9);                 // [9, 9, 9]
```

---

## ⚠️ Gotchas
- Arrays have fixed size; use `ArrayList` for dynamic resizing.
- `.length` is a field; don’t call `arr.length()`.
- Out-of-bounds access (`arr[-1]` or `arr[arr.length]`) throws `ArrayIndexOutOfBoundsException`.

---

## 🧪 Examples

### 1) Linear Search

What it means:
- Scan the array from left to right and compare each element with the target.
- Return the index of the first match; if not found, return -1.

Quick demo:
```java
int[] arr = {4, 2, 7, 1};
int target = 7;
int index = -1;
for (int i = 0; i < arr.length; i++) {
  if (arr[i] == target) { index = i; break; }
}
// index == 2
```

Time & Space:
- Best: O(1)  (match at the first position)
- Average: O(n)
- Worst: O(n)
- Space: O(1)

See code: [LinearSearch.java](./LinearSearch.java)

---

### 2) Binary Search

What it means:
- Works on a sorted array (ascending or descending).
- Repeatedly checks the middle element and halves the search space.

Quick demo (call):
```java
int idx = BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 7); // -> 3
```

Time & Space:
- Time: O(log n)
- Space: O(1)
- Requires: array must be sorted (duplicates allowed; returns one occurrence)

See code: [BinarySearch.java](./BinarySearch.java)

---

More coming to this folder:
- Max subarray (brute-force sum)
- Trapping Rainwater
- Best Time to Buy and Sell Stock
- Two Sum (Brute Force / HashMap)
- Max/Min in Array

These will be added over time with clear explanations, examples, and complexities.

---

## 📎 Tips
- Prefer `for-each` when index isn’t needed; prefer classic `for` when you need `i`.
- Use `Arrays.equals(a, b)` for equality; `a == b` compares references.
- For performance-critical code, beware of boxing/unboxing with `Integer[]` vs `int[]`.

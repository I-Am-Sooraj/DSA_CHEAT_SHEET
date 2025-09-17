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

## 🧪 Examples in this folder

- Linear Search — scan elements one by one until a match is found.
  - See: [LinearSearch.java](./LinearSearch.java)
- Binary Search — find an element in a sorted array in O(log n).
  - See: [BinarySearch.java](./BinarySearch.java)
- Two Sum (Brute Force / HashMap)
  - See: TwoSum.java (planned)
- Max/Min in Array
  - See: MaxMin.java (planned)

---

## 🏃 Quick Demo: Linear Search

```java
int[] arr = {4, 2, 7, 1};
int target = 7;
int index = -1;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) { index = i; break; }
}
// index == 2
```
---

## 🔎 Binary Search (overview)

Binary search works on sorted arrays (ascending or descending). It repeatedly halves the search space by comparing the middle element to the target.

- Time: O(log n)
- Space: O(1)
- Requires: the array must be sorted; duplicates are okay (returns one occurrence).

Example call:
```java
int idx = BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 7); // -> 3
```


---

## 📎 Tips
- Prefer `for-each` when index isn’t needed; prefer classic `for` when you need `i`.
- Use `Arrays.equals(a, b)` for equality; `a == b` compares references.
- For performance-critical code, beware of boxing/unboxing with `Integer[]` vs `int[]`.

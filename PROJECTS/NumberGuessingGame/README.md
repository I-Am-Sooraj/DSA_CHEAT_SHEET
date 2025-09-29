# 🎯 Number Guessing Game (Java)

A simple console game: the computer picks a random number, and you try to guess it. After every 5 valid guesses, you can decide to stop.

---

## 🧩 What you’ll learn
- Reading user input safely with `Scanner`
- Validating input and enforcing a range
- Using helper methods to keep `main` clean
- Random number generation within an inclusive range
- Control flow with loops and early exits

---

## 📁 Project Layout
```
PROJECTS/NumberGuessingGame/
├─ NumberGuessingGame.java   # main program
└─ README.md                 # this file
```

---

## ▶️ How to run (Windows PowerShell)
```powershell
cd "PROJECTS/NumberGuessingGame"
javac NumberGuessingGame.java
java NumberGuessingGame
```

---

## 📜 Code walkthrough

File: `NumberGuessingGame.java`

```java
public class NumberGuessingGame {
    private static final int MIN = 1;
    private static final int MAX = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secret = MIN + (int)(Math.random() * (MAX - MIN + 1));
        int attempts = 0;
        while (true) {
            int guess = readIntInRange(sc, "Guess the number between " + MIN + " and " + MAX + ": ", MIN, MAX);
            attempts++;
            if (guess == secret) { /* win */ break; }
            else if (guess > secret) { /* hint: too high */ }
            else { /* hint: too low */ }
            if (attempts % 5 == 0) {
                if (!askToContinue(sc, attempts)) { /* user exits */ break; }
            }
        }
        sc.close();
    }
}
```

### Key pieces

- Constants `MIN` and `MAX`
  - Centralize the range; used for both generating the secret and validating input.

- `secret` generation
  - `int secret = MIN + (int)(Math.random() * (MAX - MIN + 1));`
  - Produces a value in [MIN, MAX] inclusive.

- Main game loop
  - Uses `while (true)` and `break` to exit on win or when the user chooses to stop.

- Input helpers
  - `readInt(Scanner sc, String prompt)`
    - Keeps prompting until a valid integer is entered; handles non-numeric input.
  - `readIntInRange(Scanner sc, String prompt, int min, int max)`
    - Uses `readInt`, then enforces `[min, max]` with a friendly message.
  - `askToContinue(Scanner sc, int attempts)`
    - Asks every 5 attempts; accepts Yes/Y/No/N (case-insensitive). Defaults to continue.

---

## ⏱️ Complexity
- Time: depends on user guesses; core operations are O(1) per guess.
- Space: O(1), only a few variables are used.

---

## ✅ Ideas to extend
- Track best score (fewest attempts) across rounds.
- Add difficulty levels with different ranges.
- Limit the number of attempts and reveal the number if exceeded.
- Replace `Math.random()` with `java.util.Random` for testability.

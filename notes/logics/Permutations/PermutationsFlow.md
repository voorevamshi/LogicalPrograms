# End-to-End Execution Flow: Backtracking Permutations of "123"

This document traces the exact execution sequence of the `backtrack()` method for the input string `"123"`. 

The variables at play:
*   `chars`: `['1', '2', '3']` (The blocks we can use)
*   `used`: `[F, F, F]` (Which blocks are currently placed)
*   `current`: `""` (The word we are building)
*   `result`: `[]` (The completed words)

---

## 🟢 Branch 1: The First Word (123)
We start at **Level 1** from the main method.

1.  **Level 1 (`i=0`)**: Look at `'1'`. 
    *   Not used. Mark used: `[T, F, F]`. Added to word: `"1"`.
    *   `backtrack()` called (Pause at `i=0`, advance to Level 2).
2.  **Level 2 (`i=0`)**: Look at `'1'`. Already used. Skip.
3.  **Level 2 (`i=1`)**: Look at `'2'`. 
    *   Not used. Mark used: `[T, T, F]`. Added to word: `"12"`.
    *   `backtrack()` called (Pause at `i=1`, advance to Level 3).
4.  **Level 3 (`i=0`)**: Look at `'1'`. Used. Skip.
5.  **Level 3 (`i=1`)**: Look at `'2'`. Used. Skip.
6.  **Level 3 (`i=2`)**: Look at `'3'`. 
    *   Not used. Mark used: `[T, T, T]`. Added to word: `"12" + "3" = "123"`.
    *   `backtrack()` called (Pause at `i=2`, advance to Level 4).
7.  **Level 4 (Base Case)**:
    *   Length is 3! We found our first permutation. 
    *   **Add `"123"` to results.** 
    *   `return;` 

---

## 🟨 Branch 2: The First Backtrack (132)
Level 4 was destroyed. We wake up the paused **Level 3**.

8.  **Level 3 (wakes up)**: 
    *   Undo phase runs: Unmark `'3'`, remove `"3"`. Word becomes `"12"`. `used` is `[T, T, F]`.
    *   Level 3's `for` loop reaches the end.
    *   Level 3 finishes naturally and is destroyed.
9.  **Level 2 (wakes up)**:
    *   Undo phase runs: Unmark `'2'`, remove `"2"`. Word becomes `"1"`. `used` is `[T, F, F]`.
    *   Level 2's `for` loop continues from `i=1` to next value `i=2` (character `'3'`).
    *   Not used! Mark used: `[T, F, T]`. Added to word: `"13"`.
    *   `backtrack()` called (Pause at `i=2`, advance to new Level 3).
10. **Level 3 (new instance, `i=0`)**: Look at `'1'`. Used. Skip.
11. **Level 3 (new instance, `i=1`)**: Look at `'2'`. 
    *   Not used. Mark used: `[T, T, T]`. Added to word: `"132"`.
    *   `backtrack()` called (Advance to Level 4).
12. **Level 4 (Base Case)**: Let's skip the small steps.
    *   Length is 3. **Add `"132"` to results.** 
    *   `return;`

---

## 🔵 Branch 3: Moving the Root Process (Finding 213)
Level 4 is destroyed. We wake up the paused **Level 3**.

13. **Level 3 (wakes up)**: 
    *   Undo phase runs: Unmark `'2'`, remove `"2"`. Word becomes `"13"`. `used` is `[T, F, T]`.
    *   Level 3's `for` loop continues to `i=2` (character `'3'`). But wait, `'3'` is already marked `used`! Skip.
    *   Level 3's loop hits the end (i=3) and Level 3 is destroyed.
14. **Level 2 (wakes up)**:
    *   Undo phase runs: Unmark `'3'`, remove `"3"`. Word becomes `"1"`. `used` is `[T, F, F]`.
    *   Level 2's `for` loop continues from `i=2` to the end (`i=3`).
    *   Level 2 finishes naturally and is destroyed. The entire starting `'1'` branch is fully complete!
15. **Level 1 (The Original Root wakes up)**:
    *   Undo phase runs: Unmark `'1'`, remove `"1"`. Word is empty! `used` is `[F, F, F]`.
    *   Level 1's `for` loop finally ticks up from `i=0` to `i=1` (character `'2'`).
    *   Not used! Mark used: `[F, T, F]`. Added to word: `"2"`.
    *   `backtrack()` called (Pause at `i=1`, advance to Level 2).
16. **Level 2 (`i=0`)**: Look at `'1'`. 
    *   Not used. Mark used: `[T, T, F]`. Added to word: `"21"`.
    *   `backtrack()` called (Pause at `i=0`, advance to Level 3).
17. **Level 3 (`i=0`)**: Look at `'1'`. Used. Skip.
18. **Level 3 (`i=1`)**: Look at `'2'`. Used. Skip.
19. **Level 3 (`i=2`)**: Look at `'3'`. 
    *   Not used. Mark used: `[T, T, T]`. Added to word: `"213"`.
    *   `backtrack()` called (Pause at `i=2`, advance to Level 4).
20. **Level 4 (Base Case)**:
    *   Length is 3. **Add `"213"` to results.** 
    *   `return;`

---

## 🟣 Branch 4: Backtracking to find 231
Level 4 is destroyed. We wake up **Level 3**.

21. **Level 3 (wakes up)**: 
    *   Undo phase: Unmark `'3'`, remove `"3"`. Word becomes `"21"`.
    *   Loop naturally ends. Level 3 is destroyed.
22. **Level 2 (wakes up)**:
    *   Undo phase: Unmark `'1'`, remove `"1"`. Word becomes `"2"`. `used` is `[F, T, F]`.
    *   Level 2's loop continues to `i=1` (character `'2'`). Used! Skip.
    *   Level 2's loop continues to `i=2` (character `'3'`). 
    *   Not used. Mark used: `[F, T, T]`. Added to word: `"23"`.
    *   `backtrack()` called (Pause at `i=2`, advance to Level 3).
23. **Level 3 (`i=0`)**: Look at `'1'`. 
    *   Not used. Mark used: `[T, T, T]`. Added to word: `"231"`.
    *   `backtrack()` called (Advance to Level 4).
24. **Level 4 (Base Case)**:
    *   Length is 3. **Add `"231"` to results.** 
    *   `return;`

---

## 🟠 Branch 5: Moving the Root again (Finding 312)
Level 4 is destroyed. We wake up **Level 3**.

25. **Level 3 (wakes up)**:
    *   Undo phase: Unmark `'1'`, remove `"1"`. Word becomes `"23"`.
    *   Loop continues to `i=1` ('2'). Used. Skip.
    *   Loop continues to `i=2` ('3'). Used. Skip.
    *   Loop ends. Level 3 is destroyed.
26. **Level 2 (wakes up)**:
    *   Undo phase: Unmark `'3'`, remove `"3"`. Word becomes `"2"`. 
    *   Loop hits `i=3`. Level 2 is destroyed. The entire `'2'` branch is completely dead!
27. **Level 1 (The Original Root wakes up)**:
    *   Undo phase: Unmark `'2'`, remove `"2"`. Word is empty! `used` is `[F, F, F]`.
    *   Level 1's loop ticks up from `i=1` to its final character `i=2` (character `'3'`).
    *   Not used. Mark used: `[F, F, T]`. Added to word: `"3"`.
    *   `backtrack()` called (Pause at `i=2`, advance to Level 2).
28. **Level 2 (`i=0`)**: Look at `'1'`.
    *   Not used. Mark used: `[T, F, T]`. Added to word: `"31"`.
    *   `backtrack()` called (Pause at `i=0`, advance to Level 3).
29. **Level 3 (`i=0`)**: Look at `'1'`. Used. Skip.
30. **Level 3 (`i=1`)**: Look at `'2'`.
    *   Not used. Mark used `[T, T, T]`. Added to word `"312"`.
    *   `backtrack()` called (Advance to Level 4).
31. **Level 4 (Base Case)**:
    *   Length is 3. **Add `"312"` to results.**
    *   `return;`

---

## 🔴 Branch 6: Our Final Permutation (321)
Level 4 is destroyed. We wake up **Level 3**.

32. **Level 3 (wakes up)**:
    *   Undo phase: Unmark `'2'`, remove `"2"`. Word is `"31"`.
    *   Loop continues to `i=2` ('3'). Used. Skip.
    *   Loop ends. Level 3 is destroyed.
33. **Level 2 (wakes up)**:
    *   Undo phase: Unmark `'1'`, remove `"1"`. Word is `"3"`. `used` is `[F, F, T]`.
    *   Loop continues to `i=1` (character `'2'`).
    *   Not used. Mark used `[F, T, T]`. Added to word `"32"`.
    *   `backtrack()` called (Pause at `i=1`, advance to Level 3).
34. **Level 3 (`i=0`)**: Look at `'1'`.
    *   Not used. Mark used `[T, T, T]`. Added to word `"321"`.
    *   `backtrack()` called (Advance to Level 4).
35. **Level 4 (Base Case)**:
    *   Length is 3. **Add `"321"` to results.**
    *   `return;`

---

## 🏁 The Final Unwind (Shutting Down)
Level 4 is destroyed. We wake up **Level 3**.

36. **Level 3 (wakes up)**:
    *   Undo phase: Unmark `'1'`, remove `"1"`. Word is `"32"`. 
    *   Loop continues through `'2'` (used), `'3'` (used).
    *   Loop ends. Level 3 destroyed.
37. **Level 2 (wakes up)**:
    *   Undo phase: Unmark `'2'`, remove `"2"`. Word is `"3"`.
    *   Loop continues to `'3'` (used). 
    *   Loop ends. Level 2 destroyed. The final starting `'3'` branch is fully complete!
38. **Level 1 (Root wakes up for the last time)**:
    *   Undo phase: Unmark `'3'`, remove `"3"`. Word goes back to being an perfectly empty string! `used` is `[F, F, F]`. 
    *   Level 1's loop tries to tick up from `i=2` (the last character) to `i=3`. 
    *   Since `i < 3` is no longer true, the main `for` loop finally finishes!
39. **Done**: The initial `backtrack` call completes and returns the full `results` list exactly containing `["123", "132", "213", "231", "312", "321"]`!

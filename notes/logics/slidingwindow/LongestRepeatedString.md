**Sliding Window** technique using a `HashSet` to find the **Longest Substring Without Repeating Characters**.

Despite its class name (`LngstReptStr`), it's actually looking for the longest sequence of _unique_ contiguous characters.

The mechanism works like a dynamic tape:

-   **`right` pointer**: Expands the window by adding characters into the set.
    
-   **`left` pointer**: Shrinks the window from the left whenever a duplicate is encountered until all characters in the set are unique again.
    
-   **`startIndex` & `maxLength`**: Track where the longest valid sequence started and how long it was.
Example Program
```
package com.vmc.interview.altimetric;  
  
import java.util.LinkedHashSet;  
  
public class LngstReptStr {  
  
    public static void main(String[] args) {  
        String str="abcdefabccdefg";  
  
        int left=0;  
        int startIndex=0;  
        int maxLength=0;  
        LinkedHashSet<Character> hs = new LinkedHashSet<>();  
        for (int right=0;right<str.length();right++){  
            while (hs.contains(str.charAt(right))){    
              hs.remove(str.charAt(left)); 
              left++;                      
            }  
            hs.add(str.charAt(right));  
            if(right-left+1>maxLength){  
                maxLength=right-left+1;  
                startIndex=left;  
            }  
            System.out.println("index:"+(right)+",startIndex:"+startIndex+",maxLength:"+maxLength+",ch:"+str.charAt(right)+",hs:"+hs);  
        }  
        System.out.println("Longest substring:"+str.substring(startIndex,startIndex+maxLength));  
    }  
}
```
Output
```
index:0,startIndex:0,maxLength:1,ch:a,hs:[a]
index:1,startIndex:0,maxLength:2,ch:b,hs:[a, b]
index:2,startIndex:0,maxLength:3,ch:c,hs:[a, b, c]
index:3,startIndex:0,maxLength:4,ch:d,hs:[a, b, c, d]
index:4,startIndex:0,maxLength:5,ch:e,hs:[a, b, c, d, e]
index:5,startIndex:0,maxLength:6,ch:f,hs:[a, b, c, d, e, f]
index:6,startIndex:0,maxLength:6,ch:a,hs:[b, c, d, e, f, a]
index:7,startIndex:0,maxLength:6,ch:b,hs:[c, d, e, f, a, b]
index:8,startIndex:0,maxLength:6,ch:c,hs:[d, e, f, a, b, c]
index:9,startIndex:0,maxLength:6,ch:c,hs:[c]
index:10,startIndex:0,maxLength:6,ch:d,hs:[c, d]
index:11,startIndex:0,maxLength:6,ch:e,hs:[c, d, e]
index:12,startIndex:0,maxLength:6,ch:f,hs:[c, d, e, f]
index:13,startIndex:0,maxLength:6,ch:g,hs:[c, d, e, f, g]
Longest substring:abcdef
```

Here is what happens when the loop encounters the second duplicate `'c'` in `"abcdefabccdefg"` (at index `8`):

Before that second `'c'` is processed, the state looks like this:

-   **Window string:** `"defabc"` (indices 3 to 8)
    
-   **`hs` contains:** `['d', 'e', 'f', 'a', 'b', 'c']`
    
-   **`left` pointer:** index `3` (pointing to `'d'`)
    
-   **`right` pointer:** index `8` (pointing to `'c'`)
    

When `str.charAt(right)` evaluates to `'c'`, `hs.contains('c')` returns **true**. The `while` loop kicks in and runs repeatedly until `'c'` is gone from the set:

### Step-by-Step Execution of the Loop
## Sliding Window Duplicate Removal Iterations

| **Iteration** | **Character at Left** | **Action Taken** | **HashSet (`hs`) After Remove** | **Left Becomes** | **`hs.contains('c')` Check** |
|---|---|---|---|---:|---|
| **Start** | — | Duplicate `'c'` found | `['d', 'e', 'f', 'a', 'b', 'c']` | `3` | `true` |
| **Pass 1** | `'d'` (index `3`) | `hs.remove('d')` | `['e', 'f', 'a', 'b', 'c']` | `4` | `true` *(still contains `'c'`)* |
| **Pass 2** | `'e'` (index `4`) | `hs.remove('e')` | `['f', 'a', 'b', 'c']` | `5` | `true` *(still contains `'c'`)* |
| **Pass 3** | `'f'` (index `5`) | `hs.remove('f')` | `['a', 'b', 'c']` | `6` | `true` *(still contains `'c'`)* |
| **Pass 4** | `'a'` (index `6`) | `hs.remove('a')` | `['b', 'c']` | `7` | `true` *(still contains `'c'`)* |
| **Pass 5** | `'b'` (index `7`) | `hs.remove('b')` | `['c']` | `8` | `true` *(still contains `'c'`)* |
| **Pass 6** | `'c'` (index `8`) | `hs.remove('c')` | `[]` *(empty)* | `9` | `false` → **Loop Ends!** |

### Difference between LinkedHashSet and  HashSet 
## 1. The Key Difference: Preserved Order vs. Unpredictable Order

-   **`HashSet`**: Does not guarantee any specific iteration order. Elements are stored based on their hash code, which is why your output printed sets like `[a, b, c, d, e, f]`, but on different JVM implementations or runs, that order could change.
    
-   **`LinkedHashSet`**: Maintains a doubly-linked list running through all of its entries. It preserves **insertion order**.
    

Because of this, `hs.toString()` will _always_ print characters in the exact order they entered the sliding window.

### 2. Impact on Output Trace

Notice how the `hs` output changes during the trace:
#### HashSet vs LinkedHashSet Output Comparison

| **Data Structure** | **Console Output (Duplicate `'c'`)** |
|---|---|
| **HashSet** | `hs:[a, b, c, d, e, f]` *(Order is **not guaranteed** and depends on the hash codes.)* |
| **LinkedHashSet** | `hs:[d, e, f, a, b, c]` *(Maintains **insertion order**, so it exactly matches the current sliding window.)* |

In the table from the previous question, as `left` shrinks the window, a `LinkedHashSet` cleanly drops elements from the head of the list (`d`, then `e`, then `f`...) in FIFO order.

### 3. Performance Comparison
## HashSet vs LinkedHashSet Comparison

| **Property** | **HashSet** | **LinkedHashSet** | **Impact on Your Code** |
|---|---|---|---|
| **Time Complexity** | **O(1)** lookup, add, remove | **O(1)** lookup, add, remove | **No impact** — overall algorithm remains **O(N)**. |
| **Memory Overhead** | Lower | Slightly higher | `LinkedHashSet` uses extra pointers to maintain a doubly linked list. |
| **Iteration Order** | Unpredictable | Preserves insertion order | Makes debug output (e.g., `System.out.println(hs)`) much easier to understand because it reflects the current sliding window. |


es, the **step-by-step logic and character removal order are identical** for both `HashSet` and `LinkedHashSet`.

Because your code removes characters based on the string index using `str.charAt(left)` (which increments `3 -> 4 -> 5 -> 6 -> 7 -> 8`), the characters are removed in the **exact same sequential order**: `'d'`, then `'e'`, then `'f'`, then `'a'`, then `'b'`, then `'c'`.

The only difference is how the **remaining contents inside `hs` look during each step** in the log.

### Step-by-Step Execution Comparison

Here is how the set contents look at each pass of the loop for both structures:
## HashSet vs LinkedHashSet During Duplicate Removal

| **Iteration** | **Left Character Removed** | **HashSet Contents (Hash-based Order)** | **LinkedHashSet Contents (Insertion Order)** |
|---|---|---|---|
| **Start** | *(None)* | `[a, b, c, d, e, f]` | `[d, e, f, a, b, c]` |
| **Pass 1** | `'d'` (index `3`) | `[a, b, c, e, f]` | `[e, f, a, b, c]` |
| **Pass 2** | `'e'` (index `4`) | `[a, b, c, f]` | `[f, a, b, c]` |
| **Pass 3** | `'f'` (index `5`) | `[a, b, c]` | `[a, b, c]` |
| **Pass 4** | `'a'` (index `6`) | `[b, c]` | `[b, c]` |
| **Pass 5** | `'b'` (index `7`) | `[c]` | `[c]` |
| **Pass 6** | `'c'` (index `8`) | `[]` *(empty)* | `[]` *(empty)* |
**Bottom Line:** If you swap in `LinkedHashSet`, your code will produce the **exact same final substring (`"abcdef"`)**, but your debug `println` statements will reliably show the characters in the exact order of the current sliding window.

1.  **`HashSet`**: The underlying bucket array reshuffles positions based on hash codes, so the visual ordering in `hs` feels random (e.g., `[a, b, c, d, e, f]`).
    
2.  **`LinkedHashSet`**: Acting like a FIFO queue, it cleanly removes from the front (`'d'`, then `'e'`, etc.), leaving the remaining characters in their exact window sequence.
    

In short, the **algorithm steps and variables (`left`, `right`, `maxLength`) behave 100% identically** — only the `toString()` display order of the set changes.

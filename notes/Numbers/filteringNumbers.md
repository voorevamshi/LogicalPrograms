# Java List Processing: Performance & Optimization Guide

This document compares standard Java Stream approaches with optimized alternatives for handling duplicates, distinct values, and unique elements in a `List<Integer>`.

---

## 1. Get Distinct Numbers (Remove Duplicates)
*Goal: Returns every number present in the list exactly once.*

### Current Approach (Stream)
```java
List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
List<Integer> distinctNumbers = list.stream().distinct().toList();
```

-   **Verdict:** Good for readability. Internally uses a HashSet.
### Optimized Alternative (Constructor)
```java

List<Integer> distinctNumbers = new ArrayList<>(new LinkedHashSet<>(list));

```

-   **Why:** Avoids the overhead of the Stream pipeline and lambda execution if no further processing is needed. `LinkedHashSet` preserves the original insertion order.
    

----------

## 2. Get Unique Numbers (Occur Exactly Once)

_Goal: Filter out any number that appeared more than once._

### Current Approach (Grouping)

```
List<Integer> uniqueNumbers = list.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .filter(entry -> entry.getValue() == 1)
    .map(Map.Entry::getKey)
    .toList();

```

-   **Verdict:** Resource heavy. It creates a `Map` entry for every single item and counts occurrences even for items that are clearly duplicates early on.
    

### Optimized Alternative (Two-Set Pass)


```
Set<Integer> all = new HashSet<>();
Set<Integer> duplicates = new HashSet<>();

for (Integer n : list) {
    if (!all.add(n)) { // If add returns false, it's a duplicate
        duplicates.add(n);
    }
}
all.removeAll(duplicates); // What remains are items seen exactly once

```

-   **Why:** Much faster for large datasets. It avoids the "boxing" overhead of `Collectors.counting()` and stops tracking duplicates once identified.
    

----------

## 3. Get Duplicate Numbers

Goal: List only the numbers that appeared more than once._

### Current Approach (Grouping)


```
List<Integer> duplicateNumbers = list.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .filter(entry -> entry.getValue() > 1)
    .map(Map.Entry::getKey)
    .toList();

```

### Optimized Alternative (Filter with Set)



```
Set<Integer> seen = new HashSet<>();
List<Integer> duplicates = list.stream()
    .filter(n -> !seen.add(n)) // If add returns false, it's a duplicate
    .distinct()                // Ensure we don't list the same duplicate twice
    .toList();

```

-   **Why:** High performance. It identifies duplicates in a single pass without needing to count how many times they appear.
    
----------

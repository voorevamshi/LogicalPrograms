# 🚀 Java 8+ Streams & Collectors Cheat Sheet

## 1. Stream Basics

A **Stream** (Interface ) is a sequence of elements supporting functional-style operations. It does not store data; it operates on the source (Collection, Array, etc.).
-   **Internal logic:** `public interface Stream<T> extends BaseStream<T, Stream<T>>`
-   **Common Source Example:**

  ```java
  String input = "153";
  List<Integer> intList = input.chars()             // IntStream [49, 53, 51]
                               .mapToObj(c -> c - '0') // Numeric [1, 5, 3]
                               .toList();              // List<Integer>
 ```

## 1. Stream Transformation (Mapping)
Methods used to transform or flatten stream elements.

| Method | Argument Type | Returns | Description |
| :--- | :--- | :--- | :--- |
| **mapToObj** | `IntFunction<R>` | `Stream<R>` | Converts primitives to Objects. |
| **mapToInt** | `ToIntFunction<T>` | `IntStream` | Converts Objects to primitive `int`. |
| **mapToDouble**| `ToDoubleFunction<T>`| `DoubleStream`| Converts Objects to primitive `double`. |
| **flatMap** | `Function<T, Stream>`| `Stream<R>` | Flattens nested collections. |
| **skip(n)** | `long` | `Stream<T>` | Discards the first `n` elements. |

---

## 2. Collectors Utility Methods
Terminal operations used within `.collect()` to produce a final result.

| Method | Output Type | Description |
| :--- | :--- | :--- |
| **toList()** | `List<T>` | Collects elements into a List. |
| **toSet()** | `Set<T>` | Collects unique elements into a Set. |
| **joining()** | `String` | Concatenates with delimiter, prefix, suffix. |
| **counting()** | `Long` | Returns the count of elements. |
| **groupingBy** | `Map<K, List<T>>` | Groups elements by a classifier key. |
| **partitioningBy**| `Map<Boolean, List<T>>`| Splits data into two groups based on a predicate. |
| **summarizingInt** | `IntSummaryStats` | Returns (count, sum, min, average, max). |

---

## 3. Advanced Collector Logic

### toMap Variations
1. **2-Args:** `toMap(keyMapper, valueMapper)` - Throws exception on duplicate keys.
2. **3-Args:** `toMap(key, val, mergeFunction)` - `(v1, v2) -> v1` (keeps first on duplicate).
3. **4-Args:** `toMap(key, val, merge, supplier)` - e.g., `TreeMap::new`.

### collectingAndThen
Transforms a result immediately after collection.
```java
List<String> immutable = list.stream()
    .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
```

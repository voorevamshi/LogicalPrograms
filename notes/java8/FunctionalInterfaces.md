## Functional Interface
Functional Interface is just an interface with exactly one abstract method (often called a SAM—Single Abstract Method).

In the world of Streams, there are four "heavy hitters" you'll use constantly.

----------

### Comparison of Java 8 Functional Interfaces

| Interface | Inputs | Return Type | Lambda Syntax | Abstract Method |
| :--- | :--- | :--- | :--- | :--- |
| **Predicate** | 1 | `boolean` | `t -> true/false` | `test(T t)` |
| **BiPredicate** | 2 | `boolean` | `(t, u) -> true/false` | `test(T t, U u)` |
| **Function** | 1 | `R` | `t -> r` | `apply(T t)` |
| **BiFunction** | 2 | `R` | `(t, u) -> r` | `apply(T t, U u)` |
| **Consumer** | 1 | `void` | `t -> { }` | `accept(T t)` |
| **BiConsumer** | 2 | `void` | `(t, u) -> { }` | `accept(T t, U u)` |
| **Supplier** | 0 | `T` | `() -> t` | `get()` |
| **UnaryOperator**| 1 | `T` | `t -> t` | `apply(T t)` |
| **BinaryOperator**| 2 | `T` | `(t1, t2) -> t` | `apply(T t1, T t2)` |



## 1. Predicate<T>

The **Predicate** is your filter. It takes one input and returns a `boolean`.

-   **Abstract Method:** `boolean test(T t)`
    
-   **Stream Usage:** Typically used inside `.filter()`.
    

Java

```
// Check if a number is even
Predicate<Integer> isEven = n -> n % 2 == 0;

```

## 2. Function<T, R>

The **Function** is your transformer. It takes one input (type T) and produces an output (type R).

-   **Abstract Method:** `R apply(T t)`
    
-   **Stream Usage:** Typically used inside `.map()`.
    

Java

```
// Convert a String to its length
Function<String, Integer> stringLength = s -> s.length();

```

## 3. Consumer<T>

The **Consumer** is the end of the line (or a side-effect). It takes an input but returns nothing (`void`).

-   **Abstract Method:** `void accept(T t)`
    
-   **Stream Usage:** Typically used inside `.forEach()`.
    

Java

```
// Print a value to the console
Consumer<String> printer = s -> System.out.println(s);

```

## 4. Supplier<T>

The **Supplier** is the "factory." It takes no input but produces a result.

-   **Abstract Method:** `T get()`
    
-   **Stream Usage:** Often used in `.orElseGet()` or generating a stream via `Stream.generate()`.
    

Java

```
// Supply a random double
Supplier<Double> randomVal = () -> Math.random();

```

## 5. BiPredicate<T, U>

This takes two objects (possibly of different types) and returns a `boolean`.

-   **Abstract Method:** `boolean test(T t, U u)`
    
-   **Common Use:** Comparing two values or checking a value against a condition and a threshold.
    

Java

```
// Check if a string's length is greater than a specific limit
BiPredicate<String, Integer> isLongerThan = (str, limit) -> str.length() > limit;

System.out.println(isLongerThan.test("Gemini", 3)); // true

```

## 6. BiFunction<T, U, R>

This takes two inputs and produces one result. This is incredibly common when combining data.

-   **Abstract Method:** `R apply(T t, U u)`
    
-   **Stream Usage:** Often used in `.reduce()` operations.
    

Java

```
// Combine two strings with a hyphen
BiFunction<String, String, String> joiner = (s1, s2) -> s1 + "-" + s2;

System.out.println(joiner.apply("Java", "8")); // "Java-8"

```

## 7. BiConsumer<T, U>

This takes two inputs and returns nothing. You see this everywhere when working with **Maps**.

-   **Abstract Method:** `void accept(T t, U u)`
    
-   **Usage:** Iterating over a `Map` using `.forEach()`.
    

Java

```
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");

// BiConsumer used here: (key, value)
map.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

```

----------

### Putting it all Together: A Practical Example

Here is how these four work in harmony within a standard Stream pipeline:

Java

```
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream()
            .filter(name -> name.startsWith("A"))       // Predicate: keeps only "Alice"
            .map(name -> name.toUpperCase())            // Function: turns "Alice" to "ALICE"
            .forEach(name -> System.out.println(name)); // Consumer: prints "ALICE"
    }
}
```

# Java Optional Reference Guide

## 1. Overview

`Optional` is a **class** (not an interface). It supports functional programming by using functional interfaces internally. This design helps us write null-safe, readable, and concise code.

----------

## 2. Common Methods

### Static Methods (Creation)

-   `static <T> Optional<T> empty()`: Returns an empty `Optional` instance.
    
-   `static <T> Optional<T> of(T value)`: Returns an `Optional` with the specified present non-null value.
    
-   `static <T> Optional<T> ofNullable(T value)`: Returns an `Optional` describing the specified value, or an empty `Optional` if the value is null.
    

### Instance Methods (Checking & Getting)

-   `boolean isPresent()`: Returns true if there is a value present.
    
-   `boolean isEmpty()`: Returns true if the `Optional` is empty (Since Java 11).
    
-   `T get()`: If a value is present, returns the value; otherwise, throws `NoSuchElementException`.
    
-   `T orElse(T other)`: Returns the value if present, otherwise returns `other`.
    
-   `T orElseGet(Supplier<? extends T> supplier)`: Returns the value if present, otherwise returns the result produced by the supplier.
    
-   `<X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)`: Returns the value, or throws an exception produced by the supplier.
    

### Functional Methods (Transforming & Filtering)

-   `void ifPresent(Consumer<? super T> action)`: If a value is present, performs the given action.
    
-   `void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)`: If a value is present, performs the action; otherwise, performs the empty action (Java 9).
    
-   `Optional<T> filter(Predicate<? super T> predicate)`: If a value is present and matches the predicate, returns the `Optional`; otherwise, returns an empty `Optional`.
    
-   `<U> Optional<U> map(Function<? super T, ? extends U> mapper)`: If a value is present, applies the mapping function to it.
    
-   `<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)`: Similar to `map`, but the mapper returns an `Optional`.



----------

## 3. Practical Examples

### Example 1: Filtering and Mapping a List inside Optional

Java

```
import java.util.*;
import java.util.stream.*;

public class TestOptional {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee("Alice"),
            new Employee("Bob"),
            new Employee("Arun")
        );

        Optional<List<Employee>> optionalEmployees = Optional.ofNullable(list);

        List<Employee> filtered = optionalEmployees
            .filter(l -> !l.isEmpty())
            .map(l -> l.stream()
                       .filter(e -> e.name.startsWith("A"))
                       .collect(Collectors.toList()))
            .orElse(Collections.emptyList());

        filtered.forEach(System.out::println);
    }
}

```

### Example 2: Flattening a List of Optionals

Java

```
List<Optional<String>> list = Arrays.asList(
    Optional.of("A"),
    Optional.empty(),
    Optional.of("B")
);

List<String> filtered = list.stream()
    .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
    .collect(Collectors.toList());

System.out.println(filtered); // Output: [A, B]

```

**Explanation:** `.flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))`

-   `opt` is an `Optional<T>`, and this unwraps the value into a `Stream<T>`.
    
-   Used inside `.flatMap()` to flatten multiple Optionals into a single stream of values.
    
-   **✅ opt.map(Stream::of)**: `map` transforms the value if present; `Stream::of` wraps that value into a Stream.
    

----------

## 4. `orElse` vs `orElseGet` (Performance)

Java

```
System.out.println("Using orElse:");
String result1 = Optional.of("Vamshi").orElse(getDefault());
System.out.println("Result: " + result1);

System.out.println("\nUsing orElseGet:");
String result2 = Optional.of("Vamshi").orElseGet(() -> getDefault());
System.out.println("Result: " + result2);

public static String getDefault() {
    System.out.println("⚙️ getDefault() called");
    return "Default";
}

```

**Output:**

Plaintext

```
Using orElse:
⚙️ getDefault() called
Result: Vamshi

Using orElseGet:
Result: Vamshi

```

**Key Difference:** Even though "Vamshi" was present, `getDefault()` was still called in `orElse()`—this is wasteful. `orElseGet()` is lazy and only executes the supplier if the value is missing.

----------

## 5. Processing Numeric Strings Safely

Java

```
public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "3", "A", "4", "xyz");

        List<Integer> intList = Optional.ofNullable(list1)
            .map(list -> list.stream()
                .filter(Main::isNumeric) // Keep only numeric strings
                .map(Integer::parseInt)
                .collect(Collectors.toList()))
            .orElseGet(ArrayList::new);

        System.out.println(intList); // Output: [1, 3, 4]
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

```

----------

## 6. Flattening Nested Lists with Optional

**Problem:** `Optional.ofNullable(listOfLists).flatMap(listOfList -> ...)`

1.  **Logic Bug:** `.addAll(...)` returns a boolean, not a merged List.
    
2.  **FlatMap Context:** `Optional.flatMap` is for flattening nested Optionals (`Optional<Optional<T>>`), not for Stream flattening.
    

**Correct Implementation:**

Java

```
public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "3", "4");
        List<String> list2 = Arrays.asList("11", "33", "44");
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);

        List<Integer> intList = Optional.ofNullable(listOfLists)
            .map(listOfList -> listOfList.stream()       // Stream<List<String>>
                .flatMap(List::stream)                   // Flatten to Stream<String>
                .map(Integer::parseInt)                  // Convert to Stream<Integer>
                .collect(Collectors.toList()))
            .orElseGet(ArrayList::new);

        System.out.println(intList); // Output: [1, 3, 4, 11, 33, 44]
    }
}

```

----------
### Optional: map vs flatMap

To understand the difference between `map` and `flatMap` in the context of `Optional`, it helps to look at the **Return Type** of the function you are passing into them.

### 1. `Optional.map`

The `map` method is used for simple transformations. You provide a function that takes a value and returns an object. `Optional` then automatically wraps that result into another `Optional`.

-   **Theory:** If the value is present, it applies the function. If the result of that function is `null`, it returns `Optional.empty()`. If the result is a value, it returns `Optional.of(value)`.
    
-   **Problem:** If the function you are using _already_ returns an `Optional`, `map` will wrap it again, resulting in a nested `Optional<Optional<T>>`.
    

### 2. `Optional.flatMap`

The `flatMap` method is used when the transformation function **already returns an Optional**. Instead of wrapping the result again, `flatMap` "flattens" the structure so you end up with a single `Optional<T>`.

-   **Theory:** It is designed to prevent "Optional nesting." It expects the mapper function to return an `Optional` directly and simply returns that result without adding another layer of wrapping.
    

### Comparison Example

Imagine a `Person` class has a method `getAddress()` which returns an `Optional<Address>`, and `Address` has a method `getCity()` which returns `Optional<String>`.

#### Using `map` (The Nesting Problem)

Java

```
Optional<Person> person = Optional.of(new Person());

// This returns Optional<Optional<Address>> - Very hard to use!
Optional<Optional<Address>> nested = person.map(p -> p.getAddress());

```

#### Using `flatMap` (The Solution)

Java

```
// This returns Optional<Address> - Clean and flat!
Optional<Address> address = person.flatMap(p -> p.getAddress());

// You can chain them to drill deep into objects safely:
Optional<String> city = person
    .flatMap(Person::getAddress)
    .flatMap(Address::getCity)
    .orElse("Unknown City");

```


**`map`** is for transformations where the result is a simple value.
- Input: `T -> U`
- Output: `Optional<U>`

**`flatMap`** is for transformations where the result is already an `Optional`.
- Input: `T -> Optional<U>`
- Output: `Optional<U>` (Prevents `Optional<Optional<U>>`)

**Example Chain:**
```java
String city = Optional.of(user)
    .flatMap(User::getAddress)  // Returns Optional<Address>
    .flatMap(Address::getCity)  // Returns Optional<String>
    .orElse("Default City");
```

## Summary of `flatMap` Difference

-   **Stream.flatMap**: Flattens multiple streams (or collections) into a single stream.
    
    -   _Example:_ `[[1, 2], [3, 4]]` becomes `[1, 2, 3, 4]`.
        
-   **Optional.flatMap**: Avoids nested Optionals like `Optional<Optional<T>>`.
    
    -   _Example:_ If you have a method returning an `Optional`, use `flatMap` to keep the result as a flat `Optional<T>`.

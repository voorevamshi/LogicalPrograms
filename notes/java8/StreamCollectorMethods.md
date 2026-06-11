# Java Stream and Collectors Reference

### Stream – Interface
### Collectors – Utility and final Class
##  Stream methods 

-   **Stream<T> mapToObj(IntFunction<R>):** Converts each element of the stream into an object of a different type.
    
    _Ex: `IntStream.of(1, 2, 3).mapToObj(i -> "Number: " + i);`_
    
-   **IntStream mapToInt(ToIntFunction<T>):** Converts each element of the stream into an int value.
    
    _Ex: `Stream.of("1", "2", "3").mapToInt(Integer::parseInt);`_
    
-   **LongStream mapToLong(ToLongFunction<T>):** Converts each element of the stream into a long value.
    
    _Ex: `Stream.of("10000000000", "20000000000").mapToLong(Long::parseLong);`_
    
-   **DoubleStream mapToDouble(ToDoubleFunction<T>):** Converts each element of the stream into a double value.
    
    _Ex: `Stream.of("1.5", "2.5", "3.5").mapToDouble(Double::parseDouble);`_
    
    _(Note: ToDoubleFunction<T> → returns a double value)_
    

**.toList():** Finally, the `toList()` method collects the transformed stream elements into a `List<Integer>`. This results in a list of integers representing the digits in the input string. For example, if input is "153", the resulting `intList` will be `[1, 5, 3]`.

## Collectors methods 

1. **`List<S> toList()`:** Collects the elements into a List.
    *Ex: `Stream.of("A", "B", "C").collect(Collectors.toList());`*
    
2. **`Set<S> toSet()`:** Collects the elements into a Set (removes duplicates).
    *Ex: `Stream.of("A", "B", "A").collect(Collectors.toSet());`*
    
3. **`Map<I, S> toMap()`:** Collects the elements of the stream into a Map using key and value mapping functions.
    *Ex: `Stream.of("A", "BB", "CCC").collect(Collectors.toMap(String::length, s -> s));`*
    
4. **`String joining()`:** Concatenates the elements of the stream into a single String.
    *Ex: `Stream.of("A", "B", "C").collect(Collectors.joining(", "));`*
    
5. **`Map<I, List<S>> groupingBy()`:** Groups the elements by a classifier; returns a Map where keys are the classifier results.
    *Ex: `Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length));`*
    
6. **`Map<B, List<I>> partitioningBy()`:** Partitions the elements of the stream into two groups based on a predicate.
    *Ex: `Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));`*
    
7. **`long counting()`:** Counts the number of elements in the stream.
    *Ex: `Stream.of("A", "B", "C").collect(Collectors.counting());`*
    
8. **`int reducing()`:** Performs a reduction operation on the elements of the stream.
    *Ex: `Stream.of(1, 2, 3).collect(Collectors.reducing(0, Integer::sum));`*
    
9. **`List<I> mapping()`:** Applies a mapping function to the elements before collecting them.
    *Ex: `Stream.of("A", "BB", "CCC").collect(Collectors.mapping(s -> s.length(), Collectors.toList()));`*
    
10. **`IntSummaryStatistics summarizingInt()`:** *Ex: `Stream.of(1, 2, 3).collect(Collectors.summarizingInt(Integer::intValue)).getSum();`*
    
11. **`DoubleSummaryStatistics summarizingDouble()`:** *Ex: `Stream.of(1.5, 2.5, 3.5).collect(Collectors.summarizingDouble(Double::doubleValue)).getAverage();`*
    
12. **`LongSummaryStatistics summarizingLong()`:** *Ex: `Stream.of(1L, 2L, 3L).collect(Collectors.summarizingLong(Long::longValue)).getMax();`* *(Note: Statistics includes count, sum, min, average, max)*
    
13. **`averagingDouble(ToDoubleFunction mapper)`:** *Ex: `employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));`*
    
14. **`collectingAndThen(Collector downstream, Function finisher)`:**

| Argument | Type | Description |
| :--- | :--- | :--- |
| `downstream` | `Collector<T, A, R>` | A collector (like `toList()`, `toSet()`, etc.) |
| `finisher` | `Function<R, RR>` | A function to **transform the collected result** |

*Ex:*
```java
List<String> names = List.of("A", "B", "C");
List<String> unmodifiableList = names.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

Optional<Employee> highestPaid = employees.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get));
```

----------

##  toMap method arguments 

**1) toMap method with two arguments** (Throws exception on duplicate keys)

-   `Function<? super T, ? extends K> keyMapper`
    
-   `Function<? super T, ? extends V> valueMapper`
    
    _Ex: `Map<Integer, String> map1  Stream.of("A", "BB", "CCC").collect(Collectors.toMap(String::length, s -> s));`_
    

**2) toMap method with Three-arguments** (Handles duplicate keys)

-   `Function<? super T, ? extends K> keyMapper`
    
-   `Function<? super T, ? extends V> valueMapper`
    
-   `BinaryOperator<V> mergeFunction`
    
    _Ex: `Map<Integer, String> map2  Stream.of("A", "BB", "CC").collect(Collectors.toMap(String::length, s -> s, (v1, v2) -> v1 + ", " + v2));`_
    

**3) toMap with Four-arguments** (Decide which Map implementation to use)

-   `Function<? super T, ? extends K> keyMapper`
    
-   `Function<? super T, ? extends V> valueMapper`
    
-   `BinaryOperator<V> mergeFunction`
    
-   `Supplier<Map<K, V>> mapSupplier`
    
    _Ex: `Map<Integer, String> map3  Stream.of("A", "DD", "FF","CC","EEE").collect(Collectors.toMap(String::length, Function.identity(), (v1, v2) -> v1, TreeMap::new));`_
    

----------

##  joining method arguments 

-   `Collectors.joining()`
    
-   `Collectors.joining(", ")` --> _delimiter_
    
-   `Collectors.joining(delimiter, prefix, suffix)`
    

----------

##  groupingBy method arguments 

**1) groupingBy Classifier** `groupingBy(Function<? super T, ? extends K> classifier)`

_Ex: `Map<Integer, List<String>> groupMap  Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length));`_

**2) groupingBy Classifier, Downstream Collector** `groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)`

_Ex: `Map<Integer, List<String>> groupMap  Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length, Collectors.toList()));`_

**3) groupingBy Classifier, Supplier<Map>, Downstream Collector** `groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)`

_Ex: `Map<Integer, List<String>> result  Stream.of("a", "bb", "cc").collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));`_

_Common downstream collectors: `counting()`, `summingDouble()`, `averagingDouble()`, `maxBy()`, `minBy()`, `toList()`, `toSet()`_

----------

##  partitioningBy method arguments 

**1) partitioningBy(Predicate predicate)** _Ex: `Map<Boolean, List<Integer>> partitionMap  Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2  0));`_

**2) partitioningBy Predicate, Downstream Collector** _Ex: `Map<Boolean, Long> result  Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2  0, Collectors.counting()));`_

----------

##  reducing method arguments 

1.  **reducing(BinaryOperator<T> op):** _Ex: `Optional<Integer> max  Stream.of(3, 5, 7, 2).collect(Collectors.reducing(Integer::max));`_
    
2.  **reducing(T identity, BinaryOperator<T> op):** _Ex: `int reducedValue  Stream.of(1, 2, 3, 4).collect(Collectors.reducing(0, Integer::sum));`_
    
3.  **reducing(U identity, Function mapper, BinaryOperator<U> op):** _Ex: `double totalSalary  employees.stream().collect(Collectors.reducing(0.0, e -> e.getSalary(), Double::sum));`_
    

----------

##  mapping method arguments 

1.  **mapping(Function mapper, Collector downstream):** _Ex: `List<Integer> mappingList  Stream.of(1, 2, 3, 4).collect(Collectors.mapping(i -> i * 2, Collectors.toList()));`_
    

----------

##  summarizingInt/Long/Double arguments 

-   `public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper)`
    
-   `IntSummaryStatistics stats  Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(i -> i));`
    
-   `summarizingDouble()` is used to collect summary statistics (count, sum, min, max, average) for double values.
    
-   _Ex: `Optional<Double> maxValue  Stream.of(1.0, 2.0, 3.0, 4.0).collect(Collectors.maxBy(Comparator.comparingDouble(i -> i)));`_
    

----------

##  Collectors maxBy/minBy arguments 

-   `public static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator)`
    
-   _Ex: `Optional<Long> minValue  Stream.of(1L, 2L, 3L, 4L).collect(Collectors.minBy(Comparator.naturalOrder()));`_
    
-   _Ex: `Optional<Employee> highest  employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));`_
    

----------

##  Additional Stream methods 

18.  **Optional<Double> max:** Maximum value in a stream of doubles.
    
    _Ex: `Stream.of(1.0, 2.0, 3.0, 4.0).max(Comparator.comparingDouble(i -> i));`_
    
19.  **Optional<Long> min:** Minimum value in a stream of longs.
    
    _Ex: `Stream.of(1L, 2L, 3L, 4L).min(Comparator.naturalOrder());`_
    

-   _Ex: `Optional<Employee> highest  employees.stream().max(Comparator.comparing(Employee::getSalary));`_
    

----------

##  Stream sorted method arguments 

-   **Stream<T> sorted():** Natural ordering (Comparable).
    
    _Ex: `Stream.of(3, 1, 4, 2).sorted().forEach(System.out::print); // Output: 1234`_
    
-   **Stream<T> sorted(Comparator<? super T>):** Custom sorting.
    
    _Ex: `employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());`_
    

----------

##  List sort method arguments 


```
List<String> names  Arrays.asList("Charlie", "Alice", "Bob");
names.sort(Comparator.naturalOrder()); // Natural Order
names.sort(Comparator.comparing(Employee::getSalary)); // Custom Object sorting

```

----------

##  Optional ifPresent & ifPresentOrElse 

-   **void ifPresent(Consumer<? super T> action):** _Ex: `optionalEmp.ifPresent(emp -> System.out.println(emp.getName()));`_
    
-   **void ifPresentOrElse(Consumer action, Runnable emptyAction):** (Java 9)
    
    _Ex: `name.ifPresentOrElse(n -> System.out.println("Name: " + n), () -> System.out.println("Name not available"));`_
    

----------

##  forEach method arguments 

-   **Stream/Collection forEach:** `void forEach(Consumer<? super T> action)`
    
    _Ex: `employees.forEach(emp -> System.out.println(emp.getName()));`_
    
-   **Map forEach:** `void forEach(BiConsumer<? super K, ? super V> action)`
    
    _Ex: `map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));`_
    

----------

##  Other Methods 

-   **skip(long n):** Skip first n elements.
    
    _Ex: `Stream.of("A", "B", "C", "D", "E").skip(2).forEach(System.out::println);`_
    
-   **flatMap:** `<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`
### map() vs flatMap()

| Feature | map(Function<T, R>) | flatMap(Function<T, Stream<R>>) |
| :--- | :--- | :--- |
| **Mapping Logic** | 1-to-1 (One input -> One output) | 1-to-Many (One input -> Multiple outputs) |
| **Output Type** | `Stream<R>` | `Stream<R>` (Flattened) |
| **Structure** | Preserves original structure | "Flattens" nested structures |
| **Analogy** | Like changing the color of every ball in a box. | Like opening several small boxes and pouring all contents into one big box. |

#### Usage Examples
 
- **map** transforms each element into exactly one other element, **map():** `stream.map(String::toUpperCase)` — Transforms `"hello"` to `"HELLO"`

- **flatMap** transforms each element into a stream of elements and then "flattens" those streams into a single combined stream.**flatMap():** `stream.flatMap(list -> list.stream())` — Transforms `[[1,2], [3,4]]` to `[1, 2, 3, 4]`.
```

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(
            new Post("Java Basics", Arrays.asList("java", "programming")),
            new Post("Stream API", Arrays.asList("java", "streams", "functional")),
            new Post("React Intro", Arrays.asList("js", "react"))
        );

        // Using flatMap to "drill down" into the tags list
        List<String> allTags = posts.stream()
            .flatMap(post -> post.getTags().stream()) // Converts 1 Post to a Stream of Tags
            .map(String::toUpperCase)                // Optional: transform tags
            .distinct()                               // Remove duplicates
            .collect(Collectors.toList());

        System.out.println(allTags); 
        // Output: [JAVA, PROGRAMMING, STREAMS, FUNCTIONAL, JS, REACT]
    }
}

class Post {
    String title;
    List<String> tags;
    Post(String title, List<String> tags) { this.title = title; this.tags = tags; }
    List<String> getTags() { return tags; }
}
```


| Method | Description | Example Snippet |
| :--- | :--- | :--- |
| **comparing** | Sorts by a specific object field | `Comparator.comparing(Employee::getName)` |
| **comparingInt** | Optimized for primitive `int` | `Comparator.comparingInt(Employee::getId)` |
| **comparingDouble**| Optimized for primitive `double` | `Comparator.comparingDouble(Employee::getSalary)` |
| **comparingLong** | Optimized for primitive `long` | `Comparator.comparingLong(Employee::getAge)` |
| **naturalOrder** | Uses `Comparable` implementation | `Comparator.naturalOrder()` |
| **reverseOrder** | Reverses `Comparable` logic | `Comparator.reverseOrder()` |
| **nullsFirst** | Puts `null` elements at the start | `Comparator.nullsFirst(Comparator.naturalOrder())` |
| **nullsLast** | Puts `null` elements at the end | `Comparator.nullsLast(Comparator.naturalOrder())` |
| **thenComparing** | Multi-level (secondary) sorting | `comp.thenComparing(Employee::getAge)` |
| **reversed** | Inverts the current comparator | `comp.reversed()` |


### 1. BinaryOperator Methods

A `BinaryOperator<T>` is a specialization of `BiFunction<T, T, T>`. While `apply(T t1, T t2)` is the functional method you implement, the interface also provides two very useful static methods for finding extremes:

#### **static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)**
Returns a `BinaryOperator` which returns the lesser of two elements according to the specified `Comparator`.


```
BinaryOperator<Employee> cheaperEmp = BinaryOperator.minBy(Comparator.comparing(Employee::getSalary));
```

#### **static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)**
Returns a `BinaryOperator` which returns the greater of two elements according to the specified `Comparator`.

```
BinaryOperator<Employee> richerEmp = BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary));
```

----------

### 2. Key Logic Reminder (The "Subtraction" Rule)

When overriding `compare(T o1, T o2)` or `o1.compareTo(o2)`, remember the result logic:
-   **Negative Value:** `o1` is "smaller" than `o2` (comes first).
-   **Zero:** They are "equal" in terms of sorting.
-   **Positive Value:** `o1` is "larger" than `o2` (comes second).
    

> **Pro-Tip:** Avoid manually subtracting integers (e.g., `o1.id - o2.id`) because of potential **integer overflow** issues. Always use `Integer.compare(o1.id, o2.id)` or the `comparingInt` method.

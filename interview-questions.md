# 🧩 INTERVIEW QUESTIONS – COMPANY-WISE

---

## Netcracker
public ErrorInfo(String code, Integer priority)  
List<ErrorInfo> errorsConfiguration = Arrays.asList( new ErrorInfo("E-1334", 4), new ErrorInfo("E-7264", 2), new ErrorInfo("E-7264", 2), new ErrorInfo("E-2234", 1), new ErrorInfo("E-9134", 3), new ErrorInfo("E-7834", 5) );  
List<String> errorsFromServer = Arrays.asList("E-7834", "E-7264", "S-3364");  
Identifying the highest priority error received from the server  
Saga design pattern, Circuit design pattern  
How to handle exceptions  
Explain transaction  
Java 17 features and what is sealed class  

## Sutherland 2
What are OOPS concepts?  
Kafka you have worked on right, what is Kafka?  
Singleton design pattern?  
AWS Lambda  
Roles and responsibilities  
Spring AOP for monitoring, Spring connecting database? What is lazy loading in Hibernate  
Difference between HashMap and HashSet?  

## Mphish
String name = "vamshi" print even index and combine them output "vmh" using Java 8 streams  
Java 17 features  
Java 8 features. Can we use functional interfaces without lambda?  
Does Set allow null values?  

## Sutherland 1
SOLID principles  
ACID principles  
Other than Propagation REQUIRED anything you have used?  
Save flush after if the exception comes will data save in DB  
Isolation rules  
Design patterns  
How Spring Boot Auto Configuration works? Did you look into the Auto Configuration classes?  
Can the stack be stretched? Can Heap be stretched? If exceeds both sizes what are the errors you will get?  
Stack is which data structure?  
How is the HIKARI pool created in Spring as its starter project?  
Can we create multiple RestTemplates, one with 1 minute response time, another with 2 minute response time?  
When to use LinkedList, ArrayList. Do you have idea on Queue, Stack  
Runnable vs Callable  
AWS S3 service how you connect from application & what is RDS  
Eureka vs Kubernetes  
What are the things we can do with Spring Cloud Gateway?  
RestTemplate vs GraphQL  
DOM related question  
Explain AOP where you have used in your project  

## Principal Global Services – Round 1
Design ecommerce application used by 10 lakh users  
The department has a list of employees in each department. I need the second highest salary. If any department has only 1 employee that department I don’t need  
Same department wise second highest salary using database query  

## Principal Global Services – Round 2
Explain project and what are the challenging tasks you worked on  
Explain which production defect you faced difficulty for (example: batch job took cached data)  
Is it that the batch needs to pick current time -5 min is it correct? Have you discussed it with the architecture team?  
Design discussions happen with the architecture team. If yes what you will discuss  
If you become team lead, what metrics improved your team will show?  

## Candescent
Design code for YouTube views 5 billion you want to track  
In a transaction I have get, delete, update how to maintain without stale data (take example of reset function)  
How are you doing security if your token expires every 24 hours?  
How do you trace when you have multiple microservices?  
How you will do code review. You will not clone the code and check, right?  

## **Experian**

- How to solve circular dependency  
- Write `@Async` configuration — can we use it with private/protected methods?  
- WAP for S3 storage: upload 100MB PDF (split into 10MB chunks as S3 allows max 10MB). Combine chunks to retrieve 100MB.  
- How will you upload multiple files in your project?  
- With multiple instances, how do you send acknowledgements from SQS?  
- SQS message fails during processing — how to handle it?  
- WAP for Circuit Design Pattern.  
- What microservice design patterns do you know?  
- Write logic for PAN card validation and test cases.  
- Exception handling in Spring.  
- How do you maintain state (Approve, Deny, Partial) in your project?  
- In EKS, how are configurations written?  
- Have you written any alerts in your project?  
- If the app is up but logs aren’t printing, how do you debug?  

---

## **Mphasis**

### Round 1
- Input: `1,2,0,3,0,4,0,5` → Output: `1,2,3,4,5,0,0,0`  
- Explain OOPs concepts.  
- Difference between `Iterator` and `ListIterator`.  
- Difference between S3 and Lambda.  
- SQS message failure handling.  

### Round 2
- Unique numbers → Input: `2,3,2,5,6,7,4,7,4,8` → Output: `3,5,6`  
- What is offset in Kafka?  
- Write a program for S3.  
- Difference between `@Primary` and `@Qualifier`.  
- Difference between `equals()` and `hashCode()` — where are they used?  
- `String name="hello"; name="h r u";` → Output?  

---

## **EPAM**

### Round 1
- How to give privilege to S3 storage?  
- Restrict S3 access to specific users.  
- What is visibility timeout in SQS?  
- Can multiple consumers read same SQS message?  
- What is EC2?  

### Round 2
- What is OAuth2 Authorization?  
- Login via Google/Facebook/GitHub — how?  
- CSRF token in web app.  
- If consumer app is down, how to handle?  
- How to read custom property values without `@Value`?  
- How to create custom annotation?  
- Advantages of Spring Boot over Spring.  
- Can Spring Boot app (with embedded Tomcat) be deployed on JBoss/Tomcat?  
- Difference between Spring Boot 2.8 before/after.  
- Same Kafka message — multiple consumer groups — how?  
- Docker & ECS — explain.  
- Why String is immutable?  
- `A` is child, `B` is parent → `A a = new B();` valid?  
- Circuit design, rate limiter coding, DB performance tuning.  

---

## **ADP**

- Department-wise top 3 salaries.  
- Department address list, city-wise employee count.  
- Design Order Service — explain APIs.  
- Time complexity of nested loops.  

### ADP 2
- Tell me about project & team.  
- Challenging tasks faced.  
- Stage works, prod fails with `ClassNotFound` — why?  
- `OutOfMemory` error — how to handle?  
- Which data structure preserves insertion order & unique data?  
- JVM memory areas & class loaders.  
- Process vs thread.  
- Deadlock — how to overcome?  
- Design: SBI card with multiple card types across countries, export by area.  
- What is API Gateway?  
- Load balancers used?  

---

## **JP Morgan**

- Input: `{"getCurrency","getAccountName","getLongAccountName","getSWIFTCode","getTraceID"}`  
  → Output: `{"Currency","Account_Name","Long_Account_Name","SWIFT_Code","Trace_ID"}`  
- Kafka scaling — from 1K to 1L msgs — what to consider?  
- Which API Gateway are you using?  

---

## **Lloyds**

- How to ensure Kafka message sent only once?  
- Multiple messages arriving — how to consume?  
- Map input `{vamshi:32, chandu:32, ajay:30}` → Output `{32:"vamshi,chandu",30:"ajay"}`  
- Microservice design patterns used.  
- Which API Gateway design pattern used?  
- Can DB ops be in service layer (SOLID violation)?  
- How to improve app performance?  
- Mono & Flux in WebClient.  

---

## **LTI Mindtree**

### Round 1
- What is Record class? Sealed class?  
- What is var in Java?  
- Prime number program.  
- Lambda for functional interface sum method.  
- PUT vs OPTIONS difference.  
- `@Component` vs `@Service`.  

### Round 2
- `"aabbbbddc"` → longest repeated string.  
- Why use `throws` if try-catch already used?  
- Refund API for 6B transactions — design code.  
- Kafka message delivery confirmation.  

### Round 3
- Multiple microservices updating same DB — sync data?  
- Multiple worker threads — WAP.  
- Application performance improvement.  
- Singleton pattern.  
- Comparator by department name/salary (desc).  
- Binary tree check.  

### Round 4
- `"AABBCDE"` → find first non-repeated character.  
- Memory improvements in Java 8.  

---

## **Evernote**

- Roles, responsibilities, project details.  
- AWS services used.  
- WAP: Connect to S3.  
- `"Hi How are you"` → `"iH woH era uoy"`.  
- Spring design patterns known.  
- Git commands.  
- Why use `@Qualifier`?  
- Experience with CI/CD, Kubernetes, Docker.  
- Where to use Singleton

## **Swiss Re**

- Spring annotations.  
- Optional class methods.  
- Remove duplicates using recursion (Java 8).  
- Gender-based employee list.  
- Input `{0,1,2,9,0,3}` → Output `{1,2,3,9,0,0}`  
- Read YAML properties.  
- Singleton creation, reflection issue.  
- Microservices communication (API security).  
- Git commands.  
- Custom exception class.  
- Remove employee by name.  
- Enum limitations.  
- Factory class with example.  
- JVM architecture (where static objects stored).  
- Types of DI.  

### Swiss Re 2
- Sentences list → word grouping by length.  
- Second highest salary.  
- DB optimization, indexes, views, materialized view.  
- Application architecture & load balancing.  

---

## **Nettracker**

- Create Singleton & Immutable class.  
- Reflection API.  
- Remove duplicates from huge number string.  
- Error class priority logic.  
- Example where AI tools used.  

---

## **Iventy**

- Project architecture.  
- Authorization techniques (access/refresh tokens).  

---

## **ArcelorMittal**

- List max element (if empty → emptyList).  
- Map of userId & userName.  
- Arrow & bind in JS.  
- Message failure tracking (Kafka/Queue).  
- Disaster management.  

---

## **Critical River**

- Microservice architecture.  
- Service registry.  
- Design patterns used (Gateway, Circuit).  
- Exception handling.  
- Java 17 features.  
- Multi-storage design (S3, SharePoint, Azure).  
- API Gateway, security, authentication, DB connection.  

---

## **Harish Questions**

- Dept-wise employee list, count, highest, second highest salary.  
- Dept with most employees → `map.entrySet().stream().max(...)`  
- Gender-based avg salary (Hyd, salary>10k).  
- Sort list by id/name dynamically.  
- Common employees between lists (Hyd, salary>10k).  
- First non-repeated number.  
- Capitalize first letter of first word.  
- Find 2nd max from array (no predefined methods).  
- Merge two sorted arrays.  
- Retrieve Telangana employees.  
- Common elements (O(n log n) approach).  
- Group employees by dept, find highest salary.  
- Gender-based avg salary using streams.  
- `ClassCastException` example (`B b1=(B)new A()` fails).  

### SQL Queries
- Count employees dept-wise.  
- Max salary dept-wise.  

---

## **IBM (9th Aug 2024)**

- Immutable Employee with mutable Address.  
- Print even/odd in single loop (large list).  
- Connect two DBs in microservice (MySQL + Oracle/MongoDB).  
- Handle transactions across microservices (Saga).  
- Microservice design patterns: Gateway, Saga, Circuit Breaker, Aggregator.  
- Find duplicates using Java 8.  
- Find Kth largest element.  
- Implement Queue using Stack.  

---

## **TCS**

- Filter employees whose city starts with “P”.  
- Shallow vs deep cloning.  
- Volatile vs transient.  
- Identify valid lambda expressions.  
- Global exception handling.  
- DB config removed — use externalization.  
- Lazy bean loading.  
- Client-specific implementation.  
- Remove duplicate logic across classes.  
- Project architecture explanation.  

---

## **Deloitte (28-May-2024)**

- Remove 2 from list `[1,2,2,3,2,3]`.  
- List of lists → employees with salary > 10,000.  
- Difference between `call()` and `run()`.  
- Idempotent vs non-idempotent.  
- Vowel substring problem (“aaeiouxa”).  

---

## **Infosys (26-May-2024)**

- Java Stream API: find avg salary (before 2010, by dept, >60k).  
- `map()` vs `flatMap()`.  
- SAML Authentication.  
- Design patterns used.  
- Stateless vs stateful services.  
- Spring Reactive approach.  
- Multi-service failure (B fails).  
- Create deadlock.  

---

## **GlobalLogic (11-May-2024)**

- Decomposition, visitor, circuit patterns.  
- Rollback between order & inventory microservices.  
- Distributed transaction across banks.  
- CompletableFuture, Atomic vars, CountDownLatch.  
- Memory & hash changes in Java 8.  

---

## **Other Common Topics**

- `@Controller` vs `@RestController`.  
- Spring MVC Architecture.  
- Swagger usage.  
- Microservice Security.  
- Stream API operators.  
- String vs StringBuilder vs StringBuffer.  
- `ConcurrentModificationException`.  
- Optional class.  
- DB optimization (indexes, joins, etc.).  
- Spring Actuator, Eureka, SOA vs Microservice.  
- SOLID Principles, Object creation ways, Exception handling.  

---

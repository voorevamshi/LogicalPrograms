# 🧩 INTERVIEW QUESTIONS – COMPANY-WISE

---

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

- Input: `{"getCurrency","getAccountName","getLongAccountName"}`  
  → Output: `{"Currency","Account_Name","Long_Account_Name"}`  
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

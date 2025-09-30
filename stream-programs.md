<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/5a4c9424-2e3e-4e32-8eb3-f9fda37c07dc" /># Employee Management – Java 8 Stream Examples

This repository demonstrates interview-style coding questions using **Java 8 Streams and Collectors** on `Employee`, `Department`, and `Address` classes.

## 📌 Class Structure

public class Employee {
    private Department department;
    private List<Address> address;
}

# Logical Programs on Employee Data

## Department Based Programs
- **getDepartmentWiseListOfEmployee** → Get list of employees grouped by department.
- **getDepartmentWiseCountOfEmployees** → Get count of employees in each department.
- **getDepartmentWiseEmployeeHighestSalary** → Find highest salary employee in each department.
- **getDepartmentWiseEmployeeSecondHighestSalary** → Find second highest salary employee in each department.
- **Department wise top 3 highest salary employees** → Get top 3 employees with highest salaries from each department.
- **DepartmentAddressList** → Get list of addresses grouped by department.

## Analytical Programs
- **Which department has highest count of employees**  
- **Which department has more employees** → Compare departments based on employee count.
- **Gender based average salary whose stay in Hyderabad and salary above 10,000** → Calculate gender-based average salaries with filters.
- **City wise count of employees** → Get count of employees grouped by city.

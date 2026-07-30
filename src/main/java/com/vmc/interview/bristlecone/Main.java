package com.vmc.interview.bristlecone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList=new ArrayList<>();

        empList.add(new Employee(1,"vamshi",32,1000.0,"IT"));
        empList.add(new Employee(3,"ajay",31,3000.0,"HR"));
        empList.add(new Employee(4,"ramesh",35,5000.0,"IT"));
        empList.add(new Employee(4,"suresh",38,7000.0,"HR"));
        Map<String, Double> map=   empList.stream()
                .filter(emp->emp.getEmpAge()>30)
                .collect(Collectors.groupingBy(Employee::getDeptName,   Collectors.averagingDouble(Employee::getSal)
                 //Option:1       Collectors.averagingDouble(Employee::getSal)
                 //Option:2       Collectors.mapping(employee -> employee,Collectors.averagingDouble(Employee::getSal))
                 //Option:3     Collectors.toList(), list->list.stream().mapToDouble(Employee::getSal).average().orElse(0.0))
                        )
                );
        System.out.println(map);
    }

}

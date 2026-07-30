package com.vmc.interview.bristlecone;

public class Employee {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private double sal;
    private String deptName;

    public Employee(Integer empId, String empName, Integer empAge, double sal, String deptName) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.sal = sal;
        this.deptName = deptName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", sal=" + sal +
                ", deptName='" + deptName + '\'' +
                '}';
    }



}

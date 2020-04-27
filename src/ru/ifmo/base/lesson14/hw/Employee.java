package ru.ifmo.base.lesson14.hw;

import ru.ifmo.base.lesson14.hw.car.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int) (Math.random() * names.length)], companies[(int) (Math.random() * companies.length)], (int) (Math.random() * 1000 + 1000), (int) (Math.random() * 60 + 21)));
        }
        return employees;
    }


    public static void main(String[] args) {
        // Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании
        List<Employee> employees = employeeGenerator(5);
        Comparator<Employee> nameComparator = new EmployeeNameComparator();
        Comparator<Employee> nameSalaryComparator = nameComparator.thenComparing(new EmployeeSalaryComparator());
        Comparator<Employee> nameSalaryAgeCompanyComparator = nameSalaryComparator.thenComparing(new EmployeeAgeComparator()).thenComparing(new EmployeeCompanyComparator());

        System.out.println("No sort " + employees);

        employees.sort(nameComparator);
        System.out.println("Name sort " + employees);

        employees.sort(nameSalaryComparator);
        System.out.println("Name and Salary sort " + employees);

        employees.sort(nameSalaryAgeCompanyComparator);
        System.out.println("Name, Salary, Age and Company sort " + employees);
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class EmployeeCompanyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}


package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {
    String name;
    List<Employee> employees;
    HashMap<Employee, Manager> employeeManagement;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
        employeeManagement = new HashMap<>();
    }

    public int size() {
        return employees.size();
    }

    public void hire(Employee e) {
        employees.add(e);
    }

    public void fire(Employee e) {
        employees.remove(e);
    }

    public void printEmployees() {
        System.out.printf("The company %s employs:\n", name);
        for (Employee e : employees) {
            System.out.printf("- %s %s\n", e.getFirstName(), e.getLastName());
        }
    }

    public boolean addEmployeeManagement(Employee e, Manager m) {
        boolean err = false;

        if (!employees.contains(e)) {
            System.out.printf("%s %s is not employed by %s.\n", e.getFirstName(), e.getLastName(), name);
            err = true;
        }

        if (!employees.contains(m)) {
            System.out.printf("%s %s is not employed by %s.\n", m.getFirstName(), m.getLastName(), name);
            err = true;
        }

        if (err) return false;

        System.out.printf("%s %s %s\n", e.getFirstName(), e.getLastName(), !employeeManagement.containsKey(e) ? "now " +
                "now has a manager." : "has a new manager.");

        employeeManagement.put(e, m);

        return true;
    }

    public void printManager(Employee e) {
        if (employeeManagement.containsKey(e)) {
            Manager m = employeeManagement.get(e);
            System.out.printf("%s %s manages %s %s.", m.getFirstName(), m.getLastName(), e.getFirstName(),
                    e.getLastName());
        } else {
            System.out.printf("%s %s is managed by nobody.", e.getFirstName(), e.getLastName());
        }
    }
}

package fr.epita.assistants.mycompany;

public abstract class Employee {
    private String firstName;
    private String lastName;

    public Employee(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + ' ' + lastName;
    }
}

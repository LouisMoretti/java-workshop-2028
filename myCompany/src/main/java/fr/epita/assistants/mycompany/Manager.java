package fr.epita.assistants.mycompany;

public class Manager extends Employee{
    public Manager(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.printf("%s %s is a manager.", super.getFirstName(), super.getLastName());
    }
}

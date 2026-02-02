package fr.epita.assistants.mycompany;

public class Secretary extends Employee{
    public Secretary(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.printf("%s %s is a secretary.", super.getFirstName(), super.getLastName());
    }
}

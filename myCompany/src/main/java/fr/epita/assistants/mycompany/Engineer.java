package fr.epita.assistants.mycompany;

public class Engineer extends Employee{
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.printf("%s %s is an engineer.\n", super.getFirstName(), super.getLastName());
    }
}

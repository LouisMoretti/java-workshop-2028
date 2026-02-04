package fr.epita.assistants.mycompany;

public class Engineer extends Employee implements Assignable {
    public Engineer(String lastName, String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void sayMyJob() {
        System.out.printf("%s %s is an engineer.\n", super.getFirstName(), super.getLastName());
    }

    String project;

    @Override
    public void addProject(String project) {
        this.project = project;
    }

    @Override
    public boolean isAssignedToProject(String project) {
        return project.equals(this.project);
    }

    @Override
    public void listProjects() {
        if (project != null)
            System.out.printf("%s %s's current project is %s.\n", super.getFirstName(), super.getLastName(), project);
    }
}

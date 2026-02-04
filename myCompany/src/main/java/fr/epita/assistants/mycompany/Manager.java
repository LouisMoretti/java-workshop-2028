package fr.epita.assistants.mycompany;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee implements Assignable {
    public Manager(String lastName, String firstName) {
        super(lastName, firstName);
        projects = new HashSet<>();
    }

    @Override
    public void sayMyJob() {
        System.out.printf("%s %s is a manager.\n", super.getFirstName(), super.getLastName());
    }

    Set<String> projects;

    @Override
    public void addProject(String project) {
        projects.add(project);
    }

    @Override
    public boolean isAssignedToProject(String project) {
        return projects.contains(project);
    }

    @Override
    public void listProjects() {
        if (!projects.isEmpty()) {
            System.out.printf("%s %s's current projects are:\n", super.getFirstName(), super.getLastName());
            for (String project : projects)
                System.out.printf("- %s\n", project);
        }
    }
}

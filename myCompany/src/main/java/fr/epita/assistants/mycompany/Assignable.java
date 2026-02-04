package fr.epita.assistants.mycompany;

public interface Assignable {
    void addProject(String project);

    boolean isAssignedToProject(String project);

    void listProjects();
}

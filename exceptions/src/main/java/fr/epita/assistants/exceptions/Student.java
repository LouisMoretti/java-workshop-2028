package fr.epita.assistants.exceptions;

public class Student {
    String name;
    int age;
    String major;

    String[] majorsLUT = {"3SE", "BUILDSEC", "GISTRE", "GITM", "IF", "IMAGE", "MTI", "QUANTUM", "SANTE", "SCIA", "SCIA-G", "SIGL", "SRS", "SRSI", "TCOM"};

    public Student(String name, int age, String major) throws
            InvalidNameException, InvalidAgeException, InvalidMajorException {
        if (name.matches(".*[0-9].*"))
            throw new InvalidNameException(name);

        if (age <= 0 || age >= 130)
            throw new InvalidAgeException(age);

        major = major.toUpperCase();

        for (String majorLUT : majorsLUT)
//            if (majorLUT.compareTo(major) == 0)
            if (majorLUT == major)
                throw new InvalidMajorException(major);

        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}

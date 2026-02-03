package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    public Triangle(int length) {
        super(length);
    }

    @Override
    public void draw() {
        if (length <= 0)
            return;

        for (int i = 0; i < length - 1; i++) {
            if (i > 0) {
                System.out.print("# ");
                for (int j = 0; j < i - 1; j++) {
                    System.out.print("  ");
                }
            }
            System.out.print("#\n");
        }

        for (int i = 0; i < length; i++) {
            System.out.print("# ");
        }
        System.out.print("\n");
    }
}

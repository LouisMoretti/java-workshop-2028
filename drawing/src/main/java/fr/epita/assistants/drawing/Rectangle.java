package fr.epita.assistants.drawing;

public class Rectangle extends Sharp {
    int width;

    public Rectangle(int width, int length) {
        super(length);
        this.width = width;
    }

    @Override
    public void draw() {
        if (length <= 0 || width <= 0)
            return;

        for (int i = 0; i < width; i++) {
            System.out.print("# ");
        }
        System.out.print("\n");

        for (int i = 1; i < length - 1; i++) {
            System.out.print("# ");
            for (int j = 0; j < width - 2; j++) {
                System.out.print("  ");
            }
            System.out.print("#\n");
        }

        if (length > 1) {
            for (int i = 0; i < width; i++) {
                System.out.print("# ");
            }
            System.out.print("\n");
        }
    }
}

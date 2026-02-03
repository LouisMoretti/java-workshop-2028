package fr.epita.assistants.drawing;

import static java.lang.Math.abs;

public class Circle extends Entity {
    int radius;

    public Circle(int length) {
        this.radius = length;
    }

    @Override
    public void draw() {
        for (int y = -radius; y < radius + 1; y++) {
            for (int x = -radius; x < radius + 1; x++) {
                int sqDist = abs(radius * radius - (x * x + y * y));

                if (sqDist < radius) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }

//                if (x < radius) {
//
//                }
            }
            System.out.print("\n");
        }
    }
}

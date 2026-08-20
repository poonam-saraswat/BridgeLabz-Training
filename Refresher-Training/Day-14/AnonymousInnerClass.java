abstract class Shape {
    abstract double area();

    void describe() {
        System.out.println("Area: " + area());
    }
}

// Named subclass approach
class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        // Named subclass usage
        Shape namedSquare = new Square(5);

        // Anonymous inner class usage
        Shape anonTriangle = new Shape() {
            @Override
            double area() {
                return 0.5 * 6 * 4; // base=6, height=4
            }
        };

        // Call describe() on both
        namedSquare.describe();
        anonTriangle.describe();
    }
}

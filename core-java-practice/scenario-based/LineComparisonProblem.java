// Demonstrates line length calculation, equality, and comparison
public class LineComparisonProblem {

    // Utility class to represent a Line
    static class Line implements Comparable<Line> {
        private double x1, y1, x2, y2;

        public Line(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        // Calculate length using distance formula
        public double length() {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        // Equality check based on length
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Line)) return false;
            Line other = (Line) obj;
            return Double.compare(this.length(), other.length()) == 0;
        }

        // CompareTo for greater/less/equal
        @Override
        public int compareTo(Line other) {
            return Double.compare(this.length(), other.length());
        }

        @Override
        public String toString() {
            return "Line[(" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")] length=" + length();
        }
    }

    public static void main(String[] args) {
        // UC0: Start
        System.out.println("Welcome to Line Comparison Computation Program!");

        // Example lines
        Line line1 = new Line(0, 0, 3, 4); // length = 5
        Line line2 = new Line(1, 1, 4, 5); // length = 5
        Line line3 = new Line(0, 0, 6, 8); // length = 10

        // UC1: Equality check
        System.out.println("\nUC1: Equality Check");
        System.out.println("Line1: " + line1);
        System.out.println("Line2: " + line2);
        System.out.println("Are Line1 and Line2 equal? " + line1.equals(line2));

        // UC2: Comparison
        System.out.println("\nUC2: Comparison");
        System.out.println("Line1: " + line1);
        System.out.println("Line3: " + line3);
        int result = line1.compareTo(line3);
        if (result == 0) {
            System.out.println("Line1 is equal to Line3");
        } else if (result < 0) {
            System.out.println("Line1 is shorter than Line3");
        } else {
            System.out.println("Line1 is longer than Line3");
        }

        // UC3: End
        System.out.println("\nThank You");
    }
}
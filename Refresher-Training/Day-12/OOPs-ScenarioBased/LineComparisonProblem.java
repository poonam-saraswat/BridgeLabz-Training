/*import java.util.Scanner;

public class LineComparisonProblem {
    
    public static double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      // Line 1
        System.out.println("Enter coordinates of Line 1 (x1 y1 x2 y2): ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        // Line 2
        System.out.println("Enter coordinates of Line 2 (x3 y3 x4 y4): ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        double length1 = calculateLength(x1, y1, x2, y2);
        double length2 = calculateLength(x3, y3, x4, y4);

        System.out.println("Length of Line 1: " + length1);
        System.out.println("Length of Line 2: " + length2);

       
        if (Double.compare(length1, length2) == 0) {
            System.out.println("Both lines are equal in length.");
        } else if (Double.compare(length1, length2) > 0) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 2 is longer than Line 1.");
        }

        sc.close();
    }
}*/

// Line class implements Comparable to allow compareTo
class Line implements Comparable<Line> {
    private int x1, y1, x2, y2;

    // Constructor
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    
    public double getLength() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    
    @Override
    public int compareTo(Line other) {
        return Double.valueOf(this.getLength()).compareTo(other.getLength());
    }
}

public class LineComparisonProblem {
    public static void main(String[] args) {
        
        Line line1 = new Line(0, 0, 3, 4); // length = 5
        Line line2 = new Line(1, 1, 4, 5); // length = 5

        
        int result = line1.compareTo(line2);

        if (result == 0) {
            System.out.println("Both lines are equal in length.");
        } else if (result > 0) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 2 is longer than Line 1.");
        }
    }
}

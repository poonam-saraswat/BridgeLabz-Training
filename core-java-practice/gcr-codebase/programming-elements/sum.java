import java.util.Scanner;
public class sum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner object to read input
        System.out.println("Enter first number");
        int num1 = sc.nextInt();
        System.out.println("Enter second number");
        int num2 = sc.nextInt();
        int sum = num1+num2;// sum calculation
        System.out.println("The sum of two numbers is: " + sum);
    }
}
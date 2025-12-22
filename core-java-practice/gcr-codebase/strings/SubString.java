import java.util.Scanner;
public class SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        System.out.print("Enter starting index for substring of first string: ");
        int start1 = scanner.nextInt();
        System.out.print("Enter ending index for substring of first string: ");
        int end1 = scanner.nextInt();
        String subStr1 = str1.substring(start1, end1);

        System.out.print("Enter starting index for substring of second string: ");
        int start2 = scanner.nextInt();
        System.out.print("Enter ending index for substring of second string: ");
        int end2 = scanner.nextInt();
        String subStr2 = str2.substring(start2, end2);

        System.out.println("Substring of first string: " + subStr1);
        System.out.println("Substring of second string: " + subStr2);

        scanner.close();
    }
}
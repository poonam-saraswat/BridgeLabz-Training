import java.util.regex.*;
import java.util.*;

public class ValidationProblems{

    public static void validateUsername(String username){
        String regex = "^[a-zA-Z][0-9_]{5,15}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println();
        System.out.println(username + " is valid: " + pattern.matcher(username).matches());
    }

    public static void validateLicensePlate(String licensePlate){
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println(licensePlate + " is valid: " + pattern.matcher(licensePlate).matches());
    }

    public static void validateHexcode(String hexcode){
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println(hexcode + " is valid: " + pattern.matcher(hexcode).matches());
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username to validate: ");
        String username = sc.nextLine();
        System.out.println("Enter License Plate Number to validate: ");
        String licensePlate = sc.nextLine();
        System.out.println("Enter Hexcolor code to validate: ");
        String hexcode = sc.nextLine();

        validateUsername(username);
        validateLicensePlate(licensePlate);
        validateHexcode(hexcode);
        
    }
}
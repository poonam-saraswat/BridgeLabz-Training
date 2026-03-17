package M1-Problems;

import java.util.*;

public class CorporateEmailAccessControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String email = sc.nextLine().trim();
            if (isValidEmail(email)) {
                System.out.println("Access Granted");
            } else {
                System.out.println("Access Denied");
            }
        }
        sc.close();
    }

    private static boolean isValidEmail(String email) {
        // Basic format check
        if (!email.contains("@")) return false;
        if (email.contains(" ")) return false;

        String[] parts = email.split("@");
        if (parts.length != 2) return false;

        String localPart = parts[0]; // empFirstname.empLastname+digits
        String domainPart = parts[1]; // department.company.com

        // Validate domain
        String[] domainParts = domainPart.split("\\.");
        if (domainParts.length != 3) return false;
        String department = domainParts[0];
        String company = domainParts[1];
        String com = domainParts[2];

        Set<String> validDepartments = new HashSet<>(Arrays.asList("sales", "marketing", "IT", "product"));
        if (!validDepartments.contains(department)) return false;
        if (!company.equals("company") || !com.equals("com")) return false;

        // Validate local part
        // Must be firstname.lastname+digits
        String[] nameAndDigits = localPart.split("\\.");
        if (nameAndDigits.length != 2) return false;

        String firstname = nameAndDigits[0];
        String lastnameAndDigits = nameAndDigits[1];

        // Extract lastname and digits
        int digitIndex = -1;
        for (int j = 0; j < lastnameAndDigits.length(); j++) {
            if (Character.isDigit(lastnameAndDigits.charAt(j))) {
                digitIndex = j;
                break;
            }
        }
        if (digitIndex == -1) return false;

        String lastname = lastnameAndDigits.substring(0, digitIndex);
        String digits = lastnameAndDigits.substring(digitIndex);

        // Validation rules for firstname and lastname
        if (firstname.length() < 3 || lastname.length() < 3) return false;
        if (!firstname.matches("[a-z]+")) return false;
        if (!lastname.matches("[a-z]+")) return false;

        // Digits must be at least 4
        if (!digits.matches("\\d{4,}")) return false;

        return true;
    }
}
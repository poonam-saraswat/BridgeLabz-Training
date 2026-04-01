package M1-Problems;

import java.util.*;
import java.util.regex.*;

public class ShipmentValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String record = sc.nextLine().trim();
            if (isValidRecord(record)) {
                System.out.println("COMPLIANT RECORD");
            } else {
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
        sc.close();
    }

    private static boolean isValidRecord(String record) {
        String[] parts = record.split("\\|");
        if (parts.length != 5) return false;

        String code = parts[0];
        String date = parts[1];
        String mode = parts[2];
        String weight = parts[3];
        String status = parts[4];

        return validateCode(code) &&
               validateDate(date) &&
               validateMode(mode) &&
               validateWeight(weight) &&
               validateStatus(status);
    }

    private static boolean validateCode(String code) {
        if (!code.matches("SHIP-\\d{6}")) return false;
        String digits = code.substring(5);

        // First digit cannot be 0
        if (digits.charAt(0) == '0') return false;

        // No digit repeats more than 3 times consecutively
        if (digits.matches(".*(\\d)\\1{3,}.*")) return false;

        return true;
    }

    private static boolean validateDate(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) return false;
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (year < 2000 || year > 2099) return false;
        if (month < 1 || month > 12) return false;

        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31};

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    private static boolean validateMode(String mode) {
        Set<String> validModes = new HashSet<>(Arrays.asList(
            "AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT"
        ));
        return validModes.contains(mode);
    }

    private static boolean validateWeight(String weight) {
        if (!weight.matches("\\d+(\\.\\d{1,2})?")) return false;

        // No leading zeros unless value is exactly 0
        if (weight.matches("0\\d+.*")) return false;

        double val = Double.parseDouble(weight);
        return val > 0 && val <= 999999.99;
    }

    private static boolean validateStatus(String status) {
        Set<String> validStatuses = new HashSet<>(Arrays.asList(
            "DELIVERED", "CANCELLED", "IN_TRANSIT"
        ));
        return validStatuses.contains(status);
    }
}
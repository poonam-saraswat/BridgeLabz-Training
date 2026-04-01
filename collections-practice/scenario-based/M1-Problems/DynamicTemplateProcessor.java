package M1-Problems;

import java.util.*;
import java.util.regex.*;

public class DynamicTemplateProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            System.out.println(processLine(line));
        }
        sc.close();
    }

    private static String processLine(String line) {
        // Regex to match ${TYPE:VALUE}
        Pattern pattern = Pattern.compile("\\$\\{([^:}]+):([^}]+)\\}");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);
            String replacement = processPlaceholder(type, value);
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);

        return result.toString();
    }

    private static String processPlaceholder(String type, String value) {
        switch (type) {
            case "DATE":
                return processDate(value);
            case "UPPER":
                return value.toUpperCase();
            case "LOWER":
                return value.toLowerCase();
            case "REPEAT":
                return processRepeat(value);
            default:
                return "INVALID";
        }
    }

    private static String processDate(String value) {
        // Expected format: DD-MM-YYYY
        String[] parts = value.split("-");
        if (parts.length != 3) return "INVALID";
        try {
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Basic validation
            if (year < 1 || month < 1 || month > 12 || day < 1) return "INVALID";

            int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30,
                                 31, 31, 30, 31, 30, 31};
            if (day > daysInMonth[month - 1]) return "INVALID";

            return String.format("%04d/%02d/%02d", year, month, day);
        } catch (NumberFormatException e) {
            return "INVALID";
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    private static String processRepeat(String value) {
        String[] parts = value.split(",");
        if (parts.length != 2) return "INVALID";
        try {
            String word = parts[0];
            int count = Integer.parseInt(parts[1]);
            if (count < 0) return "INVALID";

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(word);
            }
            return sb.toString();
        } catch (NumberFormatException e) {
            return "INVALID";
        }
    }
}
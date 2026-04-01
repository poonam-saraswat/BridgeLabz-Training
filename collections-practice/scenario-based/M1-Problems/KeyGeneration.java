package M1-Problems;

import java.util.*;

public class KeyGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();

            String validationResult = validateInput(input);
            if (validationResult != null) {
                System.out.println(validationResult);
            } else {
                String key = generateKey(input);
                System.out.println("The generated key is - " + key);
            }
        }
        sc.close();
    }

    // Validation rules
    private static String validateInput(String str) {
        if (str == null || str.isEmpty()) {
            return "Invalid Input (empty string)";
        }
        if (str.length() < 6) {
            return "Invalid Input (length < 6)";
        }
        if (str.contains(" ")) {
            return "Invalid Input (contains space)";
        }
        if (str.matches(".*\\d.*")) {
            return "Invalid Input (contains digits)";
        }
        if (!str.matches("[a-zA-Z]+")) {
            return "Invalid Input (contains special character)";
        }
        return null; // valid
    }

    // Key generation steps
    private static String generateKey(String str) {
        // Step 1: convert to lowercase
        str = str.toLowerCase();

        // Step 2: remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c % 2 != 0) { // keep only odd ASCII
                filtered.append(c);
            }
        }

        // Step 3: reverse the remaining characters
        filtered.reverse();

        // Step 4: convert characters at even index positions to uppercase
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }
}
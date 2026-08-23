public class PasswordStrengthValidation {

    // 1. Single-regex lookahead version
    public static boolean isStrongPasswordRegex(String pw) {
        String strongPasswordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$";
        return pw.matches(strongPasswordRegex);
    }

    // 2. Separate-checks version
    public static boolean isStrongPasswordChecks(String pw) {
        return pw.matches(".*[a-z].*")   
            && pw.matches(".*[A-Z].*") 
            && pw.matches(".*\\d.*")     
            && pw.matches(".*[!@#$%^&*].*")
            && pw.length() >= 8;      
    }

    public static void main(String[] args) {
        // Test passwords
        String[] testPasswords = {
            "short7!",       
            "alllowercase7!",
            "NoDigitsHere!", 
            "NoSpecial123",  
            "ValidPass1!"   
        };

        for (String pw : testPasswords) {
            boolean regexResult = isStrongPasswordRegex(pw);
            boolean checksResult = isStrongPasswordChecks(pw);
            System.out.println(pw + " → Regex: " + regexResult +
                               ", Checks: " + checksResult);
        }
    }
}

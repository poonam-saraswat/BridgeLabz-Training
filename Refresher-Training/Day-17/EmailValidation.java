public class EmailValidation {

    // Method to validate email using regex
    public static boolean isValidEmail(String email) {
        // Regex: local-part + @ + domain + TLD (min 2 chars)
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }

    public static void main(String[] args) {
        // Test cases
        String[] validEmails = {
            "poonam@example.com",
            "user.name123@domain.co",
            "test_email+filter@sub.domain.org",
            "abc.def@ghi.com",
            "hello.world@company.in"
        };

        String[] invalidEmails = {
            "missingatsymbol.com",       // no @
            "user@nodomain",             // no TLD
            "user@domain..com",          // consecutive dots
            "@nouser.com",               // missing local-part
            "user@.startdot.com"         // domain starts with dot
        };

        System.out.println("✅ Valid Emails:");
        for (String email : validEmails) {
            System.out.println(email + " → " + isValidEmail(email));
        }

        System.out.println("\n❌ Invalid Emails:");
        for (String email : invalidEmails) {
            System.out.println(email + " → " + isValidEmail(email));
        }
    }
}

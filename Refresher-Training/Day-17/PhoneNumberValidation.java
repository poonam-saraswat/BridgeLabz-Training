public class PhoneNumberValidation {

    // Method to validate phone numbers using regex
    public static boolean isValidPhone(String phone) {
        // Regex: optional country code + area code + 7 digits
        String regex = "^(\\+\\d{1,3}[- .]?)?\\(?\\d{3}\\)?[- .]?\\d{3}[- .]?\\d{4}$";
        return phone.matches(regex);
    }

    public static void main(String[] args) {
        // Valid test cases
        String[] validPhones = {
            "5551234567",          
            "555-123-4567",        
            "(555) 123-4567",      
            "+1 555-123-4567",     
            "+91-5551234567"       
        };

        // Invalid test cases
        String[] invalidPhones = {
            "12345",               // too few digits
            "555-ABC-4567",        // letters mixed in
            "+999 (555) 123-45678" // too many digits
        };

        System.out.println(" Valid Phone Numbers:");
        for (String phone : validPhones) {
            System.out.println(phone + " → " + isValidPhone(phone));
        }

        System.out.println("\n Invalid Phone Numbers:");
        for (String phone : invalidPhones) {
            System.out.println(phone + " → " + isValidPhone(phone));
        }
    }
}


import java.util.HashSet;
public class OTP {  
    public static void main(String[] args) {
        String[] otps = new String[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otps[i]);
        }

        // Check if all OTPs are unique
        boolean areUnique = areOTPsUnique(otps);
        if (areUnique) {
            System.out.println("All generated OTPs are unique.");
        } else {
            System.out.println("There are duplicate OTPs generated.");
        }
    }

    // Method to generate a 6-digit OTP number
    public static String generateOTP() {
        int otp = 100000 + (int)(Math.random() * 900000); // Generates a number between 100000 and 999999
        return String.valueOf(otp);
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(String[] otps) {
        HashSet<String> otpSet = new HashSet<>();
        for (String otp : otps) {
            if (!otpSet.add(otp)) {
                return false; // Duplicate found
            }
        }
        return true; // All OTPs are unique
    }
}
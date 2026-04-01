interface SecurityUtils{

    static boolean isStrong(String password){
        if(password.length() < 8) return false;

        boolean upper = false;
        boolean lower = false;
        boolean number = false;

        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)) upper = true;
            else if(Character.isLowerCase(c)) lower = true;
            else if(Character.isDigit(c)) number = true;
        }

        return upper && lower && number;
    }
}

public class PasswordStrength{
    public static void main(String[] args){
        String password = "Pass1234";

        if(SecurityUtils.isStrong(password)){
            System.out.println("Strong password");
        }
        else{
            System.err.println("Weak Password");
        }
    }
}
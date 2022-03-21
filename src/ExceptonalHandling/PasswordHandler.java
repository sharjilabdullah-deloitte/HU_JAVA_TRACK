package ExceptonalHandling;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordHandler {
    public static void main(String[] args) throws pdException {
        System.out.println("Enter your PASSWORD");
        Scanner sc= new Scanner(System.in);
        String password= sc.next();
        try {
            checkPassword(password);
        }
        catch (pdException e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkPassword(String password) throws pdException {
        if (password.length()<5 && password.length()>10)
            throw new pdException("Password should be in between 5 to 10 characters");
        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean digitCheck = false;
        boolean specialchar= false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
            {
                upperCheck = true;
            }

            if (Character.isLowerCase(c))
            {
                lowerCheck = true;
            }
            if (Character.isDigit(c))
            {
                digitCheck = true;
            }
            Pattern special = Pattern.compile ("[@ #  &  % * ! ]");
            Matcher m = special.matcher(password);
            specialchar = m.find();
            if (specialchar) {
                specialchar = true;
            }
        }
        if (!upperCheck) {
            throw new pdException("There must be an uppercase character");
        }

        if (!lowerCheck) {
            throw new pdException("There must be a lowercase character");
        }

        if (!digitCheck) {
            throw new pdException("There must a be a digit");
        }
        if (!specialchar) {
            throw new pdException("There must a be a special character");
        }

        System.out.println("Valid password.");
    }
    static class pdException extends Exception {

        public pdException() {
            super("Invalid password");
        }

        public pdException(String message) {
            super("Invalid password: " + message);
        }
    }
}


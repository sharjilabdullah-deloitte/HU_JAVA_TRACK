package MainAssignment;

import ExceptonalHandling.PasswordHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HRHelper {
    public static void checkPassword(String password) throws pdException {
        if (password.length() < 5 && password.length() > 10)
            throw new pdException("Password should be in between 5 to 10 characters");
        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean digitCheck = false;
        boolean specialchar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCheck = true;
            }

            if (Character.isLowerCase(c)) {
                lowerCheck = true;
            }
            if (Character.isDigit(c)) {
                digitCheck = true;
            }
            Pattern special = Pattern.compile("[@ #  &  % * ! ]");
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

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int enteredid,id2;
        String enteredpass,pass2,pass3;
        //try{
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("********WELCOME TO USER DATABASE*******");
            System.out.println("1.LOGIN");
            System.out.println("2.REGISTER");
            System.out.println("Enter your choice :");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1 :
                    System.out.println("*******WELCOME TO LOGIN PAGE**********");
                    System.out.println("Enter the User id");
                    enteredid=sc.nextInt();
                    System.out.println("Enter your Password");
                    enteredpass= sc.next();
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_records", "root", "password");
                        Statement statement= connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("Select * from employee WHERE id = ' "+ enteredid +" ' ");
                        while(resultSet.next()) {
                            String pass = resultSet.getString("password");
                            int id = resultSet.getInt("id");
                            if ((enteredid == id) && (enteredpass.equals(pass))) {
                                System.out.println("Login Sucessful");

                                System.out.println("*****Welcome to the user database*********");
                                System.out.println("1. Add User data");
                                System.out.println("2. List User data");
                                System.out.println("3. Update User data");
                                System.out.println("4. Delete user data");
                                System.out.println("5. Exit");

                                int ch1 =sc.nextInt();
                                int nuid,nsalary,nphone,nage;
                                String nname,ncname,ndesig,nadd;
                                switch (ch)
                                {
                                    case 1:
                                        System.out.println("******Welcome to the user database*****");
                                        System.out.println("Enter the userid");
                                        nuid= sc.nextInt();
                                        System.out.println("Enter the name");
                                        nname=sc.next();
                                        System.out.println("Enter the age");
                                        nage=sc.nextInt();
                                        if(nage<18 || nage >90)
                                            System.out.println("Enter the correct age between 18 to 90");
                                        System.out.println("Enter the company name");
                                        ncname=sc.next();
                                        System.out.println("Enter the designation");
                                        ndesig=sc.next();
                                        System.out.println("Enter the salary");
                                        nsalary=sc.nextInt();
                                        if (nsalary<=0)
                                            System.out.println("Enter the salary greater than 0");
                                        System.out.println("Enter the address");
                                        nadd=sc.next();
                                        System.out.println("Enter the phone number");
                                        nphone=sc.nextInt();
                                        int lengthOfphone= String.valueOf(nphone).length();
                                        if(lengthOfphone<10 || lengthOfphone>10)
                                            System.out.println("Please enter the correct 10 digit length of your phone number");

                                }


                            } else {
                                System.out.println("Please enter correct Userid or Password");
                            }
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                case 2 :
                    System.out.println("*****WELCOME TO THE USER REGISTRATION PAGE******");
                    System.out.println("Enter the userid");
                    id2=sc.nextInt();
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_records", "root", "password");
                        Statement statement= connection.createStatement();
                        String query1="INSERT INTO employee(id)" +
                                "VALUES "+(id2)+" ";

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Enter the password");
                    pass2=sc.next();
                    System.out.println("Please reenter your password");
                    pass3=sc.next();
                    if(pass2==pass3) {
                        try {
                            checkPassword(pass2);
                            String query1="INSERT INTO employee(password)" +
                                    "VALUES (pass2)";


                        }
                        catch (pdException e){
                            e.printStackTrace();
                        }
                    }




            }




    }
}

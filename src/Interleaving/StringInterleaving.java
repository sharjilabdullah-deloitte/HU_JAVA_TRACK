package Interleaving;

import java.util.Scanner;
import java.util.*;

public class StringInterleaving {
    public static boolean isInterleaving(String s1, String s2, String s3)
    {

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        if (s3.length() == 0) {
            return false;
        }

        boolean x = (s1.length() != 0 && s3.charAt(0) == s1.charAt(0)) &&
                isInterleaving(s1.substring(1), s2, s3.substring(1));
        

        boolean y = (s1.length() != 0 && s3.charAt(0) == s2.charAt(0)) &&
                isInterleaving(s1, s2.substring(1), s3.substring(1));

        return x || y;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        String s3=sc.next();


        if (isInterleaving(s1, s2, s3)) {
            System.out.print("Valid Shuffle");
        }
        else {
            System.out.print("Invalid Shuffle");
        }
    }
}

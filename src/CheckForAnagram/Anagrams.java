package CheckForAnagram;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    public static boolean isAnagram(String string1, String string2) {
        char[] s1char = string1.toCharArray();
        char[] s2char = string2.toCharArray();
        Arrays.sort(s1char);
        Arrays.sort(s2char);
        string1 = new String(s1char);
        string2 = new String(s2char);
        return string1.equals(string2);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first String");
        String str1= sc.next();
        System.out.println("Enter the second String");
        String str2= sc.next();
        boolean result=isAnagram(str1,str2);
        if(result==true) {
            System.out.println("Strings are anagram");
        }
        else{
            System.out.println("Strings are not anagram");
        }

    }
}

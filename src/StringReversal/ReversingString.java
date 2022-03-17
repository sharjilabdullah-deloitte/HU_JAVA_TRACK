package StringReversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ReversingString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size you want to enter  + 1");
        int n =sc.nextInt();

        String [] arr = new String[n];
        for(int i=0;i<arr.length;i++)
        {
            //System.out.println("Enter the element ");
            arr[i] = sc.nextLine();
        }

        ArrayList<String> a = new ArrayList<>();

        for(int i=0;i<arr.length;i++)
        {
            a.add(arr[i]);
        }

        Collections.reverse(a);

        for(int i=0;i<a.size();i++)
        {
            System.out.println(a.get(i));
        }


    }
}

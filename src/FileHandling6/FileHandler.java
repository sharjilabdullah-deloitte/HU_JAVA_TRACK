package FileHandling6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileHandler {
    public static void main(String[] args) {
      
        try
        {
            List<List<String>> data = new ArrayList<>();//list of lists to store data
            List<List<String>> result= new ArrayList<>();// Converting array to list
            //String filePath = "C:\\Users\\asharjil\\Desktop\\StudentData.csv";//file path
            String filePath = "src\\StudentData.csv";
            File file = new File(filePath);
            Scanner s = new Scanner(file);
            //Reading until we run out of lines
            while(s.hasNextLine())
            {
                List<String> lineData = Arrays.asList(s.nextLine().split(","));//splitting lines
                data.add(lineData);
            }
            //printing the fetched data
            for(List<String> list : data)
            {
                for(String str : list)
                    System.out.print(str + " ");
                System.out.println();
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }


    }
}

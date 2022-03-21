package MainAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HRHelper {
    public static void main(String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp-records", "root", "password");
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from employee");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}

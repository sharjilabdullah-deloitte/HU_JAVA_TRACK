package ExceptonalHandling;

public class ExceptionHandler {
    public static void main(String args [])
    {
        try {
            int num1=10,num2=0;
            int result=num1/num2;
            System.out.println("Result is ="+ result);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Number cannot be divided by zero ");
        }
        finally {
            System.out.println("Thank you..!!");
        }
    }
}

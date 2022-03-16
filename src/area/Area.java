package area;

public class Area {
    void area(double x)
    {
        double ans = 3.14 * x * x;
        System.out.println("the area of the circle is "+ans);
    }

    void area(float x)
    {
        double ans =Math.pow(x, 2);
        System.out.println("the area of the square is "+ans);
    }
    void area(float x, float y)
    {
        double ans= x*y;
        System.out.println("the area of the rectangle is "+ans);
    }

}
class Overload
{
    public static void main(String args[])
    {
        Area obj = new Area();
        obj.area(5.5);
        obj.area(10);
        obj.area(15,20);

    }
}


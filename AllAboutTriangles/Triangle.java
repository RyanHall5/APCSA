package AllAboutTriangles;
/**
 * Programmer:Ryan Hall
 * Program: This class contains methods and attributes that are useful for creating a Triangle object. A shape with 3 sides.
 * The class allows the user to access and set all sides of the triangle, check if the triangle is able to exist, if it is a right triangle,
 * see the perimeter and area of the triangle, as well as display all 3 sides of the triangle smallest to largest.
 * Issues: None
 */
public class Triangle {

    //instance variables
    private double small;
    private double med;
    private double large;


    //default constructor
    public Triangle(){
        small = 3;
        med = 4;
        large = 5;
    }

    //parameter constructor
    public Triangle(double s1, double s2, double s3){
        small = Math.min(Math.min(s1,s2), Math.min(s2,s3));
        med = Math.min(Math.min(Math.max(s1,s2), Math.max(s2, s3)), Math.max(s1,s3));
        large = Math.max(Math.max(s1,s2), Math.max(s2,s3));
    }


    //Accessors
    public double getSmall(){return small;}
    public double getMedium(){return med;}
    public double getLarge(){return large;}

    //Mutators
    public void setSmall(double n){small = n;}
    public void setMedium(double n){med = n;}
    public void setLarge(double n){large = n;}


    //returns true if this is a valid triangle
    public boolean isTriangle(){
        return (small + med) > large;
    }

    //return true if this is a right triangle
    public boolean isRightTriangle(){

        //calculating left and right side of equation
        double left = Math.pow(small, 2) + Math.pow(med,2);
        double right = Math.pow(large, 2);

        //return if difference is less than tolerance of .1
        return Math.abs(left - right) <= .1;
    }

    //returns perimeter of this triangle
    public double perimeter(){
        return small + med + large;
    }

    //returns area of triangle using Heron's Formula
    public double area(){
        double p = this.perimeter() / 2;
        return Math.sqrt(p * (p - small) * (p - med) * (p - large));
    }

    //outputs contents of triangle
    public void displayTriangle(){
        System.out.println("Smallest side: " + small);
        System.out.println("Medium side: " + med);
        System.out.println("Largest side: " + large);
    }
}
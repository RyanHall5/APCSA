package ExploringMathClass;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        //displaying randomly generated int from -20 to 20
        int num = (int) (Math.random() * 41) - 20;
        System.out.println("First random number: " + num);
        //displaying the absolute value of the previous number
        int absNum = Math.abs(num);
        System.out.println("Absolute value: " + absNum);

        //spacing
        System.out.println();

        //generating random 0-90
        int num2 = (int) (Math.random() * 90);
        System.out.println("The random angle is: " + num2);
        double sine = Math.sin(num2);
        double cosine = Math.cos(num2);
        double tangent = Math.tan(num2);
        System.out.println("Sine: " + sine);
        System.out.println("Cosine: " + cosine);
        System.out.println("Tangent: " + tangent);

        //spacing
        System.out.println();

        //solving quadratic equation
        System.out.println("Enter in a: ");
        int a = reader.nextInt();
        System.out.println("Enter in b: ");
        int b = reader.nextInt();
        System.out.println("Enter in c: ");
        int c = reader.nextInt();

        double solution1 = ((-1 * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        double solution2 = ((-1 * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        System.out.println("The first solution is: " + solution1);
        System.out.println("The second solution is: " + solution2);
        System.out.println();

        //spacing
        System.out.println();

        //calculating circle area and circumference
        System.out.println("Enter the radius of your circle: ");
        double radius = reader.nextDouble();
        System.out.print("Circumference of a circle: ");
        System.out.println(2 * Math.PI * radius);
        System.out.print("Area of a circle: ");
        System.out.println(Math.PI * radius * radius);

        //spacing
        System.out.println();

        //rounding a random decimal number
        double randNum = Math.random() * 9;
        System.out.println("Random number: " + randNum);
        System.out.print("rounding method 1: ");
        System.out.printf("%.0f", randNum);
        System.out.println();
        System.out.print("rounding method 2: ");
        System.out.println(Math.round(randNum));
        System.out.print("rounding method 3: ");
        System.out.println((int) (randNum + .5));
        reader.close();
    }
}
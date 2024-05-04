import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        System.out.println("Hello Vroosh and Melovi!");
        System.out.println("I added this, on the first change -vroosh");
        int z = 1;

        System.out.print("Enter a number: ");

        Scanner input = new Scanner(System.in);  // honestly, bad scanner name
        int value = input.nextInt();
        System.out.println(value);
        if (value <= 4) {
            System.out.println("Number is less than or equal to " +value);
        }
        else {
            System.out.println("Number is greater than " +value);
        }

        doNot();
    }

    public static void doNot()
    {
        System.out.println("Do NOT!");
    }
}
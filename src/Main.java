import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        System.out.println("Hello Vroosh and Melovi!");

        System.out.print("Enter a number: ");

        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        System.out.println(value);

        if (value <= 4) {
            System.out.println("Number is less than or equal to " +value);
        }
        else {
            System.out.println("Number is greater than " +value);
        }
    }
}

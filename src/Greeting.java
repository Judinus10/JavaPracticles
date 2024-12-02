import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your name : ");
        String name = input.next();
        System.out.println("Hello, " + name + "!");
    }
}

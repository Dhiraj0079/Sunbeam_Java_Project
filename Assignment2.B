package Marcos;
import java.util.Scanner;

// Custom Exception
class ExceptionLineTooLong extends Exception {
    public ExceptionLineTooLong() {
        super("The strings is too long");
    }
}

public class StringLengthCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        try {
            if (input.length() > 80) {
                throw new ExceptionLineTooLong();
            } else {
                System.out.println("String length: " + input.length());
                System.out.println("String is within the allowed limit.");
            }
        } catch (ExceptionLineTooLong e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

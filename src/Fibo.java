import java.util.Scanner;
public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a number :");
        System.out.println(fibo(scanner.nextInt()));
        scanner.nextLine();
        return false;
    }

    public static int fibo(int n) {
        int a = 0;
        int b = 1;

        if (n < 0)
            throw new IllegalArgumentException("Met un nombre positif petit malin");

        else if (n == 0)
            return a;

        for (int i = 0; i < n - 1; i++) {
            int old_a = a;
            a = b;
            b += old_a;
        }
        return b;
    }
}
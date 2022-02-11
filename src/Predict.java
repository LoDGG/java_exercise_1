import java.util.Scanner;

public class Predict implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        return false;
    }
}

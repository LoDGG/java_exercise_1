import java.io.IOException;
import java.util.Scanner;

public interface Command {
    public String name();

    public boolean run(Scanner scan) throws IOException;

}
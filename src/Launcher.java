import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Launcher {



    public static void main(String[] args) throws IOException {
        System.out.println("un texte de bienvenue");
        Scanner scan = new Scanner(System.in);
        boolean Continue = true;
        String entry = null;

        List<Command> commands = List.of(
                new Quit(),
                new Fibo(),
                new Freq(),
                new Predict()
        );

        do {
            System.out.println("Enter some command :");
            entry = scan.nextLine();
            for (var i : commands) {
                if (i.name().equals(entry)) {
                    if (i.run(scan))
                        return;

                    Continue = true;
                }
            }

            if (!Continue)
                System.out.println("Unknown command");
        } while (true);

    }
}

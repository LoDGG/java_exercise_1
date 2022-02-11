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
    public static int fibonnacci(int n){
        int a = 0;
        int b = 1;

        if (n < 0)
            throw new IllegalArgumentException("Met un nombre positif petit malin");

        else if(n == 0)
            return a;

        for (int i = 0; i < n-1; i++) {
            int old_a = a;
            a = b;
            b += old_a;
        }

        return b;

    }

    public static void freq(Path path) throws IOException {
        String str = java.nio.file.Files.readString(path);
        str = str.toLowerCase();
        str = str.replaceAll("^a-z", " ");
        str = str.trim().replaceAll(" +", " ");
        String[] wrd_array = str.split(" ");
        List<String> words = Arrays.asList(wrd_array);

        var freqMap = words.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach( e->System.out.println(e.getKey()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("un texte de bienvenue");
        Scanner scan = new Scanner(System.in);
        boolean Continue = true;
        String entry = null;

        do {
            System.out.println("Enter some command :");
            entry = scan.nextLine();


            if("fibo".equals(entry)){
                System.out.println("Enter N :");
                String rawNumber = scan.nextLine();
                System.out.println(fibonnacci(parseInt(rawNumber)));
            }

            else if("freq".equals(entry)) {
                System.out.println("Enter path :");
                String path = scan.nextLine();
                freq(Paths.get(path));

            }

            else if ("quit".equals(entry)){
                Continue = false;
            }

            else {
                System.out.println("Unknown Command");
            }
        }while(Continue);

        System.out.println("bye bye");

    }
}

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) throws IOException {
        System.out.println("Enter a filename:");
        freq(Path.of(scanner.nextLine()));
        return false;
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
        freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach(e -> System.out.println(e.getKey()));
    }
}

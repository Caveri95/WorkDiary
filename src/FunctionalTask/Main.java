package FunctionalTask;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        String text = scanner.next();

        int wordsCount = Arrays.stream(text.replaceAll("\\p{Punct}", "").split(" "))
                .collect(Collectors.toList())
                .size();
        System.out.println("Количество слов в тексте " + wordsCount);

        Arrays.stream(text.replaceAll("\\p{Punct}", "").split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.<String, Long>comparingByKey()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " повторений в тексте " + e.getValue()));
    }
}

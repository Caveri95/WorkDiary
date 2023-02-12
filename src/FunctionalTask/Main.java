package FunctionalTask;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");


//        System.out.println(Stream.of(1, 2, 3, 4, 9).allMatch(x -> x <= 7));
//        Set<Integer> set = Stream.of(99, 2, 3).collect(Collectors.toSet());
//        System.out.println(set);
//        Long count = Stream.of("1", "2", "3", "4").count();
//        System.out.println(count);

        /*String text = "yourapp the quick brown fox jumps over the lazy dog";


        Pattern pattern = Pattern.compile("\\s");
        String[] strings = pattern.split(text);
        Arrays.stream(strings).forEach(System.out::println);
        System.out.println("Количество слов в тексте - " + strings.length);
        System.out.println(Arrays.stream(strings).collect(Collectors.toList()).get(1));*/

        /*Pattern p = Pattern.compile("a*b");// скомпилировали регулярное выражение в представление
        Matcher m = p.matcher("aaaaab");
        System.out.println(m);*/

        String textInput = "the? quick, brown/ fox. themps over the  the fox the lazy dog";
        String text = textInput.replaceAll("\\p{Punct}", "");


        Pattern pattern = Pattern.compile("\\s");
        String[] strings = pattern.split(text);
        String word = " " + Arrays.stream(strings).collect(Collectors.toList()).get(0) + " ";
        System.out.println("ищем" + word);




        Pattern pattern1 = Pattern.compile(word);
        Matcher matcher = pattern1.matcher(text);
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }

        String sentence = "Ёлочка вам нравится, ёлочка?";

        ArrayList<String> words = new ArrayList<>();
        for (String s : sentence.split(" ")) {
            words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
        }

        words.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));


        HashSet<String> distinct = new HashSet<>();
        HashSet<String> repetitive = new HashSet<>();
        for (String i: strings) {
            if (distinct.contains(i)) {
                repetitive.add(i);
            } else {
                distinct.add(i);
            }
        }
        repetitive.stream().forEach(System.out::println);
        System.out.println(repetitive.size());
        System.out.println("______________");
        distinct.stream().forEach(System.out::println);
        //System.out.println(repetitive.size());


        /*System.out.println(matcher.replaceFirst("Ира"));
        System.out.println(matcher.replaceAll("Ольга"));*/
        //System.out.println(text);

        long a = 10;
        long b = 7;


        System.out.println(a / b);





    }
}

package CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by dssachan on 03/10/16.
 */
public class Java8Stream {

    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.stream().forEach(integer -> doSomething(integer));
        integers.stream().limit(1).forEach(integer -> doSomething(integer));
        integers.stream().forEach(System.out::println);
        new Random().ints().limit(2).forEach(System.out::println);

        long count = integers.stream().filter(integer -> !integer.equals(1)).count();
        System.out.println(count);

        integers.stream().filter(integer -> !integer.equals(1)).forEach(System.out::println);
        List<Integer> collect= integers.stream().filter(integer -> !integer.equals(1)).collect(Collectors.toList());

        System.out.println(collect);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

    private static void doSomething(Integer inte){
        System.out.println(inte);
    }
}

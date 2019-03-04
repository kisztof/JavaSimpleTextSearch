package pl.kslomka;

import java.util.Comparator;
import java.util.Map;

public class PrintableResult {

    public static void print(SearchResult result) {
        if (result.getResult().isEmpty()) {
            System.out.println("Words not found!");
        }

        result.getResult().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach((v) -> {
                    Integer rank = (int) (((double) v.getValue() / result.getWords().size()) * 100);
                    System.out.printf("%s %d%%%n", v.getKey(), rank);
                });
    }
}

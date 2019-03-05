package pl.kslomka;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PrintableResult {

    public static void print(File[] filesInDirectory, SearchResult result) {
        if (result.getResult().isEmpty()) {
            System.out.println("Words not found!");
        }

        Map<String, Integer> printable = new HashMap<>();
        for (File file : filesInDirectory) printable.put(file.getName(), 0);

        printable.putAll(result.getResult());
        printable.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach((v) -> {
                    Integer rank = (int) (((double) v.getValue() / result.getWords().size()) * 100);
                    System.out.printf("%s %d%%%n", v.getKey(), rank);
                });
    }
}

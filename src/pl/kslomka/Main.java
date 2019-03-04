package pl.kslomka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No Directory given to index");
        }

        final File indexableDirectory = new File(args[0]);

        if (!indexableDirectory.isDirectory()) {
            throw new IllegalArgumentException("Given catalog name is not a directory");
        }

        SearchIndex index = new SearchIndex(new KeyNormalizer());

        for (File file : indexableDirectory.listFiles()) {
            try {
                Scanner sc = new Scanner(file);
                index.build(sc, file.getName());
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("search>>");
            final String sentence = keyboard.nextLine();

            Search search = new Search(index);
            PrintableResult.print(search.search(sentence));
        }
    }
}

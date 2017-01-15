package by.stadnik;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class JavaFeatures {


    static class ArrayFeature {

        public static void main(String[] args) {
            String[] sa = new String[8];

            IntStream.range(0, sa.length).forEach(i -> {
                sa[i] = Character.toString((char) ('A' + 1));
            });

            Arrays.parallelSetAll(sa, i -> Character.toString((char) ('A' + 1)));
        }

    }

    static class EqualsComparator {
        public static void main(String[] args) {
            String[] a = {"a", "b", "c", "d"};
            String[] b = {"A", "b", "c", "d"};

            Comparator<String> cmp = Comparator.comparing(String::toLowerCase);

            boolean eq = IntStream.range(0, Math.min(a.length, b.length))
                    .map(i -> cmp.compare(a[i], b[i]))
                    .allMatch(c -> c == 0);

        }
    }
}

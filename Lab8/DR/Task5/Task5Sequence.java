// Task 5
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task5Sequence {
    private record Extremum(int index, double value) {
        @Override
        public String toString() {
            return value + " (index " + index + ")";
        }
    }

    private record Fragment(int start, int end) {
        int length() {
            return end - start + 1;
        }
    }

    private static final double[] EXAMPLE = {1, 3, 5, 4, 2, 6, 8, 7, 9, 11, 10};

    public static void main(String[] args) {
        double[] sequence;
        if (args.length == 0) {
            System.out.println("No numbers given, using the example from the task.");
            sequence = EXAMPLE.clone();
        } else {
            sequence = Arrays.stream(String.join(" ", args).trim().split("[,\\s]+"))
                    .mapToDouble(text -> parseFiniteDouble(text, "element"))
                    .toArray();
        }
        System.out.println("Sequence: " + Arrays.toString(sequence));

        List<Extremum> maxima = findExtrema(sequence, true);
        List<Extremum> minima = findExtrema(sequence, false);

        System.out.println("Local maxima: " + maxima);
        System.out.println("Local minima: " + minima);
        System.out.println("Transitions from increasing to decreasing: " + maxima.size());
        System.out.println("Transitions from decreasing to increasing: " + minima.size());

        Fragment longest = longestIncreasing(sequence);
        double[] elements = Arrays.copyOfRange(sequence, longest.start(), longest.end() + 1);
        System.out.println("Longest strictly increasing fragment: " + Arrays.toString(elements));
        System.out.println("  indexes " + longest.start() + " - " + longest.end()
                + ", length " + longest.length());
    }

    private static List<Extremum> findExtrema(double[] a, boolean maximum) {
        return IntStream.range(1, a.length - 1)
                .filter(i -> maximum
                        ? a[i] > a[i - 1] && a[i] > a[i + 1]
                        : a[i] < a[i - 1] && a[i] < a[i + 1])
                .mapToObj(i -> new Extremum(i, a[i]))
                .toList();
    }

    private static Fragment longestIncreasing(double[] a) {
        int bestStart = 0;
        int bestLength = 1;
        int start = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                if (i - start + 1 > bestLength) {
                    bestLength = i - start + 1;
                    bestStart = start;
                }
            } else {
                start = i;
            }
        }
        return new Fragment(bestStart, bestStart + bestLength - 1);
    }

    private static double parseFiniteDouble(String text, String name) {
        try {
            double value = Double.parseDouble(text);
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException(name + " must be a finite number: " + text);
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(name + " must be a number: " + text, exception);
        }
    }
}

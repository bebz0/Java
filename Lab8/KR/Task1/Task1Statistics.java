// Task 1
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1Statistics {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java Task1Statistics <directory> <delta>");
        }

        Path root = Path.of(args[0]);
        double delta = parseFiniteDouble(args[1], "delta");
        if (delta < 0) {
            throw new IllegalArgumentException("delta must be non-negative.");
        }
        if (!Files.isDirectory(root)) {
            throw new IllegalArgumentException("Directory does not exist or is not a directory: " + root);
        }

        List<Path> files = findFiles(root);
        if (files.isEmpty()) {
            throw new IllegalArgumentException("No log*.txt files were found in " + root);
        }

        double[] values = files.stream()
                .flatMapToDouble(file -> readMeasurements(file).stream().mapToDouble(Double::doubleValue))
                .toArray();
        if (values.length == 0) {
            throw new IllegalArgumentException("The found files do not contain any measurements.");
        }

        DoubleSummaryStatistics statistics = Arrays.stream(values).summaryStatistics();
        double mean = statistics.getAverage();
        double[] sorted = Arrays.stream(values).sorted().toArray();
        double[] outliers = Arrays.stream(values)
                .filter(value -> Math.abs(value - mean) > delta)
                .toArray();

        System.out.println("Files:");
        files.forEach(file -> System.out.println("  " + file));
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Mean: " + mean);
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Values with |x - mean| > " + delta + ": " + Arrays.toString(outliers));

        if (statistics.getMin() == statistics.getMax()) {
            System.out.println("Mean without min and max: " + statistics.getMin()
                    + " (all values are equal)");
        } else if (sorted.length <= 2) {
            System.out.println("Mean without min and max can not be calculated: no values are left.");
        } else {
            double trimmedMean = Arrays.stream(sorted)
                    .skip(1)
                    .limit(sorted.length - 2)
                    .average()
                    .getAsDouble();
            System.out.println("Mean without min and max: " + trimmedMean);
        }
    }

    private static List<Path> findFiles(Path root) throws IOException {
        try (Stream<Path> paths = Files.walk(root)) {
            return paths.filter(path -> Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS))
                    .filter(Task1Statistics::isMeasurementFile)
                    .sorted()
                    .toList();
        } catch (UncheckedIOException exception) {
            throw new IOException("Cannot read directory: " + exception.getCause().getMessage(),
                    exception.getCause());
        }
    }

    private static boolean isMeasurementFile(Path path) {
        String name = path.getFileName().toString().toLowerCase(Locale.ROOT);
        return name.startsWith("log") && name.endsWith(".txt");
    }

    private static List<Double> readMeasurements(Path file) {
        List<String> lines;
        try (Stream<String> stream = Files.lines(file, StandardCharsets.UTF_8)) {
            lines = stream.toList();
        } catch (IOException | UncheckedIOException exception) {
            throw new IllegalArgumentException("Cannot read file " + file + ": " + exception.getMessage(),
                    exception);
        }

        return IntStream.range(0, lines.size())
                .filter(index -> !lines.get(index).isBlank())
                .mapToObj(index -> parseValue(file, index + 1, lines.get(index)))
                .toList();
    }

    private static double parseValue(Path file, int lineNumber, String line) {
        try {
            return parseFiniteDouble(line.trim(), "value");
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(file + ":" + lineNumber + ": " + exception.getMessage(),
                    exception);
        }
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

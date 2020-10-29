import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CalculateIngots {


    public static void main(String[] args) {
        long start = System.nanoTime();

        ArrayList<String> strings = new ArrayList<>();
        String fileName = "C:\\workspaces\\ChallangeProject\\src\\main\\resources\\input";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(strings::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        if (strings.size() > 1000) {
            strings.parallelStream().map(in -> new CalculateIngots()
                    .getEurosForIngots(Integer.parseInt(in)))
                    .forEach(System.out::println);
        } else {
            strings.forEach(s -> System.out.println(new CalculateIngots().getEurosForIngots(Integer.parseInt(s))));
        }

        long end = System.nanoTime();

        System.out.println("Processing Took " + (end - start) + "ns");
    }

    public long getEurosForIngots(int input_ingot) {

        double firstIngot = Math.round(input_ingot / 2);
        double secondIngot = Math.round(input_ingot / 3);
        double thridIngot = Math.round(input_ingot / 4);
        long eurosAfterSplit = (long) (firstIngot + secondIngot + thridIngot);
        return Math.max(input_ingot, eurosAfterSplit);
    }
}

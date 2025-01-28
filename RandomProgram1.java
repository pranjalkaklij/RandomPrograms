import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class RandomProgram1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println("Printing n = " + n);
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .limit(n)
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);
        bufferedReader.close();
    }

}

class Result {

    public static void plusMinus(List<Integer> arr) {
        ArrayList<Double> output = new ArrayList<>();

        output.add(arr.stream()
                .mapToInt(num -> num > 0 ? 1 : 0)
                .sum() / (double) arr.size());

        output.add(arr.stream()
                .mapToInt(num -> num < 0 ? 1 : 0)
                .sum() / (double) arr.size());

        output.add(arr.stream()
                .mapToInt(num -> num == 0 ? 1 : 0)
                .sum() / (double) arr.size());

        for (Double ratio : output) {
            System.out.println(String.format("%.6f", ratio));
        }
    }

}
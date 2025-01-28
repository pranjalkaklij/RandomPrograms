import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomProgram2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .limit(5)
                .map(Long::parseLong)
                .collect(toList());

        Result2.miniMaxSum(arr);

        bufferedReader.close();
    }
}

class Result2 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        Long array[] = new Long[arr.size()];
        array = arr.toArray(array);
        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;
        if (arr.size() == 5) {
            long count = 0;
            for (long i = 0; i < arr.size(); i++) {
                for (long j = 0; j < arr.size(); j++) {
                    if (i != j) {
                        count = count + array[(int) j];
                    }
                }
                if (maxSum < count) {
                    maxSum = count;
                }
                if (minSum > count) {
                    System.out.println(count);
                    minSum = count;
                }
                count = 0;
            }

            System.out.println(minSum + " " + maxSum);
        } else {
            System.out.println("Size of array should be 5");
        }
    }

}

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] count = new int[100];

        for (int num : arr) {
            count[num]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            while (count[i] > 0) {
                result.add(i);
                count[i]--;
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" ")) + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

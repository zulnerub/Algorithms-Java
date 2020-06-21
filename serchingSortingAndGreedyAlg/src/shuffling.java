import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class shuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        for (int rand : arr) {
            System.out.println(rand);
        }

    }

    private static int[] getAsRandom(int[] arr) {
        int[] result = new int[arr.length];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
           swap(arr, i, random.nextInt(arr.length));
        }

        return result;
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {

        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

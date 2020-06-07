import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum;

        sum = sumNumbers(arr, 0);

        System.out.println(sum);
    }

    private static int sumNumbers(int[] numbers, int index) {
        if (index >= numbers.length){
            return 0;
        }
        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}

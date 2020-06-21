import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class combinationWithoutRepetition {

    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        int k = Integer.parseInt(reader.readLine());

        arr = new int[k];

        combine(0, 1);
    }

    private static void combine(int index, int start) {
        if (index == arr.length){
            printArr();
        }else {
            for (int i = start; i <= n ; i++) {
                arr[index] = i;
                combine(index + 1, i + 1);
            }
        }
    }

    private static void printArr() {
        for (int number :
                arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

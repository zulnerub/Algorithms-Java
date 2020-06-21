import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class twoSorts {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(rd.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void sort(int[] arr){
      /*  for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            swap(arr, i, index);
        }*/

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }



    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

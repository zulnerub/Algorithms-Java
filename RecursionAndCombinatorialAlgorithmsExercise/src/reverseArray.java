import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = br.readLine().split("\\s+");

        printReversedArray(elements, elements.length - 1);
    }

    private static void printReversedArray(String[] elements, int index) {
        if (index < 0){
            return;
        }
        System.out.print(elements[index] + " ");
        printReversedArray(elements, index - 1);
    }
}

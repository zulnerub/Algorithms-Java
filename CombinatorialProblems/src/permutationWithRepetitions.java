import java.util.HashSet;
import java.util.Scanner;

public class permutationWithRepetitions {

    public static String[] elements;
    public static String[] permutes;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        elements = sc.nextLine().split("\\s+");
        permutes = new String[elements.length];
        used = new boolean[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length){
            print();
            return;
        }
        permute(index + 1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains(elements[i])){
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
                swapped.add(elements[i]);
            }

        }
    }

    private static void swap(String[] elements, int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }
}

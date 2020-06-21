import java.util.Scanner;

public class variationsWithRepetitions {
    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");

        int k = Integer.parseInt(sc.nextLine());
        variations = new String[k];

        variation(0);
    }

    private static void variation(int index) {
        if (index == variations.length){
            print(variations);
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            variations[index] = elements[i];
            variation(index + 1);
        }
    }

    private static void print(String[] variations) {
        System.out.println(String.join(" ", variations));
    }
}

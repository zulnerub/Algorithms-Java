import java.util.Scanner;

public class combinationsWithRepetitions {

    public static String[] elements;
    public static String[] variations;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");

        int k = Integer.parseInt(sc.nextLine());
        variations = new String[k];

        combination(0, 0);
    }

    private static void combination(int index, int start) {
        if (index == variations.length){
            print(variations);
        }else {
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combination(index + 1, i);
            }
        }
    }

    private static void print(String[] variations) {
        System.out.println(String.join(" ", variations));
    }
}

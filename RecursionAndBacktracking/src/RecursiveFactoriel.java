import java.util.Scanner;

public class RecursiveFactoriel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        long result = calculateFactorial(n);

        System.out.println(result);
    }

    private static long calculateFactorial(int n) {

        if (n == 0){
            return 1;
        }

        return n * calculateFactorial(n - 1);

    }
}

import java.util.Scanner;

public class recursiveFibonacci {
        static long fibonacci(int n) {
            if (n <= 1){
                return 1;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println(fibonacci(Integer.parseInt(sc.nextLine())));
        }
}

import java.util.*;

public class MoveDownRight {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[rows][cols];

        dp[0][0] = matrix[0][0];

        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++){
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col] + matrix[row][col],
                        dp[row][col - 1] + matrix[row][col]);
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(row, col));

        while (row > 0 || col > 0){
            int top = -1;
            int left = -1;

            if (col > 0){
                left = dp[row][col - 1];
            }

            if (row > 0){
                top = dp[row - 1][col];
            }


            if (top > left){
                row--;
            }else {
                col--;
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);
        path.forEach(e -> System.out.print(e + " "));

    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}

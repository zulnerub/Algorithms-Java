import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salaries {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static int totalSalaries = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employees = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < employees; i++){
            graph.add(new ArrayList<>());
            String line = sc.nextLine();

            for (int emp = 0; emp < line.length(); emp++) {
                if (line.charAt(emp) == 'Y'){
                    graph.get(i).add(emp);
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            dfs(i);
        }

        System.out.println(totalSalaries);
    }

    private static void dfs(int index) {
        if (index > graph.size()){
            return;
        }
        if (graph.get(index).size() == 0){
            totalSalaries++;
            return;
        }
        for (int i = 0; i < graph.get(index).size(); i++) {
            dfs(graph.get(index).get(i));
        }
    }
}

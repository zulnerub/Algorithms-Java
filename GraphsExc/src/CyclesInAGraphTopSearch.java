import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CyclesInAGraphTopSearch {
    public static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String line = sc.readLine();
        String source = null;

        while (!line.equals("End")){
            String[] tokens = line.split("-");
            source = tokens[0];

            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);

            line = sc.readLine();
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();

        try {
            dfs(source, visited, cycles);
            System.out.println("Acyclic: Yes");
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)){
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source) || !graph.containsKey(source)){
            return;
        }

        cycles.add(source);
        visited.add(source);

        for (String child: graph.get(source)){
            dfs(child, visited, cycles);
        }
        cycles.remove(source);
    }
}

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;


    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(System.in)
        );

        people = Arrays.stream(rd.readLine().split(",\\s+")).collect(Collectors.toList());

        seats = new String[people.size()];

        String line = rd.readLine();

        while (!line.equals("generate")){
            String[] tokens = line.split(" - ");

            String name = tokens[0];
            int position = Integer.parseInt(tokens[1]) - 1;

            seats[position] = name;

            people.remove(name);

            line = rd.readLine();
        }
        
        combinations = new String[people.size()];
        used = new boolean[people.size()];
        
        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length){
            print();
        }else{
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]){
                    used[i] = true;
                    combinations[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        String[] out = new String[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != null){
                out[i] = seats[i];
            }else {
                out[i] = combinations[index++];
            }
        }
        System.out.println(String.join(" ", out));
    }
}

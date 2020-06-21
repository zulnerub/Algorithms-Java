import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class schoolTeams {

    public static String[] girls;
    public static String[] girlsCombinations = new String[3];
    public static String[] boys;
    public static String[] boysCombinations = new String[2];

    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        girls = rd.readLine().split(", ");
        boys = rd.readLine().split(", ");

        combineGirls(0, 0);
        combineBoys(0, 0);
        print();
    }

    private static void print() {
        for (String allGirl : allGirls) {
            for (String allBoy : allBoys) {
                System.out.println(allGirl + ", " + allBoy);
            }
        }
    }

    private static void combineGirls(int index, int start) {
        if (index == girlsCombinations.length){
            allGirls.add(String.join(", ", girlsCombinations));
        }else {
            for (int i = start; i < girls.length; i++) {
                girlsCombinations[index] = girls[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }

    private static void combineBoys(int index, int start) {
        if (index == boysCombinations.length){
            allBoys.add(String.join(", ", boysCombinations));
        }else {
            for (int i = start; i < boys.length; i++) {
                boysCombinations[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }
}

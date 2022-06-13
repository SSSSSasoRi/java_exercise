package Exercise66_76;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Exercise67 {
    public static void main(String[] args) {
        ArrayList<String> idList = new ArrayList<String>(Arrays.asList("A100", "B101", "C102", "D103", "E104", "F105",
                "G106", "H107", "I108", "J109", "K110", "L111", "M112", "N113", "O114", "P115", "Q116", "R117", "S118",
                "T119", "U120", "V121", "W122", "X123", "Y124", "Z125"));
        Collections.shuffle(idList);

        ArrayList<String> bingo = new ArrayList<>();

        Random r = new Random();
        int min = 1;
        int max = idList.size();
        int numberOfTarget = r.nextInt(max - min + 1) + min;
        for (int i = 0; i < numberOfTarget; i++) {
            bingo.add(idList.get(i));
        }
        System.out.println(bingo);
    }
}

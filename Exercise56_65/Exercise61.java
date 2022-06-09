package Exercise56_65;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exercise61 {
    public static void main(String[] args) {
        File file = new File("C:/Users/User/Desktop/61ひみつ道具一覧.txt");

        if (!file.exists()) {
            System.out.println("ファイルが存在しません。");
            return;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> propList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                propList.add(line);
            }
            br.close();

            Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine()) {
                String input = scan.nextLine();
                if (input.equals("end")) {
                    break;
                }
                if (input.equals("")) {
                    int r = new Random().nextInt(100);
                    System.out.println(propList.get(r) + "～");
                }
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

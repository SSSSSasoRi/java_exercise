package Exercise66_75;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise67 {
    public static void main(String[] args) {
        List<String> idList = new ArrayList<>();
        File fApp = new File("C:/Users/User/Desktop/appList.txt");

        // 『応募者ID一覧』を読み込んで、リスト化する
        try {
            BufferedReader textFile = new BufferedReader(new InputStreamReader(new FileInputStream(fApp), "UTF-8"));
            String line = "";
            int index = 0;
            while ((line = textFile.readLine()) != null) {
                if (index++ == 0) {
                    continue;
                }
                String[] appArr = line.split(",");
                for (int i = 0; i < appArr.length; i++) {
                    idList.add(appArr[i]);
                }
            }
            textFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(idList);
        List<String> bingo = new ArrayList<>();

        Random r = new Random();
        int min = 1;
        int max = idList.size();
        int numberOfTarget = r.nextInt(max - min + 1) + min;
        for (int i = 0; i < numberOfTarget; i++) {
            bingo.add(idList.get(i));
        }
        System.out.println("抽選結果を発表します：");
        System.out.println(bingo);
    }
}

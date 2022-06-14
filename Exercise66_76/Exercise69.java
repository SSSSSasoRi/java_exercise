package Exercise66_76;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise69 {
    public static void main(String[] args) {
        List<String> idList = new ArrayList<>();
        List<String> blackList = new ArrayList<>();
        List<String> priorityList = new ArrayList<>();

        File fApp = new File("C:/Users/User/Desktop/appList.txt");
        File fBlack = new File("C:/Users/User/Desktop/blackList.txt");
        File fPriority = new File("C:/Users/User/Desktop/priorityList.txt");

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

        // 『ブラックリスト』を読み込んで、リスト化する
        try {
            BufferedReader textFile = new BufferedReader(new InputStreamReader(new FileInputStream(fBlack), "UTF-8"));
            String line = "";
            int index = 0;
            while ((line = textFile.readLine()) != null) {
                if (index++ == 0) {
                    continue;
                }
                String[] blackArr = line.split(",");
                for (int i = 0; i < blackArr.length; i++) {
                    blackList.add(blackArr[i]);
                }
            }
            textFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 『プライオリティリスト』を読み込んで、リスト化する
        try {
            BufferedReader textFile = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fPriority), "UTF-8"));
            String line = "";
            int index = 0;
            while ((line = textFile.readLine()) != null) {
                if (index++ <= 4) {
                    continue;
                }
                String[] priorityArr = line.split(",");
                for (int i = 0; i < priorityArr.length; i++) {
                    priorityList.add(priorityArr[i].substring(0, 5));
                }
            }
            textFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ブラックリストに存在する応募者IDを抽選対象から除外する
        for (int j = 0; j < idList.size(); j++) {
            for (int k = 0; k < blackList.size(); k++) {
                if (idList.get(j).equals(blackList.get(k))) {
                    idList.remove(j);
                }
            }
        }

        // プライオリティリストに存在する応募者IDを重複なしに応募者リストに追加する
        List<String> targetList = Stream.concat(idList.stream(), priorityList.stream()).distinct()
                .collect(Collectors.toList());

        // 画面に抽選対象の応募者IDを出力する
        System.out.println("抽選対象となる応募者のIDは下記の通りです：");
        System.out.println(targetList);

        // 各応募者のプライオリティをリストで格納する
        List<Integer> weight = new ArrayList<Integer>(
                Arrays.asList(5, 1, 1, 4, 4, 1, 2, 1, 1, 3, 1, 1, 4, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 5));

        List<String> bingo = new ArrayList<>();

        int min = 1;
        int max = idList.size();
        int numberOfTarget = new Random().nextInt(max - min + 1) + min;
        for (int i = 0; i < numberOfTarget; i++) {
            int index = random(weight);
            bingo.add(targetList.get(index) + "(" + weight.get(index) + ")");
            targetList.remove(index);
            weight.remove(index);
        }
        System.out.println("抽選結果を発表します：");
        System.out.println(bingo);
    }

    public static int random(List<Integer> weight) {
        List<Integer> weightTmp = new ArrayList<Integer>(weight.size() + 1);
        weightTmp.add(0);
        int sum = 0;
        for (int d : weight) {
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        for (int i = weightTmp.size() - 1; i > 0; i--) {
            if (rand >= weightTmp.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

package Exercise56_65;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise65 {
    public static void main(String[] args) {
        System.out.println("「翻訳リストを表示する：1」");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input != 1) {
            System.out.println("無効な入力値です。終了します。");
        } else {
            System.out.println("-------------------------");
            System.out.println("   英単語   |   日本語   ");
            System.out.println("-------------------------");
            File csv = new File("C:/Users/User/Desktop/honyaku.csv");
            try {
                BufferedReader textFile = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
                String line = "";
                while ((line = textFile.readLine()) != null) {
                    System.out.println(strFormat(line));
                    System.out.println("-------------------------");
                }
                textFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("指定されたファイルが見つかりません。");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scan.close();
    }

    static String strFormat(String str) {
        // 翻訳リストの各行の書式を整える
        List<String> words = Arrays.asList(str.split(","));
        String space = " ";
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        if (words.get(0).length() <= 12) {
            for (int j = 0; j < 12 - words.get(0).length(); j++) {
                sb.append(space);
            }
        }
        sb.append("|");
        sb.append(words.get(1));
        String result = sb.toString();
        return result;
    }
}

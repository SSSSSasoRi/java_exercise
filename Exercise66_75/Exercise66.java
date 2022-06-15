package Exercise66_75;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercise66 {
    public static void main(String[] args) {
        File csv = new File("C:/Users/User/Desktop/honyaku.csv");
        Scanner scan = new Scanner(System.in);

        System.out.println("翻訳リストを表示する：1");
        System.out.println("翻訳する：2");
        int input = scan.nextInt();

        if (input == 1) {
            // 翻訳リストを表示する
            System.out.println("-------------------------");
            System.out.println("   英単語   |   日本語   ");
            System.out.println("-------------------------");
            try {
                BufferedReader textFile = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
                String lineData = "";
                while ((lineData = textFile.readLine()) != null) {
                    System.out.println(strFormat(lineData));
                    System.out.println("-------------------------");
                }
                textFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("指定されたファイルが見つかりません。");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (input == 2) {
            // 翻訳する
            System.out.println("日本語の文章を入力してください：");
            String jaString = scan.next();
            System.out.println("翻訳結果：");

            HashMap<String, String> wordMap = new HashMap<>();
            try {
                BufferedReader textFile = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
                String lineData = "";
                while ((lineData = textFile.readLine()) != null) {
                    List<String> words = Arrays.asList(lineData.split(","));
                    wordMap.put(words.get(1), words.get(0));
                }
                textFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("指定されたファイルが見つかりません。");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (jaString.contains("１月") || jaString.contains("1月")) {
                jaString = jaString.replaceAll("１月", wordMap.get("１月"));
                jaString = jaString.replaceAll("1月", wordMap.get("１月"));
            }
            if (jaString.contains("２月") || jaString.contains("2月")) {
                jaString = jaString.replaceAll("２月", wordMap.get("２月"));
                jaString = jaString.replaceAll("2月", wordMap.get("２月"));
            }
            if (jaString.contains("３月") || jaString.contains("3月")) {
                jaString = jaString.replaceAll("３月", wordMap.get("３月"));
                jaString = jaString.replaceAll("3月", wordMap.get("３月"));
            }
            if (jaString.contains("４月") || jaString.contains("4月")) {
                jaString = jaString.replaceAll("４月", wordMap.get("４月"));
                jaString = jaString.replaceAll("4月", wordMap.get("４月"));
            }
            if (jaString.contains("５月") || jaString.contains("5月")) {
                jaString = jaString.replaceAll("５月", wordMap.get("５月"));
                jaString = jaString.replaceAll("5月", wordMap.get("５月"));
            }
            if (jaString.contains("６月") || jaString.contains("6月")) {
                jaString = jaString.replaceAll("６月", wordMap.get("６月"));
                jaString = jaString.replaceAll("6月", wordMap.get("６月"));
            }
            if (jaString.contains("７月") || jaString.contains("7月")) {
                jaString = jaString.replaceAll("７月", wordMap.get("７月"));
                jaString = jaString.replaceAll("7月", wordMap.get("７月"));
            }
            if (jaString.contains("８月") || jaString.contains("8月")) {
                jaString = jaString.replaceAll("８月", wordMap.get("８月"));
                jaString = jaString.replaceAll("8月", wordMap.get("８月"));
            }
            if (jaString.contains("９月") || jaString.contains("9月")) {
                jaString = jaString.replaceAll("９月", wordMap.get("９月"));
                jaString = jaString.replaceAll("9月", wordMap.get("９月"));
            }
            if (jaString.contains("１０月") || jaString.contains("10月")) {
                jaString = jaString.replaceAll("１０月", wordMap.get("１０月"));
                jaString = jaString.replaceAll("10月", wordMap.get("１０月"));
            }
            if (jaString.contains("１１月") || jaString.contains("11月")) {
                jaString = jaString.replaceAll("１１月", wordMap.get("１１月"));
                jaString = jaString.replaceAll("11月", wordMap.get("１１月"));
            }
            if (jaString.contains("１２月") || jaString.contains("12月")) {
                jaString = jaString.replaceAll("１２月", wordMap.get("１２月"));
                jaString = jaString.replaceAll("12月", wordMap.get("１２月"));
            }

            for (String key : wordMap.keySet()) {
                if (jaString.contains(key)) {
                    jaString = jaString.replaceAll(key, wordMap.get(key));
                }
            }
            System.out.println(jaString);

        } else {
            // 1、2以外が入力された場合
            System.out.println("無効な入力値です。終了します。");
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
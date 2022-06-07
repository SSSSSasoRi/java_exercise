package Exercise36_55;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "SHIFT-JIS");
        System.out.println("指定ファイルに追記したい内容を入力してください：");
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:/Users/User/Desktop/sample/test.txt", true), "UTF-8")));
            while (scan.hasNext()) {
                String input = scan.nextLine();
                if (input.equals("end")) {
                    pw.close();
                    break;
                } else {
                    pw.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }
}

package Exercise36_55;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Exercise49 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in, "SHIFT-JIS");
        System.out.println("ファイルパスを指定してください：");
        String file = scan.nextLine();

        System.out.println("テキストを入力してください：");
        try {
            PrintWriter pw = new PrintWriter(file, Charset.forName("UTF-8"));
            while (scan.hasNextLine()) {
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
package Exercise36_55;

import java.io.File;
import java.util.Scanner;

public class Exercise47 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("パスを指定してください：");
        String path = scan.nextLine();
        File file = new File(path);

        if (file.mkdir()) {
            System.out.println("フォルダを新規作成しました。");
        } else {
            System.out.println("フォルダの作成に失敗しました。");
        }

        scan.close();
    }
}

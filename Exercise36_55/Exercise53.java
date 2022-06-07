package Exercise36_55;

import java.io.File;
import java.util.Scanner;

public class Exercise53 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("確認したいフォルダのパスを入力してください：");
        String path = scan.nextLine();

        File file = new File(path);
        File[] fileList = file.listFiles();

        System.out.println("指定したフォルダ直下のフォルダ・ファイルは下記の通りです：");
        if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                System.out.println(fileList[i].getName());
            }
        }
        scan.close();
    }
}

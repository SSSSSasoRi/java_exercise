package Exercise36_55;

import java.io.File;
import java.util.Scanner;

public class Exercise48 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ファイルパスを入力してください：");
        String path = scan.nextLine();
        File dir = new File(path);
        scan.close();

        if (dir.exists()) {
            if (dir.delete()) {
                System.out.println("ファイル削除成功");
            } else {
                System.out.println("ファイル削除失敗");
            }
        } else {
            System.out.println("指定したファイルは存在しません。");
        }
    }
}

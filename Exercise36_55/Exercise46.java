package Exercise36_55;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise46 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ファイルパスを指定してください：");
        String strPath = scan.nextLine();
        Path path = Paths.get(strPath);
        searchFile(path);

        scan.close();
    }

    private static void searchFile(Path p) {
        System.out.print(p.getFileName() + "は");
        if (Files.exists(p)) {
            System.out.println("存在します。");
        } else {
            System.out.println("存在しません。");
        }
    }
}

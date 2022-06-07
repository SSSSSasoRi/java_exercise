package Exercise36_55;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Exercise55 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("フォルダパスを入力してください：");
        String path = scan.nextLine();

        System.out.println("ファイル一覧を出力します…");
        getDirectory(path);
        System.out.println("出力完了");

        scan.close();
    }

    public static void getDirectory(String path) {
        Path dirpath = Paths.get(path);

        try (Stream<Path> stream = Files.walk(dirpath, 10)) {
            stream.forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

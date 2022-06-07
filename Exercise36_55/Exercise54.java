package Exercise36_55;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Exercise54 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("コピー元パスを指定してください：");
        String from = scan.nextLine();
        System.out.println("コピー先パスを指定してください：");
        String to = scan.nextLine();

        System.out.println("フォルダコピー開始");
        File srcFolder = new File(from);
        File destFolder = new File(to);

        if (!srcFolder.exists()) {
            System.out.println("指定したフォルダは存在しません");
            System.exit(0);
        } else {
            try {
                copyFolder(srcFolder, destFolder);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        System.out.println("フォルダコピー完了");
        scan.close();
    }

    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from" + src + "to" + dest);
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("File copied from" + src + "to" + dest);
        }
    }
}

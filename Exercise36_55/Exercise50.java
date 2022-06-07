package Exercise36_55;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise50 {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/User/Desktop/sample/test.txt");

            if (!file.exists()) {
                System.out.println("ファイルが存在しません。");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

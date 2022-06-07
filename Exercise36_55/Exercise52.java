package Exercise36_55;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Exercise52 {
    public static void main(String[] args) throws IOException {
        setProperties();

        Properties settings = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("foo.properties");
            settings.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        String country = settings.getProperty("country");
        System.out.println("国名：" + country);

        String lang = settings.getProperty("language");
        System.out.println("使用言語：" + lang);

        String popu = settings.getProperty("population size");
        System.out.println("人口数：" + popu);

        String area = settings.getProperty("land area");
        System.out.println("国土面積：" + area);
    }

    private static void setProperties() throws IOException {
        Properties settings = new Properties();
        settings.setProperty("country", "中国");
        settings.setProperty("language", "中国語");
        settings.setProperty("population size", "14億");
        settings.setProperty("land area", "9600000km");

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("foo.properties");
            settings.store(out, "Foo Properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

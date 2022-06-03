package Exercise01_35;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise22 {
    public static void main(String[] args) {
        String str = "abc123def456abc123def456abc123def456";
        String target1 = "e";
        String target2 = "5";

        String[] strArray = str.split("");
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strArray));
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).equals(target1) || strList.get(i).equals(target2)) {
                strList.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String x : strList) {
            sb.append(x);
        }
        System.out.println(sb.toString());
    }
}

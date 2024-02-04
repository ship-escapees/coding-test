import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {

            public int compare(String o1, String o2) {
                String[] o1_split = detach(o1);
                String[] o2_split = detach(o2);

                int headValue = o1_split[0].compareTo(o2_split[0]);
                if(headValue == 0) {
                    int num1 = Integer.parseInt(o1_split[1]);
                    int num2 = Integer.parseInt(o2_split[1]);
                    return num1 - num2;
                } else {
                    return headValue;
                }
            }

            private String[] detach(String str) {
                String head = str.split("[0-9]")[0];
                str = str.replace(head, "");
                head = head.toUpperCase();

                Pattern p = Pattern.compile("\\d{1,5}");
                Matcher m = p.matcher(str);
                String number = "";
                if(m.find()) {
                    number = m.group();
                }
                str = str.replace(number, "");
                return new String[]{head, number, str};
            }
        });

        return files;
    }
}
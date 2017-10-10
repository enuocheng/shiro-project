package cn.mycloudedu.framework.core.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Cailin.Chen
 * @Date 15/8/19
 * @eMail cailin618@sina.com
 */

public class StringUtil {

    public static String string2stringArray(String str) {
        String result = "[";
        result += '"' + str + '"';
        return result + "]";
    }

    /**
     * 半角转全角
     *
     * @param input String.
     * @return 全角字符串.
     */
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     *
     * @param input String.
     * @return 半角字符串
     */
    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    /**
     * 中英文字符串的字符数
     *
     * @param str 字符串的长度
     * @return 字符个数
     */

    public static int stringLength(String str) {
        if (str==null){
            return 0;
        }
        int length = 0;
        String chinese = "[\u4e00-\u9fa5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < str.length(); i++) {
            /* 获取一个字符 */
            String temp = str.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                length += 2;
            } else {
                /* 其他字符长度为1 */
                length += 1;
            }
        }
        return length;
    }

    public static String removeSpaces(String str) {
        return (str == null || "".equals(str)) ? "" : str.replaceAll("\\s*", "");
    }

    public static String jsonToString(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(removeSpaces(str));
    }
}

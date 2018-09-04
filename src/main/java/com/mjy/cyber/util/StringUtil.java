package com.mjy.cyber.util;

public class StringUtil {

    public static String[] toStringArray(String string) {

        char[] chars = string.toCharArray();
        String[] stringArray = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            stringArray[i] = chars[i] + "";
        }
        return stringArray;
    }

    public static int toIntValue(String str) {

        return Integer.valueOf(str);
    }

    /**
     * 替换某位index的字符串
     *
     * @param str 原始字符串
     * @param index 被替换位置
     * @param replacedLength 被替换长度
     * @param replaceContent 新字符串
     * @return
     */
    public static String replaceIndex(String str, int index, int replacedLength, String replaceContent) {

        return str.substring(0, index) + replaceContent + str.substring(index + replacedLength);
    }

    public static String replaceIndex(String str, int index, String replaceContent) {

        return replaceIndex(str, index, 1, replaceContent);
    }

    public static void main(String[] args) {

        String str = "abcdefghijkabcddeeffg";
        System.err.println(replaceIndex(str, 5, "哈哈"));
    }

    public static String splicing(String[] split) {

        StringBuilder strBuilder = new StringBuilder();
        for (String str : split) {
            strBuilder.append(str);
        }
        return strBuilder.toString();
    }
}

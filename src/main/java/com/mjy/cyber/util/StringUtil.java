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

    public static int toIntValue(String str){
        return Integer.valueOf(str);
    }

}

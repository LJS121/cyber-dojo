package com.mjy.cyber;

public class Unsplice {

    private static String backslash = "\\\n";
    private static String backslash_regex = "\\\\\\n";

    public static String of(String str) {
        if (str.contains(backslash)) {
            int time = 0;
            while (str.contains(backslash)) {
                time++;
                str = str.replaceFirst(backslash_regex, "");
            }
            return String.format("\"%s\" (%s stripped out)", str, time);
        }else{

        }



        return null;
    }

}

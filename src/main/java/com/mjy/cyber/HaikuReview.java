package com.mjy.cyber;

import java.util.Arrays;
import java.util.List;

public class HaikuReview {

    private final static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

    public static void checkHaikuReview(String input) {
        Arrays.stream(input.toLowerCase().split("\n")).forEach(inputLine -> checkLineHaiku(inputLine));
    }

    private static boolean checkLineHaiku(String inputLine) {
        String[] inputStrs = inputLine.toLowerCase().split("/");
        int num1 = findVowelsNum(inputStrs[0]);
        int num2 = findVowelsNum(inputStrs[1]);
        int num3 = findVowelsNum(inputStrs[2]);
        if (num1 == 5 && num2 == 7 && num3 == 5) {
            System.out.println("5,7,5,Yes");
        } else {
            System.out.println(String.format("%s,%s,%s,No", num1, num2, num3));
        }
        return (num1 == 5 && num2 == 7 && num3 == 5) ? true : false;
    }

    private static int findVowelsNum(String inputStr) {
        char[] charArray = inputStr.toCharArray();
        int vowelCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (vowels.contains(charArray[i])) {
                if (i == 0) {
                    vowelCount++;
                } else if (!vowels.contains(charArray[i - 1])) {
                    vowelCount++;
                }
            }
        }
        return vowelCount;
    }

}

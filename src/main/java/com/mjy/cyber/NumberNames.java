package com.mjy.cyber;

import java.util.HashMap;
import java.util.Map;

public class NumberNames {

    private static final Map<Integer, String> map = new HashMap<Integer, String>() {

        {
            put(0, "zero");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put(14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(30, "thirty");
            put(40, "fourty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");
            put(100, "hundred");
            put(1000, "thousand");
        }
    };

    private static final String HUNDRED = "hundred";

    private static final String THOUSAND = "thousand";

    private static final String MILLION = "million";

    private static final String SPACE = " ";

    public static String getNumberName(int number) {

        switch (getNumberLength(number)) {
            case 1:
                return map.get(number);
            case 2:
                if (ifWholeTimes(number) || number < 20) {
                    return map.get(number);
                } else {
                    return map.get(number / getNumberBase(number) * getNumberBase(number)) + SPACE
                                    + getNumberName(number % getNumberBase(number));
                }
            case 3:
                if (ifWholeTimes(number)) {
                    return map.get(number / getNumberBase(number)) + SPACE + HUNDRED;
                } else {
                    return getNumberName(number / getNumberBase(number) * getNumberBase(number)) + " and "
                                    + getNumberName(number % getNumberBase(number));
                }
            case 4:
            case 5:
            case 6:
                if (ifWholeTimes(number)) {
                    return getNumberName(number / getNumberBase(number)) + SPACE + THOUSAND;
                } else {
                    return recursionNumberNames(number);
                }
            case 7:
            case 8:
            case 9:
                if (ifWholeTimes(number)) {
                    return getNumberName(number / getNumberBase(number)) + SPACE + MILLION;
                } else {
                    return recursionNumberNames(number);
                }
            default:
                return "";
        }

    }

    private static boolean ifWholeTimes(int number) {

        return number % getNumberBase(number) == 0;
    }

    private static String recursionNumberNames(int number) {

        return getNumberName(number / getNumberBase(number) * getNumberBase(number)) + ", " + getNumberName(number % getNumberBase(number));
    }

    private static int getNumberBase(int number) {

        switch (getNumberLength(number)) {
            case 2:
                return 10;
            case 3:
                return 100;
            case 4:
                return 1000;
            case 5:
                return 1000;
            case 6:
                return 1000;
            case 7:
                return 1000000;
            case 8:
                return 1000000;
            case 9:
                return 1000000;
            default:
                return 1;
        }
    }

    private static int getNumberLength(int number) {

        return ("" + number).length();
    }
}

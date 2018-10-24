package com.mjy.cyber;

import java.util.Map;

import com.google.common.collect.Maps;

public class RomanNumerals {

    private static final Map<Integer, String> map = Maps.newHashMap();

    static {
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");
        map.put(4000, "MMMM");
    }

    public static String of(int number) {
        if (number <= 0) {
            return "";
        }
        int power = getPower(number);
        if (number % Math.pow(10, power) == 0) {
            return map.get(number);
        } else {
            return getBaseValue(number / getPowNum(power) * getPowNum(power)) + of(number % getPowNum(power));
        }
    }

    private static int getPowNum(int power) {
        return new Double(Math.pow(10, power)).intValue();
    }

    private static int getPower(int number) {
        if (number < 10) {
            return 0;
        }
        int pow = 1;
        for (int i = 10; i <= number; i = i * 10) {
            if (i * 10 > number) {
                return pow;
            } else {
                pow++;
            }
        }
        return pow;
    }

    public static String getBaseValue(int num) {
        return map.get(num) == null ? "" : map.get(num);
    }

}

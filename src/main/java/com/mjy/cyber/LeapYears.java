package com.mjy.cyber;

public class LeapYears {

    public static boolean checkLeapYears(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

}

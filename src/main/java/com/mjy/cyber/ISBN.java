package com.mjy.cyber;

import junit.framework.Assert;

public class ISBN {

    public static boolean checkISBN(String code) {
        Assert.assertNotNull(code);
        code = formatCode(code);
        String checkDigit = getCheckDigit(code);

        return checkDigitIndex(code, checkDigit);
    }

    private static boolean checkDigitIndex(String code, String checkDigit) {
        return code.endsWith(checkDigit);
    }

    private static String formatCode(String code) {
        return code.replaceAll(" ", "").replaceAll("-", "");
    }

    private static String getCheckDigit(String code) {
        int digit = 0;
        char[] chars = code.toCharArray();
        if (code.length() == 10) {
            for (int i = 0; i < chars.length - 1; i++) {
                digit += (i + 1) * Integer.valueOf(chars[i] + "");
            }
            digit = Math.floorMod(digit, 11);
        } else if (code.length() == 13) {
            for (int i = 0; i < chars.length - 1; i++) {
                if (i % 2 == 0) {
                    digit += 1 * Integer.valueOf(chars[i] + "");
                } else {
                    digit += 3 * Integer.valueOf(chars[i] + "");
                }
            }
            digit = Math.floorMod(digit, 10);
            digit = Math.floorMod(digit, 10);
        }
        return digit == 10 ? "x" : digit + "";
    }

}

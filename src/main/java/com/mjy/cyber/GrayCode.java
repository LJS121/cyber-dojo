package com.mjy.cyber;

public class GrayCode {

    public static int strLength = 6;

    /**
     * if b[i-1] = 1
     * g[i] = not b[i]
     * else
     * g[i] = b[i]
     *
     * @param binary
     * @return
     */
    public static int[] encodeGrayCode(int[] binary) {
        int[] grayArr = new int[binary.length];
        for (int i = 1; i < binary.length; i++) {
            if (binary[i - 1] == 1) {
                grayArr[i] = not(binary[i]);
            } else {
                grayArr[i] = binary[i];
            }
        }
        return dropPreZero(grayArr);
    }

    /**
     * b[0] = g[0]
     * for other bits:
     * b[i] = g[i] xor b[i-1]
     *
     * @param grayCode
     * @return
     */
    public static int[] decodeGrayCode(int[] grayCode) {
        grayCode = addPreZero(grayCode);
        int[] binary = new int[strLength];
        binary[0] = grayCode[0];
        for (int i = 1; i < binary.length; i++) {
            binary[i] = grayCode[i] ^ binary[i - 1];
        }
        return binary;
    }

    private static int[] addPreZero(int[] grayCode) {
        int[] tempArr = new int[strLength];
        int preZeroNum = 0;
        for (int i = 0; i < tempArr.length; i++) {
            if (i + grayCode.length < tempArr.length) {
                tempArr[i] = 0;
                preZeroNum++;
            } else {
                tempArr[i] = grayCode[i - preZeroNum];
            }
        }
        return tempArr;
    }

    private static int[] dropPreZero(int[] grayArr) {
        int firstIndex = 0;
        for (int i = 0; i < grayArr.length; i++) {
            if (grayArr[i] != 0) {
                firstIndex = i;
                break;
            }
        }
        int[] tempArr = new int[grayArr.length - firstIndex];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = grayArr[i + firstIndex];
        }
        return tempArr;
    }

    private static int not(int value) {
        return value == 0 ? 1 : 0;
    }


}

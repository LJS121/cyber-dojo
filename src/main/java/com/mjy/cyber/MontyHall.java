package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.mjy.cyber.util.MathUtil;

public class MontyHall {

    public static void montyHall() {

        for (int i = 0; i < 1000; i++) {
            simulationOnce();
        }

    }

    private static void simulationOnce() {

        int[] ints = new int[3];
        ints[MathUtil.randomInt(3)] = 1;
        int firstChoose = MathUtil.randomInt(3);
        int hostChoose = createHostChoose(ints, firstChoose);
        int thirdChoose = createThirdChoose(ints, firstChoose, hostChoose);
        System.err.println(String.format("doors is %s, first time choosed No.%s, host choosed No.%s, finally player choosed No.%s, %s。",
            JSONObject.toJSONString(ints), firstChoose + 1, hostChoose + 1, thirdChoose + 1,
            ints[thirdChoose] == 1 ? "got a car" : "got a goat"));
    }

    private static int createHostChoose(int[] ints, int firstChoose) {

        int hostChoose = 0;
        if (ints[firstChoose] == 1) {
            do {
                hostChoose = MathUtil.randomInt(3);
            } while (hostChoose == firstChoose);
            return hostChoose;
        } else {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 0 && i != firstChoose) {
                    return i;
                }
            }
        }
        return hostChoose;
    }

    private static Integer createThirdChoose(int[] ints, int firstChoose, int hostChoose) {

        boolean ifChooseThird = MathUtil.randomInt(2) == 1 ? true : false;
        if (ifChooseThird) {
            for (int i = 0; i < ints.length; i++) {
                if (i != firstChoose && i != hostChoose) {
                    return i;
                }
            }
        } else {
            return firstChoose;
        }
        return null;
    }

}

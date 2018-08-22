package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Diversion {

    private String binarySequences;


    public int diversion(int digit) {
        this.binarySequences = initBinarySequences(digit);
        System.err.println(JSONObject.toJSONString(this.binarySequences));
        String[] splits = this.binarySequences.split(",");
        int countDouble = 0;
        for (int i = 0; i < splits.length; i++) {
            if (!splits[i].contains("11")) {
                countDouble++;
            }
        }
        return countDouble;
    }

    private String initBinarySequences(int digit) {
        this.binarySequences = "";
        for (int i = 0; i < Math.pow(2, digit); i++) {
            String tempBinaryString = Integer.toBinaryString(i);
            while (tempBinaryString.length() < digit) {
                tempBinaryString = "0" + tempBinaryString;
            }
            this.binarySequences += tempBinaryString + ", ";
        }

        return this.binarySequences.substring(0, this.binarySequences.length() - 2);
    }

}

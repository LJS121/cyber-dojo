package com.mjy.cyber;

import java.util.List;

public class ClosestToZero {

    private int minAbsValue;

    public int findClosestToZero(List<Integer> integerList) {
        this.minAbsValue = Math.abs(integerList.get(0));
        integerList.stream().forEach(value -> this.minAbsValue = Math.abs(value) >= this.minAbsValue ? this.minAbsValue : Math.abs(value));

        if (integerList.contains(this.minAbsValue)) {
            return this.minAbsValue;
        } else {
            return -this.minAbsValue;
        }

    }

}

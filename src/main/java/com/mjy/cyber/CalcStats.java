package com.mjy.cyber;

import java.math.BigDecimal;
import java.util.List;

public class CalcStats {

    private int minValue = 0;
    private int maxValue = 0;
    private int sumValue = 0;

    public int minimumValue(List<Integer> integerList) {
        this.minValue = integerList.get(0);
        integerList.stream().forEach(value -> this.minValue = (value >= this.minValue) ? this.minValue : value);
        return this.minValue;
    }

    public int maximumValue(List<Integer> integerList) {
        this.maxValue = integerList.get(0);
        integerList.stream().forEach(value -> this.maxValue = (value <= this.maxValue) ? this.maxValue : value);
        return this.maxValue;
    }

    public int elementCount(List<Integer> integerList) {
        return integerList.size();
    }

    public BigDecimal averageValue(List<Integer> integerList) {
        integerList.stream().forEach(value -> this.sumValue += value);
        return new BigDecimal(sumValue).divide(new BigDecimal(integerList.size()), 2, 5);
    }
}

package com.mjy.cyber;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class CombinedNumber {

    private String largestNumber;

    public String combineLargestNumber(List<Integer> integerList) {

        List<Number> numberList = Lists.newArrayList();
        integerList.stream().forEach(value -> numberList.add(new Number(value)));

        Collections.sort(numberList);

        largestNumber = "";
        numberList.stream().forEach(toNumber -> this.largestNumber += toNumber.getIntegerValue());

        return this.largestNumber;
    }

    @Data
    class Number implements Comparable {
        private String integerValue;

        public Number(Integer integer) {
            this.integerValue = String.valueOf(integer);
        }

        @Override
        public int compareTo(Object object) {
            Number toNumber = (Number) object;

            int minLength = this.integerValue.length() >= toNumber.getIntegerValue().length()
                    ? toNumber.getIntegerValue().length() : this.integerValue.length();
            for (int i = 0; i < minLength; i++) {
                if (Integer.valueOf(this.integerValue.substring(i, i + 1)) >
                        Integer.valueOf(toNumber.getIntegerValue().substring(i, i + 1))) {
                    return -1;
                } else if (Integer.valueOf(this.integerValue.substring(i, i + 1)) <
                        Integer.valueOf(toNumber.getIntegerValue().substring(i, i + 1))) {
                    return 1;
                } else {
                    i++;
                }
            }

            if (this.integerValue.length() == minLength && toNumber.getIntegerValue().length() > minLength) {
                return compareTo(new Number(Integer.valueOf(toNumber.getIntegerValue().substring(minLength, toNumber.getIntegerValue().length()))));
            } else if (toNumber.getIntegerValue().length() == minLength && this.integerValue.length() > minLength) {
                return new Number(Integer.valueOf(this.integerValue.substring(minLength, this.integerValue.length()))).compareTo(toNumber);
            }

            return 0;
        }

    }

}

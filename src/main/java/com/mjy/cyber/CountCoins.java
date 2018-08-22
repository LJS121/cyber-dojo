package com.mjy.cyber;

import lombok.Data;

@Data
public class CountCoins {

    private int finalCents;
    private int penniesNum;
    private int nickelsNum;
    private int dimesNum;
    private int quartersNum;

    public void exchangeCoins(int finalCents) {
        for (this.penniesNum = 0; penniesNum <= finalCents / Coins.valueOf(1).getValue(); penniesNum++) {
            for (this.nickelsNum = 0; nickelsNum <= finalCents / Coins.valueOf(5).getValue(); nickelsNum++) {
                for (this.dimesNum = 0; dimesNum <= finalCents / Coins.valueOf(10).getValue(); dimesNum++) {
                    for (this.quartersNum = 0; quartersNum <= finalCents / Coins.valueOf(25).getValue(); quartersNum++) {
                        int sum = this.penniesNum * Coins.valueOf(1).getValue() + this.nickelsNum * Coins.valueOf(5).getValue()
                                + this.dimesNum * Coins.valueOf(10).getValue() + this.quartersNum * Coins.valueOf(25).getValue();
                        if (sum == finalCents) {
                            System.err.println(String.format("%s pennies, %s nickels, %s dimes, %s quarters total %s.",
                                    this.penniesNum,
                                    this.nickelsNum,
                                    this.dimesNum,
                                    this.quartersNum,
                                    finalCents));
                        }
                    }
                }
            }
        }
    }


    enum Coins {

        QUARTERS(25),
        DIMES(10),
        NICKELS(5),
        PENNIES(1);

        private int value;

        private Coins(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Coins valueOf(int value) {
            switch (value) {
                case 1:
                    return PENNIES;
                case 5:
                    return NICKELS;
                case 10:
                    return DIMES;
                case 25:
                    return QUARTERS;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

}

package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void testRomanNumber_1() {
        // given
        int number = 1;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("I", romanNumber);
    }

    @Test
    public void testRomanNumber_2() {
        // given
        int number = 2;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("II", romanNumber);
    }

    @Test
    public void testRomanNumber_200() {
        // given
        int number = 200;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("CC", romanNumber);
    }

    @Test
    public void testRomanNumber_47() {
        // given
        int number = 47;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("XLVII", romanNumber);
    }

    @Test
    public void testRomanNumber_99() {
        // given
        int number = 99;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("XCIX", romanNumber);
    }

    @Test
    public void testRomanNumber_999() {
        // given
        int number = 999;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("CMXCIX", romanNumber);
    }

    @Test
    public void testRomanNumber_1990() {
        // given
        int number = 1990;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("MCMXC", romanNumber);
    }

    @Test
    public void testRomanNumber_2008() {
        // given
        int number = 2008;

        // when
        String romanNumber = RomanNumerals.of(number);

        // then
        Assert.assertEquals("MMVIII", romanNumber);
    }


    @Test
    public void test() {
        for (int i = 1; i < 5000; i++) {
            System.err.println(i + " == " + RomanNumerals.of(i)) ;
        }
    }


}

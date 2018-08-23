package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Anagrams2Test {


    @Test
    public void one_Char() {
        //given

        //when
        List<String> list = Anagrams2.of("b");

        //then
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void two_Char() {
        //given

        //when
        List<String> list = Anagrams2.of("bi");

        //then
        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals("bi", list.get(0));
    }

    @Test
    public void three_Char() {
        //given
        List<String> listGiven = Arrays.asList("bir", "bri", "ibr", "irb", "rbi", "rib");

        //when
        List<String> list = Anagrams2.of("bir");

        //then
        Assert.assertTrue(list.size() == 6);
        Assert.assertTrue(listGiven.containsAll(list));
    }

    @Test
    public void four_Char() {
        //given

        //when
        List<String> list = Anagrams2.of("biro");

        //then
        Assert.assertTrue(list.size() == 24);
        Assert.assertEquals("orib", list.get(list.size() - 1));
    }

}

package com.mjy.cyber;

import static com.mjy.cyber.PokerHands.BLACK;
import static com.mjy.cyber.PokerHands.WHITE;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Maps;

public class PokerHandsTest {

    @Test
    public void pokerHands() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "2H 3D 5S 9C KD");
        map.put(WHITE, "2C 3H 4S 8C AH");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("White wins - high card: A", output);

    }

    @Test
    public void pokerHands_2() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "2H 3D 5S 9C KD");
        map.put(WHITE, "2C 3C 4C 5C 6C");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("White wins - straight flush", output);

    }

    @Test
    public void pokerHands_3() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "3S 4S 5S 6S 7S");
        map.put(WHITE, "2C 3C 4C 5C 6C");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - straight flush", output);

    }

    @Test
    public void pokerHands_4() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "6C 6D 6H 6S TS");
        map.put(WHITE, "7C 8C 9C TD JC");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - four of a kind", output);
    }

    @Test
    public void pokerHands_5_full_house() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "2H 4S 4C 2D 4H");
        map.put(WHITE, "2S 8S AS QS 3S");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - full house", output);
    }

    @Test
    public void pokerHands_6_flush() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "2H 4H 6H KH TH");
        map.put(WHITE, "2S 5S 8S QS TS");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - flush", output);
    }

    @Test
    public void pokerHands_7_straight() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "3H 4H 5H 6H 7S");
        map.put(WHITE, "2S 5S 8H QS TS");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - straight", output);
    }

    @Test
    public void pokerHands_8_Three_of_Kind() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "TH TS TC 6H 7S");
        map.put(WHITE, "9H 9S 9C 6S 7C");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - three of a kind", output);
    }

    @Test
    public void pokerHands_9_Two_Pairs() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "TH TS QH QC 7S");
        map.put(WHITE, "9H 9S JC JH 7C");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - two pairs", output);
    }
    @Test
    public void pokerHands_10_Pair() {

        //given
        Map<String, String> map = Maps.newHashMap();
        map.put(BLACK, "TH 3S QH QC 7S");
        map.put(WHITE, "9H AS JC JH 7C");
        //when
        String output = PokerHands.pokerHands(map);

        //then
        Assert.assertEquals("Black wins - pair", output);
    }

}

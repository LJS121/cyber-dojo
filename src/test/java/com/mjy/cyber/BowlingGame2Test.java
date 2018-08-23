package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGame2Test {

    @Test
    public void bowlingGame_1round() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(8);
        game2.add(2);
        game2.add(6);

        //when
        int score = game2.getGameScore(1);

        //then
        Assert.assertEquals(16, score);

    }

    @Test
    public void bowlingGame_1round_2() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(7);
        game2.add(2);
        game2.add(6);

        //when
        int score = game2.getGameScore(1);

        //then
        Assert.assertEquals(9, score);

    }

    @Test
    public void bowlingGame_1round_3() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(10);
        game2.add(null);
        game2.add(7);
        game2.add(2);//

        //when
        int score = game2.getGameScore(1);

        //then
        Assert.assertEquals(19, score);

    }

    @Test
    public void bowlingGame_2round() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(8);
        game2.add(2);//一
        game2.add(6);
        game2.add(4);//二
        game2.add(5);

        //when
        int score = game2.getGameScore(2);

        //then
        Assert.assertEquals(15, score);

    }

    @Test
    public void bowlingGame_2round_2() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(8);
        game2.add(2);//一
        game2.add(10);
        game2.add(null);//二
        game2.add(5);
        game2.add(5);//
        game2.add(8);


        //when
        int score = game2.getGameScore(2);

        //then
        Assert.assertEquals(20, score);

    }

    @Test
    public void bowlingGame_2round_3() {
        //given
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(8);
        game2.add(2);//一
        game2.add(10);
        game2.add(null);//二
        game2.add(10);
        game2.add(null);//
        game2.add(8);


        //when
        int score = game2.getGameScore(2);

        //then
        Assert.assertEquals(28, score);

    }

    @Test
    public void bowlingGame_10round_1() {
        //given
        BowlingGame2 game2 = addFirstNine();
        game2.add(10);
        game2.add(null);//第十次抛
        game2.add(10);
        game2.add(2);

        //when
        int score = game2.getGameScore(10);

        //then
        Assert.assertEquals(22, score);

    }

    @Test
    public void bowlingGame_10round_2() {
        //given
        BowlingGame2 game2 = addFirstNine();
        game2.add(10);
        game2.add(null);//第十次抛
        game2.add(5);
        game2.add(4);

        //when
        int score = game2.getGameScore(10);

        //then
        Assert.assertEquals(19, score);
    }

    @Test
    public void bowlingGame_10round_3() {
        //given
        BowlingGame2 game2 = addFirstNine();
        game2.add(5);
        game2.add(5);//第十次抛
        game2.add(5);
        game2.add(4);

        //when
        int score = game2.getGameScore(10);

        //then
        Assert.assertEquals(15, score);
    }

    @Test
    public void bowlingGame_10round_4() {
        //given
        BowlingGame2 game2 = addFirstNine();
        game2.add(5);
        game2.add(4);//第十次抛
        game2.add(5);
        game2.add(4);

        //when
        int score = game2.getGameScore(10);

        //then
        Assert.assertEquals(9, score);
    }

    @Test
    public void bowlingGame_totalScore() {
        //given
        BowlingGame2 game2 = addFirstNine();
        game2.add(5);
        game2.add(5);//第十次抛
        game2.add(5);
        //when
        int totalScore = game2.getGameTotalScore();

        //then
        int actuScore = 0;
        for (int round = 1; round <= 10; round++) {
            System.err.println(game2.getGameScore(round));
            actuScore += game2.getGameScore(round);
        }
        Assert.assertEquals(actuScore, totalScore);

    }

    private BowlingGame2 addFirstNine() {
        BowlingGame2 game2 = new BowlingGame2();
        game2.add(8);
        game2.add(2);//一
        game2.add(10);
        game2.add(null);//二
        game2.add(10);
        game2.add(null);//三
        game2.add(8);
        game2.add(1);//四
        game2.add(4);
        game2.add(4);//五
        game2.add(10);
        game2.add(null);//六
        game2.add(7);
        game2.add(3);//七
        game2.add(7);
        game2.add(3);//八
        game2.add(4);
        game2.add(5);//九
        return game2;
    }


}
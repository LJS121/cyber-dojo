package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    private void initGameScore(BowlingGame game) {
        game.add(8);
        game.add(2);//一
        game.add(4);
        game.add(5);//二
        game.add(6);
        game.add(4);//三
        game.add(5);
        game.add(5);//四
        game.add(10);//五
        game.add(0);
        game.add(1);//六
        game.add(7);
        game.add(3);//七
        game.add(6);
        game.add(4);//八
        game.add(10);//九
    }

    @Test
    public void 第10局一抛二抛全10中() {
        //given
        BowlingGame game = new BowlingGame();
        initGameScore(game);

        //when
        game.add(10);
        game.add(10);//十
        game.add(6);

        int score1 = game.getScoreForCurrentFrame(1);
        int score2 = game.getScoreForCurrentFrame(2);
        int score10 = game.getScoreForCurrentFrame(10);
        int scoreSum = 0;
        for (int i = 1; i <= 10; i++) {
            scoreSum += game.getScoreForCurrentFrame(i);
        }

        //then
        Assert.assertEquals(score1, 14);
        Assert.assertEquals(score2, 9);
        Assert.assertEquals(score10, 26);

        Assert.assertEquals(scoreSum, game.getScoreForFrame(10));
    }



    @Test
    public void 第10局一抛10中_二抛未10中() {
        //given
        BowlingGame game = new BowlingGame();
        initGameScore(game);

        //when
        game.add(10);
        game.add(6);//十
        game.add(2);

        int score1 = game.getScoreForCurrentFrame(1);
        int score2 = game.getScoreForCurrentFrame(2);
        int score10 = game.getScoreForCurrentFrame(10);
        int scoreSum = 0;
        for (int i = 1; i <= 10; i++) {
            scoreSum += game.getScoreForCurrentFrame(i);
        }

        //then
        Assert.assertEquals(score1, 14);
        Assert.assertEquals(score2, 9);
        Assert.assertEquals(score10, 18);

        Assert.assertEquals(scoreSum, game.getScoreForFrame(10));

    }

    @Test
    public void 第10局一抛二抛共10中() {
        //given
        BowlingGame game = new BowlingGame();
        initGameScore(game);

        //when
        game.add(6);
        game.add(4);//十
        game.add(6);

        int score1 = game.getScoreForCurrentFrame(1);
        int score2 = game.getScoreForCurrentFrame(2);
        int score10 = game.getScoreForCurrentFrame(10);
        int scoreSum = 0;
        for (int i = 1; i <= 10; i++) {
            scoreSum += game.getScoreForCurrentFrame(i);
        }

        //then
        Assert.assertEquals(score1, 14);
        Assert.assertEquals(score2, 9);
        Assert.assertEquals(score10, 16);

        Assert.assertEquals(scoreSum, game.getScoreForFrame(10));

    }

    @Test
    public void 第10局一抛二抛未10中() {
        //given
        BowlingGame game = new BowlingGame();
        initGameScore(game);

        //when
        game.add(8);
        game.add(1);//十
//        game.add(6);

        int score1 = game.getScoreForCurrentFrame(1);
        int score2 = game.getScoreForCurrentFrame(2);
        int score10 = game.getScoreForCurrentFrame(10);
        int scoreSum = 0;
        for (int i = 1; i <= 10; i++) {
            scoreSum += game.getScoreForCurrentFrame(i);
        }

        //then
        Assert.assertEquals(score1, 14);
        Assert.assertEquals(score2, 9);
        Assert.assertEquals(score10, 9);

        Assert.assertEquals(scoreSum, game.getScoreForFrame(10));

    }

}
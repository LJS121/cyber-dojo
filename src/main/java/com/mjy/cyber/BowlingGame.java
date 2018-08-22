package com.mjy.cyber;

import lombok.Data;

import java.util.List;

@Data
public class BowlingGame {

    //投掷击倒数
    private int[] bowlingNums = new int[21];
    //数组下标
    private int ballIndex = 0;
    //轮数
    private int countFrame = 0;
    //分数
    private int score = 0;
    //是否第一次投掷
    boolean firstThrow = true;

    public void add(int pins) {
        bowlingNums[ballIndex++] = pins;
        judgeFirstThrow(pins);
    }

    private void judgeFirstThrow(int pins) {
        if (this.firstThrow) {
            if (pins == 10) {
                this.countFrame++;
            } else {
                this.firstThrow = false;
            }
        } else {
            this.countFrame++;
            this.firstThrow = true;
        }
    }


    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        addBall(game);

        for (int i = 1; i <= 10; i++) {
            System.err.println("No." + i + " : " + game.getScoreForFrame(i));
        }
    }

    public int getScoreForFrame(int frame) {

        int ball = 0;
        int score = 0;
        for (int i = 1; i <= frame; i++) {
            int bowlingNumFirst = bowlingNums[ball++];
            if (bowlingNumFirst == 10) {
                score = score + 10 + bowlingNums[ball] + bowlingNums[ball + 1];
            } else {
                int bowlingNumSecond = bowlingNums[ball++];
                int groupNum = bowlingNumFirst + bowlingNumSecond;
                if (groupNum == 10) {
                    score = score + groupNum + bowlingNums[ball];
                } else {
                    score = score + groupNum;
                }
            }

        }
        return score;
    }

    public int getScoreForCurrentFrame(int frame) {
        int ball = 0;
        for (int i = 1; i <= frame; i++) {
            int groupScore = 0;
            int bowlingNumFirst = bowlingNums[ball++];
            if (bowlingNumFirst == 10) {
                groupScore = groupScore + 10 + bowlingNums[ball] + bowlingNums[ball + 1];
            } else {
                int bowlingNumSecond = bowlingNums[ball++];
                int groupNum = bowlingNumFirst + bowlingNumSecond;
                if (groupNum == 10) {
                    groupScore = groupScore + groupNum + bowlingNums[ball];
                } else {
                    groupScore = groupScore + groupNum;
                }
            }
            if (i == frame) {
                return groupScore;
            }

        }
        return score;
    }


    private static void addBall(BowlingGame game) {
        game.add(1);
        game.add(9);
        game.add(4);
        game.add(5);
        game.add(6);
        game.add(4);
        game.add(5);
        game.add(5);
        game.add(10);
        game.add(0);
        game.add(1);
        game.add(7);
        game.add(3);
        game.add(6);
        game.add(4);
        game.add(10);
        game.add(2);
        game.add(8);
        game.add(6);
    }

    public static int randomKnock(int max) {
        return (int) (Math.random() * (max + 1));
    }


    @Data
    static class Scorer {
        private int frame;
        private int times;
        private int score;
    }

    private static void playBowlingGame(List<Scorer> scorerList, int frame) {
        Scorer scorer = new Scorer();
        scorer.setFrame(frame);
        if (frame > 10) {
            return;
        } else if (frame == 10) {
            int currentScore1 = randomKnock(10);
            int currentScore2 = 0;
            int currentScore3 = 0;
            if (currentScore1 == 10) {
                currentScore2 = randomKnock(10);
                if (currentScore2 == 10) {
                    currentScore3 = randomKnock(10);
                } else {
                    currentScore3 = randomKnock(10 - currentScore2);
                }
            } else {
                currentScore2 = randomKnock(10 - currentScore2);
                if (currentScore1 + currentScore2 == 10) {
                    currentScore3 = randomKnock(10);
                }
            }

            scorer.setScore(currentScore1 + currentScore2 + currentScore3);
        } else {
            frame++;
            int currentScore1 = randomKnock(10);
            if (currentScore1 == 10) {
                playBowlingGame(scorerList, frame);
            }
        }
    }

}

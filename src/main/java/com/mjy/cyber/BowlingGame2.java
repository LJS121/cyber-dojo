package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.Arrays;

public class BowlingGame2 {

    private Integer[] knocks = new Integer[22];
    private int knockTime = 0;
    private int totalScore = 0;

    public void add(Integer knockNum) {
        this.knocks[this.knockTime++] = knockNum;
    }

    public int getGameScore(int round) {
        int score = 0;
        int roundIndex = 2 * (round - 1);
        int nextIndex = 2 * round;

        if (knocks[roundIndex] == 10) {
            if (round == 10) {
                score = knocks[roundIndex] + knocks[roundIndex + 2] + knocks[roundIndex + 3];
            } else {
                if (knocks[nextIndex] == 10) {
                    score = knocks[roundIndex] + knocks[nextIndex] + knocks[nextIndex + 2];
                } else {
                    score = knocks[roundIndex] + knocks[nextIndex] + knocks[nextIndex + 1];
                }
            }
        } else if (knocks[roundIndex] + knocks[roundIndex + 1] == 10) {
            score = knocks[roundIndex] + knocks[roundIndex + 1] + knocks[nextIndex];
        } else {
            score = knocks[roundIndex] + knocks[roundIndex + 1];
        }
        return score;
    }

    public int getGameTotalScore() {
        for (int round = 1; round <= 10; round++) {
            this.totalScore += getGameScore(round);
        }
        return this.totalScore;
    }
}

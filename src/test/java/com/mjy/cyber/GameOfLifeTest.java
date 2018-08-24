package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GameOfLifeTest {

    @Test
    public void gameOfLife() {
        // given
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.setHeight(4);
        gameOfLife.setLength(8);
        gameOfLife.setPointAlive(1, 4);
        gameOfLife.setPointAlive(2, 3);
        gameOfLife.setPointAlive(2, 4);

        // when
        List<int[][]> boardList = gameOfLife.findAllBoardList();

        // then
        int[] line0 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] line1 = new int[]{0, 0, 0, 1, 1, 0, 0, 0};
        int[] line2 = new int[]{0, 0, 0, 1, 1, 0, 0, 0};
        int[] line3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

        Assert.assertEquals(1, boardList.size());
        Assert.assertTrue(Arrays.equals(line0, boardList.get(0)[0]));
        Assert.assertTrue(Arrays.equals(line1, boardList.get(0)[1]));
        Assert.assertTrue(Arrays.equals(line2, boardList.get(0)[2]));
        Assert.assertTrue(Arrays.equals(line3, boardList.get(0)[3]));
    }


    @Test
    public void gameOfLife2() {
        // given
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.setHeight(4);
        gameOfLife.setLength(4);
        gameOfLife.setPointAlive(1, 2);
        gameOfLife.setPointAlive(2, 1);
        gameOfLife.setPointAlive(2, 2);

        // when
        List<int[][]> boardList = gameOfLife.findAllBoardList();

        // then
        int[] line0 = new int[]{0, 0, 0, 0};
        int[] line1 = new int[]{0, 1, 1, 0};
        int[] line2 = new int[]{0, 1, 1, 0};
        int[] line3 = new int[]{0, 0, 0, 0};

        Assert.assertEquals(1, boardList.size());
        Assert.assertTrue(Arrays.equals(line0, boardList.get(0)[0]));
        Assert.assertTrue(Arrays.equals(line1, boardList.get(0)[1]));
        Assert.assertTrue(Arrays.equals(line2, boardList.get(0)[2]));
        Assert.assertTrue(Arrays.equals(line3, boardList.get(0)[3]));
    }

}

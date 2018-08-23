package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EightQueensTest {


    @Test
    public void printEightQueens() {
        // given
        EightQueens eightQueens = new EightQueens();

        // when
        List<int[][]> eightQueenBoard = eightQueens.printEightQueens();

        // then
        Assert.assertEquals(92, eightQueenBoard.size());

    }


}

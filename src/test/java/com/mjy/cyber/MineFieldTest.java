package com.mjy.cyber;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MineFieldTest {

    @Test
    public void printMineField(){
        //given
        List<String> commandList = Lists.newArrayList();
        commandList.add("3 4");
        commandList.add("*...");
        commandList.add("..*.");
        commandList.add("....");
        //when
        MineField.printMineField(commandList);

        //then

    }

    @Test
    public void printMineField_2(){
        //given
        List<String> commandList = Lists.newArrayList();
        commandList.add("8 8");
        commandList.add("......*.");
        commandList.add(".*..*...");
        commandList.add("......*.");
        commandList.add("...*....");
        commandList.add("..***...");
        commandList.add("...*....");
        commandList.add(".....*..");
        commandList.add("*.......");

        //when
        List<String> board = MineField.printMineField(commandList);

        //then
        Assert.assertTrue(board.get(0).equals("111112*1"));
        Assert.assertTrue(board.get(1).equals("1*11*322"));
        Assert.assertTrue(board.contains("013*4210"));


    }

}

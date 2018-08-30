package com.mjy.cyber;

import com.google.common.collect.Lists;
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

}

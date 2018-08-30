package com.mjy.cyber;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Mars Rover Technical Challenge
 * <p>
 * Mars Rover technical Challenge
 * <p>
 * The problem below requires some kind of input. You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test). You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data.
 * <p>
 * We highly recommend using a unit testing framework such as JUnit or NUnit. Even if you have not used it before, it is simple to learn and incredibly useful.
 * <p>
 * The code you write should be of production quality, and most importantly, it should be code you are proud of.
 * <p>
 * MARS ROVERS
 * <p>
 * A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
 * <p>
 * This plateau, which is curiously rectangular, must be navigated by the rovers so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth.
 * <p>
 * A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
 * <p>
 * In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot.
 * <p>
 * 'M' means move forward one grid point, and maintain the same heading.
 * <p>
 * Assume that the square directly North from (x, y) is (x, y+1).
 * <p>
 * Input:
 * <p>
 * The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
 * <p>
 * The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
 * <p>
 * The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
 * <p>
 * Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
 * <p>
 * Output:
 * <p>
 * The output for each rover should be its final co-ordinates and heading.
 * <p>
 * Test Input:
 * <p>
 * 5 5
 * <p>
 * 1 2 N
 * <p>
 * LMLMLMLMM
 * <p>
 * 3 3 E
 * <p>
 * MMRMMRMRRM
 * <p>
 * Expected Output:
 * <p>
 * 1 3 N
 * <p>
 * 5 1 E
 */
public class MarsRoverTest {

    @Test
    public void marsRover() {
        //given
        List<String> commandList = Lists.newArrayList();
        commandList.add("5 5");
        commandList.add("1 2 N");
        commandList.add("LMLMLMLMM");

        //when
        List<String> coordinateList = MarsRover.marsRover(commandList);

        //then
        Assert.assertTrue(Arrays.asList("1 3 N").containsAll(coordinateList));

    }

    @Test
    public void marsRover2() {
        //given
        List<String> commandList = Lists.newArrayList();
        commandList.add("5 5");
        commandList.add("3 3 E");
        commandList.add("MMRMMRMRRM");

        //when
        List<String> coordinateList = MarsRover.marsRover(commandList);

        //then
        Assert.assertTrue(Arrays.asList("5 1 E").containsAll(coordinateList));
    }

    @Test
    public void marsRover3() {
        //given
        List<String> commandList = Lists.newArrayList();
        commandList.add("5 5");
        commandList.add("1 2 N");
        commandList.add("LMLMLMLMM");
        commandList.add("3 3 E");
        commandList.add("MMRMMRMRRM");

        //when
        List<String> coordinateList = MarsRover.marsRover(commandList);

        //then
        Assert.assertEquals(2, coordinateList.size());
        Assert.assertEquals("1 3 N", coordinateList.get(0));
        Assert.assertEquals("5 1 E", coordinateList.get(1));
        Assert.assertTrue(Arrays.asList("1 3 N", "5 1 E").containsAll(coordinateList));

    }

}

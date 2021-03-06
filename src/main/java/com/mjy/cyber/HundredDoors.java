package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 100 doors
 * 100 doors in a row are all initially closed. You make
 * 100 passes by the doors. The first time through, you
 * visit every door and toggle the door (if the door is
 * closed, you open it; if it is open, you close it).
 * The second time you only visit every 2nd door (door
 * #2, #4, #6, ...). The third time, every 3rd door
 * (door #3, #6, #9, ...), etc, until you only visit
 * the 100th door.
 * <p>
 * Question: What state are the doors in after the last
 * pass? Which are open, which are closed?
 * <p>
 * [Source http://rosettacode.org]
 *
 * @author msh11535
 */
@Data
public class HundredDoors {

    public static final int NUM = 100;

    private List<Door> doorList;

    public static void main(String[] args) {
        //init
        HundredDoors hundredDoors = new HundredDoors();
        hundredDoors.initDoors();

        //visit
        hundredDoors.visit();

        //print
        hundredDoors.print();

    }

    public void visit() {
        for (int frequency = 1; frequency <= NUM; frequency++) {
            visitDoors(this.doorList, frequency);
        }
    }

    public void print() {
        for (int i = 0; i < this.doorList.size(); i++) {
            System.err.println(JSONObject.toJSONString(this.doorList.get(i)));
        }
    }

    public void visitDoors(List<Door> doorList, int frequency) {
        for (int i = 0; i < doorList.size(); i++) {
            if (doorList.get(i).getIndex() % frequency == 0) {
                doorList.get(i).visitDoor();
            }
        }
    }

    public List<Door> initDoors() {
        this.doorList = new ArrayList<Door>(NUM);
        for (int i = 1; i <= NUM; i++) {
            this.doorList.add(new Door(i, false));
        }
        return this.doorList;
    }


    @Data
    class Door {
        private int index;
        private boolean state;

        public Door(int index, boolean state) {
            this.index = index;
            this.state = state;
        }

        public void visitDoor() {
            this.state = !this.state;
        }
    }

}

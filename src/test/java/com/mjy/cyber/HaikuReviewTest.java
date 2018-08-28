package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class HaikuReviewTest {

    /**
     * Sample Input
     * ------------
     * happy purple frog/eating bugs in the marshes/get indigestion
     * computer programs/the bugs try to eat my code/i will not let them
     *
     * Sample Output
     * -------------
     * 5,7,5,Yes
     * 5,8,5,No
     */
    @Test
    public void checkHaikuReview(){
        //given
        String input = "happy purple frog/eating bugs in the marshes/get indigestion\n" +
                "computer programs/the bugs try to eat my code/i will not let them";

        //when
        HaikuReview.checkHaikuReview(input);

        //then

    }

}

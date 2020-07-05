package com.tfl.buses.util;



import org.junit.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUtilTest {

    @Test
    public void test() throws ParseException {
        String bst = AppUtil.convertTimeToBST("2020-07-05T16:41:08Z");
        assertEquals("17:41", bst);
    }
}

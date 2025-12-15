/*
Assignment :
Task 1: Test `reverse()`
Task 2: Test `isEmpty()`
Task 3: Test `findFirst()` with Null Handling
Task 4: Test `split()` with Array Assertions
Task 5: Master `assertAll()`
Write a single test that validates a `User` object using `assertAll`:
*/

package com.revature.StringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTests {

    @Test
    void testReverse() {
        String result = StringUtils.reverse("reverse");
        assertEquals("esrever", result);
    }

    @Test
    void testIsEmpty_positive() {
        boolean result = StringUtils.isEmpty("");
        assertTrue(result);
    }

    @Test
    void testIsEmpty_negative() {
        boolean result = StringUtils.isEmpty("Hello");
        assertFalse(result);
    }

    @Test
    void testFindFirst_positive() {
        String result = StringUtils.findFirst(new String[]{"Hello", "World", "I", "Am", "Perry"}, "H");
        assertEquals("Hello", result);
    }

    @Test
    void testFindFirst_negative() {
        String result = StringUtils.findFirst(new String[]{}, "H");
        assertNull(result);
    }
}

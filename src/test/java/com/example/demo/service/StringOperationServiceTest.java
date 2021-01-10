package com.example.demo.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StringOperationServiceTest {
    private StringOperationService stringOperationService = new StringOperationService();

    @Test
    public void shouldGetLongestString() {
        String longest = "longestStringggggggggggggggggg";
        List<String> input = asList("String1", "littleLingerString", longest);

        String actual = stringOperationService.getLongestString(input);
        assertEquals(longest, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHandleNullInput() {
        stringOperationService.getLongestString(null);
    }

    @Test
    public void shouldFilterStringValuesWithLengthGreaterThan10() {
        List<String> input = asList("String1",  "littleLongerString", "longerString", "String2", "String3");
        List<String> expected = asList("String1", "String2", "String3");
        List<String> actual = stringOperationService.filterInput(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHandleNullInputOnFilter() {
        stringOperationService.filterInput(null);
    }
}
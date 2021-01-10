package com.example.demo.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringOperationServiceTest {
    private StringOperationService stringOperationService = new StringOperationService();

    @Test
    public void shouldGetLongestString() {
        String longest = "longestStringggggggggggggggggg";
        List<String> input = Arrays.asList("String1", "littleLingerString", longest);

        String actual = stringOperationService.getLongestString(input);
        Assert.assertEquals(longest, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldHandleNullInput() {
        stringOperationService.getLongestString(null);
    }
}
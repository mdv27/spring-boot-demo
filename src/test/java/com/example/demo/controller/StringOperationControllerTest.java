package com.example.demo.controller;

import com.example.demo.service.StringOperationService;
import org.junit.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StringOperationControllerTest {
    @Mock
    private StringOperationService stringOperationService;
    @InjectMocks
    private StringOperationController stringOperationController;

    @Test
    public void shouldCallServiceMethod() {
        List<String> input = asList("testString1");
        stringOperationController.getLongestString(input);
        verify(stringOperationService).getLongestString(input);
    }

    @Test
    public void shouldGetLongestString() {
        List<String> input = asList("testString1");
        String expected = "expectedResultString";

        when(stringOperationService.getLongestString(anyList())).thenReturn(expected);

        String actual = stringOperationController.getLongestString(input);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldHavePostMapping() {
        Optional<Method> getLongestStringMethod = ReflectionUtils.findMethod(StringOperationController.class, "getLongestString", List.class);
        Method method = getLongestStringMethod.orElseThrow(() -> new AssertionError("getLongestString method should exist"));
        PostMapping annotation = method.getAnnotation(PostMapping.class);
        assertEquals("/strings", annotation.path()[0]);
        assertEquals("application/json", annotation.consumes()[0]);
        assertEquals("application/json", annotation.produces()[0]);
    }

    @Test
    public void shouldCallFilterInputOnDeleteStrings() {
        List<String> input = asList("testString1");
        stringOperationController.deleteStrings(input);
        verify(stringOperationService).filterInput(input);
    }

    @Test
    public void shouldDeleteStrings() {
        List<String> input = asList("testString1");
        List<String> expected = asList("filteredstring");

        when(stringOperationService.filterInput(anyList())).thenReturn(expected);

        List<String> actual = stringOperationController.deleteStrings(input);
        assertEquals(expected, actual);
    }
}
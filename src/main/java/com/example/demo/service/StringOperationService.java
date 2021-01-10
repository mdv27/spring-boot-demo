package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class StringOperationService {
    public String getLongestString(List<String> input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        return input.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new RuntimeException());
    }
}

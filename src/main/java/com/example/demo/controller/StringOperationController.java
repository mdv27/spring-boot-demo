package com.example.demo.controller;

import com.example.demo.service.StringOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StringOperationController {
    @Autowired
    private StringOperationService stringOperationService;

    @PostMapping(path = "/strings", consumes = "application/json", produces = "application/json")
    public String getLongestString(List<String> input) {
      return stringOperationService.getLongestString(input);
    }
}

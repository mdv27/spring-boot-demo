package com.example.demo.controller;

import com.example.demo.service.StringOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class StringOperationController {
    @Autowired
    private StringOperationService stringOperationService;

    @PostMapping(path = "/strings", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String getLongestString(@RequestBody List<String> input) {
      return stringOperationService.getLongestString(input);
    }
}

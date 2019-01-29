package com.amrita.task.controller;

import com.amrita.task.service.TaskTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value = "/task2")
public class TaskTwoController {

    @Autowired TaskTwoService taskTwoService;

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, consumes = "application/json")
    public TreeMap<String, List> getAllProducts() {
        return taskTwoService.getAllProducts();
    }

}

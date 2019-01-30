package com.amrita.task.controller;

import com.amrita.task.entity.products;
import com.amrita.task.service.TaskOneService;
import com.amrita.task.service.TaskTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired TaskOneService taskOneService;

    @Autowired TaskTwoService taskTwoService;

    @RequestMapping(value = "/alpha", method = RequestMethod.PUT, consumes = "application/json")
    public Map<String, Object> alpha(@RequestBody Map<String, Object> request) {
        return taskOneService.alpha(request);
    }

    @RequestMapping(value = "/flatten", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> flatten(@RequestBody Map<String, Object> request) {
        return taskOneService.flatten(request);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Map<String, Object> getStatus() {
        return taskOneService.getStatus();
    }

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public TreeMap<String, List> getAllProducts() {
        return taskTwoService.getAllProducts();

    }

}

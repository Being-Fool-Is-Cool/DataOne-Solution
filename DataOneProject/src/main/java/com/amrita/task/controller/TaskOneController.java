package com.amrita.task.controller;

import com.amrita.task.entity.products;
import com.amrita.task.service.TaskOneService;
import com.amrita.task.service.TaskTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/task1")
public class TaskOneController {

    @Autowired TaskOneService taskOneService;

    @Autowired TaskTwoService taskTwoService;

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String HelloWorldTest() {
        return taskOneService.HelloWorldTest();
    }

    @RequestMapping(value = "/alpha", method = RequestMethod.PUT, consumes = "application/json")
    public Map<String, Object> alpha(@RequestBody Map<String, Object> request) {
        return taskOneService.alpha(request);
    }

    @RequestMapping(value = "/flatten", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, Object> flatten(@RequestBody Map<String, Object> request) {
        return taskOneService.flatten(request);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, consumes = "application/json")
    public Map<String, Object> getStatus() {
        return taskOneService.getStatus();
    }

}

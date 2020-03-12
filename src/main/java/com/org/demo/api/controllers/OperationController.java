package com.org.demo.api.controllers;

import com.demo.ws.ServiceWeb;
import com.demo.ws.ServiceWeb_Service;
import com.org.demo.api.services.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class OperationController {
    
    @Autowired
    private OperationService operationService;

    @PostMapping("/suma")
    @ResponseBody
    public double suma(
            @RequestParam("a") double a,
            @RequestParam("b") double b) {
        return operationService.suma(a, b);
    }

}

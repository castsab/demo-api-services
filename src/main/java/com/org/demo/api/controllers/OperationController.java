package com.org.demo.api.controllers;

import com.demo.ws.ServiceWeb;
import com.demo.ws.ServiceWeb_Service;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/suma")
    @ResponseBody
    public double suma(
            @RequestParam("a") double a,
            @RequestParam("b") double b) {

        ServiceWeb_Service serviceService = new ServiceWeb_Service();
        ServiceWeb serviceWeb = serviceService.getServiceWebPort();
        double result = serviceWeb.suma(a, b);
        return result;
    }

}

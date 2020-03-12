/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.demo.api.services;

import com.demo.ws.ServiceWeb;
import com.demo.ws.ServiceWeb_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OperationService {
    
    public double suma(double a, double b){
        ServiceWeb_Service serviceService = new ServiceWeb_Service();
        ServiceWeb serviceWeb = serviceService.getServiceWebPort();
        double result = serviceWeb.suma(a, b);
        return result;
    }
    
}

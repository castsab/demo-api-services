package com.org.demo.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodes {
  
  SESSION_NOT_EXIST("CIF-1", "Session not exist");
    
  private String code;
  private String message;

}

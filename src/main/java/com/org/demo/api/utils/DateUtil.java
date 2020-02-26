
package com.org.demo.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    
    public static java.util.Date getStartTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
    
    public static java.util.Date getCurrentDate(){
        Date date = new Date();
	return date;
    }
}

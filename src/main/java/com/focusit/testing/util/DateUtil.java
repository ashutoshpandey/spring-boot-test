package com.focusit.testing.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateUtil {
    public long dateDifferenceInDays(Date date1, Date date2){
        return (date1.getTime() - date2.getTime()) / (24*60*60*1000);
    }
}

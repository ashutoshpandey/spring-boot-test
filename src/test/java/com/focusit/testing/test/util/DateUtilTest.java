package com.focusit.testing.test.util;

import com.focusit.testing.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateUtilTest {
    @Autowired
    private DateUtil dateUtil;

    @Test
    public void testDateDifferenceInDays(){
        String dateStart = "01/15/2019 09:29:58";
        String dateStop = "01/12/2012 10:31:48";

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            assertEquals(3, dateUtil.dateDifferenceInDays(d1, d2));
        }
        catch(Exception ex){
            System.out.println("Error in date difference test");
            ex.printStackTrace();
        }
    }
}

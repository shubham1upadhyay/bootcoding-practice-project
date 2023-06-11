package com.bootcoding.ipl.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

@UtilityClass
public class DateUtility {

    public Date getDate(String dateStr){
        try {
            return DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}

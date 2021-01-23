package com.piclo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date convertToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(date);
    }

    public static boolean isDateValid(String createdDate,String openDate,String closedDate) throws ParseException {
        Date openFormatDate=convertToDateFormat(openDate);
        Date closeFormatDate=convertToDateFormat(closedDate);
        Date createdFormatDate=convertToDateFormat(createdDate);
        return !createdFormatDate.before(openFormatDate) && !createdFormatDate.after(closeFormatDate);
    }
}

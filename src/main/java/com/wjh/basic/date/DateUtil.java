package com.wjh.basic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 所有日期、时间都用该格式
     */
    public final static String DATE_DEFAULT_MASK = "yyyy-MM-dd";
    public final static String TIME_DEFAULT_MASK = "HH:mm:ss";
    public final static String DATE_TIME_DEFAULT_MASK = "yyyy-MM-dd HH:mm:ss";

    public final static SimpleDateFormat dateDefaultFormat = new SimpleDateFormat(DATE_DEFAULT_MASK);
    public final static SimpleDateFormat timeDefaultFormat = new SimpleDateFormat(TIME_DEFAULT_MASK);
    public final static SimpleDateFormat dateDefaultTimeFormat = new SimpleDateFormat(DATE_TIME_DEFAULT_MASK);


    public static Date stringToDate(String s, String mask) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        return sdf.parse(s);
    }

    public static String dateToString(Date d, String mask) {
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        return sdf.format(d);
    }

    /**
     * 给date加上seconds秒
     */
    public static Date addSeconds(Date date, Integer seconds) {
        return new Date(date.getTime() + seconds * 1000);
    }

}

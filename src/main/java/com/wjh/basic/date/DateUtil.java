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


    /**
     * 字符串转日期
     * 不报错，但是转换结果不正确
     * new SimpleDateFormat("yyyyMMdd").parse("2021-02-25");
     * <p>
     * 报错：java.text.ParseException
     * new SimpleDateFormat("yyyy-MM-dd").parse("20210225");
     * <p>
     * 报错
     * new SimpleDateFormat("yyyyMMdd").parse("2021#02#25");
     */
    public static Date stringToDate(String s, String mask) throws ParseException {
        // mask和s必须都包含-或都不包含
        if (mask.contains("-") ^ s.contains("-")) {
            throw new RuntimeException(" mask【" + mask + "】和s【" + s + "】必须都包含-或都不包含");
        }
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

    /**
     * 获取日期中的年
     */
    public static Integer getYear(Date d) {
        return d.getYear() + 1900;
    }

    /**
     * 获取日期中的月
     */
    public static Integer getMonth(Date d) {
        return d.getMonth() + 1;
    }

    /**
     * 获取日期中的日
     */
    public static Integer getDay(Date d) {
        return d.getDate();
    }
}

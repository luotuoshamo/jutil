package cn.topicstudy.jutil.basic.date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {
    String dateStr = "2020-12-05 12:09:35";
    String mask = "yyyy-MM-dd hh:mm:ss";
    Date date;


    @Before
    public void setUp() throws Exception {
        date = DateUtil.stringToDate(dateStr, mask);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stringToDate() throws Exception {
        Date date = DateUtil.stringToDate(dateStr, mask);
        String s = DateUtil.dateToString(date, mask);
        Assert.assertEquals(s, dateStr);
    }

    @Test
    public void dateToString() {
        // see stringToDate
    }

    @Test
    public void addSeconds() {
        int oneDayInSeconds = 24 * 60 * 60;
        Date date = DateUtil.addSeconds(this.date, oneDayInSeconds);
        String s = DateUtil.dateToString(date, mask);
        Assert.assertEquals(s, "2020-12-06 12:09:35");
    }

    @Test
    public void getYear() {
        String year = DateUtil.getYear(date) + "";
        Assert.assertEquals(year, "2020");
    }

    @Test
    public void getMonth() {
        Assert.assertEquals(DateUtil.getMonth(date) + "", "12");
    }

    @Test
    public void getDay() {
        Assert.assertEquals(DateUtil.getDay(date) + "", "5");
    }
}

package com.gyd.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName mDateUtil
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/23 16:52
 * @Version 1.0
 */
public class DateUtil {

    //获取某年第一天日期
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    //获取num个月之前的日期
    public static Date getLastMonth(int num){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, num);
        return cal.getTime();
    }

}

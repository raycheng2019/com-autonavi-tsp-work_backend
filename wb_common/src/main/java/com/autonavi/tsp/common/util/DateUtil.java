/**
 * autonavi.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.autonavi.tsp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by you on 2014/12/5.
 */
public class DateUtil {
    private static final long ONE_DAY = 86400000;

    /**
     * 获取当前日期字符串 格式为YYYY-MM-DD
     *
     * @return java.lang.String
     */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(new Date());
        return s;
    }

    public static String getCurrentYear() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String s = df.format(new Date());
        return s;
    }

    public static String getCurrentMonth() {
        SimpleDateFormat df = new SimpleDateFormat("MM");
        String s = df.format(new Date());
        return s;
    }

    public static String getDayInWeek(String sDate) {
        Date date = strToDate(sDate);
        SimpleDateFormat df = new SimpleDateFormat("EEE");
        String s = df.format(date);
        return s;
    }

    public static Date strToDate(String str) {
        Date date = null;
        if (str != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = df.parse(str);
            } catch (ParseException e) {

            }
        }
        return date;
    }

    public static Date strToDate(String timeStr, String pattern) {
        Date date = null;
        if (timeStr != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {
                date = df.parse(timeStr);
            } catch (ParseException e) {

            }
        }
        return date;
    }

    public static Date strToDateTime(String str) {
        Date date = null;
        if (null!=str && str.trim().length()>0) {
            if(!str.contains(":")){
                str += " 00:00:00";
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = df.parse(str);
            } catch (ParseException e) {
                McLog.error(e.getMessage(),e,true);
            }
        }
        return date;
    }

    public static Date strToDateTime(String timeStr, String pattern) {
        Date date = null;
        if (timeStr != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {
                date = df.parse(timeStr);
            } catch (ParseException e) {
                McLog.error(e.getMessage(),e,true);
            }
        }
        return date;
    }

    public static String dateTimeToStr(Date date) {
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date != null) {
            str = df.format(date);
        }
        return str;
    }

    public static String dateTimeToStr(Date date, String pattern) {
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        if (date != null) {
            str = df.format(date);
        }
        return str;
    }

    public static String dateToStr(Date date) {
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null) {
            str = df.format(date);
        }
        return str;
    }

    /**
     * 转化成中文类型的日期
     *
     * @param date
     * @return
     */
    public static String dateToStrCh(Date date) {
        String str = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        if (date != null) {
            str = df.format(date);
        }
        return str;
    }

    /**
     * 在原有的日期上面加i天
     *
     * @param date
     * @param i
     * @return
     */
    public static Date add(Date date, int i) {
        date = new Date(date.getTime() + i * ONE_DAY);
        return date;
    }

    /**
     * 加1天
     *
     * @param date
     * @return
     */
    public static Date add(Date date) {
        return add(date, 1);
    }

    /**
     * 减1天
     *
     * @param date
     * @return
     */
    public static Date sub(Date date) {
        return add(date, -1);
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(new Date());
        return s;
    }

    public static String getCurrentDateTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String s = df.format(new Date());
        return s;
    }

    public static String getCurrentDateWeek() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd EEE");
        String s = df.format(new Date());
        return s;

    }

    public static int getDateWeekNum(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 返回月份之间的差。
     *
     * @param startYear
     * @param startMonth
     * @param endYear
     * @param endMonth
     * @return
     */
    public static int compareMonth(String startYear, String startMonth,
                                   String endYear, String endMonth) {
        return (Integer.parseInt(endYear) - Integer.parseInt(startYear)) * 12
                + (Integer.parseInt(endMonth) - Integer.parseInt(startMonth));

    }

    /**
     * @param sDate
     * @return
     */
    public static String getYearMonth(String sDate) {
        Date date1 = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = null;
        try {
            date1 = df.parse(sDate);
            df.applyPattern("yyMM");
            s = df.format(date1);
        } catch (ParseException e) {
            McLog.error(e.getMessage(),e,true);
            return s;
        }
        return s;
    }

    /**
     * @param date
     * @return
     */
    public static String getYearMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyMM");
        String s = null;

        s = df.format(date);

        return s;

    }

    public static String getYearMonthDay(String sDate) {
        Date date1 = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = null;
        try {
            date1 = df.parse(sDate);
            df.applyPattern("yyMMdd");
            s = df.format(date1);
        } catch (ParseException e) {
            McLog.error(e.getMessage(),e,true);
            return s;
        }
        return s;
    }

    /**
     * @param sDate
     * @return
     */
    public static String getMonth(String sDate) {
        Date date1 = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = null;
        try {
            date1 = df.parse(sDate);
            df.applyPattern("MM");
            s = df.format(date1);
        } catch (ParseException e) {
            return s;
        }
        return s;

    }

    /**
     * @param sDate1
     * @param sDate2
     * @return
     */
    public static int compareDate(String sDate1, String sDate2) {

        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date1 = dateFormat.parse(sDate1);
            date2 = dateFormat.parse(sDate2);
        } catch (ParseException e) {
            McLog.error(e.getMessage(),e,true);
        }

        long dif = 0;
        if (date2.after(date1)){
            dif = (date2.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24;
        }else{
            dif = (date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24;
        }
        return (int) dif;
    }

    public static int getDate(String sDate, String sTag) {
        int iSecondMinusPos = sDate.lastIndexOf('-');
        if (sTag.equalsIgnoreCase("y")) {
            return Integer.parseInt(sDate.substring(0, 4));
        } else if (sTag.equalsIgnoreCase("m")) {
            return Integer.parseInt(sDate.substring(5, iSecondMinusPos));
        } else{
            return Integer.parseInt(sDate.substring(iSecondMinusPos + 1));
        }
    }

    /**
     * 得到当前时间的时分秒。格式：hh:mm:ss。
     *
     * @return
     */
    public static String getCurrentTime() {
        Calendar CD = Calendar.getInstance();
        int HH = CD.get(Calendar.HOUR);
        int NN = CD.get(Calendar.MINUTE);
        int SS = CD.get(Calendar.SECOND);
        String time = String.valueOf(HH) + ":" + String.valueOf(NN) + ":"
                + String.valueOf(SS);
        return time;
    }

    /**
     * 返回相差分钟数
     *
     * @param endDate
     * @param startDate
     * @return
     */
    public static int betweenMinute(Date endDate, Date startDate) {
        if (endDate == null || startDate == null)
            return 0;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(endDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(startDate);
        long l = c1.getTimeInMillis() - c2.getTimeInMillis();

        return (int) (l / (1000 * 60));
    }

    /**
     * 返回相差秒数数
     *
     * @param endDate
     * @param startDate
     * @return
     */
    public static int betweenSecond(Date endDate, Date startDate) {
        if (endDate == null || startDate == null)
            return 0;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(endDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(startDate);
        long l = c1.getTimeInMillis() - c2.getTimeInMillis();

        return (int) (l / (1000));
    }

    /**
     * 返回相差小时
     *
     * @param endDate
     * @param startDate
     * @return
     */
    public static int betweenHour(Date endDate, Date startDate){
        if (endDate == null || startDate == null)
            return 0;

        Calendar c1 = Calendar.getInstance();
        c1.setTime(endDate);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(startDate);
        long l = c1.getTimeInMillis() - c2.getTimeInMillis();

        return (int) (l / (1000 * 60 * 60));
    }

    /**
     * 获取当日0点的时间
     *
     * @Title: getTodayZero
     * @Date:2012-9-26 下午3:07:07
     * @Description: TODO
     * @return Date
     * @throws
     * @Author:ZZQ
     */
    public static Date getTodayZero() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);// 设置小时
        c.set(Calendar.MINUTE, 0);// 设置分
        c.set(Calendar.SECOND, 0);// 设置秒
        c.set(Calendar.MILLISECOND, 0);// 设置毫秒数
        return c.getTime();
    }
}
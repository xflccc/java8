package com.xiaoxu.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @auther XuGeGe
 * @date 2022/6/23
 */
public class CalculateEnd {

    public static void main(String[] args) throws ParseException {

//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = sdf1.parse("2022-02-30");
//        //开始时间
//        Date startDate = parse;
//        Calendar c = Calendar.getInstance();
//        c.setTime(startDate);
//        System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
//        System.out.println("当前时间的年份：" + c.get(Calendar.YEAR));
//        System.out.println("当前时间的月份：" + (c.get(Calendar.MONTH) + 1));
//        // 一个月内的第xx天
//        System.out.println("当前时间的月日期：" + c.get(Calendar.DAY_OF_MONTH));
//        // 一年内的第xx周
//        System.out.println("当前时间的年周数：" + c.get(Calendar.WEEK_OF_YEAR));
//        // 一个月内的第xx周
//        System.out.println("当前时间的月周数：" + c.get(Calendar.WEEK_OF_MONTH));
//
//        System.out.println("aa: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(addMonth(startDate,1)));
        int[] arry = {1, 25,31};
        DateUtile dateUtile = new DateUtile();
        List<Date> dateByMonth = dateUtile.getDateByMonth(new Date(), arry, 3);
        dateByMonth.forEach(System.out::println);

    }


    //增加月份
    public static Date addMonth(Date startTime,int month){
        Calendar   calendar = new GregorianCalendar();
        calendar.setTime(startTime);
        calendar.add(calendar.MONTH,month); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime(); //这个时间就是日期往后推一天的结果
    }
}

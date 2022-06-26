package com.xiaoxu.date;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @auther XuGeGe
 * @date 2022/6/24
 */
public class DateUtile {


    public List<Date> getDateByMonth(Date startDate,int[] arry,int acount){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        //当前日期 的号数
        int startNumber = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int lastNumber = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("开始日期的 号数：  " + startNumber);
        System.out.println("当前月份： " + month);
        System.out.println("开始日期的月份的最后一天号数：  " + lastNumber);
        //下一次随访时间
        Date nextFollowDate = new Date();
        //下一次随访的号数标识
        for (int i = 0; i < arry.length; i++) {
            if (startNumber == arry[i] && arry[i] <= lastNumber) {
                //下一次随访时间
                nextFollowDate = startDate;
                System.out.println("下一次随访时间:" + sdf1.format(nextFollowDate));
                break;
            }
            if (startNumber < arry[i] && arry[i] <= lastNumber) {
                //下一次随访时间
                nextFollowDate = getAddDay(startDate, arry[i] - startNumber);
                System.out.println("下一次随访时间:" + sdf1.format(nextFollowDate));
                break;
            }
            if (startNumber < arry[i] && arry[i] > lastNumber) {
                //下一个月的开始
                //下一次随访时间
                nextFollowDate = getAddDay(startDate, lastNumber - startNumber + arry[0]);
                System.out.println("下一次随访时间:" + sdf1.format(nextFollowDate));
                break;
            }
        }
        //计算结束时间开始
        Date endDate = new Date();
        //获取开始时间的 号数
        cal.setTime(nextFollowDate);
        int nextDateNumber = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("开始执行时间： " + nextDateNumber);

        int index = printArray(arry, nextDateNumber);
        if (index != -1) {
            //获取当月还有几次
            int Time = arry.length - index;
            if (acount <= Time) {
                endDate = getAddDay(nextFollowDate, arry[index + acount] - nextDateNumber + 1);
            }
            if (acount > Time) {
                acount = acount - Time;
                if (acount < arry.length) {
                    lastNumber = gteMaxMonthNumber(nextFollowDate);
                    endDate = getAddDay(nextFollowDate, (lastNumber - nextDateNumber) + arry[acount - 1]+1);
                }
                if (acount >= arry.length) {
                    //第一阶段
                    int dayOne = lastNumber - nextDateNumber;
                    //第二阶段
                    int towTime = acount / arry.length; //需要增加的月份数
                    int dayTow = 0;//第二阶段总天数
                    ArrayList<Date> dates = new ArrayList<>();
                    for (int j = 1; j <= towTime; j++) {
                        dates.add(addMonth(nextFollowDate, j));
                    }
                    for (Date date : dates) {
                        dayTow += gteMaxMonthNumber(date);
                    }
                    //第三阶段
                    int dayThree = 0;
                    int threeTime = acount - towTime * arry.length;
                    if (threeTime <= 0) {
                        dayThree = 0;
                    }
                    if (threeTime > 0) {
                        dayThree = arry[threeTime - 1] + 1;
                    }

                    endDate = getAddDay(endDate, dayOne + dayTow + dayThree + 1);
                }
            }

        }

        System.out.println("endDate:  " + sdf1.format(endDate));
        ArrayList<Date> lis = new ArrayList<>();
        lis.add(nextFollowDate);
        lis.add(endDate);
        return lis;
    }








    //遍历数组
    public  int printArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;//当if条件不成立时，默认返回一个负数值-1
    }

    /**
     * 获取当前日期月份最大天数
     */
    public  int gteMaxMonthNumber(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取当前日期月份最大天数
        int lastNumber = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastNumber;
    }

    //当前日期 + n 天
    public  Date getAddDay(Date startTime, int dayNumber) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startTime);
        calendar.add(calendar.DATE, dayNumber); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime(); //这个时间就是日期往后推一天的结果
    }

    //增加月份
    public  Date addMonth(Date startTime, int month) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startTime);
        calendar.add(calendar.MONTH, month); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime(); //这个时间就是日期往后推一天的结果
    }


}

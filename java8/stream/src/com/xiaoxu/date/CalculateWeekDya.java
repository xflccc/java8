package com.xiaoxu.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @auther XuGeGe
 * @date 2022/6/23
 */
public class CalculateWeekDya {

    public static void main(String[] args) throws ParseException {
        int[] arry = {1,2};
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf1.parse("2022-06-06");
        //计算下一次访问时间
        Date startDate = parse;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        //一周 第一天是否为星期天
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取开始时间是周几
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        System.out.println("weekDay:" + weekDay);

        //下一次随访时间
        Date nextFollowDate = new Date();
        //结束时间
        Date endDate = new Date();

        int count = 3 ;
       int index = 0;
       for(int i=0;i<arry.length;i++){
           if (weekDay == arry[i]){
               index = weekDay;
               break;
           }
           if (weekDay < arry[i]){
               index = arry[i];
               break;
           }
       }

        //当前==
        if (weekDay == index){
            //下一次随访时间
            nextFollowDate = startDate;
            System.out.println("下一次随访时间:"+sdf1.format(nextFollowDate));
        }
        if (weekDay<index){
            //下一次随访时间
            //nextFollowDate = new Date(startDate.getTime() + (index-weekDay) * (1 * 24 * 60 * 60 * 1000));
            nextFollowDate =  getAddDay(startDate,index-weekDay);
            System.out.println("下一次随访时间:"+sdf1.format(nextFollowDate));
            //计算结束

        }
        if (weekDay>index){
            //下一次随访时间
            //nextFollowDate = new Date(startDate.getTime() + (7-weekDay) * (1 * 24 * 60 * 60 * 1000) + arry[0] * (1 * 24 * 60 * 60 * 1000));
            nextFollowDate = getAddDay(startDate,7-weekDay+arry[0]);
            System.out.println("下一次随访时间:"+sdf1.format(nextFollowDate));
            //计算结束

        }


        int nextWeek = getWeek(nextFollowDate);

        int number = 0;
        //计算结束
        for(int i=0;i<arry.length;i++){
            if (nextWeek <= arry[i]){
                number ++;
            }
        }
        System.out.println("第一阶段次数=number : " + number);
        //第一阶段时间
         int first = (7 - nextWeek);
        //第二阶段时间
         int two = (count - number) / arry.length * 7;

        //第三段时间
        int endWeek = 0;
        int time = (count - number) % arry.length;
        int three = 0;

        if (time == 0){
            three = - (7 - arry[arry.length-1] - 1);
        }
        if (time>0){
            endWeek  =  arry[time -1];
            three = (endWeek + 1) ;
        }

        endDate = getAddDay(nextFollowDate,first+two+three);
        System.out.println("endDatw: " + sdf1.format(endDate));

    }



    public static int getWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //一周 第一天是否为星期天
        boolean isFirstSunday = (cal.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取开始时间是周几
        int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        return weekDay;
    }

    //当前日期 + n 天
    public static Date getAddDay(Date startTime,int dayNumber){
        Calendar   calendar = new GregorianCalendar();
        calendar.setTime(startTime);
        calendar.add(calendar.DATE,dayNumber); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime(); //这个时间就是日期往后推一天的结果
    }

}

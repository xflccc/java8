package com.xiaoxu.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @auther 徐富林
 * @Date 2022/5/10
 */
public class Dome {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        System.out.println(now);
        System.out.println(date);
        System.out.println(time);
    }
}

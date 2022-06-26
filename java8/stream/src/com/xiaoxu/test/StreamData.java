package com.xiaoxu.test;

import com.xiaoxu.entry.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XuGeGe
 * @auther 徐富林
 * @Date 2022/5/4
 */

public class StreamData {



    public static List<Employee> data(){
        List<Employee> list= new ArrayList<>();
        Employee e1 = new Employee("xiaoxu", 20, '男', 156);
        Employee e2 = new Employee("叶巧", 21, '女', 157);
        Employee e3= new Employee("曾杰", 22, '女', 158);
        Employee e4= new Employee("糖开水", 23, '男', 159);
        Employee e5= new Employee("轻容", 24, '女', 159);
        Employee e6 = new Employee("xiaoxu", 20, '男', 256);
        Employee e7 = new Employee("叶巧", 21, '女', 257);
        Employee e8= new Employee("曾杰", 22, '女', 258);
        Employee e9= new Employee("糖开水", 23, '男', 259);
        Employee e10= new Employee("轻容", 24, '女', 259);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);
        list.add(e9);
        list.add(e10);
        return list;
    }

}

package test.com.xiaoxu.test;

import com.xiaoxu.entry.Employee;
import com.xiaoxu.test.StreamData;
import org.junit.Test;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StreamTest Tester.
 */
public class StreamTestTest {

    @Test
    public void test1() {
        List<Employee> list = StreamData.data();
        list.stream().sorted((e1, e2) -> {
            return Integer.compare(e1.getAge(), e2.getAge());
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 排序
     */
    @Test
    public void test2() {
        List<Employee> list = StreamData.data();
        list.stream().sorted((e1, e2) -> {
            int value = Integer.compare(e1.getAge(), e2.getAge());
            if (value != 0) {
                return value;
            } else {
                return Integer.compare(e1.getScors(), e2.getScors());
            }
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 匹配
     * allMach  匹配所有
     * 例：是否所有年龄大于20岁
     */
    @Test
    public void test3() {
        List<Employee> list = StreamData.data();
        boolean b = list.stream().allMatch(employee -> employee.getAge() > 20);
        System.out.println("是否所有年龄大于20岁: " + b);
    }

    /**
     * anyMatch() 匹配任意一个
     */
    @Test
    public void test4(){
        List<Employee> list = StreamData.data();
        System.out.println("是否存在分数大于256： " + list.stream().anyMatch(employee -> employee.getScors() > 256));
    }

    /**
     * 检查是否  不包含某个xxx
     */
    @Test
    public void test5(){
        List<Employee> list = StreamData.data();
        System.out.println("姓名不包含 巧 字的：" +  list.stream().noneMatch(employee -> employee.getName().contains("巧")));
    }

    /**
     * 检查是否没有 包含某个xxx开头
     */
    @Test
    public void test6(){
        List<Employee> list = StreamData.data();
        System.out.println("没有姓名以 巧 字开头的：" +  list.stream().noneMatch(employee -> employee.getName().startsWith("巧")));
    }

    /**
     * 返回第一个元素
     */
    @Test
    public void tset7(){
        List<Employee> list = StreamData.data();
        System.out.println("返回第一个元素：" + list.stream().findFirst());
    }

    /**
     * 返回某一字段的最大值
     */
    @Test
    public void tset8(){
        List<Employee> list = StreamData.data();
        System.out.println("成绩最大：" + list.stream().max((employee, t1) -> {
            return Integer.compare(employee.getScors(),t1.getScors());
        }));
        System.out.println("----------");
        System.out.println("最大成绩" + list.stream().map(Employee::getScors).max(Integer::compare));
    }


    /**
     * 返回某一字段的最小值
     */
    @Test
    public void tset9(){
        List<Employee> list = StreamData.data();
        System.out.println("成绩最小：" + list.stream().min((employee, t1) -> {
            return Integer.compare(employee.getScors(),t1.getScors());
        }));
        System.out.println("----------");
        System.out.println("最小成绩" + list.stream().map(Employee::getScors).min(Integer::compare));
    }

    /**
     * 统计
     */
    @Test
    public void test10(){
        List<Employee> list = StreamData.data();
        long count = list.stream().filter(e -> e.getAge() > 21).count();
        System.out.println("年龄大于21的人数 ：" + count);
    }


    /**
     * 规约 求和
     */
    @Test
    public void test11(){
        List<Employee> list = StreamData.data();
        Optional<Integer> reduce = list.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println("年龄总大小 ：" + reduce);
    }

}

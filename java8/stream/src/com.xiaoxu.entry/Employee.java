package com.xiaoxu.entry;

/**
 * @author XuGeGe
 * @auther 徐富林
 * @Date 2022/5/4
 */

public class Employee {

        private  String name;

        private Integer  age;

        private char sex;

        private Integer scors;

    public Employee(String name, Integer age, char sex, Integer scors) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.scors = scors;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Integer getScors() {
        return scors;
    }

    public void setScors(Integer scors) {
        this.scors = scors;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", scors=" + scors +
                '}';
    }

}

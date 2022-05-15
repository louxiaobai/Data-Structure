package com.line.algo.sort;

import java.util.Comparator;

/**
 * @author lqw
 * @date 2021/9/30-8:38 下午
 */
public class Comparable {


    public static void main(String[] args) {

        Person p1=new Person("二狗",13);
        Person p2=new Person("三蛋",14);

        //System.out.println(p1.compareTo(p2));

        ComparablePerson comparable=new ComparablePerson();
        System.out.println(comparable.compare(p1, p2));
        //方式一实现java.lang中的比较器

    }

}

//自己定一个一个比较器

class ComparablePerson implements Comparator<Person>{


    @Override
    public int compare(Person o1, Person o2) {

        return o1.getAge()-o2.getAge();
    }
}




class Person implements java.lang.Comparable<Person> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }



    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



}
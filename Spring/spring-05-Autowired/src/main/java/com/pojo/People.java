package com.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * @author lqw
 * @date 2021/10/20-8:56 ����
 */
public class People {

    //�����ʾ������Autowired��required������Ϊfalse,˵������������Ϊnull,��������Ϊ��
    @Resource(name="cat")
    private Cat cat;
    @Autowired
    @Qualifier(value ="dog")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }
    public void setCat(Cat cat) {
        this.cat = cat;
    }
    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
package com.mikael0.resterror;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by mikael0 on 08.03.17.
 */
@XmlRootElement
public class Person {

    private String name;
    private String surname;
    private Integer age;
    private String sex;
    private Date birth;

    public Person() {
    }

    public Person(String name, String surname, int age, String sex, Date birth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.birth =  birth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirth(){return  birth;}

    public String getSex() { return sex;}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setBirth(Date birth){
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age="
                + age + ", sex=" + sex
                + ", birth=" + birth + "}";
    }
}
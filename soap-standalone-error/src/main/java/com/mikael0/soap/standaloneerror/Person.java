/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.standaloneerror;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{

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

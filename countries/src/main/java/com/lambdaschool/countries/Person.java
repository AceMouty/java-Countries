package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Person {
    private final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int age;

    public  Person(String name, int age){
        this.id = counter.incrementAndGet();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "counter=" + counter +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.powernode.spring6.beans;

import java.util.Arrays;

public class Person {
    private String[] hobbies;

    //数组类型为简单类型
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    private Woman[] womans;
    //数组类型为非简单类型
    public void setWomans(Woman[] womans) {
        this.womans = womans;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", womans=" + Arrays.toString(womans) +
                '}';
    }
}

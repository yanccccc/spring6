package com.powernode.spring6.bean;


public class OrderFactory {
    public Order get(){
        return new Order();
    }
}
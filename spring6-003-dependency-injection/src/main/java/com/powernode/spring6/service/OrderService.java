package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;
import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}

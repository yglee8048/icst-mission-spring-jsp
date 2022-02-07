package com.lgcns.icst.mission.spring.jsp.hangma.order.entity;

import java.time.LocalDateTime;

public class OrderEntity {

    private Long orderId;
    private Integer empNo;
    private Integer price;
    private Integer discountPrice;
    private LocalDateTime orderDt;

    public OrderEntity(Long orderId, Integer empNo, Integer price, Integer discountPrice, LocalDateTime orderDt) {
        this.orderId = orderId;
        this.empNo = empNo;
        this.price = price;
        this.discountPrice = discountPrice;
        this.orderDt = orderDt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public LocalDateTime getOrderDt() {
        return orderDt;
    }
}

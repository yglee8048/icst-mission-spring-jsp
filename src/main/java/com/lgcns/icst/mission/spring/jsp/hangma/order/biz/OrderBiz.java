package com.lgcns.icst.mission.spring.jsp.hangma.order.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.common.util.JdbcUtil;
import com.lgcns.icst.mission.spring.jsp.hangma.member.dao.EmployeeDAO;
import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity;
import com.lgcns.icst.mission.spring.jsp.hangma.order.dao.OrderDao;
import com.lgcns.icst.mission.spring.jsp.hangma.order.entity.OrderEntity;

import java.sql.Connection;
import java.util.List;

public class OrderBiz {

    private final OrderDao orderDao;
    private final EmployeeDAO employeeDAO;
    private final DiscountPolicy discountPolicy;

    public OrderBiz(OrderDao orderDao, EmployeeDAO employeeDAO, DiscountPolicy discountPolicy) {
        this.orderDao = orderDao;
        this.employeeDAO = employeeDAO;
        this.discountPolicy = discountPolicy;
    }

    public void insertOrder(Integer empNo, Integer price) throws Exception {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            EmployeeEntity employeeEntity = employeeDAO.findByEmpNo(connection, empNo);
            int discountPrice = discountPolicy.getDiscountPrice(employeeEntity.getEmpRank(), price);

            orderDao.insertOrder(connection, empNo, price, discountPrice);

            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public List<OrderEntity> findAllOrdersByEmpNoOrderByIdDesc(Integer empNo) throws Exception {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            return orderDao.findAllByEmpNoOrderByIdDesc(connection, empNo);
        } finally {
            JdbcUtil.close(connection);
        }
    }
}
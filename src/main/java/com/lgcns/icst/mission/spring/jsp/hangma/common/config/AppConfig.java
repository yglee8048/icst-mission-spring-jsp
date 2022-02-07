package com.lgcns.icst.mission.spring.jsp.hangma.common.config;

import com.lgcns.icst.mission.spring.jsp.hangma.member.biz.MemberBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.member.dao.EmployeeDAO;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.biz.MenuBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.dao.MenuDAO;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.DiscountPolicy;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.FixedDiscountPolicy;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.OrderBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.RateDiscountPolicy;
import com.lgcns.icst.mission.spring.jsp.hangma.order.dao.OrderDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberBiz memberBiz() {
        return new MemberBiz(employeeDAO());
    }

    @Bean
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAO();
    }

    @Bean
    public MenuBiz menuBiz() {
        return new MenuBiz(menuDAO());
    }

    @Bean
    public MenuDAO menuDAO() {
        return new MenuDAO();
    }

    @Bean
    public OrderBiz orderBiz() {
        return new OrderBiz(orderDao(), employeeDAO(), rateDiscountPolicy());
    }

    @Bean
    public OrderDao orderDao() {
        return new OrderDao();
    }

    @Bean
    public DiscountPolicy fixedDiscountPolicy() {
        return new FixedDiscountPolicy();
    }

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}

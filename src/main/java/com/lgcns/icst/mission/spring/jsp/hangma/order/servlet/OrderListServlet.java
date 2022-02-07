package com.lgcns.icst.mission.spring.jsp.hangma.order.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.common.constant.SessionKey;
import com.lgcns.icst.mission.spring.jsp.hangma.member.biz.MemberBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.OrderBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.order.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderListServlet", urlPatterns = "/order/list")
public class OrderListServlet extends HttpServlet {

    private final OrderBiz orderBiz;
    private final MemberBiz memberBiz;

    @Autowired
    public OrderListServlet(OrderBiz orderBiz, MemberBiz memberBiz) {
        this.orderBiz = orderBiz;
        this.memberBiz = memberBiz;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Integer empNo = (Integer) session.getAttribute(SessionKey.EMP_NO);
            if (empNo == null) {
                throw new Exception("로그인 되지 않은 사용자 입니다.");
            }

            EmployeeEntity employeeEntity = memberBiz.findByEmpNo(empNo);
            req.setAttribute("empNm", employeeEntity.getEmpNm());

            List<OrderEntity> orders = orderBiz.findAllOrdersByEmpNoOrderByIdDesc(empNo);
            req.setAttribute("orders", orders);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/order/list.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

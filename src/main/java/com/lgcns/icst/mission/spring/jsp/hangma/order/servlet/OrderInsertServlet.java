package com.lgcns.icst.mission.spring.jsp.hangma.order.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.common.config.AppConfig;
import com.lgcns.icst.mission.spring.jsp.hangma.common.constant.SessionKey;
import com.lgcns.icst.mission.spring.jsp.hangma.order.biz.OrderBiz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "orderServlet", urlPatterns = "/order/insert")
public class OrderInsertServlet extends HttpServlet {

    private final OrderBiz orderBiz;

    public OrderInsertServlet() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        orderBiz = applicationContext.getBean(OrderBiz.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String price = req.getParameter("price");

        try {
            HttpSession session = req.getSession();
            Integer empNo = (Integer) session.getAttribute(SessionKey.EMP_NO);
            if (empNo == null) {
                throw new Exception("로그인 되지 않은 사용자 입니다.");
            }

            orderBiz.insertOrder(empNo, Integer.parseInt(price));
            resp.sendRedirect(req.getContextPath() + "/order/list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

package com.lgcns.icst.mission.spring.jsp.hangma.member.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.common.constant.SessionKey;
import com.lgcns.icst.mission.spring.jsp.hangma.member.biz.MemberBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/member/login")
public class LoginServlet extends HttpServlet {

    private final MemberBiz memberBiz;

    @Autowired
    public LoginServlet(MemberBiz memberBiz) {
        this.memberBiz = memberBiz;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo = req.getParameter("empNo");
        try {
            EmployeeEntity employeeEntity = memberBiz.findByEmpNo(Integer.parseInt(empNo));

            HttpSession session = req.getSession();
            session.setAttribute(SessionKey.EMP_NO, employeeEntity.getEmpNo());

            resp.sendRedirect(req.getContextPath() + "/menu/list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

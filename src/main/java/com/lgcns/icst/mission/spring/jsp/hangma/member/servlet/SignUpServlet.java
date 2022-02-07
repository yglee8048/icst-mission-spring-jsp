package com.lgcns.icst.mission.spring.jsp.hangma.member.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.common.config.AppConfig;
import com.lgcns.icst.mission.spring.jsp.hangma.member.biz.MemberBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signUpServlet", urlPatterns = "/member/sign-up")
public class SignUpServlet extends HttpServlet {

    private final MemberBiz memberBiz;

    public SignUpServlet() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.memberBiz = applicationContext.getBean(MemberBiz.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/signUp.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo = req.getParameter("empNo");
        String empNm = req.getParameter("empNm");

        try {
            memberBiz.signUp(Integer.parseInt(empNo), empNm);

            resp.sendRedirect(req.getContextPath() + "/member/login");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

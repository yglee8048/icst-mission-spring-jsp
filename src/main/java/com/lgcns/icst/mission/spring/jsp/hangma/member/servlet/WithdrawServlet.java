package com.lgcns.icst.mission.spring.jsp.hangma.member.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.common.constant.SessionKey;
import com.lgcns.icst.mission.spring.jsp.hangma.member.biz.MemberBiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "withdrawServlet", urlPatterns = "/member/withdraw")
public class WithdrawServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberBiz memberBiz = new MemberBiz();
        try {
            HttpSession session = req.getSession();
            Integer empNo = (Integer) session.getAttribute(SessionKey.EMP_NO);
            if (empNo == null) {
                throw new Exception("로그인 되지 않은 사용자 입니다.");
            }

            memberBiz.withdraw(empNo);

            resp.sendRedirect(req.getContextPath() + "/member/login");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

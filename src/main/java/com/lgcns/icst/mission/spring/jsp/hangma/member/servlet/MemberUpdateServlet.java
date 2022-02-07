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

@WebServlet(name = "memberUpdateServlet", urlPatterns = "/member/update")
public class MemberUpdateServlet extends HttpServlet {

    private final MemberBiz memberBiz;

    @Autowired
    public MemberUpdateServlet(MemberBiz memberBiz) {
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

            req.setAttribute("member", employeeEntity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/update.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNm = req.getParameter("empNm");

        try {
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new Exception("로그인 되지 않은 사용자 입니다.");
            }
            Integer empNo = (Integer) session.getAttribute(SessionKey.EMP_NO);

            memberBiz.updateEmployee(empNo, empNm);

            resp.sendRedirect(req.getContextPath() + "/menu/list");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

package com.lgcns.icst.mission.spring.jsp.hangma.menu.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.menu.biz.MenuBiz;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuDeleteServlet", urlPatterns = "/menu/delete")
public class MenuDeleteServlet extends HttpServlet {

    private final MenuBiz menuBiz;

    @Autowired
    public MenuDeleteServlet(MenuBiz menuBiz) {
        this.menuBiz = menuBiz;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuId = req.getParameter("menuId");

        try {
            menuBiz.deleteMenuById(Long.parseLong(menuId));

            resp.sendRedirect(req.getContextPath() + "/menu/manage");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

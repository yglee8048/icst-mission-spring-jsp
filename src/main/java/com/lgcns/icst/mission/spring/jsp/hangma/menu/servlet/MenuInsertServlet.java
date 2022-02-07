package com.lgcns.icst.mission.spring.jsp.hangma.menu.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.menu.biz.MenuBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuInsertServlet", urlPatterns = "/menu/insert")
public class MenuInsertServlet extends HttpServlet {

    private final MenuBiz menuBiz;

    @Autowired
    public MenuInsertServlet(MenuBiz menuBiz) {
        this.menuBiz = menuBiz;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/insert.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String menuNm = req.getParameter("menuNm");
        String price = req.getParameter("price");

        try {
            menuBiz.addMenu(Category.valueOf(category), menuNm, Integer.parseInt(price));

            resp.sendRedirect(req.getContextPath() + "/menu/manage");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

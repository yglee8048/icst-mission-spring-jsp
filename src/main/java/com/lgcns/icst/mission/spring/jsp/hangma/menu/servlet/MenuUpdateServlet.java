package com.lgcns.icst.mission.spring.jsp.hangma.menu.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.menu.biz.MenuBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuUpdateServlet", urlPatterns = "/menu/update")
public class MenuUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuId = req.getParameter("menuId");

        MenuBiz menuBiz = new MenuBiz();
        try {
            MenuEntity menuEntity = menuBiz.findMenuById(Long.parseLong(menuId));

            req.setAttribute("menu", menuEntity);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/update.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuId = req.getParameter("menuId");
        String category = req.getParameter("category");
        String menuNm = req.getParameter("menuNm");
        String price = req.getParameter("price");

        MenuBiz menuBiz = new MenuBiz();
        try {
            menuBiz.updateMenu(new MenuEntity(Long.parseLong(menuId), category, menuNm, Integer.parseInt(price), null));

            resp.sendRedirect(req.getContextPath() + "/menu/manage");

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

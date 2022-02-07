package com.lgcns.icst.mission.spring.jsp.hangma.menu.servlet;

import com.lgcns.icst.mission.spring.jsp.hangma.menu.biz.MenuBiz;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "menuListServlet", urlPatterns = "/menu/list")
public class MenuListServlet extends HttpServlet {

    private final MenuBiz menuBiz;

    @Autowired
    public MenuListServlet(MenuBiz menuBiz) {
        this.menuBiz = menuBiz;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<MenuEntity> menu = menuBiz.findAllMenu();

            req.setAttribute("menu", menu);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/list.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/common/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

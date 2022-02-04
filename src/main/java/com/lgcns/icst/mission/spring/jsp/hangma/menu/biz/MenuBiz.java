package com.lgcns.icst.mission.spring.jsp.hangma.menu.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.common.util.JdbcUtil;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.dao.MenuDAO;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.Category;
import com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuBiz {

    public List<MenuEntity> findAllMenu() throws SQLException {
        MenuDAO menuDao = new MenuDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            return menuDao.findAll(connection);
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public MenuEntity findMenuById(Long menuId) throws SQLException {
        MenuDAO menuDao = new MenuDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            return menuDao.findById(connection, menuId);
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void addMenu(Category category, String menuNm, int price) throws Exception {
        MenuDAO menuDao = new MenuDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            menuDao.save(connection, category, menuNm, price);
            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void updateMenu(MenuEntity menuEntity) throws Exception {
        MenuDAO menuDao = new MenuDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            menuDao.update(connection, menuEntity);
            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void deleteMenuById(long menuId) throws Exception {
        MenuDAO menuDao = new MenuDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            menuDao.deleteById(connection, menuId);
            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }
}

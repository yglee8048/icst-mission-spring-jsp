package com.lgcns.icst.mission.spring.jsp.hangma.member.biz;

import com.lgcns.icst.mission.spring.jsp.hangma.common.util.JdbcUtil;
import com.lgcns.icst.mission.spring.jsp.hangma.member.dao.EmployeeDAO;
import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity;

import java.sql.Connection;

public class MemberBiz {

    public EmployeeEntity findByEmpNo(Integer empNo) throws Exception {
        EmployeeDAO employeeDao = new EmployeeDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            EmployeeEntity employeeEntity = employeeDao.findByEmpNo(connection, empNo);
            if (employeeEntity == null) {
                throw new Exception("일치하는 사번이 존재하지 않습니다.");
            }
            return employeeEntity;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void signUp(Integer empNo, String empNm) throws Exception {
        EmployeeDAO employeeDao = new EmployeeDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            employeeDao.save(connection, empNo, empNm);
            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void updateEmployee(EmployeeEntity employeeEntity) throws Exception {
        EmployeeDAO employeeDao = new EmployeeDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            employeeDao.update(connection, employeeEntity);

            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void withdraw(Integer empNo) throws Exception {
        EmployeeDAO employeeDao = new EmployeeDAO();
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            employeeDao.deleteByEmployeeNumber(connection, empNo);

            JdbcUtil.commit(connection);
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }
}

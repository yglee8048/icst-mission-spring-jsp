package com.lgcns.icst.mission.spring.jsp.hangma.member.dao;

import com.lgcns.icst.mission.spring.jsp.hangma.common.util.JdbcUtil;
import com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public EmployeeEntity findByEmpNo(Connection connection, Integer empNo) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT EMP_NM, EMP_RANK FROM HANGMA_EMPLOYEE WHERE EMP_NO = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String empNm = resultSet.getString("EMP_NM");
                return new EmployeeEntity(empNo, empNm);
            }
            return null;
        } finally {
            JdbcUtil.close(resultSet);
            JdbcUtil.close(preparedStatement);
        }
    }

    public void save(Connection connection, Integer empNo, String empNm) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO HANGMA_EMPLOYEE(EMP_NO, EMP_NM) VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setString(2, empNm);

            int rows = preparedStatement.executeUpdate();
            if (rows != 1) {
                throw new Exception("회원 가입 중 오류가 발생했습니다.");
            }
        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }

    public void update(Connection connection, Integer empNo, String empNm) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE HANGMA_EMPLOYEE SET EMP_NM = ? WHERE EMP_NO = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empNm);
            preparedStatement.setInt(2, empNo);

            int rows = preparedStatement.executeUpdate();
            if (rows != 1) {
                throw new Exception("회원 수정 중 오류가 발생했습니다.");
            }
        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }

    public void deleteByEmpNo(Connection connection, Integer empNo) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM HANGMA_EMPLOYEE WHERE EMP_NO = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);

            int rows = preparedStatement.executeUpdate();
            if (rows != 1) {
                throw new Exception("회원 탈퇴 중 오류가 발생했습니다.");
            }
        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }
}

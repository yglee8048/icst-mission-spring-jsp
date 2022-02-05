<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.member.entity.EmployeeEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/update.css">
</head>
<body>
<div class="signUp">
    <h1>회원수정</h1>
    <form action="<%=request.getContextPath()%>/member/update" method="post">
        <hr>
        <table>
            <colgroup>
                <col style="width: 25%;">
                <col style="width: 75%;">
            </colgroup>
            <tbody>
            <%
                EmployeeEntity member = (EmployeeEntity) request.getAttribute("member");
            %>
            <tr>
                <th><label for="empNo">사번</label></th>
                <td>
                    <input type="text" id="empNo" name="empNo" value="<%=member.getEmpNo()%>" disabled>
                </td>
            </tr>
            <tr>
                <th><label for="empNm">이름</label></th>
                <td>
                    <input type="text" id="empNm" name="empNm" value="<%=member.getEmpNm()%>" placeholder="이름" required>
                    *이름을 입력해주세요
                </td>
            </tr>
            <tr>
                <th><label for="empNm">등급</label></th>
                <td>
                    <input type="text" id="empRank" name="empRank" value="<%=member.getEmpRank()%>" placeholder="등급"
                           required>
                </td>
            </tr>
            </tbody>
        </table>
        <hr>
        <div class="buttonDiv">
            <button type="submit">수정</button>
            <button type="button" id="cancelBtn" onclick="location.href='<%=request.getContextPath()%>/menu/list'">
                취소
            </button>
        </div>
    </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/signUp.css">
</head>
<body>
<div class="signUp">
    <h1>회원가입</h1>
    <form id="signUpForm" action="<%=request.getContextPath()%>/member/sign-up" method="post">
        <hr>
        <table>
            <colgroup>
                <col style="width: 25%;">
                <col style="width: 75%;">
            </colgroup>
            <tbody>
            <tr>
                <th><label for="empNo">사번</label></th>
                <td>
                    <input type="text" id="empNo" name="empNo" placeholder="사번" required minlength="5" maxlength="5">
                    *사번을 입력해주세요
                </td>
            </tr>
            <tr>
                <th><label for="empNm">이름</label></th>
                <td><input type="text" id="empNm" name="empNm" placeholder="이름" required>*이름을 입력해주세요</td>
            </tr>
            </tbody>
        </table>
        <hr>
        <div class="buttonDiv">
            <button type="submit">등록</button>
            <button type="button" id="cancelBtn" onclick="location.href='<%=request.getContextPath()%>/member/login'">
                취소
            </button>
        </div>
    </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/login.css"/>
</head>
<body>
<div class="login">
    <form id="loginForm" action="<%=request.getContextPath()%>/member/login" method="post">
        <h1>행복마루에 오신 것을 환영합니다.</h1>

        <h1><label for="empNo">사원번호로 인증해주세요.</label></h1>
        <input type="text" id="empNo" name="empNo" placeholder="사번" minlength="5" maxlength="5" required>

        <button type="submit">로그인</button>
        <button type="button" id="signUpBtn" onclick="location.href='<%=request.getContextPath()%>/member/sign-up'">
            회원가입
        </button>
    </form>
</div>
</body>
</html>
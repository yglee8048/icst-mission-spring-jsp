<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/error.css">
</head>
<body>
<div class="error">
    <h1>오류가 발생하였습니다</h1>
    <hr>
    <table>
        <colgroup>
            <col style="width: 25%;">
            <col style="width: 75%;">
        </colgroup>
        <tbody>
        <tr>
            <th>오류내용</th>
            <td>
                <%=request.getAttribute("errorMessage")%>
            </td>
        </tr>
        </tbody>
    </table>
    <hr>
    <div class="buttonDiv">
        <button type="button" id="homeBtn" onclick="location.href='<%=request.getContextPath()%>/member/login'">
            홈으로
        </button>
    </div>
</div>
</body>
</html>
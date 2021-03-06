<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu/insert.css">
</head>
<body>
<div class="signUp">
    <h1>메뉴생성</h1>
    <form action="<%=request.getContextPath()%>/menu/insert" method="post">
        <hr>
        <table>
            <colgroup>
                <col style="width: 25%;">
                <col style="width: 75%;">
            </colgroup>
            <tbody>
            <tr>
                <th><label for="category">카테고리</label></th>
                <td>
                    <select id="category" name="category" required>
                        <option value="COFFEE_HOT">커피(HOT)</option>
                        <option value="COFFEE_ICE">커피(ICED)</option>
                        <option value="TEA">차(HOT/ICED)</option>
                        <option value="JUICE">주스/스무디</option>
                        <option value="BAKERY">베이커리</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="menuNm">메뉴명</label></th>
                <td><input type="text" id="menuNm" name="menuNm" placeholder="이름" required>*메뉴명을 입력해주세요</td>
            </tr>
            <tr>
                <th><label for="price">가격</label></th>
                <td><input type="number" id="price" name="price" placeholder="가격" required>가격을 입력해주세요</td>
            </tr>
            </tbody>
        </table>
        <hr>
        <div class="buttonDiv">
            <button type="submit">등록</button>
            <button type="button" id="cancelBtn" onclick="location.href='<%=request.getContextPath()%>/menu/manage'">
                취소
            </button>
        </div>
    </form>
</div>
</body>
</html>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu/update.css">
</head>
<body>
<div class="signUp">
    <h1>메뉴수정</h1>
    <%
        MenuEntity menu = (MenuEntity) request.getAttribute("menu");
    %>
    <form action="<%=request.getContextPath()%>/menu/<%=menu.getMenuId()%>/update" method="post">
        <hr>
        <table>
            <colgroup>
                <col style="width: 25%;">
                <col style="width: 75%;">
            </colgroup>
            <tbody>
            <tr>
                <th><label for="menuId">메뉴번호</label></th>
                <td><input type="text" id="menuId" name="menuId" value="<%=menu.getMenuId()%>" readonly></td>
            </tr>
            <tr>
                <th><label for="category">카테고리</label></th>
                <td>
                    <select id="category" name="category" required>
                        <option value="COFFEE_HOT"
                                <% if (menu.getCategory().equals(Category.COFFEE_HOT)) { %>
                                selected
                                <% }%>
                        >
                            커피(HOT)
                        </option>
                        <option value="COFFEE_ICE"
                                <% if (menu.getCategory().equals(Category.COFFEE_ICE)) { %>
                                selected
                                <% }%>
                        >
                            커피(ICED)
                        </option>
                        <option value="TEA"
                                <% if (menu.getCategory().equals(Category.TEA)) { %>
                                selected
                                <% }%>
                        >
                            차(HOT/ICED)
                        </option>
                        <option value="JUICE"
                                <% if (menu.getCategory().equals(Category.JUICE)) { %>
                                selected
                                <% }%>
                        >
                            주스/스무디
                        </option>
                        <option value="BAKERY"
                                <% if (menu.getCategory().equals(Category.BAKERY)) { %>
                                selected
                                <% }%>
                        >
                            베이커리
                        </option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="menuNm">메뉴명</label></th>
                <td>
                    <input type="text" id="menuNm" name="menuNm" value="<%=menu.getMenuNm()%>"
                           placeholder="이름" required>
                    *메뉴명을 입력해주세요
                </td>
            </tr>
            <tr>
                <th><label for="price">가격</label></th>
                <td>
                    <input type="number" id="price" name="price" value="<%=menu.getPrice()%>" placeholder="가격" required>
                    가격을 입력해주세요
                </td>
            </tr>
            </tbody>
        </table>
        <hr>
        <div class="buttonDiv">
            <button type="submit">수정</button>
            <button type="button" id="deleteBtn"
                    onclick="if(confirm('정말로 삭제하시겠습니까?')){location.href='<%=request.getContextPath()%>/menu/<%=menu.getMenuId()%>/delete'}">
                삭제
            </button>
            <button type="button" id="cancelBtn" onclick="location.href='<%=request.getContextPath()%>/menu/manage'">
                취소
            </button>
        </div>
    </form>
</div>
</body>
</html>
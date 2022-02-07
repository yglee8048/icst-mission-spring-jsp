<%@ page import="java.util.List" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu/manage.css">
    <script src="<%=request.getContextPath()%>/lib/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/menu/manage.js"></script>
</head>
<body>
<header>
    <div class="leftHalf">
        <a id="backBtn" href="<%=request.getContextPath()%>/menu/list">뒤로가기</a>
        <a id="insertBtn" href="<%=request.getContextPath()%>/menu/insert">메뉴등록</a>
    </div>
</header>
<div class="menu">
    <ul class="tabs">
        <li id="COFFEE_HOT">커피(HOT)</li>
        <li id="COFFEE_ICE">커피(ICED)</li>
        <li id="TEA">차(HOT/ICED)</li>
        <li id="JUICE">주스/스무디</li>
        <li id="BAKERY">베이커리</li>
    </ul>
    <%
        List<MenuEntity> menu = (List<MenuEntity>) request.getAttribute("menu");
    %>
    <div class="tab_content" id="TAB_COFFEE_HOT">
        <%
            for (MenuEntity item : menu) {
                if (item.getCategory().equals(Category.COFFEE_HOT)) {
        %>
        <div class="item"
             onclick="location.href='<%=request.getContextPath()%>/menu/<%=item.getMenuId()%>/update'">
            <input type="hidden" class="menuId" value="<%=item.getMenuId()%>">
            <img src="<%=request.getContextPath()%>/img/<%=item.getImgFileNm()%>" alt="menu_img">
            <p class="menuName">
                <%=item.getMenuNm()%>
            </p>
            <p><span class="price"><%=item.getPrice()%></span>원</p>
        </div>
        <%
                }
            }
        %>
    </div>
    <div class="tab_content" id="TAB_COFFEE_ICE">
        <%
            for (MenuEntity item : menu) {
                if (item.getCategory().equals(Category.COFFEE_ICE)) {
        %>
        <div class="item"
             onclick="location.href='<%=request.getContextPath()%>/menu/<%=item.getMenuId()%>/update'">
            <input type="hidden" class="menuId" value="<%=item.getMenuId()%>">
            <img src="<%=request.getContextPath()%>/img/<%=item.getImgFileNm()%>" alt="menu_img">
            <p class="menuName">
                <%=item.getMenuNm()%>
            </p>
            <p><span class="price"><%=item.getPrice()%></span>원</p>
        </div>
        <%
                }
            }
        %>
    </div>
    <div class="tab_content" id="TAB_TEA">
        <%
            for (MenuEntity item : menu) {
                if (item.getCategory().equals(Category.TEA)) {
        %>
        <div class="item"
             onclick="location.href='<%=request.getContextPath()%>/menu/<%=item.getMenuId()%>/update'">
            <input type="hidden" class="menuId" value="<%=item.getMenuId()%>">
            <img src="<%=request.getContextPath()%>/img/<%=item.getImgFileNm()%>" alt="menu_img">
            <p class="menuName">
                <%=item.getMenuNm()%>
            </p>
            <p><span class="price"><%=item.getPrice()%></span>원</p>
        </div>
        <%
                }
            }
        %>
    </div>
    <div class="tab_content" id="TAB_JUICE">
        <%
            for (MenuEntity item : menu) {
                if (item.getCategory().equals(Category.JUICE)) {
        %>
        <div class="item"
             onclick="location.href='<%=request.getContextPath()%>/menu/<%=item.getMenuId()%>/update'">
            <input type="hidden" class="menuId" value="<%=item.getMenuId()%>">
            <img src="<%=request.getContextPath()%>/img/<%=item.getImgFileNm()%>" alt="menu_img">
            <p class="menuName">
                <%=item.getMenuNm()%>
            </p>
            <p><span class="price"><%=item.getPrice()%></span>원</p>
        </div>
        <%
                }
            }
        %>
    </div>
    <div class="tab_content" id="TAB_BAKERY">
        <%
            for (MenuEntity item : menu) {
                if (item.getCategory().equals(Category.BAKERY)) {
        %>
        <div class="item"
             onclick="location.href='<%=request.getContextPath()%>/menu/<%=item.getMenuId()%>/update'">
            <input type="hidden" class="menuId" value="<%=item.getMenuId()%>">
            <img src="<%=request.getContextPath()%>/img/<%=item.getImgFileNm()%>" alt="menu_img">
            <p class="menuName">
                <%=item.getMenuNm()%>
            </p>
            <p><span class="price"><%=item.getPrice()%></span>원</p>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
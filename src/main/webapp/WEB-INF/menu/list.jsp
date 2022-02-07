<%@ page import="java.util.List" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.MenuEntity" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.menu.entity.Category" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.common.constant.SessionKey" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu/list.css">
    <script src="<%=request.getContextPath()%>/lib/js/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/menu/list.js"></script>
</head>
<body>
<header>
    <div class="rightHalf">
        <a id="logoutBtn" href="<%=request.getContextPath()%>/member/logout">로그아웃</a>
        <a id="updateBtn" href="<%=request.getContextPath()%>/member/update">회원수정</a>
        <a id="withdrawBtn"
           onclick="if(confirm('정말 탈퇴하시겠습니까?')){location.href='<%=request.getContextPath()%>/member/withdraw'}">회원탈퇴</a>
        <a id="orderListBtn" href="<%=request.getContextPath()%>/order/list">주문목록</a>
        <a id="manageMenuBtn" href="<%=request.getContextPath()%>/menu/manage">메뉴관리</a>
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
        <div class="item">
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
        <div class="item">
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
        <div class="item">
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
        <div class="item">
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
        <div class="item">
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
<div class="order">
    <form id="orderForm" action="<%=request.getContextPath()%>/order/insert" method="post">
        <input type="hidden" id="price" name="price">
        <div class="orderDetails">
            <h1>주문내역</h1>
            <table>
                <colgroup>
                    <col style="width: 45%;">
                    <col style="width: 15%;">
                    <col style="width: 25%;">
                    <col style="width: 15%;">
                </colgroup>
                <thead>
                <tr>
                    <th>메뉴명</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th></th><!-- Delete Button -->
                </tr>
                </thead>
                <tbody>
                <tr id="orderTemplate" class="blind">
                    <td class="menuName">아메리카노</td>
                    <td class="qty">2</td>
                    <td class="price">2000</td>
                    <td>
                        <button type="button">삭제</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <table class="orderSum">
            <colgroup>
                <col style="width: 30%;">
                <col style="width: 70%;">
            </colgroup>
            <tbody>
            <tr>
                <th>총 금액</th>
                <td><span id="totalPrice">0</span>원</td>
            </tr>
            <tr>
                <th>사번</th>
                <td>
                    <%=session.getAttribute(SessionKey.EMP_NO)%>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="orderButtonDiv">
            <button type="submit">사원결제</button>
        </div>
    </form>
</div>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="com.lgcns.icst.mission.spring.jsp.hangma.order.entity.OrderEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>행복마루</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/order/list.css">
    <script src="<%=request.getContextPath()%>/lib/js/jquery-3.4.1.js"></script>
</head>
<body>
<div class="order">
    <h1> <%=request.getAttribute("empNm")%> 님의 주문내역</h1>
    <hr>
    <table>
        <colgroup>
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
        </colgroup>
        <thead>
        <tr>
            <th>No</th>
            <th>주문금액</th>
            <th>할인금액</th>
            <th>총 금액</th>
            <th>주문일시</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<OrderEntity> orders = (List<OrderEntity>) request.getAttribute("orders");
            for(OrderEntity order : orders) {
        %>
        <tr>
            <td><%=order.getOrderId()%></td>
            <td><%=order.getPrice()%></td>
            <td><%=order.getDiscountPrice()%></td>
            <td><%=order.getPrice() - order.getDiscountPrice()%></td>
            <td><%=order.getOrderDt()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <hr>
    <div class="buttonDiv">
        <button type="button" id="menuBtn" onclick="location.href='<%=request.getContextPath()%>/menu/list'">
            메뉴보기
        </button>
    </div>
</div>
</body>
</html>
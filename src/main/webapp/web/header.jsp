<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="${pageContext.request.contextPath}/images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容" style="width:350px"/>
        <a href="search.html" class="rt"><img id="search" src="${pageContext.request.contextPath}/images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
        	<li><a href="${pageContext.request.contextPath}/main/showPersonal.do">${user.username}</a></li>
            <li><a href="favorites.html" title="我的收藏"><img class="care" src="${pageContext.request.contextPath}/images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="orders.html" title="我的订单"><img class="order" src="${pageContext.request.contextPath}/images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="../cart/showCart.do" title="我的购物车"><img class="shopcar" src="${pageContext.request.contextPath}/images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="help.html">帮助</a><b>|</b></li>
            <c:choose>
            	<c:when test="${user!=null}">
            		<li><a href="${pageContext.request.contextPath}/user/exit.do">退出</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="${pageContext.request.contextPath}/user/toLogin.do">登陆</a></li>
            	</c:otherwise>
            </c:choose>
        </ul>
    </div>
</header>
<%-- 
    Document   : header
    Created on : Jul 25, 2023, 4:06:41 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<nav class="menuchinh">
    <div class="logo1">
        <a href="<c:url value ="/"/>" id="logo"><img src="<c:url value="/img/logo_1.png"/>" alt="alert" /></a>
    </div>
    <div class="menu">
        <ul class="menucha">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="sub"><a href="<c:url value ="/dangnhap"/>">Đăng nhập</a></li>
                <li class="sub"><a href="<c:url value ="/dangky"/>">Đăng ký</a></li>

            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="sub"><a href="<c:url value ="/"/>">${pageContext.request.userPrincipal.name}</a></li>
                </c:if>


            <li class="sub"><a href="<c:url value ="/dangkykham"/>">Đăng ký khám</a></li>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="sub"><a href="<c:url value ="/logout"/>">Đăng xuất</a></li>
                </c:if>

            <li class="sub"><a href="<c:url value ="/lapdskham"/>">Lập danh sách khám</a></li>
        </ul>
    </div>
</nav>

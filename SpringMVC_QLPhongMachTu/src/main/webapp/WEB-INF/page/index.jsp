<%-- 
    Document   : index.jsp
    Created on : Jul 24, 2023, 12:37:37 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="idText">Xin chao ban!!!</h1>
<ul>
    <c:forEach items="${benhnhans}" var="p">
        <li>
            ${p.idBn} - ${p.hoTen}
        </li>
    </c:forEach>
</ul>


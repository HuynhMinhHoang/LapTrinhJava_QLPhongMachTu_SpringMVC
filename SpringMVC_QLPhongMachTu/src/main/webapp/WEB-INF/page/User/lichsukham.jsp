<%-- 
    Document   : lichsukham
    Created on : Aug 12, 2023, 11:18:36 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/benhnhan/lichsukham" var="actions"/>
<c:if test="${err != null}">
    <div class="alert1">
        ${err}
    </div>
</c:if>

<form:form modelAttribute="user">
    <div class="text-lsk">
        <p>Lịch sử khám bệnh</p>
    </div>
    <main class="table lskham">
        <div>
            <section class="table__body lskham1">
                <table>
                    <thead>
                        <tr>

                            <th>Tên bệnh nhân</th>
                            <th>Trạng thái</th>
                            <th>Ngày đăng ký</th>
                            <th></th>

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${lskham}" var="p">
                            <tr>
                                <td>${p.idBn.hoTen}</td>
                                <td><c:choose>
                                        <c:when test="${p.trangThaidky.toString() eq 0}">
                                            <p id="xacnhan">Chưa xác nhận</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p id="xacnhan1"> Đã xác nhận </p>
                                        </c:otherwise>
                                    </c:choose>
                                </td>

                                <td>${p.ngayDky}</td>
                                <td>
                                    <button class="btn_lsk">Hủy phiếu đăng ký</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
    </main>
</form:form>
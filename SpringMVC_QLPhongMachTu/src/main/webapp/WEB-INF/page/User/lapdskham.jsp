<%-- 
    Document   : lapdskham
    Created on : Jul 28, 2023, 3:09:49 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/yta/lapdskham" var="actions"/>
<form:form method="post" modelAttribute="user" action="${actions}">

    <nav class="table1">
        <section class="table__body1">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Bệnh nhân</th>
                        <th>Ngày đăng ký</th>
                        <th>Y tá</th>
                        <th>Ngày hẹn khám</th>

                        <th>ID Phiếu khám</th>

                        <th>Trạng thái</th>
                        <th>Bác sĩ</th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${dskham}" var="p">
                    <tbody>
                        <tr>
                            <td>${p.idPhieudk}</td>
                            <td>${p.idBn.hoTen}</td>
                            <td>${p.ngayDky}</td>
                            <td>${p.idYt.hoTen}</td>
                            <td>${p.ngayHkham}</td>
                            <td>${p.idPk.idPhieukham}</td>
                            <td><c:choose>
                                    <c:when test="${p.trangThaidky.toString() eq 0}">
                                        <p id="xacnhan">Chưa xác nhận</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p id="xacnhan1"> Đã xác nhận </p>
                                    </c:otherwise>
                                </c:choose></td>
                            <td>
                                <select path="idRole" id="idRole" class="form-select" cssErrorClass="is-invalid">
                                    <c:forEach items="${dsbacsi}" var="c">
                                        <option value="${c.idTk}">${c.hoTen}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <div class="admin_submit111">
                                    <a href="<c:url value="/yta/lapdskham/${p.idPhieudk}"/>" >
                                        <c:choose>
                                            <c:when test="${p.trangThaidky == 0}">
                                                Xác nhận
                                            </c:when>
                                            <c:otherwise>
                                                Hủy xác nhận
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </div>

                            </td>

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </section>
    </nav>

</form:form>




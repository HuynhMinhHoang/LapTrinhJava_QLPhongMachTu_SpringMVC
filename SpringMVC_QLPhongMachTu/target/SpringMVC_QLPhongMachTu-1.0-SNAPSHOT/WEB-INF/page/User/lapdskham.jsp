<%-- 
    Document   : lapdskham
    Created on : Jul 28, 2023, 3:09:49 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/yta/lapdskham" var="actions"/>

<nav class="header-lapdskham">
    <div class="text-lsk lsk1">
        <p>Danh sách bệnh nhân đăng ký khám</p>
    </div>
    <div class="lapdskham_search">
        <p>Tìm kiếm theo ngày</p>
        <form action="${actions}">
            <input name="kwDate" type="date"" placeholder="Tìm kiếm theo ngày...">
            <button type="submit"> <i class="fa-solid fa-magnifying-glass"></i> </button>
        </form>
    </div>
</nav>

<form:form method="post" modelAttribute="themDSpkd" action="${actions}">
    <nav class="table1">
        <section class="table__body1">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ID Bệnh nhân</th>
                        <th>Email</th>
                        <th>Ngày đăng ký</th>
                        <th>Y tá</th>
                        <th>Bác sĩ</th>
                        <th>Ngày hẹn khám</th>
                        <th>Trạng thái</th>
                        <th></th>
                        <!--<th>ID Phiếu khám</th>-->
                    </tr>
                </thead>
                <c:forEach items="${dskham}" var="p">
                    <tbody>
                        <tr>
                            <td>${p.idPhieudk}</td>
                            <td>[${p.idBn.idTk}] ${p.idBn.hoTen}</td>
                            <td>${p.idBn.email}</td>
                            <td>${p.ngayDky}</td>
                            <td>${p.idYt.hoTen}</td>
                            
                            <td>
                                <form:select name="idBs" path="idBs" id="idBs" class="form-select" cssErrorClass="is-invalid">
                                    <c:forEach items="${dsbacsi}" var="c">
                                        <form:option value="${c.idTk}" >${c.hoTen}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            
                            <td>
                                <form:input type="date" path="ngayHkham" id="ngayHKham" placeholder=""/>
                            </td>
                            
                            <td>
                                <c:choose>
                                    <c:when test="${p.trangThaidky.toString() eq 0}">
                                        <p id="xacnhan">Chưa xác nhận</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p id="xacnhan1"> Đã xác nhận </p>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            
                            <td> 
                                <c:choose>
                                    <c:when test="${p.trangThaidky == 0}">
                                        <button class="admin_submit111" type="submit">
                                            <a href="<c:url value="/yta/lapdskham/${p.idPhieudk}"/>" >
                                                Xác nhận
                                            </a>
                                        </button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="admin_submit111" id="xacnhanLK" type="submit">
                                            <a href="<c:url value="/yta/lapdskham/${p.idPhieudk}"/>" >
                                                Hủy Xác nhận
                                            </a>
                                        </button>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            
                            
                            <!--<td>${p.idPk.idPhieukham}</td>-->

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </section>
    </nav>

</form:form>




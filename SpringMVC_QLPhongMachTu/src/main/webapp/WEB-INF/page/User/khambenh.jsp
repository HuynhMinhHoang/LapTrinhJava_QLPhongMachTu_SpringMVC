<%-- 
    Document   : khambenh.jsp
    Created on : Aug 22, 2023, 2:36:28 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/bacsi/khambenh" var="actions"/>



<nav class="dkk_main dkykhambenh">

    <div class="dkk khambenh">

        <form:form class="form_login11" method="post" action="${actions}" modelAttribute="dsdv">

            <div class="contentdkk2_main contentdkk2_main1">
                <div class="contentdkk2 contentdkk21">
                    <h1>PHIẾU KHÁM BỆNH NHÂN</h1>
                </div>




                <div class="contentdkk3 contentdkk31">
                    <div id="input_tt">
                        <h5>ID Bệnh nhân</h5>
                        <input type="text"  placeholder="${idpdk.idBn.idTk}" readonly="true"/>
                    </div>

                    <div>
                        <h5>Họ tên</h5>
                        <input type="text" placeholder="${idpdk.idBn.hoTen}" readonly="true"/>
                    </div>

                </div>


                <div class="contentdkk2 contentdkk22">
                    <h5>* Thông tin bệnh án</h5>
                </div>

                <div class="contentdkk4 contentdkk41">

                    <form:select path="idDv" id="idDv" class="form-select" cssErrorClass="is-invalid">
                        <option value="" >Dịch vụ</option>
                        <c:forEach items="${listDv}" var="c" >
                            <option value="${c.idDv}" >${c.tenDv}</option>
                        </c:forEach>
                    </form:select>


                    <div class="contentdkk5 contentdkk51">
                        <input class="custom-input" type="text" id="custom-input1" path="sdt" placeholder="Triệu chứng" />
                    </div>

                    <div class="contentdkk5 contentdkk51">
                        <input class="custom-input" type="text" id="custom-input1" path="diaChi" placeholder="Kết luận bệnh án" />
                    </div>

                    <div class="submitdkk submitdkk111 submitdkk1111">
                        <a><button type="submit">LƯU THÔNG TIN</button></a>
                    </div>

                </div>

            </div>

        </form:form>

        <form>
            <div class="contentdkk2_main contentdkk2_main1">
                <div class="contentdkk2 lskhambenh">
                    <h1>LỊCH SỬ KHÁM BỆNH</h1>
                    <div class="inputkw inputkw1">
                        <form action="${actions}">
                            <input name="kwDate" type="date"" placeholder="Tìm kiếm theo ngày...">
                            <button type="submit"> <i class="fa-solid fa-magnifying-glass"></i> </button>
                        </form>
                    </div>
                </div>




                <section class="table__body1 table__body11">
                    <table>
                        <thead>
                            <tr>
                                <th>ID Bệnh nhân</th>
                                <th>Họ tên</th>
                                <th>Ngày khám</th>

                                <th>Triệu chứng</th>

                                <th>Dịch vụ</th>
                                <th>Kết luận</th>

                            </tr>
                        </thead>
                        <%--<c:forEach items="${dsbenhnhan}" var="d">--%>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>

                                <td></td>
                                <td></td>

                            </tr>
                        </tbody>
                        <%--</c:forEach>--%>
                    </table>
                </section>

            </div>

        </form>

    </div>


</nav>


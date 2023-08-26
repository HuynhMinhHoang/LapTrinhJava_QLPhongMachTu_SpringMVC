<%-- 
    Document   : capthuoc
    Created on : Aug 26, 2023, 12:40:10 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/bacsi/capthuoc" var="actions"/>

<%--<c:if test="${errMsg != null}">
    <div class="alert1">
        ${errMsg}
    </div>
</c:if>--%>

<nav class="dkk_main dkykhambenh">

    <div class="dkk khambenh">

        <form:form class="form_login11" method="post" action="${actions}" modelAttribute="addChiTietThuoc">
            <form:hidden path="idChitietThuoc"/>
            <input type="hidden" name="idPDK" value="${idPDK}" />

         
            <div class="contentdkk2_main contentdkk2_main1">
                <div class="contentdkk2 contentdkk21">
                    <h1>CẤP THUỐC</h1>
                </div>




                <div class="contentdkk3 contentdkk31">
                    <div id="input_tt">
                        <h5>ID Bệnh nhân</h5>
                        <input type="text"  placeholder="${idpdk.idBn.idTk}" disabled="true"/>
                    </div>

                    <div>
                        <h5>Họ tên</h5>
                        <input type="text" placeholder="${idpdk.idBn.hoTen}" disabled="true"/>
                    </div>

                </div>


                <div class="contentdkk5 contentdkk51">
                    <h5>Kết luận bệnh án</h5>
                    <input type="text" placeholder="${idpdk.idPk.ketLuan}" disabled="true"/>
                </div>


                <div class="contentdkk2 contentdkk22">
                    <h5>* Thông tin thuốc</h5>
                </div>

                <div class="contentdkk4 contentdkk41">



                    <div class="contentdkk3 contentdkk31 contentdkk311">

                        <form:select path="idThuoc" id="idThuoc" class="form-select form-select1 form-select111" cssErrorClass="is-invalid">
                            <option value="" >Thuốc</option>
                            <c:forEach items="${listThuoc}" var="c">
                                <option value="${c.idThuoc}" >${c.tenThuoc}</option>
                            </c:forEach>
                        </form:select>


                        <div class="contentdkk5 contentdkk51">
                            <form:input class="custom-input" type="number" id="custom-input1" path="soLuongSd" placeholder="Số lượng" />
                        </div>

                        <div class="contentdkk5 contentdkk51 contentdkk511">
                            <button>
                                <img src="<c:url value='/img/plus.png'/>" alt="" />
                            </button>
                        </div>

                    </div>


                    <div class="contentdkk5 contentdkk51">
                        <form:input class="custom-input" type="text" id="custom-input1" path="hdsd" placeholder="Hướng dẫn sử dụng thuốc" />
                    </div>

                    <div class="submitdkk submitdkk111 submitdkk1111">
                        <a href=""><button type="submit">LƯU THÔNG TIN</button></a>
                    </div>

                </div>

            </div>

        </form:form>

        <!--</form>-->



        <form>
            <div class="contentdkk2_main contentdkk2_main1 contentdkk2_main11">
                <div class="contentdkk2 lskhambenh">
                    <h1>DANH SÁCH THUỐC</h1>
                    <div class="inputkw inputkw1">
                        <form action="${actions}">
                            <input name="kw" type="text"" placeholder="Tìm kiếm thuốc...">
                            <button type="submit"> <i class="fa-solid fa-magnifying-glass"></i> </button>
                        </form>
                    </div>
                </div>




                <section class="table__body1 table__body11 table__body111">
                    <table>
                        <thead>
                            <tr>
                                <th>ID Thuốc</th>
                                <th>Tên thuốc</th>
                                <th>Xuất xứ</th>
                                <th>Giá thuốc</th>
                                <th>Đơn vị</th>
                                <th>Số lượng</th>
                                <th>HDSD</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listThuoc}" var="p">
                                <tr>
                                    <td>${p.idThuoc}</td>
                                    <td>${p.tenThuoc}</td>
                                    <td>${p.xuatXu}</td>
                                    <td>${p.giaThuoc}</td>
                                    <td>${p.donVi}</td>
                                    <td>${p.soLuong}</td>
                                    <th></th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>

                <div class="submitdkk submitdkk111 submitdkk1111">
                    <a href=""><button type="submit">XUẤT FILE PDF</button></a>
                </div>

            </div>

        </form>
    </div>






</div>


</nav>

<!--<a href="/SpringMVC_QLPhongMachTu/generate-pdf?id=${id}" target="_blank">Generate PDF</a>-->
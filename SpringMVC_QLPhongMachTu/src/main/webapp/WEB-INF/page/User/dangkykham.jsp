<%-- 
    Document   : dangkykham
    Created on : Jul 26, 2023, 11:01:33 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/benhnhan/dangkykham" var="actions"/>


<c:if test="${err != null}">
    <div class="alert1">
        ${err}
    </div>
</c:if>


<form:form method="post" modelAttribute="themphieudky" action="${actions}" enctype="multipart/form-data">


    <nav class="dkk_main">
        <!--<div class="textdkk"><h1>ĐĂNG KÝ KHÁM</h1></div>-->

        <div class="dkk">
            <div class="dkk1">
                <div class="contentdkk1">
                    <h5>Lưu ý:</h5>
                    <h5>Lịch hẹn có hiệu lực sau khi có xác nhận chính thức từ Phòng khám Bệnh viện Health couch</h5>
                    <h5>Quý khánh hàng vui lòng cung cấp thông tin chính xác để được phục vụ tốt nhất. Trong trường hợp cung cấp sai thông tin email & điện thoại, việc xác nhận cuộc hẹn sẽ không hiệu lực.</h5>
                    <h5>Quý khách sử dụng dịch vụ đặt hẹn trực tuyến, xin vui lòng đặt trước ít nhất là 24 giờ trước khi đến khám.</h5>
                    <h5>Trong trường hợp khẩn cấp hoặc nghi ngờ có các triệu chứng nguy hiểm, quý khách vui lòng ĐẾN TRỰC TIẾP Phòng khám hoặc các trung tâm y tế gần nhất để kịp thời xử lý.</h5>
                </div>
            </div>
            <div class="contentdkk2_main">
                <div class="contentdkk2">
                    <h1>ĐĂNG KÝ KHÁM</h1>
                    <h5>Vui lòng kiểm tra thông tin chính xác trước khi gửi phiếu đăng ký khám!</h5>
                </div>


                <%--<form:hidden path="idTk"/>--%>
                <%--<form:hidden path="taiKhoan"/>--%>
                <%--<form:hidden path="avt"/>--%>


                <div class="contentdkk3">
                    <input class="custom-input" type="text" id="custom-input1" placeholder="${user.hoTen}" disabled ="true"/>
                    <input class="custom-input" type="text" id="custom-input1" placeholder="${user.email}" disabled ="true"/>
                </div>

                <div class="contentdkk4">
                    <select class="custom-input" path="gioiTinh" id="custom-input1" cssErrorClass="is-invalid">
                        <option value="${user.gioiTinh}" label="${user.gioiTinh}" />
                    </select>


                    <div class="contentdkk5">
                        <input class="custom-input" type="text" id="custom-input1" placeholder="${user.ngaySinh}" disabled ="true"/>
                    </div>

                    <div class="contentdkk5">
                        <input class="custom-input" type="text" id="custom-input1" placeholder="${user.sdt}" disabled ="true"/>
                    </div>

                    <div class="contentdkk5">
                        <input class="custom-input" type="text" id="custom-input1" placeholder="${user.diaChi}" disabled ="true"/>
                    </div>

                    <!--hide-->
                    <%--<form:input type="text" path="matKhau" id="matKhauu" placeholder=""/>--%>
                    <%--<form:input type="file" id="file1" path="file" placeholder="Upload Avatar"/>--%>



                    <div class="submitdkk">
                        <a><button type="submit">ĐĂNG KÝ KHÁM</button></a>
                    </div>
                </div>


            </div>
    </nav>

    <form:input type="text" id="hoTen111" path="tenBenhNhanDky" value="${pageContext.request.userPrincipal.name}" />
</form:form>
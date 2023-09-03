<%-- 
    Document   : taohoadon
    Created on : Aug 31, 2023, 4:39:20 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/yta/taohoadon" var="actions"/>

<form:form method="post" action="${actions}" modelAttribute="addHoaDon">
    <%--<form:hidden path="idHoadon" />--%>
    <%--<form:hidden path="ngayThanhToan" />--%>

    <nav class="login111 login111111">

        <div class="login_main1111 taohoadon1">  

            <div class="dky111 taohoadon2">
                <p id="tenHoaDon">THÔNG TIN HÓA ĐƠN</p>

                <div class="thongtin_taohoadon">
                    <div>
                        <p>
                            Tên bệnh nhân: ${idHD.idPhieudky.idBn.hoTen}
                        </p>
                    </div>

                    <div>
                        <p>
                            Ngày khám bệnh: <fmt:formatDate value="${idHD.idPhieudky.chonNgaykham}" pattern="dd-MM-yyyy" />

                        </p>
                    </div>
                </div>

                <div class="thongtin_taohoadon">
                    <div>
                        <p>
                            Triệu chứng bệnh: ${idHD.idPhieudky.idPk.trieuChung}
                        </p>
                    </div>

                    <div>
                        <p>
                            Kết luận bệnh: ${idHD.idPhieudky.idPk.ketLuan}
                        </p>
                    </div>
                </div>

                <div class="thongtin_taohoadon">
                    <div>
                        <p>
                            Tiền khám & Tiền dịch vụ: ${idHD.tienKham.tienKham + idHD.tienDv}vnđ
                        </p>
                    </div>

                    <div>
                        <p>
                            Tiền thuốc: ${idHD.tienThuoc}vnđ
                        </p>
                    </div>
                </div>

                <nav class="loaiTT">
                    <div class="thongtin_taohoadon thongtin_taohoadon1">
                        <div>
                            <p>
                                Tổng tiền: ${idHD.tienKham.tienKham + idHD.tienDv + idHD.tienThuoc}vnđ
                            </p>
                        </div>

                    </div>

                    <div class="login0111 login011111">
                        <div class="one2111 one21116">
                            <a href="/SpringMVC_QLPhongMachTu/ThongHoaDon-PDF?id=${id}" target="_blank">
                                <img src="<c:url value='/img/pdf.png'/>" />
                            </a>
                        </div>

                        <div class="one2111 one21116">
                            <a href="/SpringMVC_QLPhongMachTu/taohoadon?id=${id}" target="_blank">
                                <img src="<c:url value='/img/momo.png'/>" />
                            </a>
                        </div>

                    </div>
                </nav>


                <input type="hidden" name="id" value="${id}" />
                <div class="one2111 one211122222">
                    <button type="submit" >
                        Xác nhận thanh toán
                    </button>
                </div> 

            </div>

    </nav>
</form:form>

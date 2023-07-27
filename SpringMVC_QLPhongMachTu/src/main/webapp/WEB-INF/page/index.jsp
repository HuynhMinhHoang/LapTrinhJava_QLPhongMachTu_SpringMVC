<%-- 
    Document   : index.jsp
    Created on : Jul 24, 2023, 12:37:37 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="index">
    <div class="title">
        <div>
            <h3>BỆNH VIỆN CAO CẤP CHUẨN 5 SAO HÀNG ĐẦU VIỆT NAM</h3>
            <p>Hệ thống Bệnh Viện Health Couch là địa chỉ uy tín về khám chữa bệnh, với đội ngũ chuyên gia bác sĩ hàng đầu, trang thiết bị hiện đại, cùng các phác đồ điều trị hiệu quả, khoa học mang đến dịch vụ khám, điều trị, chăm sóc sức khỏe cao cấp, toàn diện với chi phí hợp lý.</p>
            <a href="<c:url value ="/dangnhap"/>"><button>ĐĂNG KÝ KHÁM</button></a>
        </div>
        <div>
            <img src="<c:url value="/img/banner_img.png"/>" alt="alert" />
        </div>
    </div>
</nav>





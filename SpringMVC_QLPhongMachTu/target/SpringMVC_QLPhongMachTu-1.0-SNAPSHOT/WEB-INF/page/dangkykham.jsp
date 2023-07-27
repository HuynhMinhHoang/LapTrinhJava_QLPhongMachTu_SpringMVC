<%-- 
    Document   : dangkykham
    Created on : Jul 26, 2023, 11:01:33 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        <div class="dkk2">
            <div class="contentdkk2_main">
                <div class="contentdkk2">
                    <h1>ĐĂNG KÝ KHÁM</h1>
                    <h5>Vui lòng điền thông tin vào form bên dưới để đăng ký khám bệnh theo yêu cầu!</h5>
                </div>

                <div class="contentdkk3">

                    <input type="text" placeholder="Họ tên"/>
                    <input type="text" placeholder="Email"/>
                </div>

                <div class="contentdkk4">
                    <form action="action">
                        <select name="lang" id="lang-select">
                            <option value="">Giới tính</option>
                            <option value="sex">Nam</option>
                            <option value="sex">Nữ</option>
                        </select>
                    </form>
                </div>
                
                <div class="contentdkk6">
                    <form class="p-1" action="https://httpbin.org/anything" method="post">
                        <input type="date" name="ngaysinh" id="ngaysinh" value="yyyy-mm-dd">
                    </form>
                </div>

                <div class="contentdkk5">
                    <input type="text" placeholder="Địa chỉ"/>
                </div>
                
                <div class="submitdkk">
                    <a href="<c:url value ="/dangnhap"/>"><button>ĐĂNG KÝ KHÁM</button></a>
                </div>
            </div>
        </div>







    </div>
</nav>
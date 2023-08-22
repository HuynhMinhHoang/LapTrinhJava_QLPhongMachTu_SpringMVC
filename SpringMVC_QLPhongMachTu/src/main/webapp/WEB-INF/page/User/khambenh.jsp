<%-- 
    Document   : khambenh.jsp
    Created on : Aug 22, 2023, 2:36:28 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<nav class="dkk_main dkykhambenh">

    <div class="dkk khambenh">
        <form>
            <div class="contentdkk2_main contentdkk2_main1">
                <div class="contentdkk2 contentdkk21">
                    <h1>PHIẾU KHÁM BỆNH NHÂN</h1>
                </div>




                <div class="contentdkk3 contentdkk31">
                    <input class="custom-input" type="text" id="custom-input1" path="hoTen" placeholder="ID bệnh nhân" readonly="true"/>
                    <input class="custom-input" type="text" id="custom-input1" path="email" placeholder="Họ và tên" readonly="true"/>
                </div>

                <div class="contentdkk2 contentdkk22">
                    <h5>* Thông tin bệnh án</h5>
                </div>
                
                <div class="contentdkk4 contentdkk41">

                    <select path="gioiTinh" id="gioiTinh" class="form-select" cssErrorClass="is-invalid">
                        <option value="" label="Dịch vụ" />
                    </select>


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

        </form>

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
                                <th>Bệnh nhân</th>
                                <th>Bệnh nhân</th>
                                <th>Bệnh nhân</th>
                                
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


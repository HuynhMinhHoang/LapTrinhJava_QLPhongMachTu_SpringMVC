<%-- 
    Document   : quanlytk
    Created on : Aug 6, 2023, 1:16:40 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--<section class="admin_tk">
    <div class="list_ac">

        <div class="search_ac">
            <div class="search_ac1">
                <input type="search" id="search" placeholder="Search..." />
                <span class="icon"><i class="fa fa-search"></i></span>
            </div>
        </div>

        <nav class="container">
            <div class="container mt-3">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID TK</th>
                            <th>HỌ VÀ TÊN</th>
                            <th>NĂM SINH</th>
                            <th>GIỚI TÍNH</th>
                            <th>TÀI KHOẢN</th>
                            <th>MẬT KHẨU</th>
                            <th>ROLE</th>
                        </tr>
                    </thead>
                    <tbody>
<c:forEach items="${benhnhan}" var="p">
    <tr>
        <td>${p.idBn}</td>
        <td>${p.hoTen}</td>
        <td>${p.namSinh}</td>
        <td>${p.gioiTinh}</td>
        <td>${p.diaChi}</td>
        <td>${p.email}</td>
        <td>${p.email}</td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</nav>
</div>

<div class="change_ac">

<div class="change_ac1">
<div class="change1">
<h5>ID tk</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>

<div class="change1">
<h5>Ho ten</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>
</div>


<div class="change_ac1">
<div class="change1">
<h5>Nam sinh</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>

<div class="change1">
<h5>Gioi tinh</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>
</div>

<div class="change_ac1">
<div class="change1">
<h5>username</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>

<div class="change1">
<h5>password</h1>
<input type="text" path="hoTen" id="hoTen" placeholder="Họ tên"/>
</div>
</div>

<div class="change_ac1">
<select class="role" name="lang" id="lang-select" path="gioiTinh">
<option value="">user_role</option>
<option value="sex">Admin</option>
<option value="sex">Bác sĩ</option>
<option value="sex">Y tá</option>
</select>
</div>


<div>

</div>

</div>
</section>-->

<main class="table">
    <div>
        <section class="table__header">
            <h3>Danh sách tài khoản</h3>
            <div class="input-group">
                <input type="search" placeholder="Tìm kiếm...">
            </div>
        </section>
        <section class="table__body">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Họ tên </th>
                        <th>Năm sinh</th>
                        <th>Giới tính</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>User_Role</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${benhnhan}" var="p">
                        <tr>
                            <td>${p.idBn}</td>
                            <td>${p.hoTen}</td>
                            <td>${p.namSinh}</td>
                            <td>${p.gioiTinh}</td>
                            <td>${p.diaChi}</td>
                            <td>${p.email}</td>
                            <td>${p.gioiTinh}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>

        <section class="admin_btn">
            <div class="admin_submit">
                <button type="submit">THÊM</button>         
            </div>

            <div class="admin_submit">
                <button type="submit">SỬA</button>      
            </div>

            <div class="admin_submit">
                <button type="submit">CẬP NHẬT</button>   
            </div>

            <div class="admin_submit admin_submit1">
                <button type="submit">XÓA</button>   
            </div>
        </section>

    </div>

    <div class="change_ac">

        <div class="change_ac1">
            <div class="change1">
                <h5>ID</h5>
                <input type="text" path="hoTen" id="hoTen" placeholder="" disabled/>
            </div>

            <div class="change1">
                <h5>Họ tên</h1>
                    <input type="text" path="hoTen" id="hoTen" placeholder=""/>
            </div>
        </div>


        <div class="change_ac1">
            <div class="change1">
                <h5>Năm sinh</h5>
                <input type="text" path="hoTen" id="hoTen" placeholder=""/>
            </div>

            <div class="change1">
                <h5>Giới tính</h5>
                <input type="text" path="hoTen" id="hoTen" placeholder=""/>
            </div>
        </div>

        <div class="change_ac1">
            <div class="change1">
                <h5>Username</h5>
                <input type="text" path="hoTen" id="hoTen" placeholder=""/>
            </div>

            <div class="change1">
                <h5>Password</h5>
                <input type="text" path="hoTen" id="hoTen" placeholder=""/>
            </div>
        </div>

        <div class="change_ac1" id="role_main">
            <div class="change1">
                <h5>Chức vụ</h5>
                <select class="role" name="lang" id="lang-select" path="gioiTinh">
                    <option value="sex">Admin</option>
                    <option value="sex">Bác sĩ</option>
                    <option value="sex">Y tá</option>
                </select>
            </div>

        </div>
    </div>

</main>
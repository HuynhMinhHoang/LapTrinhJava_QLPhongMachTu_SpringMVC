<%-- 
    Document   : login
    Created on : Jul 24, 2023, 1:34:13 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="login">
    <div class="login_main">  
        <form class="form_login">
            <p>ĐĂNG KÝ</p>
            <div class="login0">
                <div class="one">
                    <div class="one1">
                        <div id="tk1"><i class="fas fa-key"></i></div>
                    </div>

                    <div class="one1">
                        <input type="email" placeholder="Nhập tài khoản"/>
                    </div>
                </div>
            </div>

            <div class="login0">
                <div class="one">
                    <div class="one1">
                        <div id="tk1"><i class="fas fa-lock"></i></div>
                    </div>

                    <div class="one1">
                        <input type="password" placeholder="Nhập mật khẩu">
                    </div>
                </div>
            </div>

            <div class="login0">
                <div class="one">
                    <div class="one1">
                        <div id="tk1"><i class="fas fa-lock"></i></div>
                    </div>

                    <div class="one1">
                        <input type="password" placeholder="Nhập lại mật khẩu">
                    </div>
                </div>
            </div>
            

            <div class="login0">
                <div class="one2">
                    <button onclick="submit3(this)">Đăng ký</button>
                </div>
            </div>

        </form>
    </div>
</nav>




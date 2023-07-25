<%-- 
    Document   : header
    Created on : Jul 25, 2023, 4:06:41 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-info p-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">DBook Inc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class=" collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto ">
                <li class="nav-item">
                    <a class="nav-link mx-2 active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="#">Pricing</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link mx-2 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Company
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto d-none d-lg-inline-flex">
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i class="fab fa-google-plus-square"></i></a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i class="fab fa-twitter"></i></a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i class="fab fa-facebook-square"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
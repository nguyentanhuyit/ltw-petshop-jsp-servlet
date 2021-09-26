
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
    <div class="humberger__menu__logo">
        <a href="#"><img src="user/img/logo.png" alt=""></a>
    </div>
    <div class="humberger__menu__cart">
        <ul>
            <li><a href="wish-list.html"><i class="fa fa-heart"></i> <span>1</span></a></li>
            <li><a href="shoping-cart.html"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
        </ul>
        <div class="header__cart__price">Mục: <span>$150.00</span></div>
    </div>
    <div class="humberger__menu__widget">
        <div class="header__top__right__language">
            <img src="user/img/language.png" alt="">
            <div>Tiếng Việt</div>
            <span class="arrow_carrot-down"></span>
            <ul>
                <li><a href="#">Tiếng Việt</a></li>
                <li><a href="#">Tiếng Anh</a></li>
            </ul>
        </div>
        <div class="header__top__right__auth">
            <a href="signup"><i class="fa fa-user-plus"></i> Đăng ký</a>
        </div>
        <div class="header__top__right__auth">
            <a href="login"><i class="fa fa-user"></i> Đăng nhập</a>
            <span class="arrow_carrot-down"></span>
            <ul>
                <li><a href="account/profile.html">Tài khoản</a></li>
                <li><a href="logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
    <nav class="humberger__menu__nav mobile-menu">
        <ul>
            <li class="active"><a href="home">Trang chủ</a></li>
            <li><a href="shop-grid">Shop</a></li>
            <li><a href="dog-blog.html">Chó</a>
                <ul class="header__menu__dropdown">
                    <li><a href="dog-blog.html">Chăm sóc</a></li>
                    <li><a href="dog-blog.html">Sức khỏe</a></li>
                    <li><a href="dog-blog.html">Dinh dưỡng</a></li>
                </ul>
            </li>
            <li><a href="cat-blog.html">Mèo</a>
                <ul class="header__menu__dropdown">
                    <li><a href="cat-blog.html">Chăm sóc</a></li>
                    <li><a href="cat-blog.html">Sức khỏe</a></li>
                    <li><a href="cat-blog.html">Dinh dưỡng</a></li>
                </ul>
            </li>
            <li><a href="contact">Liên hệ</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
    <div class="header__top__right__social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
        <a href="#"><i class="fa fa-pinterest-p"></i></a>
    </div>
    <div class="humberger__menu__contact">
        <ul>
            <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
            <li>Free ship cho đơn hàng trên 3 triệu đồng</li>
        </ul>
    </div>
</div>
<%@ page import="bean.Cart" %>
<%@ page import="bean.Pet" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<header class="header" id="navbar">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                            <li>Free ship cho đơn hàng trên 3 triệu đồng</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__language">
                            <img src="user/img/language.png" alt="">
                            <div>Tiếng Việt</div>
                            <span class="arrow_carrot-down"></span>
                            <ul>
                                <li><a href="#">Tiếng Anh</a></li>
                                <li><a href="#">Tiếng Việt</a></li>
                            </ul>
                        </div>
                        <c:if test="${empty account}">
                        <div class="header__top__right__auth sign_up">
                            <a href="signup"><i class="fa fa-user-plus"></i>Đăng ký</a>
                        </div>
                        </c:if>
                        <div class="header__top__right__auth">
                            <c:if test="${empty account}">
                            <a href="login"><i class="fa fa-user"></i>Đăng nhập</a
                            </c:if>
                            <c:if test="${not empty account}">
                                <c:if test="${empty account.account_name}">
                                <a href="profile"><i class="fa fa-user"></i>${account.user_name}</a>
                                </c:if>
                                <c:if test="${not empty account.account_name}">
                                    <a href="profile"><i class="fa fa-user"></i>${account.account_name}</a>
                                </c:if>
                            <span class="arrow_carrot-down"></span>
                            <ul>
                                <li><a href="profile">Tài khoản</a></li>
                                <li><a href="logout">Đăng xuất</a></li>
                            </ul>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="menu">
        <div class="container" >
            <div class="row fix" >
                <div class="col-lg-3">
                    <div class="header__logo logo">
                        <a href="home"><img src="user/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
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
                </div>
                <%
                    Cart cart = Cart.getCart(session);
                    Collection<Pet> data = cart.getDt();
                    request.setAttribute("data", data);
                    long total = cart.total();
                    request.setAttribute("total", total);
                    System.out.println(total);
                %>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="wish-list"><i class="fa fa-heart"></i> <span>${listPetSize}</span></a></li>
                            <div class="cart">
                                <li><a href="shoppingCart"><i class="fa fa-shopping-bag"></i> <span>${data.size()}</span></a></li>
                                <div class="list">

                                    <div class="shopping-cart-header">
                                        <li><a><i class="fa fa-shopping-bag" id="cart-icon"></i> <span>${data.size()}</span></a></li>
                                        <div class="shopping-cart-total">
                                            <span class="lighter-text">Total:</span>
                                            <span class="main-color-text">${Cart.currencyFormat(total)}đ</span>
                                        </div>
                                    </div> <!--end shopping-cart-header -->
                                    <%request.setAttribute("noItem", "Chưa có thú cưng nào ^^");%>
                                    <c:if test="${empty data}">
                                        <p style="text-align: center; font-weight: bold">${requestScope.noItem}</p>
                                    </c:if>
                                    <ul class="shopping-cart-items">
                                        <c:forEach items="${data}" var="data">
                                        <li class="clearfix">
                                            <img src="${data.photo.photo_main}" alt="item1" />
                                            <div>
                                                <span class="item-name">${data.petName}</span>
                                                <span><a href="removeCart?pid=${data.id}" class="delete-btn" >Xóa</a></span>
                                            </div>
                                            <div>
                                                <span class="item-price">${Pet.currencyFormat(data.sellPrice)}</span>
                                                <span class="item-quantity">${data.quantity}</span>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>

                                    <a href="shoppingCart" class="checkout-button">Xem giỏ hàng</a>

                                </div>
                            </div>
                        </ul>

                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </div>
<%--    <script src="user/js/jquery.min.js"></script>--%>
<%--    <script>--%>
<%--        $('li').click(function(){--%>
<%--            if($(this).hasClass('active')){--%>
<%--                $(this).removeClass('active')--%>
<%--            } else {--%>
<%--                $(this).addClass('active')--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>
</header>

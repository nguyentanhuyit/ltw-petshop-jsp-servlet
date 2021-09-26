<%@ page import="bean.DiscountCode" %>
<%@ page import="bean.Cart" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bean.Pet" %>
<%@ page import="bean.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pet shop</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/style.css" type="text/css">

    <script type="text/javascript">
        function deleteCategory(id, btn) {
            var check = confirm("Bạn chắc chắn muốn xóa???")
            if (check) {
                var city = document.getElementById("city").value;
                var district = document.getElementById("district").value;
                var address = document.getElementById("address").value;
                var url = "successPayOnline?category_id=" + id+"&"+city+"&"+district+"&"+address;
                var xhttp;
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState == 4) {
                    }
                };
                xhttp.open("POST", url, true);
                xhttp.send();
            }
        }
    </script>
</head>
<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<jsp:include page="humberger.jsp"></jsp:include>
<!-- Humberger End -->

<!-- Header Section Begin -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero hero-normal">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <jsp:include page="hero-category.jsp"></jsp:include>
            </div>
            <div class="col-lg-9">
                <jsp:include page="hero-search.jsp"></jsp:include>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

<% Cart cart = Cart.getCart(session);
    Collection<Pet> data = cart.getDt();
    request.setAttribute("data", data);
    long total = cart.total();
    request.setAttribute("total", total);
    System.out.println(total);
%>
<c:set value="${sessionScope.dc}" var="discount"/>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">

                    <div class="breadcrumb__option">
                        <a href="home">Trang chủ</a>
                        <span>Giỏ hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->
<c:set value="${requestScope.account}" var="accounts"/>
<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <h4>Chi tiết hóa đơn</h4>
            <form action="#">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <div class="checkout__input">
                            <p>Tên<span>*</span></p>
                            <input type="text" value="${accounts.account_name}" name="account_name" style="color: black" disabled>
                        </div>
                        <div class="checkout__input">
                            <p>Tỉnh/Thành phố<span>*</span></p>
                            <input type="text" value="${accounts.address.province}" name="province" style="color: black" id="city">
                        </div>
                        <div class="checkout__input">
                            <p>Quận/Huyện<span>*</span></p>
                            <input type="text" value="${accounts.address.district}" style="color: black" id="district">
                        </div>
                        <div class="checkout__input">
                            <p>Địa chỉ<span>*</span></p>
                            <input type="text" placeholder="Địa chỉ cụ thể" class="checkout__input__add"
                                   value="${accounts.address.address_detail}" name="address_detail" style="color: black" id="address">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Số điện thoại<span>*</span></p>
                                    <input type="text" value="${accounts.phone_num}" name="phone" style="color: black">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="text" value="${accounts.email}" style="color: black" >
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Lời nhắn<span>*</span></p>
                            <input type="text"
                                   placeholder="Nhập lời nhắn" value="warning">
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">

                        <!--   thanh toán -->
                        <div class="checkout__order">
                            <h4>Đơn hàng</h4>
                            <div class="checkout__order__products">Sản phẩm <span>Tổng</span></div>

                            <ul>
                                <c:forEach items="${data}" var="data">
                                    <li>${data.petName}<span>${Pet.currencyFormat(data.sellPrice*data.quantity)}đ</span></li>
                                </c:forEach>
                            </ul>
                            <div class="checkout__order__subtotal checkout__order__total"> Giảm giá
                                <span>${Cart.currencyFormat(total* discount.rate) }đ</span></div>
                            <div class="checkout__order__subtotal checkout__order__total"> Thành tiền
                                <span>${Cart.currencyFormat(total - total* discount.rate) }đ</span></div>
                            <a href="successPayOnline?id=${account.account_id}" ><i type="submit" class="site-btn" style="width: 100%; text-align: center">THANH TOÁN ONLINE</i></a>
                            <a href="pay-onDelivery?id=${account.account_id}" ><i type="submit" class="site-btn" style="margin-top: 5px;width: 100%;text-align: center">THANH TOÁN TRỰC TIẾP</i></a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Checkout Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/user/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/user/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/main.js"></script>


</body>
</html>

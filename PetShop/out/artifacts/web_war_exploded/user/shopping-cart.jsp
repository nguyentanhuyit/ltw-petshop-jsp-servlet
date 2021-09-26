<%@ page import="bean.DiscountCode" %>
<%@ page import="bean.Cart" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bean.Pet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html lang="zxx">

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
</head>

<body>
<!-- Page Preloder -->

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
<c:set value="${sessionScope.account}" var="account"/>
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

<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <table>
                        <thead>
                        <tr>
                            <th class="shoping__product">Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            Cart cart = Cart.getCart(session);
                            Collection<Pet> data = cart.getDt();
                            request.setAttribute("data", data);
                            long total = cart.total();
                            request.setAttribute("total", total);
                            System.out.println(total);
                        %>
                        <c:forEach items="${data}" var="data">
                            <tr>
                                <td class="shoping__cart__item img_product">
                                    <img src="${data.photo.photo_main}" alt="">
                                    <h5>${data.petName}</h5>
                                </td>
                                <td class="shoping__cart__price">
                                        ${Pet.currencyFormat(data.sellPrice)}
                                </td>
                                <td class="shoping__cart__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <button class="dec qtybtn btn-minus">- <input style="display: none" class="petid" value="${data.id}"></button>

                                            <input type="text" value="${data.quantity}" name="quantity">

                                            <button class="inc qtybtn btn-plus">+ <input style="display: none" class="petid" value="${data.id}"></button>
                                        </div>
                                    </div>
                                </td>
                                <td class="shoping__cart__total">
                                        ${Pet.currencyFormat(data.sellPrice*data.quantity)}
                                </td>
                                <td class="shoping__cart__item__close">
                                    <span><a href="removeCart?pid=${data.id}"><i class="icon_close"></i></a></span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__btns">
                    <a href="home" class="primary-btn cart-btn">TIẾP TỤC MUA HÀNG</a>
                    <a href="updatequantity" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                        Cập nhật giỏ hàng</a>
                </div>
            </div>
            <div class="col-lg-6">
                <c:set value="${requestScope.dc}" var="dc"/>

                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Mã giảm giá</h5>
                            <form action="discountCode">
                            <input type="text" placeholder="Nhập mã giảm giá" name="discountCode"
                                   value="${requestScope.code}">
                            <button type="submit" class="site-btn">NHẬP
                            </button>
                            </form>
                        </div>

                    </div>
                    <c:if test="${not empty dc}">
                    <div class="show-discount-rate">
                        <p>${requestScope.noticeCode}</p>
                    </div>
                    </c:if>

            </div>


            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Tổng đơn hàng</h5>
                    <ul>
                        <li>Tổng <span>${Cart.currencyFormat(total)}đ</span></li>
                        <li>Giảm <span>${Cart.currencyFormat(total*dc.rate)}đ</span></li>
                        <li>Thành tiền <span>${Cart.currencyFormat(total - total*dc.rate)}đ</span></li>
                        <input name="total-price" value="${total-total*dc.rate}" style="display: none">

                    </ul>
                    <c:if test="${not empty account}">
                    <c:if test="${empty data}">
                    <a onclick="alert('Chưa có mặt hàng nào')" class="primary-btn">Tiến hành thanh toán</a>
                    </c:if>
                    </c:if>
                    <c:if test="${empty account}">
                    <a onclick="alert('Bạn cần đăng nhập')" class="primary-btn">Tiến hành thanh toán</a>
                    </c:if>
                    <c:if test="${not empty account}">
                    <c:if test="${not empty data}">
                    <a href="checkout?uid=${account.account_id}" class="primary-btn">Tiến hành thanh toán</a>
                    </c:if>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</section>
<!-- Shoping Cart Section End -->


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
<script>

    // giam
    $(".btn-minus").click(function (e) {
        var petid = $(this).find(".petid").val();
        $.ajax({
            url: "<%="minus"%>",
            type: "post",
            data: {
                petid: petid, // servlet : input
            },
            success: function (a) {
                if (a == 'OK') {
                    window.location.reload();
                } else {
                    alert(a)
                }
            }, error: function (b) {
                alert(b)
            }
        });
    })

    //tang sp
    $(".btn-plus").click(function (e) {
        var petid = $(this).find(".petid").val();
        // alert(maSP)
        $.ajax({
            url: "<%="plus"%>",
            type: "post",
            data: {
                petid: petid, // servlet : input
            },
            success: function (a) {
                if (a == 'OK') {
                    window.location.reload();
                } else {
                    alert(a)
                }
            }, error: function (b) {
                alert(b)
            }
        });
    })
    //xoa
</script>

</body>

</html>
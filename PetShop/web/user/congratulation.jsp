<%@ page import="bean.Cart" %>
<%@ page import="bean.Pet" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
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
<% Cart cart = Cart.getCart(session);
    Collection<Pet> data = cart.getDt();
    request.setAttribute("data", data);
    long total = cart.total();
    request.setAttribute("total", total);
    System.out.println(total);%>
<c:set value="${sessionScope.dc}" var="dc"/>
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

<!-- Checkout Section Begin -->
<section class="checkout spad" style="padding-top: 20px">
    <div class="container">
        <h4 style="text-align: center">Cảm ơn bạn đã mua thú cưng</h4>
        <form action="#">
            <div class="row">
                <div class="col-lg-12 col-md-6">
<c:set value="${sessionScope.account.user_name}" var="account"/>
                    <!--   thanh toán -->
                    <div class="checkout__order" style="text-align: center">
                        <h4>Xin chào ${account.user_name}!</h4>
                        <div class="checkout__order__products"></div>
                        <ul>
                            <li>Chúng tôi sẽ tư tay đưa thú cưng đến ${account.address.address_detail}, ${account.address.district}, ${account.address.province} trong vài ngày tới </li>
                            <li>Hoặc bạn có thể trưc tiếp đến DHNL để nhận thú cưng</li>
                           <c:if test="${not empty requestScope.pay}" var="pay">
                            <li>${pay}</li>
                           </c:if>


                        </ul>
                        <div class="checkout__order__subtotal checkout__order__total"><a href="">Xem chi tiết đơn</a></div>
                        <a href=""><i type="submit" class="site-btn" style="width: 50%; text-align: center">TIẾP TỤC MUA HÀNG</i></a>
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

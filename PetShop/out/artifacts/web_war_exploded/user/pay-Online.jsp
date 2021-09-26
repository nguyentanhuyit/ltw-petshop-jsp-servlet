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
    <section class="checkout spad" style="padding-top: 10px">
    <div class="container">
    <div class="checkout__form">
    <h4 style="text-align: center">Chi tiết hóa đơn</h4>
    <form action="successPayOnline">
    <div class="row">

    <div class="col-lg-5 col-md-6">

    <!-- thanh toán -->
    <div class="checkout__order">
    <h4>Đơn hàng</h4>
    <div class="checkout__order__products">Sản phẩm <span>Tổng</span></div>
    <ul>
    <c:forEach items="${data}" var="data">
        <li>${data.petName}<span>${Pet.currencyFormat(data.sellPrice)}đ</span></li>
    </c:forEach>
        <li style="color: red">Giảm giá<span>${Cart.currencyFormat(dc.rate*total)}</span></li>
    </ul>
    <div class="checkout__order__subtotal checkout__order__total">Tổng thanh toán
    <span>${Cart.currencyFormat(total - dc.rate)}</span></div>
    <div class="checkout__order__products">Tên KH: <span>${account.account_name}</span></div>
    <div class="checkout__order__products">Địa chỉ: <span>${account.address.address_detail}, ${account.address.district}, ${account.address.province}</span></div>
    <div class="checkout__order__products">Sdt: <span>${account.phone_num}</span></div>
    </div>
    </div>
    <div class="col-lg-7 col-md-6">
    <div class="bank_img">
    <img src="user/img/bank/Vpbank.jpg">
    <img src="user/img/bank/BIDV.jpg">
    <img src="user/img/bank/mbbank.jpg">
    <img src="user/img/bank/teckcombank.jpg">
    <img src="user/img/bank/VietinBank.png">
    </div>

    <!-- Ngân hàng -->
    <div class="checkout__order">
    <h4>THANH TOÁN</h4>
        <c:if test="${not empty requestScope.noExist}">
            <h4 style="color: #b51616; text-align: center">Tài khoản không tồn tại</h4>
        </c:if>
    <div class="checkout__order__products">Thông qua <span>tài khoản ngân hàng</span></div>


    <div>
        <select name="bank_id">
    <option value="">chọn ngân hàng</option>
    <c:forEach items="${requestScope.listBank}" var="listBank">
    <option value="${listBank.bank_id}">${listBank.bank_name} - ${f:toUpperCase(listBank.bank_id)}</option>
    </c:forEach>
    </select>
    </div>
    <div class="bank_cart_name"><input type="text" placeholder="Nhập tên chủ thẻ" name="owner_name"></div>
    <div class="bank_cart_name"><input type="text" placeholder="Nhập mã thẻ" name="bank_code"></div>
    <div class="bank_cart_name"><input type="text" value="${account.email}" disabled name="email"></div>


    <div class="checkout__order__subtotal checkout__order__total">

        <button type="submit" class="site-btn" style="width: 100%; text-align: center">XÁC NHẬN</button>
        <a href="shoppingCart" class="cancel" data-toggle="modal" data-confirm="Bạn muốn hủy giao dịch?"><i class="site-btn" style="margin-top: 10px; width: 100%; text-align: center">HỦY ĐƠN HÀNG</i></a>

    </div>
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
    <script src="${pageContext.request.contextPath}/user/js/page.js"></script>
<script>
    $(document).ready(function(){
        $(".btn-edit").hide();
        $(".icon-edit").click(function(){
            $('#editable').editableTableWidget();
            $('#editable td.uneditable').on('change', function(evt, newValue) {
                return false;
            });
            $(".uneditable").css('cursor', 'none');
            $(".btn-edit").show();
        });
        $(".btn-edit").click(function(){
            $(".uneditable").css('cursor', '');
            $(".btn-edit").hide();
        });
    });

</script>

<script>
    var deleteLinks = document.querySelectorAll('.cancel');

    for (var i = 0; i < deleteLinks.length; i++) {
        deleteLinks[i].addEventListener('click', function(event) {
            event.preventDefault();

            var choice = confirm(this.getAttribute('data-confirm'));
            if (choice) {
                window.location.href = this.getAttribute('href');
            }
        });
    }
</script>
</body>
    </html>

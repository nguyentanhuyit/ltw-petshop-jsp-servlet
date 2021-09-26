<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <jsp:include page="hero-background.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <div class="breadcrumb__option">
                            <a href="../index.jsp">Trang chủ</a>
                            <a href="../account/profile.html">Tài khoản</a>
                            <span>Đổi mật khẩu</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Profile Section Begin -->
    <section class="profile-section profile">
        <div class="container">
            <div class="row">
                <div class="left-menu">
                    <div class="profile">
                        <img src="../img/avatar/avatar1.jpg" alt="Profile">
                        <div class="profile-name">Jack</div>
                    </div>
                    <div class="profile-menu">
                        <ul>
                            <li><i class="fa fa-user-circle"></i> &ensp;<a href="profile.html">Tài khoản của tôi</a>
                                <ul>
                                    <li><a href="profile.html">Hồ sơ</a></li>
                                    <li><a href="change-password.jsp">Đổi mật khẩu</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="my-profile">
                    <div class="profile-header">
                        <h3>Đổi mật khẩu</h3>
                        <p>Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác</p>
                        <hr>
                    </div>
                    <div class="profile-form">
                        <div class="profile-form-info">
                            <form action="">
                                <div class="input-with-lable-profile input-profile">
                                    <label for="password-now">Mật khẩu hiện tại</label>
                                    <input type="password" id="password-now" name="password-now">
                                </div>
                                <div class="input-with-lable-profile input-profile">
                                    <label for="password-new">Mật khẩu mới</label>
                                    <input type="password" id="password-new"name="password-new">
                                </div>
                                <div class="input-with-lable-profile input-profile">
                                    <label for="password-confirm">Xác nhận mật khẩu</label>
                                    <input type="password"  id="password-confirm" name="password-confirm">
                                </div>
                                
                                <div class="btn">
                                    <input type="submit" value="Xác nhận">
                                </div>
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Profile Section End -->
    <!-- Footer Section Begin -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/user/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/user/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/user/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/user//js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/user//js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/user//js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/user//js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/user//js/main.js"></script>


</body>

</html>
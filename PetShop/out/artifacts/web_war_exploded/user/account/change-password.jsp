
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
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
    <link rel="stylesheet" href="user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/style.css" type="text/css">
    <style>
        label.error{
            color: red;
        }
    </style>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<jsp:include page="../humberger.jsp"></jsp:include>
<!-- Humberger End -->

<!-- Header Section Begin -->
<jsp:include page="../header.jsp"></jsp:include>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero hero-normal">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <jsp:include page="../hero-category.jsp"></jsp:include>
            </div>
            <div class="col-lg-9">
                <jsp:include page="../hero-search.jsp"></jsp:include>
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
                        <a href="home">Trang ch???</a>
                        <a href="profile">T??i kho???n</a>
                        <span>?????i m???t kh???u</span>
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
                    <img src="user//img/avatar/avatar1.jpg" alt="Profile">
                    <div class="profile-name">Jack</div>
                </div>
                <div class="profile-menu">
                    <ul>
                        <li><i class="fa fa-user-circle"></i> &ensp;<a href="profile">T??i kho???n c???a t??i</a>
                            <ul>
                                <li><a href="profile">H??? s??</a></li>
                                <li><a href="changepassword">?????i m???t kh???u</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="my-profile">
                <div class="profile-header">
                    <h3>?????i m???t kh???u</h3>
                    <p>????? b???o m???t t??i kho???n, vui l??ng kh??ng chia s??? m???t kh???u cho ng?????i kh??c</p>
                    <hr>
                </div>
                <div class="profile-form">
                    <div class="profile-form-info">
                        <form action="changepassword" method="post" name="changePasswordForm">
                            <div style="color: #B5231F; text-align: center; margin: auto">${erre}</div>
                            <div class="input-with-lable-profile input-profile">
                                <label >M???t kh???u hi???n t???i:</label>
                                <input type="password" name="passwordNow" id="password">
                            </div>
                            <div class="input-with-lable-profile input-profile" >
                                <label >M???t kh???u m???i:</label>
                                <input type="password" name="passwordNew" id="passwordNew">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label>X??c nh???n m???t kh???u:</label>
                                <input type="password"  name="passwordConfirm" id="passwordConfirm">
                            </div>

                            <div class="btn">
                                <input type="submit" value="X??c nh???n">
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
<jsp:include page="../footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="user/js/jquery-3.3.1.min.js"></script>
<script src="user/js/bootstrap.min.js"></script>
<script src="user/js/jquery.nice-select.min.js"></script>
<script src="user/js/jquery-ui.min.js"></script>
<script src="user/js/jquery.slicknav.js"></script>
<script src="user/js/mixitup.min.js"></script>
<script src="user/js/owl.carousel.min.js"></script>
<script src="user/js/main.js"></script>
<script src="user/js/jquery.min.js"></script>
<script src="user/js/jquery.validate.min.js"></script>
<script type="text/javascript">

    $(function(){
        $("form[name='changePasswordForm']").validate({
            rules:{
                passwordNow: {required:true, minlength: 8},
                passwordNew:{required:true, minlength: 8},
               passwordConfirm:{required:true, equalTo: "#passwordNew"},
            },
            messages: {
                passwordNow :{required: "Vui l??ng ??i???n m???t kh???u hi???n t???i", minlength: "M???t kh???u ??t nh???t 8 k?? t???"},
                passwordNew :{required: "Vui l??ng ??i???n m???t kh???u m???i", minlength: "M???t kh???u ??t nh???t 8 k?? t???"},
                passwordConfirm :{required: "Vui l??ng ??i???n x??c th???c m???t kh???u",equalTo:"M???t kh???u x??c th???c ph???i kh???p v???i m???t kh???u m???i"}
            }
        });
    });


</script>

</body>

</html>

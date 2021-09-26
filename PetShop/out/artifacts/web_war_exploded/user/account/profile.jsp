
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
    <title>PetShop</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="user../css/jquery-ui.min.css" type="text/css">
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
                        <a href="home">Trang chủ</a>
                        <a href="profile">Tài khoản</a>
                        <span>Hồ sơ</span>
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
                    <c:if test="${empty account.image}">
                        <img src="user/img/avatar/avatar_default.jpg" alt="avatar">
                    </c:if>
                    <c:if test="${not empty account.image}">
                        <img src="${account.image}" alt="avatar">
                    </c:if>
                    <div class="profile-name">${account.user_name}</div>
                </div>
                <div class="profile-menu">
                    <ul>
                        <li><i class="fa fa-user-circle"></i> &ensp;<a href="profile">Tài khoản của tôi</a>
                            <ul>
                                <li><a href="profile">Hồ sơ</a></li>
                                <li><a href="changepassword">Đổi mật khẩu</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="my-profile">
                <div class="profile-header">
                    <h3>Hồ sơ của tôi</h3>
                    <p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
                    <hr>
                </div>
                <div class="profile-form">
                    <div class="profile-form-info">
                        <form action="profile" method="post" name="profileForm">
                            <div class="input-with-lable-profile input-profile">
                                <label >Tên đăng nhập</label>
                                <input type="text" value="${account.user_name}" name="username">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >Tên:</label>
                                <input type="text" value="${account.account_name}" name="name">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >Email:</label>
                                <input type="email" value="${account.email}" name="email">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >Số điện thoại: </label>
                                <input type="text" value="${account.phone_num}" name="phonenumber">
                            </div>
                            <div class="input-with-lable-profile check-sex input-profile">
                                <label >Giới tính:</label>
                                <div style="display: flex">
                                <div class="rdo-btn sex-btn">
                                    <input type="radio" value="Nam" name="gender" <c:if test="${account.gender eq 'Nam'}">checked</c:if>>
                                    <span>Nam </span>
                                </div>
                                <div class="rdo-btn sex-btn">
                                    <input type="radio" value="Nữ" name="gender" <c:if test="${account.gender eq 'Nữ'}">checked</c:if>>
                                    <span>Nữ</span>
                                </div>
                                </div>
                            </div>
                            <div class="input-with-lable-profile input-profile input-birthday">
                                <label >Ngày sinh</label>
                                <input type="date" name="birthday"  value="${account.birthday}">
                            </div>
                            <div class="btn">
                                <input type="submit" value="Cập nhật">
                            </div>
                        </form>
                    </div>
                    <div class="avatar-upload">
                        <div class="avatar">
                            <c:if test="${empty account.image}">
                            <img src="user/img/avatar/avatar_default.jpg" alt="avatar">
                            </c:if>
                            <c:if test="${not empty account.image}">
                                <img src="${account.image}" alt="avatar">
                            </c:if>

                        </div>
                        <form method="post" action="uploadAvatar" enctype="multipart/form-data">
                            <div class="btn-upload">
                                <input type="file" value="Chọn ảnh" name="uploadAvatar">
                                <button type="submit" style="margin-left: 41.3%; border: 1px solid gray; border-radius:2px">Upload</button>
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
        $("form[name='profileForm']").validate({
            rules:{
                username: {required:true, minlength: 8},
                email: {email:true}
            },
            messages: {
                username :{required: "Vui lòng điền tên đăng nhập", minlength: "Tên đăng nhập ít nhất 8 ký tự"},
                email : {email:"Vui lòng nhập đúng định dạng email"}
            }
        });
    });


</script>
</body>

</html>


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
                        <a href="home">Trang ch???</a>
                        <a href="profile">T??i kho???n</a>
                        <span>H??? s??</span>
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
                    <h3>H??? s?? c???a t??i</h3>
                    <p>Qu???n l?? th??ng tin h??? s?? ????? b???o m???t t??i kho???n</p>
                    <hr>
                </div>
                <div class="profile-form">
                    <div class="profile-form-info">
                        <form action="profile" method="post" name="profileForm">
                            <div class="input-with-lable-profile input-profile">
                                <label >T??n ????ng nh???p</label>
                                <input type="text" value="${account.user_name}" name="username">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >T??n:</label>
                                <input type="text" value="${account.account_name}" name="name">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >Email:</label>
                                <input type="email" value="${account.email}" name="email">
                            </div>
                            <div class="input-with-lable-profile input-profile">
                                <label >S??? ??i???n tho???i: </label>
                                <input type="text" value="${account.phone_num}" name="phonenumber">
                            </div>
                            <div class="input-with-lable-profile check-sex input-profile">
                                <label >Gi???i t??nh:</label>
                                <div style="display: flex">
                                <div class="rdo-btn sex-btn">
                                    <input type="radio" value="Nam" name="gender" <c:if test="${account.gender eq 'Nam'}">checked</c:if>>
                                    <span>Nam </span>
                                </div>
                                <div class="rdo-btn sex-btn">
                                    <input type="radio" value="N???" name="gender" <c:if test="${account.gender eq 'N???'}">checked</c:if>>
                                    <span>N???</span>
                                </div>
                                </div>
                            </div>
                            <div class="input-with-lable-profile input-profile input-birthday">
                                <label >Ng??y sinh</label>
                                <input type="date" name="birthday"  value="${account.birthday}">
                            </div>
                            <div class="btn">
                                <input type="submit" value="C???p nh???t">
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
                                <input type="file" value="Ch???n ???nh" name="uploadAvatar">
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
                username :{required: "Vui l??ng ??i???n t??n ????ng nh???p", minlength: "T??n ????ng nh???p ??t nh???t 8 k?? t???"},
                email : {email:"Vui l??ng nh???p ????ng ?????nh d???ng email"}
            }
        });
    });


</script>
</body>

</html>

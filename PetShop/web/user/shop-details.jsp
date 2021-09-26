<%@ page import="java.util.List" %>
<%@ page import="bean.Pet" %>
<%@ page import="bean.Comment" %>
<%@ page import="DAO.AccountDAO" %>
<%@ page import="bean.SubComment" %>
<%@ page import="DAO.SubCommentDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="PetShop Template">
    <meta name="keywords" content="PetShop, unica, creative, html">
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

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <div class="breadcrumb__option">
                        <a href="home">Trang chủ</a>
                        <a href="./index.html">Chó</a>
                        <a href="./index.html">Pomeranian</a>
                        <span> Pomeranian trắng 01</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__item">
                        <img class="product__details__pic__item--large"
                             src="${petDetail.photo.photo_main}" alt="">
                    </div>
                    <div class="product__details__pic__slider owl-carousel">
                        <img data-imgbigurl="${petDetail.photo.photo_main_1}"
                             src="${petDetail.photo.photo_main_1}" alt="">
                        <img data-imgbigurl="${petDetail.photo.photo_main_2}"
                             src="${petDetail.photo.photo_main_2}" alt="">
                        <img data-imgbigurl="petDetail.photo.photo_main_3"
                             src="${petDetail.photo.photo_main_3}" alt="">
                        <img data-imgbigurl="petDetail.photo.photo_main_4"
                             src="${petDetail.photo.photo_main_4}" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__text">
                    <h3>${petDetail.petName}</h3>
                    <div class="product__details__rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <span>(18 đánh giá)</span>
                    </div>
                    <div class="product__details__price">${petDetail.sellPrice}đ</div>
                    <p>- Giống: ${category.category_name} <br>
                        - Tuổi: ${petDetail.age} ngày.<br>
                        - Giới tính: ${petDetail.gender}.<br>
                        - Màu lông: ${petDetail.color}.<br>
                        - Số lượng: ${petDetail.quantity}<br>
                        - Cân nặng: ${petDetail.weight}kg.
                    <div class="product__details__quantity">
                        <div class="quantity">
                            <div class="pro-qty">
                                <input type="text" value="1">
                            </div>
                        </div>
                    </div>
                    <a href="addtoCart?pid=${petDetail.id}" class="primary-btn">Thêm vào giỏ hàng</a>
                    <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                    <ul>
                        <li><b>Tình trạng</b> <span>${petDetail.petStatus}</span></li>
                        <li><b>Vận chuyển</b> <span> <samp></samp></span></li>
                        <li><b>Chia sẻ</b>
                            <div class="share">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                               aria-selected="true">Mô tả</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                               aria-selected="false">Nhận xét <span>(<%=request.getAttribute("NhanXet")%>)</span></a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <h6>Mô tả thú cưng</h6>
                                <p>${petDetail.description}</p>
                            </div>
                        </div>

                        <div class="tab-pane" id="tabs-2" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <div class="container bootdey">
                                    <div class="col-md-12 bootstrap snippets">
                                        <form action="comment" method="post">
                                            <input type="hidden" value="${petDetail.id}" name="pet_id">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <textarea class="form-control" rows="2" placeholder="Bạn đang nghĩ gì?" name="content"></textarea>
                                                <div class="mar-top clearfix">
                                                    <button class="btn btn-sm btn-primary pull-right" type="submit"><i class="fa fa-pencil fa-fw"></i> Post</button>
                                                    <a class="btn btn-trans btn-icon fa fa-video-camera add-tooltip" href="#"></a>
                                                    <a class="btn btn-trans btn-icon fa fa-camera add-tooltip" href="#"></a>
                                                </div>
                                            </div>
                                        </div>
                                        </form>
                                        <div class="panel">
                                            <div class="panel-body">
                                                <!-- Newsfeed Content -->
                                                <!--===================================================-->
                                                <%List<Comment> listComment = (List<Comment>) request.getAttribute("listComment");%>
                                                <%for (int i = 0 ; i < listComment.size(); i++){%>
                                                <div class="media-block">
                                                    <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="<%=AccountDAO.getInfoAccountById(listComment.get(i).getAccount_id()).getImage()%>"></a>
                                                    <div class="media-body">
                                                        <div class="mar-btm">
                                                            <a href="#" class="btn-link text-semibold media-heading box-inline"><%=AccountDAO.getInfoAccountById(listComment.get(i).getAccount_id()).getAccount_name()%></a>
                                                            <p class="text-muted text-sm">  <%=listComment.get(i).getTime_cmt()%></p>
                                                        </div>
                                                        <p><%=listComment.get(i).getContent()%></p>
                                                        <div class="pad-ver">
                                                            <div class="btn-group">
                                                                <button class="btn btn-sm btn-default btn-hover-success" ><i class="fa fa-thumbs-up"></i></button>
                                                                <button class="btn btn-sm btn-default btn-hover-danger"><i class="fa fa-thumbs-down"></i></button>
                                                            </div>

                                                        </div>
                                                        <hr>

                                                        <!-- Comments -->
                                                        <div>
                                                            <%List<SubComment> listSubCmt = SubCommentDAO.getListSubcomment(listComment.get(i).getCmt_id());%>
                                                            <%for (int j = 0 ; j < listSubCmt.size(); j++){%>
                                                            <div class="media-block">
                                                                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="<%=AccountDAO.getInfoAccountById(listSubCmt.get(j).getAccount_id()).getImage()%>"></a>
                                                                <div class="media-body">
                                                                    <div class="mar-btm">
                                                                        <a href="#" class="btn-link text-semibold media-heading box-inline"><%=AccountDAO.getInfoAccountById(listSubCmt.get(j).getAccount_id()).getAccount_name()%></a>
                                                                        <p class="text-muted text-sm"> <%=listSubCmt.get(j).getSub_cmt_date()%></p>
                                                                    </div>
                                                                    <p><%=listSubCmt.get(j).getSub_cmt_content()%></p>
                                                                    <div class="pad-ver">
                                                                        <div class="btn-group">
                                                                            <a class="btn btn-sm btn-default btn-hover-success active" href="#"><i class="fa fa-thumbs-up"></i> You Like it</a>
                                                                            <a class="btn btn-sm btn-default btn-hover-danger" href="#"><i class="fa fa-thumbs-down"></i></a>
                                                                        </div>
                                                                        <a class="btn btn-sm btn-default btn-hover-primary" href="#">Comment</a>
                                                                    </div>
                                                                    <hr>
                                                                </div>
                                                            </div>

                                                            <%}%>
                                                            <form action="replyComment" method="post">
                                                                <input type="hidden" value="<%=listComment.get(i).getCmt_id()%>" name="cmt_id">
                                                                <input type="hidden" value="${petDetail.id}" name="pet_id">
                                                                <div class="panel">
                                                                    <div class="panel-body">
                                                                        <textarea class="form-control" rows="2" placeholder="Viết câu trả lời..." name="content"></textarea>
                                                                        <div class="mar-top clearfix">
                                                                            <button class="btn btn-sm btn-primary pull-right" type="submit"><i class="fa fa-pencil fa-fw"></i> Post</button>
                                                                            <a class="btn btn-trans btn-icon fa fa-video-camera add-tooltip" href="#"></a>
                                                                            <a class="btn btn-trans btn-icon fa fa-camera add-tooltip" href="#"></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%}%>
                                                <!--===================================================-->
                                                <!-- End Newsfeed Content -->

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title related__product__title">
                    <h2>Thú cưng liên quan</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <%List<Pet> listPetRelative = (List<Pet>) request.getAttribute("listPetRelative");%>
            <%for (Pet pet: listPetRelative){%>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="<%=pet.getPhoto().getPhoto_main()%>">
                        <ul class="product__item__pic__hover">
                            <li><a href="wish-list.html"><i class="fa fa-heart"></i></a></li>
                            <li><a href="shop-details?PetID=<%=pet.getId()%>"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="shoping-cart.html"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6><a href="shop-details.html"><%=pet.getPetName()%></a></h6>
                        <h5><%=pet.getSellPrice()%>đ</h5>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</section>
<!-- Related Product Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp"></jsp:include>
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

</body>

</html>

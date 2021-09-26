<%@ page import="java.util.List" %>
<%@ page import="bean.Pet" %>
<%@ page import="DAO.SaleDAO" %>
<%@ page import="bean.Size" %>
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
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="sidebar">

                    <div class="sidebar__item">
                        <h4>Giá</h4>
                        <div class="price-range-wrap">
                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                 data-min="0" data-max="100000000">
                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            </div>
                            <div class="range-slider">
                                <div class="price-input">
                                    <input type="text" id="minamount">
                                    <input type="text" id="maxamount">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar__item sidebar__item__color--option">
                        <h4>Màu sắc</h4>
                        <div class="sidebar__item__color sidebar__item__color--white">
                            <label for="white">
                                Trắng
                                <input type="radio" id="white">
                            </label>
                        </div>
                        <div class="sidebar__item__color sidebar__item__color--gray">
                            <label for="gray">
                                Xám
                                <input type="radio" id="gray">
                            </label>
                        </div>
                        <div class="sidebar__item__color sidebar__item__color--red">
                            <label for="red">
                                Đỏ
                                <input type="radio" id="red">
                            </label>
                        </div>
                        <div class="sidebar__item__color sidebar__item__color--black">
                            <label for="black">
                                Đen
                                <input type="radio" id="black">
                            </label>
                        </div>
                        <div class="sidebar__item__color sidebar__item__color--blue">
                            <label for="blue">
                                Xanh dương
                                <input type="radio" id="blue">
                            </label>
                        </div>
                        <div class="sidebar__item__color sidebar__item__color--green">
                            <label for="green">
                                Xanh lá
                                <input type="radio" id="green">
                            </label>
                        </div>
                    </div>
                    <div class="sidebar__item">
                        <h4>Kích cỡ</h4>
                        <%List<Size> listSize = (List<Size>) request.getAttribute("listSize");%>
                        <%for (Size size: listSize){%>
                        <div class="sidebar__item__size">
                            <label for="large">
                                <%=size.getSize_name()%>
                                <input type="radio" id="large">
                            </label>
                        </div>
                        <%}%>
                    </div>
                    <div class="sidebar__item">
                        <div class="latest-product__text">
                            <h4>Mới nhất</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <%List<Pet> listLatestProduct1 = (List<Pet>) request.getAttribute("listLatestProduct1");%>
                                    <%for (Pet pet:listLatestProduct1) {%>
                                    <a href="shop-details?petID=<%=pet.getId()%>" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="<%=pet.getPhoto().getPhoto_main()%>" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6><%=pet.getPetName()%></h6>
                                            <span><%=pet.getSellPrice()%>đ</span>
                                        </div>
                                    </a>
                                    <%}%>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <%List<Pet> listLatestProduct2 = (List<Pet>) request.getAttribute("listLatestProduct2");%>
                                    <%for (Pet pet:listLatestProduct2) {%>
                                    <a href="shop-details?petID=<%=pet.getId()%>" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="<%=pet.getPhoto().getPhoto_main()%>" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6><%=pet.getPetName()%></h6>
                                            <span><%=pet.getSellPrice()%>đ</span>
                                        </div>
                                    </a>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="product__discount">
                    <div class="section-title product__discount__title">
                        <h2>Khuyến mãi</h2>
                    </div>
                    <div class="row">
                        <div class="product__discount__slider owl-carousel">
                            <%List<Pet> listPetSale = (List<Pet>) request.getAttribute("listPetSale");%>
                            <%for (int i = 0; i< listPetSale.size(); i++){%>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="<%=listPetSale.get(i).getPhoto().getPhoto_main()%>">
                                        <div class="product__discount__percent">-<%=SaleDAO.getSaleByPetID(listPetSale.get(i).getId())*100+"%"%></div>
                                        <ul class="product__item__pic__hover">
                                            <li><a href="wish-list.html"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="shop-details?petID=<%=listPetSale.get(i).getId()%>"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="addtoCart?pid=<%=listPetSale.get(i).getId()%>"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span><%=listPetSale.get(i).getPetName()%></span>
                                        <h5><a href="shop-details?petID=<%=listPetSale.get(i).getId()%>">Pug vàng 07</a></h5>
                                        <div class="product__item__price"><%=listPetSale.get(i).getSellPrice()-listPetSale.get(i).getSellPrice()*SaleDAO.getSaleByPetID(listPetSale.get(i).getId())%>đ <span><%=listPetSale.get(i).getSellPrice()%>đ</span></div>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="filter__sort">
                                <span>Sắp xếp</span>
                                <select>
                                    <option value="0">Mặc định</option>
                                    <option value="0">Mặc định</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4">
                            <div class="filter__found">
                                <h6><span>${size}</span> Thú cưng được tìm thấy</h6>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-3">
                            <div class="filter__option">
                                <span class="icon_grid-2x2"></span>
                                <span class="icon_ul"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" id="product">
                    <c:forEach items="${listPet}" var="item">
                    <div class="col-lg-4 col-md-6 col-sm-6" >
                        <div class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="${item.photo.photo_main}">
                                <ul class="product__item__pic__hover">
                                    <li><a href="wish-list.html"><i class="fa fa-heart"></i></a></li>
                                    <li><a href="shop-details?petID=${item.id}"><i class="fa fa-retweet"></i></a></li>
                                    <li><a href="addtoCart?pid=${item.id}"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="shop-details.html">${item.petName}</a></h6>
                                <h5>${item.sellPrice}đ</h5>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>

            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

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
<script src="user/js/page.js"></script>
<script>

</script>
</body>

</html>

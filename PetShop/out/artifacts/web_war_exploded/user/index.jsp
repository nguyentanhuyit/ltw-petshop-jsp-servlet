<%@ page import="java.util.List" %>
<%@ page import="bean.Species" %>
<%@ page import="bean.Pet" %>
<%@ page import="DAO.SaleDAO" %>
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
<section class="hero">
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

<!-- Categories Section Begin -->
<section class="categories">
    <div class="container">
        <div class="row">
            <div class="categories__slider owl-carousel">
                <c:forEach items="${listCategory}" var="lc">
                <div class="col-lg-3">
                    <div class="categories__item set-bg" data-setbg="${lc.photo}">
                        <h5><a href="category?category_name=${lc.category_name}">${lc.category_name}</a></h5>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<!-- Categories Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Sản phẩm</h2>
                </div>
                <div class="featured__controls">
                    <%List<Species> listSpecies = (List<Species>) request.getAttribute("listSpecies");%>
                    <ul>
                        <li class="active" data-filter="*">Tất cả</li>
                        <%for (Species species:listSpecies) {%>
                        <li data-filter=".<%=species.getSpecies_name()%>"><%=species.getSpecies_name()%></li>
                        <%}%>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row featured__filter" id="product">
            <%int count = 0;%>
            <%while (count<listSpecies.size()){%>
            <%List<Pet> listPetSpecies = (List<Pet>) request.getAttribute("listPetSpecies"+count);%>
            <% for (int i = 0; i< listPetSpecies.size(); i ++){%>
            <div class="col-lg-3 col-md-4 col-sm-6 mix <%=listSpecies.get(count).getSpecies_name()%> " >
                <div class="featured__item" >
                    <div class="featured__item__pic set-bg" data-setbg="<%=listPetSpecies.get(i).getPhoto().getPhoto_main()%>">
                        <ul class="featured__item__pic__hover">
                            <li><a href="wish-list.html"><i class="fa fa-heart"></i></a></li>
                            <li><a href="shop-details?petID=<%=listPetSpecies.get(i).getId()%>"><i class="fa fa-retweet"></i></a></li>
                            <li><a href="addtoCart?pid=<%=listPetSpecies.get(i).getId()%>"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="featured__item__text">
                        <h6><a href="shop-details?petID=<%=listPetSpecies.get(i).getId()%>"><%=listPetSpecies.get(i).getPetName()%></a></h6>
                        <h5><%=listPetSpecies.get(i).getSellPrice()%>đ</h5>
                    </div>
                </div>
            </div>
            <%  }%>
            <%count++;%>
            <% }%>
        </div>
        <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>
    </div>
</section>
<!-- Featured Section End -->

<!-- Banner Begin -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="user/img/banner/banner-1.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img src="user/img/banner/banner-2.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner End -->

<!-- Latest Product Section Begin -->
<section class="latest-product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Mới nhất</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${listPet1}" var="lp1">
                            <a href="shop-details?petID=${lp1.id}" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="${lp1.photo.photo_main}" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>${lp1.petName}</h6>
                                    <span>${lp1.sellPrice}đ</span>
                                </div>
                            </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${listPet2}" var="lp2">
                            <a href="shop-details?petID=${lp2.id}" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="${lp2.photo.photo_main}" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6>${lp2.petName}</h6>
                                    <span>${lp2.sellPrice}đ</span>
                                </div>
                            </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Bán chạy nhất</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <%List<Pet> listBestSale1 = (List<Pet>) request.getAttribute("listBestSale1");%>
                            <%for (Pet pet:listBestSale1) {%>
                            <a href="shop-details.html" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="<%=pet.getPhoto().getPhoto_main()%>" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6><%=pet.getPetName()%></h6>
                                    <span><%=pet.getSellPrice()%>đ</span>
                                </div>
                            </a
                            <%}%>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <%List<Pet> listBestSale2 = (List<Pet>) request.getAttribute("listBestSale2");%>
                            <%for (Pet pet:listBestSale2) {%>
                            <a href="shop-details.html" class="latest-product__item">
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
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Giảm giá</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <%List<Pet> listPetLatestSale1 = (List<Pet>) request.getAttribute("listPetLatestSale1");%>
                            <%for (Pet pet:listPetLatestSale1) {%>
                            <a href="shop-details.html" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="<%=pet.getPhoto().getPhoto_main()%>" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6><%=pet.getPetName()%></h6>
                                    <span><%=pet.getSellPrice()-pet.getSellPrice()*SaleDAO.getSaleByPetID(pet.getId())%>đ</span>
                                    <span><%=pet.getSellPrice()%>đ</span>
                                </div>
                            </a>
                            <%}%>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <%List<Pet> listPetLatestSale2 = (List<Pet>) request.getAttribute("listPetLatestSale2");%>
                            <%for (Pet pet:listPetLatestSale2) {%>
                            <a href="shop-details.html" class="latest-product__item">
                                <div class="latest-product__item__pic">
                                    <img src="<%=pet.getPhoto().getPhoto_main()%>" alt="">
                                </div>
                                <div class="latest-product__item__text">
                                    <h6><%=pet.getPetName()%></h6>
                                    <span><%=pet.getSellPrice()-pet.getSellPrice()*SaleDAO.getSaleByPetID(pet.getId())%>đ</span>
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
</section>
<!-- Latest Product Section End -->

<!-- Blog Section Begin -->
<!-- Blog Section End -->

<!-- Footer Section Begin -->
    <jsp:include page="footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="user/js/jquery-3.3.1.min.js"></script>
<script src="user/js/bootstrap.min.js"></script>
<script src="user/js/jquery.nice-select.min.js"></script>
<script src="user//js/jquery-ui.min.js"></script>
<script src="user//js/jquery.slicknav.js"></script>
<script src="user//js/mixitup.min.js"></script>
<script src="user//js/owl.carousel.min.js"></script>
<script src="user//js/main.js"></script>
<script src="user/js/page.js"></script>
<script>

    function Pager(divID, itemsPerPage) {
        this.divID = divID;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = 1;
        this.pages = 0;
        this.inited = false;
        this.showRecords = function(from, to) {
            var rows = document.getElementsByClassName(divID);
            // i starts from 1 to skip table header row
            for (var i = 1; i < rows.length; i++) {
                if (i < from || i > to)
                    rows[i].style.display = 'none';
                else
                    rows[i].style.display = '';
            }
        }
        this.showPage = function(pageNumber) {
            if (! this.inited) {
                alert("not inited");
                return;
            }
            var oldPageAnchor = document.getElementById('pg'+this.currentPage);
            oldPageAnchor.className = 'btn btn-sm btn-icon';
            this.currentPage = pageNumber;
            var newPageAnchor = document.getElementById('pg'+this.currentPage);
            newPageAnchor.className = 'btn btn-info btn-fill';
            var from = (pageNumber - 1) * itemsPerPage + 1;
            var to = from + itemsPerPage - 1;
            this.showRecords(from, to);
        }
        this.prev = function() {
            if (this.currentPage > 1)
                this.showPage(this.currentPage - 1);
        }
        this.next = function() {
            if (this.currentPage < this.pages) {
                this.showPage(this.currentPage + 1);
            }
        }
        this.init = function() {
            var rows = document.getElementsByClassName(divID);
            var records = (rows.length - 1);
            this.pages = Math.ceil(records / itemsPerPage);
            this.inited = true;
        }
        this.showPageNav = function(pagerName, positionId) {
            if (! this.inited) {
                alert("not inited");
                return;
            }
            var element = document.getElementById(positionId);
            var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="btn btn-sm btn-icon"> « Prev </span> ';
            for (var page = 1; page <= this.pages; page++)
                pagerHtml += '<span id="pg' + page + '" class="btn btn-sm btn-icon" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> ';

            pagerHtml += '<span onclick="'+pagerName+'.next();" class="btn btn-sm btn-icon"> Next »</span>';
            element.innerHTML = pagerHtml;
        }
    }

    var pager = new Pager('mix', 7);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
    

</script>
</body>

</html>

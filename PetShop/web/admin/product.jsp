<%@ page import="java.util.List" %>
<%@ page import="bean.Pet" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DAO.SaleDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="admin/css/bootstrap.min.css">
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="admin/css/style.css" rel='stylesheet' type='text/css'/>
    <link href="admin/css/style-responsive.css" rel="stylesheet"/>
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="admin/css/font.css" type="text/css"/>
    <link href="admin/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="admin/css/morris.css" type="text/css"/>
    <!-- calendar -->
    <link rel="stylesheet" href="admin/css/monthly.css">
    <!-- //calendar -->
    <!-- //font-awesome icons -->
    <script src="admin/js/jquery2.0.3.min.js"></script>
    <script src="admin/js/raphael-min.js"></script>
    <script src="admin/js/morris.js"></script>
    <link rel="stylesheet" href="admin/css/table.css">
    <script type="text/javascript">
        function deletePet(id, btn) {
            var check = confirm("Bạn chắc chắn muốn xóa???")
            if (check) {
                var url = "deletePet?pet_id=" + id;
                var xhttp;
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState == 4) {
                        var row = btn.parentNode.parentNode.parentNode;
                        row.parentNode.removeChild(row);
                    }
                };
                xhttp.open("POST", url, true);
                xhttp.send();
                alert("Xóa thành công");
            }
        }
    </script>
</head>
<body>
<section id="container">
    <!--header start-->
    <jsp:include page="header.jsp"></jsp:include>

    <!--header end-->
    <!--sidebar start-->
    <jsp:include page="menu.jsp"></jsp:include>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <div class="table-agile-info col-xs-12 col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thú cưng
                    </div>
                    <div>
                        <div class="row w3-res-tb">
                            <div class="col-sm-3 m-b-xs">
                                <select class="input-sm form-control w-sm inline v-middle">
                                    <option value="0">Romance</option>
                                    <option value="1">Comic</option>
                                    <option value="2">Horror</option>
                                    <option value="3">History</option>
                                    <option value="4">Humor and Comedy</option>
                                </select>
                            </div>
                            <div class="col-sm-5">
                                <div class="input-group">
                                    <input type="text" class="input-sm form-control" placeholder="Search">
                                    <span class="input-group-btn"><button class="btn btn-sm btn-default" type="button"><i class="fa fa-search"></i></button></span>
                                </div>
                            </div>
                            <div class="col-sm-4 m-b-xs">
                                <select class="input-sm form-control w-sm inline v-middle">
                                    <option value="0">Xem tất cả</option>
                                    <option value="1">Mới</option>
                                    <option value="2">Nổi bật</option>
                                </select>
                                <a href="addProduct.html"><button class="btn btn-sm btn-default" style="float: right">Thêm<i class="fa fa-plus"></i></button></a>
                            </div>
                        </div>

                        <table class="col-xs-12 col-md-12" id="tablepaging" class="table table-striped">
                            <tr>
                                <td>Mã</td>
                                <td>Giống</td>
                                <td>Tên</td>
                                <td>Hình ảnh</td>
                                <td>Giới tính</td>
                                <td>Cân nặng</td>
                                <td>Tuổi</td>
                                <td>Màu sắc</td>
                                <td>Giảm giá</td>
                                <td>Giá net</td>
                                <td>Giá bán</td>
                                <td>Số lượng</td>
                                <td>SL đã bán</td>
                                <td>Active</td>
                            </tr>
                            <%List<Pet> listPet = (List<Pet>) request.getAttribute("listPet");%>
                            <%for (Pet pet : listPet){%>
                            <tr>
                                <td><%=pet.getId()%></td>
                                <td><%=CategoryDAO.getCategoryInPetDetail(pet.getId()).getCategory_name()%></td>
                                <td><%=pet.getPetName()%></td>
                                <td><img src="<%=pet.getPhoto().getPhoto_main()%>"/></td>
                                <td><%=pet.getGender()%></td>
                                <td><%=pet.getWeight()%>kg</td>
                                <td><%=pet.getAge()%> tháng</td>
                                <td><%=pet.getColor()%></td>
                                <td><%=SaleDAO.getSaleByPetID(pet.getId())%></td>
                                <td><%=pet.getNetPrice()%>đ</td>
                                <td><%=pet.getSellPrice()%>đ</td>
                                <td><%=pet.getQuantity()%></td>
                                <td><%=pet.getSell_quantity()%></td>
                                <td><span><a href="editProduct.html"><i class="fa fa-edit"></i></a> <i
                                        class="fa fa-times-circle" onclick="deletePet(<%=pet.getId()%>, this)" style="cursor: pointer"></i></span></td>
                            </tr>
                           <%}%>
                        </table>
                        <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>
                    </div>
                </div>
            </div>
        </section>
    </section>
    <!--main content end-->
</section>
<script src="admin/js/bootstrap.js"></script>
<script src="admin/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="admin/js/scripts.js"></script>
<script src="admin/js/jquery.slimscroll.js"></script>
<script src="admin/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="admin/js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="admin/js/jquery.scrollTo.js"></script>
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/edittable.js"></script>
<script src="admin/js/breakPage.js"></script>
</body>
</html>


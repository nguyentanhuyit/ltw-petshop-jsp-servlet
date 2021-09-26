<%@ page import="bean.Species" %>
<%@ page import="bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DAO.SpeciesDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
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
    <link rel="stylesheet" href="admin/css/pure.css">

    <script type="text/javascript">
        function deleteCategory(id, btn) {
            var check = confirm("Bạn chắc chắn muốn xóa???")
            if (check) {
                var url = "deleteCategory?category_id=" + id;
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
    <section id="main-content">
        <section class="wrapper">
            <div class="table-agile-info col-xs-12 col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Giống thú cưng
                    </div>
                    <div>
                        <div class="row w3-res-tb">
                            <form action="searchCategory" method="get">
                                <div class="col-sm-8">
                                    <div class="input-group">

                                        <input type="text" class="input-sm form-control" placeholder="Search" name="search">
                                        <span class="input-group-btn"><button class="btn btn-sm btn-default" type="submit"><i class="fa fa-search"></i></button></span>

                                    </div>
                                </div>
                            </form>
                            <div class="col-sm-4">
                                <a href="addCategory"><button class="btn btn-sm btn-default" style="float: right">Add<i class="fa fa-plus"></i></button></a>
                            </div>
                        </div>
                        <table class="col-xs-12 col-lg-12" id="tablepaging" class="table table-striped">
                            <tr>
                                <td class="uneditable">Mã giống</td>
                                <td class="uneditable">Loài</td>
                                <td class="uneditable">Tên giống</td>
                                <td class="uneditable">Hình ảnh</td>
                                <td class="uneditable">Hoạt động</td>
                            </tr>
                            <%List<Category> listCategory = (List<Category>) request.getAttribute("listCategory");%>
                            <%for (int i =0;i<listCategory.size();i++){%>
                            <tr>
                                <td style="width: 10%"><%=listCategory.get(i).getCategory_id()%></td>
                                <td><%=SpeciesDAO.getSearchSpeciesName(listCategory.get(i).getCategory_id())%></td>
                                <td><%=listCategory.get(i).getCategory_name()%></td>
                                <td style="width: 20%"><img src="<%=listCategory.get(i).getPhoto()%>"></td>
                                <td><span><a href="editCategory?category_id=<%=listCategory.get(i).getCategory_id()%>" style="color:black;"><i class="fa fa-edit"></i></a>
                                    <i class="fa fa-times-circle" onclick="deleteCategory(<%=listCategory.get(i).getCategory_id()%>, this)" style="cursor: pointer"></i></span></td>
                            </tr>
                            <%}%>
                        </table>
                        <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>

                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<script src="admin/js/bootstrap.js"></script>
<script src="admin/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="admin/js/scripts.js"></script>
<script src="admin/js/jquery.slimscroll.js"></script>
<script src="admin/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="admin/js/jquery.scrollTo.js"></script>
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/breakPage.js"></script>

</body>
</html>

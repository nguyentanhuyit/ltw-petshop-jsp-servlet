<%@ page import="DAO.BillDAO" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css">
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel='stylesheet' type='text/css'/>
    <link href="${pageContext.request.contextPath}/admin/css/style-responsive.css" rel="stylesheet"/>
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css" type="text/css"/>
    <link href="${pageContext.request.contextPath}/admin/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/morris.css" type="text/css"/>
    <!-- calendar -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/monthly.css">
    <!-- //calendar -->
    <!-- //font-awesome icons -->
    <script src="${pageContext.request.contextPath}/admin/js/jquery2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/js/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/js/morris.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/pure.css">
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
                        CHI TIẾT ĐƠN HÀNG
                    </div>
                    <div>
                        <div class="row w3-res-tb">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-8">
                                <div class="input-group">
                                    <input type="text" class="input-sm form-control" placeholder="Search">
                                    <span class="input-group-btn"><button class="btn btn-sm btn-default"
                                                                          type="button"><i
                                            class="fa fa-search"></i></button></span>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <select class="input-sm form-control w-sm inline v-middle">
                                    <option value="0">Xem tất cả</option>
                                    <option value="1">Hôm nay</option>
                                    <option value="2">Tháng này</option>
                                </select>
                            </div>
                        </div>

                        <%String[] arr = (String[]) request.getAttribute("arr");%>
                        <% System.out.println(new BillDAO().print(arr));%>
                        <%if (arr != null) {%>
                        <div class="bill">
                            Mã đơn hàng:
                            <span><%= arr[0]%></span>
                        </div>
                        <div class="bill">
                            Tên khách hàng:
                            <span><%= arr[1]%></span>
                        </div>
                        <div class="bill">
                            Địa chỉ:
                            <span><%= arr[2]%></span>
                        </div>
                        <div class="bill">
                            Số điện thoại:
                            <span><%= arr[3]%></span>
                        </div>

                        <div class="bill">
                            Danh sách đã mua:
                        </div>

                        <div>
                            <table class="col-xs-12 col-lg-12" id="bill-detail">

                                <tr>
                                    <td>Mã thú cưng</td>
                                    <td>Tên</td>
                                    <td>Số lượng</td>
                                    <td>Đơn giá</td>
                                    <td>Tổng giá</td>
                                </tr>


                                <c:forEach items="${list}" var="billdetail">
                                    <tr>
                                        <td>${billdetail.id}</td>
                                        <td>${billdetail.petName}</td>
                                        <td>${billdetail.quantity}</td>
                                        <td>${billdetail.amount}</td>
                                        <td data-order="${billdetail.total}">${billdetail.total}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="bill">
                            Đặt cọc:
                            <span><%= arr[5]%></span>
                        </div>
                        <div class="bill">
                            Thanh toán:
                            <span><%= arr[6] %></span>
                        </div>
                        <div class="bill">
                            Thành tiền:
                            <span>${total}</span>
                        </div>
                        <div class="bill">
                            Trạng thái:
                            <span><%=arr[4]%></span>
                        </div>

                        <%}%>
                        <footer class="panel-footer col-xs-12 col-md-12">
                            <div class="row">

                                <div class="col-sm-5">
                                </div>
                                <div class="col-sm-7 text-right text-center-xs">
                                    <div class="form-group" style="float:left;">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <a href="${pageContext.request.contextPath}/managerOther"
                                               style="color: white;text-align: center" class="btn btn-primary">Trở
                                                về</a>
                                            <%--                                        <button class="btn btn-primary"></button>--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
<script>
    $(document).ready(function() {
        // DataTable initialisation
        $('#bill-detail').DataTable(
            {
                "paging": false,
                "autoWidth": true,
                "footerCallback": function ( row, data, start, end, display ) {
                    var api = this.api();
                    nb_cols = api.columns().nodes().length;
                    var j = 3;
                    while(j < nb_cols){
                        var pageTotal = api
                            .column( j, { page: 'current'} )
                            .data()
                            .reduce( function (a, b) {
                                return Number(a) + Number(b);
                            }, 0 );
                        // Update footer
                        $( api.column( j ).footer() ).html(pageTotal);
                        j++;
                    }
                }
            }
        );
    });
</script>
</body>
</html>

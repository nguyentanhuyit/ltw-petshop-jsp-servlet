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
                        Đặt hàng
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
                        <table class="col-xs-12 col-lg-12" id="editable" class="pure-table pure-table-bordered">
                            <tr>
                                <td title="Mã đơn hàng" class="uneditable">Mã ĐH</td>
                                <td class="uneditable">Khách hàng</td>
                                <td title="Ngày đặt hàng" class="uneditable">Ngày ĐH</td>
                                <td title="Ngày giao hàng" class="uneditable">Ngày GH</td>
                                <td class="uneditable">Thanh toán</td>
                                <td class="uneditable">Tổng giá</td>
                                <td class="uneditable">Trạng thái</td>
                                <td class="uneditable">Chi tiết</td>
                                <td class="uneditable">Action</td>
                            </tr>

        <c:forEach items="${list}" var="bill">
                            <tr>
                                
                                <td  class="uneditable">${bill.bill_id}</td>
                                <td class="uneditable">${bill.account_name}</td>
                                <td class="uneditable">${bill.bill_date}</td>
                                <td class="uneditable">${bill.delivery_date}</td>
                                <c:set var="payment" value="${bill.payment}"/>
                                <td><input type="checkbox" ${payment == true?'checked disabled':''} ></td>

                                <td class="uneditable">${bill.total_price}</td>
                                <td>${bill.bill_status}</td>
                                    <td><a href="${pageContext.request.contextPath}/orderDetail?bid=${bill.bill_id}" class="detail" data-toggle="modal"><i class="fa fa-eye"></i></a></td>
                                    <td class="uneditable">
                                 <span>
                                    <i class="icon-edit"></i>
                                        <a href="${pageContext.request.contextPath}/deleteBill?bid=${bill.bill_id}" class="delete" data-toggle="modal" data-confirm="Bạn muốn xóa thông tin này?"><i class=" fa fa-times-circle"></i></a>
                                </span></td>
                            </tr>
        </c:forEach>
                        </table>
                        <footer class="panel-footer col-xs-12 col-md-12">
                            <div class="row">
                                <div class="col-sm-5">
                                </div>
                                <div class="col-sm-7 text-right text-center-xs">
                                    <ul class="pagination pagination-sm m-t-none m-b-none">
                                        <li><a href=""><i class="fa fa-chevron-left"></i></a></li>
                                        <li><a href="">1</a></li>
                                        <li><a href="">2</a></li>
                                        <li><a href="">3</a></li>
                                        <li><a href="">4</a></li>
                                        <li><a href=""><i class="fa fa-chevron-right"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </footer>
                        <div class="form-group" style="float: right;">
                            <div class="col-lg-offset-2 col-lg-10" style="margin-top: 10px; display: flex;">
                                <button type="submit" class="btn btn-primary btn-edit" id="btn-save">Lưu</button>
                                <button type="button" class="btn btn-default btn-edit" id="btn-cancel">Hủy</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>
</section>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.slimscroll.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="${pageContext.request.contextPath}/admin/js/jquery.scrollTo.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/edittable.js"></script>
<script>
    $(document).ready(function(){
      $(".btn-edit").hide();
      $(".icon-edit").click(function(){
        $('#editable').editableTableWidget();
        $('#editable td.uneditable').on('change', function(evt, newValue) {
        return false;
        });
        $(".uneditable").css('cursor', 'none');
        $(".btn-edit").show();
      });
      $(".btn-edit").click(function(){
        $(".uneditable").css('cursor', '');
        $(".btn-edit").hide();
      });
    });
    
    </script>

<script>
    var deleteLinks = document.querySelectorAll('.delete');

    for (var i = 0; i < deleteLinks.length; i++) {
        deleteLinks[i].addEventListener('click', function(event) {
            event.preventDefault();

            var choice = confirm(this.getAttribute('data-confirm'));
            if (choice) {
                window.location.href = this.getAttribute('href');
            }
        });
    }
</script>
</body>
</html>

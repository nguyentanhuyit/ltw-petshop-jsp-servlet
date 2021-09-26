<%@ page import="java.util.List" %>
<%@ page import="bean.Pet" %>
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
    <!-- //font-awesome icons -->
    <script src="admin/js/jquery2.0.3.min.js"></script>
    <link rel="stylesheet" href="admin/css/form.css">
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
            <div class="form-w3layouts col-xs-12 col-md-12">
                <section class="panel">
                    <header class="panel-heading">
                        Thêm giảm giá
                    </header>
                    <div class="panel-body">
                        <form class="form-horizontal bucket-form" method="post" action="addSale">

                            <div class="form-group">
                                <label for="pet_name" class="col-lg-2 col-sm-2 control-label">Tên pet</label>
                                <div class="col-sm-10">
                                    <select id="pet_name" class="form-control m-bot15" name="pet">
                                        <%List<Pet> listPet = (List<Pet>) request.getAttribute("listPet");%>
                                       <%for (Pet pet: listPet){%>

                                        <option><%=pet.getId()+" "%><%=pet.getPetName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="rate" class="col-lg-2 col-sm-2 control-label">Tỷ lệ</label>
                                <div class="col-sm-10">
                                    <input id="rate" type="number" min="0" max="1" step="0.1" class="form-control" name="rate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="begin_date" class="col-lg-2 col-sm-2 control-label">Ngày bắt đầu</label>
                                <div class="col-sm-10">
                                    <input id="begin_date" type="date" class="form-control" name="begin_date">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="end_date" class="col-lg-2 col-sm-2 control-label">Ngày kết thúc</label>
                                <div class="col-sm-10">
                                    <input id="end_date" type="date" class="form-control" name="end_date">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" class="btn btn-primary">Lưu</button>
                                    <button type="button" class="btn btn-default">Hủy</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>

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
<!-- calendar -->
<script type="text/javascript" src="admin/js/monthly.js"></script>
<script type="text/javascript">
    $(window).load(function () {

        $('#mycalendar').monthly({
            mode: 'event',

        });

        $('#mycalendar2').monthly({
            mode: 'picker',
            target: '#mytarget',
            setWidth: '250px',
            startHidden: true,
            showTrigger: '#mytarget',
            stylePast: true,
            disablePast: true
        });

        switch (window.location.protocol) {
            case 'http:':
            case 'https:':
                // running on a server, should be good.
                break;
            case 'file:':
                alert('Just a heads-up, events will not work when run locally.');
        }

    });
</script>
<!-- //calendar -->
</body>
</html>

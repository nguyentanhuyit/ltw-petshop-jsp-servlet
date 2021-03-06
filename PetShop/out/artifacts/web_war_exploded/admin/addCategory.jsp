
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<head>
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="admin/css/bootstrap.min.css" >
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="admin/css/style.css" rel='stylesheet' type='text/css' />
    <link href="admin/css/style-responsive.css" rel="stylesheet"/>
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
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
    <link rel="stylesheet" href="admin/css/form.css">
    <style>
    label.error{
        color: red;
    }
</style>
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
            <div class="form-w3layouts col-xs-12 col-md-12">
                <section class="panel">
                    <header class="panel-heading">
                        Th??m gi???ng
                    </header>
                    <div class="body-content">
                        <div class="avatar-upload">
                            <div class="avatar">
                                <%if (request.getAttribute("ImagePath")==null||request.getAttribute("ImagePath")==""){%>
                                <img src="user/img/avatar/avatar_default.jpg" alt="avatar">
                                <%}else{%>
                                <img src="<%=request.getAttribute("ImagePath")%>" alt="avatar">
                                <%}%>
                            </div>
                            <form action="uploadImageCategory" method="post" enctype="multipart/form-data" name="uploadImageCategoryForm">
                                <div class="btn-upload">
                                    <input type="file" value="Ch???n ???nh" name="image">
                                    <button type="submit" style="margin-left: 41.3%; border: 1px solid gray; border-radius:2px">Upload</button>
                                </div>
                            </form>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal bucket-form" method="post" name="addCategoryForm" action="addCategory">
                                <input type="hidden" value="<%=request.getAttribute("ImagePath")%>" name="photo">
                                <div class="form-group">
                                    <label for="category" class="col-lg-2 col-sm-2 control-label">Lo??i</label>
                                    <div class="col-sm-10">
                                        <select id="category" class="form-control m-bot15" name="species">
                                            <option>Ch??</option>
                                            <option>M??o</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="categoryName" class="col-lg-2 col-sm-2 control-label">T??n gi???ng</label>
                                    <div class="col-sm-10">
                                        <input id="categoryName" type="text" class="form-control" name="categoryName">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button type="submit" class="btn btn-primary">L??u</button>
                                        <button type="reset" class="btn btn-default">H???y</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </section>
    </section>
</section>
<script src="admin/js/bootstrap.js"></script>
<script src="admin/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="admin/js/scripts.js"></script>
<script src="admin/js/jquery.slimscroll.js"></script>
<script src="admin/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="admin/js/jquery.scrollTo.js"></script>
<!-- calendar -->
<script type="text/javascript" src="admin/js/monthly.js"></script>
<script type="text/javascript">
    $(window).load( function() {

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

        switch(window.location.protocol) {
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
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/jquery.validate.min.js"></script>
<script type="text/javascript">

    $(function(){
        $("form[name='addCategoryForm']").validate({
            rules:{
                photo: "required",
                categoryName: "required"
            },
            messages: {
                photo: "Vui l??ng ch???n h??nh ???nh",
                categoryName: "Vui l??ng nh???p t??n gi???ng"
            }
        });
    });
    $(function(){
        $("form[name='uploadImageCategoryForm']").validate({
            rules:{
                image: "required",

            },
            messages: {
                image: "Vui l??ng ch???n h??nh ???nh",

            }
        });
    });

</script>
</body>
</html>


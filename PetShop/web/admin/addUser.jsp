<%@ page import="java.util.List" %>
<%@ page import="bean.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <link rel="admin/stylesheet" href="css/form.css">
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
                        Thêm người dùng
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
                            <form action="uploadImageUser" method="post" enctype="multipart/form-data" name="uploadImageUserForm">
                                <div class="btn-upload">
                                    <input type="file" value="Chọn ảnh" name="image">
                                    <button type="submit" style="margin-left: 41.3%; border: 1px solid gray; border-radius:2px">Upload</button>
                                </div>
                            </form>
                        </div>
                        <div class="panel-body">
                        <form class="form-horizontal bucket-form" method="post" action="addUser" name="addUserForm">
                            <%if (request.getAttribute("ImagePath")==null){%>
                            <input type="hidden" value="user/img/avatar/avatar_default.jpg" name="photo">
                            <%}else{%>
                            <input type="hidden" value="<%=request.getAttribute("ImagePath")%>" name="photo">
                            <%}%>
                            <%List<Role> listRole = (List<Role>) request.getAttribute("listRole");%>
                            <div class="form-group">
                                <label for="role" class="col-lg-2 col-sm-2 control-label">Role</label>
                                <div class="col-sm-10">
                                    <select id="role" class="form-control m-bot15" name="role_name">
                                        <%for (Role role : listRole){%>
                                        <option><%=role.getRole_name()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_name" class="col-lg-2 col-sm-2 control-label">User name</label>
                                <div class="col-sm-10">
                                    <input id="user_name" type="text" class="form-control" name="user_name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-lg-2 col-sm-2 control-label">Password</label>
                                <div class="col-sm-10">
                                    <input id="password" type="password" class="form-control" name="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pass_confirm" class="col-lg-2 col-sm-2 control-label">Password confirm</label>
                                <div class="col-sm-10">
                                    <input id="pass_confirm" type="password" class="form-control" name="pass_confirm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="account_name" class="col-lg-2 col-sm-2 control-label">Họ tên</label>
                                <div class="col-sm-10">
                                    <input id="account_name" type="text" class="form-control" name="account_name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="gender" class="col-lg-2 col-sm-2 control-label">Giới tính</label>
                                <div class="col-sm-10">
                                    <select id="gender" class="form-control m-bot15" name="gender">
                                        <option>Nam</option>
                                        <option>Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-lg-2 col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input id="email" type="email" class="form-control" name="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="birthday" class="col-lg-2 col-sm-2 control-label">Ngày sinh</label>
                                <div class="col-sm-10">
                                    <input id="birthday" type="date" class="form-control" name="birthday">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone_num" class="col-lg-2 col-sm-2 control-label" title="Số điện thoại">SĐT</label>
                                <div class="col-sm-10">
                                    <input id="phone_num" type="text" class="form-control" name="phone_num">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-2 col-sm-2 control-label"></label>
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" class="btn btn-primary">Lưu</button>
                                    <button type="reset" class="btn btn-default">Hủy</button>
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
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/jquery.validate.min.js"></script>
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

<script type="text/javascript">

    $(function(){
        $("form[name='addUserForm']").validate({
            rules:{
                user_name:{required:true, minlength: 8} ,
                password:{required:true, minlength: 8},
                pass_confirm: {required: true, equalTo:"#password"},
                account_name: "required"
            },
            messages: {
               user_name: {required:"Vui lòng điền tên đăng nhập", minlength:"Tên đăng nhập tối thiểu 8 ký tự"},
                pass_word: {required: "Vui lòng điền mật khẩu", minlength: "Mật khẩu tối thiểu 8 ký tự"},
                pass_confirm: {required: "Vui lòng xác nhận mật khẩu", equalTo: "Mật khẩu xác nhận không khớp"},
                account_name: {required:"Vui lòng điền tên tài khoản"}
            }
        });
    });
    $(function(){
        $("form[name='uploadImageUserForm']").validate({
            rules:{
                image: "required"

            },
            messages: {
                image: "Vui lòng chọn hình ảnh"

            }
        });
    });

</script>
<!-- //calendar -->
</body>
</html>

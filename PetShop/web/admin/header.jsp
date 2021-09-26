
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header fixed-top clearfix">
    <!--logo start-->
    <div class="brand">
        <a href="index.html" class="logo">
            Admin
        </a>
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars"></div>
        </div>
    </div>
    <!--logo end-->
    <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
            <!-- settings start -->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <i class="fa fa-tasks"></i>
                    <span class="badge bg-success">8</span>
                </a>
                <ul class="dropdown-menu extended tasks-bar">
                    <li>
                        <p class="">Bạn có 8 nhiệm vụ đang chờ</p>
                    </li>
                    <li>
                        <a href="#">
                            <div class="task-info clearfix">
                                <div class="desc pull-left">
                                    <h5>Xác định mục tiêu</h5>
                                    <p>25% , Deadline 12/6/20</p>
                                </div>
                                <span class="notification-pie-chart pull-right" data-percent="45">
                            <span class="percent"></span>
                            </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="task-info clearfix">
                                <div class="desc pull-left">
                                    <h5>Giao hàng</h5>
                                    <p>45% , Deadline 12/7/20</p>
                                </div>
                                <span class="notification-pie-chart pull-right" data-percent="78">
                            <span class="percent"></span>
                            </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="task-info clearfix">
                                <div class="desc pull-left">
                                    <h5>Thu tiền thanh toán</h5>
                                    <p>87% , Deadline 30/8/20</p>
                                </div>
                                <span class="notification-pie-chart pull-right" data-percent="60">
                            <span class="percent"></span>
                            </span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="task-info clearfix">
                                <div class="desc pull-left">
                                    <h5>Mục tiêu bán hàng</h5>
                                    <p>33% , Deadline 30/8/20</p>
                                </div>
                                <span class="notification-pie-chart pull-right" data-percent="90">
                            <span class="percent"></span>
                            </span>
                            </div>
                        </a>
                    </li>

                    <li class="external">
                        <a href="#">Xem tất cả</a>
                    </li>
                </ul>
            </li>
            <!-- settings end -->
            <!-- inbox dropdown start-->
            <li id="header_inbox_bar" class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-important">4</span>
                </a>
                <ul class="dropdown-menu extended inbox">
                    <li>
                        <p class="red">bạn có 4 thư</p>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="images/3.png"></span>
                            <span class="subject">
                                <span class="from">Jonathan Smith</span>
                                <span class="time">Hiện tại</span>
                                </span>
                            <span class="message">
                                    Xin chào, tôi cần liên hệ.
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="images/1.png"></span>
                            <span class="subject">
                                <span class="from">Jane Doe</span>
                                <span class="time">2 phút trước</span>
                                </span>
                            <span class="message">
                                    Ngày tốt lành nhé.
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="images/3.png"></span>
                            <span class="subject">
                                <span class="from">Tasi sam</span>
                                <span class="time">2 ngày trước</span>
                                </span>
                            <span class="message">
                                    Chúng ta có hẹn vào ngày mai.
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="photo"><img alt="avatar" src="images/2.png"></span>
                            <span class="subject">
                                <span class="from">Mr. Perfect</span>
                                <span class="time">2 giờ trước</span>
                                </span>
                            <span class="message">
                                    Gửi tiền vào tài khoản tôi nhé.
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">Xem tất cả</a>
                    </li>
                </ul>
            </li>
            <!-- inbox dropdown end -->
            <!-- notification dropdown start-->
            <li id="header_notification_bar" class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                    <i class="fa fa-bell-o"></i>
                    <span class="badge bg-warning">3</span>
                </a>
                <ul class="dropdown-menu extended notification">
                    <li>
                        <p>Thông báo</p>
                    </li>
                    <li>
                        <div class="alert alert-info clearfix">
                            <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                            <div class="noti-info">
                                <a href="#"> Server #1 ổn.</a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="alert alert-danger clearfix">
                            <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                            <div class="noti-info">
                                <a href="#"> Server #2 quá tải.</a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="alert alert-success clearfix">
                            <span class="alert-icon"><i class="fa fa-bolt"></i></span>
                            <div class="noti-info">
                                <a href="#"> Server #3 ổn.</a>
                            </div>
                        </div>
                    </li>

                </ul>
            </li>
            <!-- notification dropdown end -->
        </ul>
        <!--  notification end -->
    </div>
    <div class="top-nav clearfix">
        <!--search & user info start-->
        <ul class="nav pull-right top-menu">
            <li>
                <input type="text" class="form-control search" placeholder=" Search">
            </li>
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <img alt="" src="user/images/2.png">
                    <span class="username">John Doe</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <li><a href="profile.html"><i class=" fa fa-suitcase"></i>Thông tin</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>Cài đặt</a></li>
                    <li><a href="login.html"><i class="fa fa-key"></i>Đăng xuất</a></li>
                </ul>
            </li>
            <!-- user login dropdown end -->

        </ul>
        <!--search & user info end-->
    </div>
</header>

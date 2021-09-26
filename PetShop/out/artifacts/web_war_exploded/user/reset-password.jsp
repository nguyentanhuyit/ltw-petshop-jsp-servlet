<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 1/8/2021
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet shop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/style-edit.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/main-edit.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" action="resetPassword" method="post">
					<span class="login100-form-title p-b-49">
						Đặt lại mật khẩu
					</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate="Email is reauired">
                    <span class="label-input100">Email</span>
                    <%  if (session.getAttribute("acc")!= null){
                        Account acc = (Account) session.getAttribute("acc");
                    %>
                    <p style="text-align: center "><%= acc.getEmail()%></p>

                    <%}%>
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-23" data-validate="Password is reauired">
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" id="password" name="password" placeholder="Nhập mật khẩu" onkeyup='check(); ' />
                    <span class="focus-input100" data-symbol="&#xf18e;"></span>
                    <span class="span-input" id='check'></span>
                </div>

                <div class="wrap-input100 validate-input m-b-23" data-validate="Email is reauired"
                     style="margin-bottom: 10px">
                    <span class="label-input100">Confirm password</span>
                    <input class="input100" type="password" id="confirm_password" name="confirm_password" placeholder="Nhập lại mật khẩu"
                           onkeyup='check();' />
                    <span class="focus-input100" data-symbol="&#xf18e;"></span>
                    <span class="span-input" id='message'></span>
                </div>

                <input type="checkbox" onclick="myFunction()" id="showpass">Show password
                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="submit" id="button-reset">
                            Xác nhận
                        </button>

                    </div>
                </div>
                <c:if test="${not empty done}">
                    <script>
                        window.addEventListener("load",function(){
                            alert("${done}");
                        });
                    </script>
                </c:if>
                <div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Hoặc đăng ký
                        </span>
                    <a href="sign-up.html" class="txt2">
                        Đăng ký
                    </a>
                </div>

                <div class="flex-c-m">
                    <a href="#" class="login100-social-item bg1">
                        <i class="fa fa-facebook"></i>
                    </a>

                    <a href="#" class="login100-social-item bg2">
                        <i class="fa fa-twitter"></i>
                    </a>

                    <a href="#" class="login100-social-item bg3">
                        <i class="fa fa-google"></i>
                    </a>
                </div>

                <div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Bạn đã có tài khoản
						</span>

                    <a href="login.html" class="txt2">
                        Đăng nhập
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<script src="${pageContext.request.contextPath}/user/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/user/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/vendor/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/user/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/user/js/sign.js"></script>
<script src="${pageContext.request.contextPath}/user/js/main.js"></script>
<script src="${pageContext.request.contextPath}/user/js/main1.js"></script>
<script src="${pageContext.request.contextPath}/user/js/sign1.js"></script>


</body>
</html>

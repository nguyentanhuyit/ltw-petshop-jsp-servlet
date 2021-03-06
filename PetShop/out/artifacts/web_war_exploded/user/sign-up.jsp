
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pet shop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="user/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="user/css/util.css">
    <link rel="stylesheet" type="text/css" href="user/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" action="signup" method="post">
					<span class="login100-form-title p-b-49">
						????ng k??
					</span>
                <div style="color: #B5231F; text-align: center; margin: auto">${requestScope.Erro}</div>
                <div class="wrap-input100 validate-input m-b-23" >
                    <span class="label-input100">T??n ????ng nh???p</span>
                    <input class="input100 input-name" type="text" name="username" placeholder="Nh???p t??n ????ng nh???p">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <span class="label-input100">M???t kh???u</span>
                    <input class="input100 input-pass" type="password" name="pass" placeholder="Nh???p m???t kh???u">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>
                <div class="wrap-input100 validate-input m-b" style="    margin: 20px 0 20px 0">
                    <span class="label-input100">X??c nh???n m???t kh???u</span>
                    <input class="input100 input-pass-confirm" type="password" name="pass-confirm" placeholder="X??c nh???n m???t kh???u">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="row validate-input">
                    <h6>Ch??nh s??ch v?? ??i???u kho???n</h6>
                    <div class="input-group">
                        <input type="checkbox" id="terms" name="check" class="input-check" value="Y">
                        <label for="terms">T??i ch???p nh???n c??c ??i???u kho???n v?? ??i???u ki???n ????? ????ng k?? d???ch v??? n??y v?? qua ????y x??c nh???n r???ng t??i ???? ?????c ch??nh s??ch b???o m???t.</label>
                    </div>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            ????ng k??
                        </button>
                    </div>
                </div>

                <div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Ho???c ????ng k??
						</span>
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
							B???n ???? c?? t??i kho???n?
						</span>

                    <a href="login" class="txt2">
                        ????ng nh???p
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="user/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="user/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="user/vendor/bootstrap/js/popper.js"></script>
<script src="user/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="user/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="user/vendor/daterangepicker/moment.min.js"></script>
<script src="user/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="user/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="user/js/sign.js"></script>

</body>
</html>

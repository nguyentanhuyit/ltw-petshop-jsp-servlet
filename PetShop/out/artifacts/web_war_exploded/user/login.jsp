
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
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
            <form class="login100-form validate-form" method="post" action="login">
					<span class="login100-form-title p-b-49">
						Đăng nhập
					</span>
                <div style="color: #B5231F; text-align: center; margin: auto">${requestScope.Inform}</div>
                <div style="color: #B5231F; text-align: center; margin: auto">${requestScope.errorStr}</div>
                <div class="wrap-input100 validate-input m-b-23" >
                    <span class="label-input100">Tên đăng nhập</span>
                    <input class="input100 input-name" type="text" name="username" placeholder="Nhập tên đăng nhập">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <span class="label-input100">Mật khẩu</span>
                    <input class="input100 input-pass" type="password" name="pass" placeholder="Nhập mật khẩu">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="text-right p-t-8 p-b-31">
                    <a href="forgot-pass">
                        Quên mật khẩu
                    </a>
                </div>
                <div class="row">
                    <div class="input-group">
                        <input type="checkbox" id="terms" name="check" value="A">
                        <label for="terms">Nhớ mật khẩu</label>
                    </div>
                </div>
                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Đăng nhập
                        </button>
                    </div>
                </div>

                <div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Hoặc đăng nhập
						</span>
                </div>

                <div class="flex-c-m">
                    <a href="#" class="login100-social-item bg1">
                        <i class="fa fa-facebook" ></i>
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
							Hoặc đăng ký
						</span>

                    <a href="signup" class="txt2">
                        Đăng ký
                    </a>

                </div>
            </form>
            <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
            </fb:login-button>
            <div id="fb-root"></div>
            <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v9.0&appId=691427151542543&autoLogAppEvents=1" nonce="MvCqCmIE"></script>
<%--            <div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false"></div>--%>
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

<script>


    function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
        console.log('statusChangeCallback');
        console.log(response);                   // The current login status of the person.
        if (response.status === 'connected') {   // Logged into your webpage and Facebook.
            testAPI();
        } else {                                 // Not logged into your webpage or we are unable to tell.
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this webpage.';
        }
    }


    function checkLoginState() {               // Called when a person is finished with the Login Button.
        FB.getLoginStatus(function(response) {   // See the onlogin handler
            statusChangeCallback(response);
        });
    }


    window.fbAsyncInit = function() {
        FB.init({
            appId      : '{app-id}',
            cookie     : true,                     // Enable cookies to allow the server to access the session.
            xfbml      : true,                     // Parse social plugins on this webpage.
            version    : '{api-version}'           // Use this Graph API version for this call.
        });


        FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
            statusChangeCallback(response);        // Returns the login status.
        });
    };

    function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                'Thanks for logging in, ' + response.name + '!';
        });
    }

</script>



<div id="status">
</div>

<!-- Load the JS SDK asynchronously -->
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
<%--<script async defer crossorigin src="user/js/fb_sdk.js"></script>--%>
</body>
</html>

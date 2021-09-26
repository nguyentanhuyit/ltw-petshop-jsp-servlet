
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="hero__search">
    <div class="hero__search__form">
        <form  name="myform" action="search" method="get">
            <div class="hero__search__categories">
                Tất cả sản phẩm
                <span class="arrow_carrot-down"></span>
            </div>
            <input type="text" placeholder="Bạn cần gì?" name="key" onkeyup="Search()" >
            <button type="submit" class="site-btn">SEARCH</button>
        </form>
    </div>
    <div class="hero__search__phone">
        <div class="hero__search__phone__icon">
            <i class="fa fa-phone"></i>
        </div>
        <div class="hero__search__phone__text">
            <h5>+65 11.188.888</h5>
            <span>Hỗ trợ 24/7</span>
        </div>
    </div>
</div>
<script type="text/javascript">
    function Search() {
        var xhttp;
        var key = document.myform.key.value;
        var url = "search?key="+key;
        if(window.XMLHttpRequest){
            xhttp = new XMLHttpRequest();
        }else{
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhttp.onreadystatechange = function () {
            if(xhttp.readyState==4){
                var data = xhttp.responseText;
                document.getElementById("MySearch").innerHTML = data;
            }
        }
        xhttp.open("POST", url, true);
        xhttp.send();
    }
</script>

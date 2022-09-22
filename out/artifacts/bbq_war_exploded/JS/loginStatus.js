function setHeader(loginInfo) {

    alert("메롱")

    if (loginInfo.id == 'admin01') {

        alert("ㅅㅣ바")

        $("#nav2 li").remove();

        $("#nav2").append("<li class=\"nav-item\"><a href=\"\" class=\"nav-link link-dark px-2\" id=\"logout\">로그아웃</a></li><li class=\"nav-item\"><a href=\"../bbq/mypage.html\" class=\"nav-link link-dark px-2\">마이페이지</a></li><li class=\"nav-item\"><a href=\"../bbq/customerinfo.html\" class=\"nav-link link-dark px-2\">고객센터</a></li>");

        $("#logout").on("click", function () {
            location.href="/bbq/log/out";
        });
    }
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신짱구 팬페이지</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>

<body>
	<style>
	.image-thumbnail {
    	object-fit:cover;
    }
	</style>
    <header>
        <div class="inner">
            <h1><a href="#">짱구는 못말려</a></h1>

            <ul id="gnb">
            	<li><a href="board/list.jsp">게시판</a></li>
                <li><a href="https://namu.wiki/w/%EC%A7%B1%EA%B5%AC%EB%8A%94%20%EB%AA%BB%EB%A7%90%EB%A0%A4">나무위키</a></li>
                <li><a href="https://www.youtube.com/@jjangu_dasibogi/videos">유튜브</a></li>
                <li><a href="https://www.github.com">홈페이지 정보</a></li>
            </ul>
<%
	if ((String)session.getAttribute("userId") != null) {
%>
			<ul class="util">
				<li><%=(String)session.getAttribute("username")%>님 환영합니다.</li>
                <li><a href="logout.jsp">로그아웃</a></li>
                <li><a href="mem_update_form.jsp">회원정보 수정</a></li>
            </ul> 
<%  
    } else {
%>
			<ul class="util">
                <li><a href="login_form.jsp">로그인</a></li>
                <li><a href="signup_form.jsp">회원가입</a></li>
            </ul>
<%
    }
%>     
        </div>
    </header>


    <figure>
    <div class="image-box">
     	<img src="img/house.jpg">
    </div>
        <div class="inner">
            <h1>Welcome</h1>
            <p>신짱구 월드에 오신걸 환영합니다. <br>
                자유롭게 이용해 주세요.</p>
        </div>
    </figure>

    <section>
        <div class="inner">
            <h1>RECENT NEWS</h1>
            <div class="wrap">
                <article>
                    <div class="pic">
                        <img src="img/news1.jpg" alt="1번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad
                        maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news2.jpg" alt="2번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad
                        maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news3.jpg" alt="3번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad
                        maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news4.jpg" alt="4번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad
                        maiores!</p>
                </article>
            </div>
        </div>
    </section>

    <footer>
        <div class="inner">
            <div class="upper">
                <h1>KimChangYong</h1>
                <ul>
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas, facere.<br>
                    TEL : 031-111-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2020 DOCDELAB &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>




</body>

</html>
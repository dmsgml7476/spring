<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<ul id="menuList">
			<li><a href="/"> 어린이집 </a></li>
			<li><a href="/list?type=유"> 유치원 </a></li>
			<li><a href="/list?type=초"> 초등학교 </a></li>
			<li><a href="/list?type=중"> 중학교 </a></li>
			<li><a href="/list?type=고"> 고등학교 </a></li>
			<li><a href="/list?type=특수"> 특수학교 </a></li>
			<li><a href="/"> 은진학교종이땡땡 </a></li>
			<li><a href="/"> 현진사립유치원 </a></li>
		</ul>
		
		
		
		<hr>
		<%
			String user = (String)session.getAttribute("user");
		
			if (user == null) { // 로그인하지 않았거나 로그인 실패
		%>
		
		<a href="/signIn">로그인</a>
		<a href="/signUp">회원가입</a>
	<% } else { %>
		<b> <%=user %> <a href="/logout">로그아웃</a></b>
		<a href="/userUpdate">정보수정</a>
	<% } %>		
		
		
		
	</div>
</body>
</html>
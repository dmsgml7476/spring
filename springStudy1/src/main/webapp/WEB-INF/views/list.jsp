<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{ width:1000px; margin:0 auto;}
	#schoolList{ width:100%; padding:50px 0;}
	.list{ display:flex; align-items:center;}
	.num{ width:100px; text-align:center;}
	.name{width:250px; text-align:center;}
	.addr{width:250px; text-align:center;}
	.tel{width:150px; text-align:center;}
	.url{ width:250px; text-align:center;}
</style>
</head>
<body>
	
	<div id="wrap">
		<h2> 조회 결과 </h2>
		<ul id="schoolList">
			
			<li class="list"> 
				<b class="num">번호</b>
				<b class="name">학교명</b>
				<b class="addr">주소</b>
				<b class="tel">연락처</b>
				<b class="url">홈페이지</b>
			</li>
			
<%--  for(School sc : list)   --%>


			<c:forEach var="row" items="${list }">
				<li class="list">
					<span class="num">${row.id }</span>
					<span class="name">${row.schoolName }</span>
					<span class="addr">${row.address }</span>
					<span class="tel">${row.tel }</span>
					<span class="url">${row.homePage }</span>
				</li>
			</c:forEach>
			
		</ul>
	</div>
	
</body>
</html>







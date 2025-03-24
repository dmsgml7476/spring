<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 
<form method="post" action="/signUp">
	
	<input type="text" name="userId" placeholder="아이디 입력해라"> <br>
	<input type="password" name="userPw" placeholder="비밀번호 입력하거라"> <br>
	<input type="email" name="userEmail" placeholder="이메일 입력해봐"> <br>
	<input type="text" name="userAddr" placeholder="니네 집 어디야"> <br>
	<input type="text" name="userJob" placeholder="머하냐?"> <br>
	<input type="text" name="userLike" placeholder="너가 젤 최고로 진짜 엄청 가장 좋아하는건?"> <br>
	<button >회원가입</button>
</form>


</body>
</html>
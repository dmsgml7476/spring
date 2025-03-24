<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보 수정

<form method="post" action="/userUpdate">  <!-- info는 UserSevice에서 -->
	<input type="text" name="id" value="${info.userId}" readonly placeholder="아이디 입력해라"> <br>
	<input type="password" name="pw" placeholder="비밀번호 입력하거라"> <br>
	<input type="email" name="email" value="${info.userEmail}" placeholder="이메일 입력해봐"> <br>
	<input type="text" name="addr" value="${info.userAddr}" placeholder="니네 집 어디야"> <br>
	<input type="text" name="job" value="${info.userJob}" placeholder="머하냐?"> <br>
	<input type="text" name="like" value="${info.userLike}" placeholder="너가 젤 최고로 진짜 엄청 가장 좋아하는건?"> <br>
	<button >정보 수정</button>
</form>


</body>
</html>
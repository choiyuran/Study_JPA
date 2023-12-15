<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
    <div>
        <form method="post">
            <p><input type="text" name="username" placeholder="이름" required></p>
            <p><input type="text" name="userid" placeholder="아이디" required></p>
            <p><input type="text" name="userpw" placeholder="비밀번호" required></p>
            <p><input type="text" name="pnum" placeholder="전화번호" required></p>
            <p><input type="text" name="address" placeholder="주소" required></p>

            <p><input type="submit" value="회원가입"></p>
        </form>
    </div>


</body>
</html>

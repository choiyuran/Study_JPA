<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>

<br>
<div class="write">
    <form method="post">
        <p><input type="text" name="title" value="${dto.title}"></p>
        <p><textarea name="content" cols="150" rows="20">${dto.content}</textarea></p>

        <p><button class="btn btn-warning">수정하기</button></p>
    </form>
</div>
</body>
</html>

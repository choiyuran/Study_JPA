<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>

<br>
<div class="write">
    <form method="post">
        <p><input type="text" name="title" placeholder="제목"></p>
        <p><textarea name="content" cols="150" rows="20"></textarea></p>
        <p><input type="hidden" name="memberId" value="${login.id}"></p>
        <p><input type="submit" value="작성"></p>
    </form>
</div>
</body>
</html>

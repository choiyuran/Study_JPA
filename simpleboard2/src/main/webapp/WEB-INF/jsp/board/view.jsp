<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">${board.title}</h4>
            <p class="card-text">${board.content}</p>
            <p>${board.wdate}</p>
            <p>${board.member.userid}</p>
        </div>

        <div>
            <c:if test="${login.id eq board.member.id}">
                <a href="${cpath}/board/update/${board.id}"><button class="btn btn-warning">수정하기</button></a>
                <a href="${cpath}/board/delete/${board.id}"><button class="btn btn-danger">삭제하기</button></a>
            </c:if>
            <a href="${cpath}/board/list"><button class="btn btn-secondary">목록으로</button></a>
        </div>
    </div>
</div>

</body>
</html>

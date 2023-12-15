<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
    <br>
    <h2>글 목록</h2><br>
    <table class="table">
        <thead>
        <tr class="table-primary">
            <th>글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>상세</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="row" items="${list}">
            <tr class="table-info">
                <td>${row.id}</td>
                <td>${row.title}</td>
                <td>${row.writer.userid}</td>
                <td>${row.wdate}</td>
                <td><a href="${cpath}/board/view/${row.id}">상세보기</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

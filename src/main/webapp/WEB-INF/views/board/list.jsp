<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .board-box {
            border: 1px solid black;
            padding: 10px;
        }
    </style>
</head>
<body>
<h1>글목록 화면</h1>
<hr/>
<div class="board-box">
    <c:forEach items="${boardList}" var="board">
        <div class="board-box">글쓴이 : ${board.user.username} 글 제목 : ${board.title}</div>
    </c:forEach>
</div>
</body>
</html>
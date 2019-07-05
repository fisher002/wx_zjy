<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 加入JSTL的标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借阅列表</title>
<link href="/zjy/library/css/main.css" rel="stylesheet"/>
</head>
<body>
<a href="/zjy/library" class="return_book">返回图书列表</a>
	<c:forEach items="${debitList.books }" var="book">
		<div class="book">
			<div class="col-1">
				<img class="image" src="/zjy/library/images/${book.image }" />
			</div>
			<span class="col-10 name">${book.name }</span>
			<span class="col-2">
			<a href="/zjy/library/debit/remove/${book.id }" class="remove">删除</a>
			<a href="/zjy/library/confirm/conbook?id=${book.id }" class="remove">确认借阅</a>
			</span>
		</div>
	</c:forEach>
</body>
</html>
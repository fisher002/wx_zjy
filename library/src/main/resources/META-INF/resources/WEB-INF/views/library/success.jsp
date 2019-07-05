<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 加入JSTL的标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借阅成功</title>
<link href="/zjy/library/css/main.css" rel="stylesheet"/>
</head>
<body>
<a href="/zjy/library" class="return_book">返回图书列表</a>
	<c:forEach items="${conBook }" var="book">
		<div class="book">
			<div class="col-1">
				<img class="image" src="/zjy/library/images/${book.b_img }" />
			</div>
			<span class="col-10 name">${book.b_name }</span>
			<span class="col-2">
			<a href="#" class="remove">删除</a>
			</span>
		</div>
	</c:forEach>
</body>
</html>
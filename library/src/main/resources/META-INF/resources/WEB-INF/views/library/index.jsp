<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- 引入JSTL里面的core标签库，它里面包含了forEach、if、choose等标签，代替JSP的脚本和表达式。 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书</title>
<link href="/zjy/library/css/main.css" rel="stylesheet" />
</head>
<body>
<form action="" method="get">
<input type="text" name="keyword" value="${param.keyword }" placeholder="请输入搜索关键字"/><button>搜索</button><br>
	<%-- 使用JSTL的forEach标签实现循环输出 --%>
	<%-- items可以处理任意数组、集合，甚至Map --%>
	<%-- ${page.content }是EL表达式，也是JSP里面非常常用的一种语法。 --%>
	<c:forEach items="${page.content }" var="book">
		<div class="book">
			<div class="col-1">
				<img class="image" src="/zjy/library/images/${book.image }" />
			</div>
			<span class="col-10 name">${book.name }</span>
			<span class="col-1" style="text-align: right;">
				<a href="/zjy/library/debit?id=${book.id }" class="button">+</a>
			</span>
		</div>
	</c:forEach>

	<%-- 分页按钮 --%>
	<div>
		<c:if test="${page.number > 0 }">
			<a href="?pageNumber=${page.number -1 }&keyword=${param.keyword}">上一页</a>
		</c:if>
		<c:if test="${page.number <= 0 }">
			<a>上一页</a>
		</c:if>
		<c:choose>
			<%-- 为什么要减一？因为页码从0开始，但是totalPages是总页数，从1开始。 --%>
			<c:when test="${page.number >= page.totalPages - 1 }">
				<a>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="?pageNumber=${page.number + 1 }&keyword=${param.keyword}">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
</form>
</body>
</html>
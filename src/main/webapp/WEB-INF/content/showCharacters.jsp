<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	th{font-weight:bold;background:#ccc;}
</style>
</head>
<body>
<br>
<form action="saveCharacters" method = "post">
      <input type = "text" name = "url"  style="width:200px;height:20px;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type = "submit" value = "添加"  style="height:20px;">
  </form>
<br>
<table border="1">
	<tr>
		<th>标题</th><th>字数</th><th>中文字数</th><th>英文字数</th><th>标点符号数</th>
	</tr>
	<c:forEach items="${requestScope.characters_list }" var="characters">
		<tr>
			<td>${characters.title }</td>
			<td>${characters.characters }</td>
			<td>${characters.chinese }</td>
			<td>${characters.letters }</td>
			<td>${characters.punctuation }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
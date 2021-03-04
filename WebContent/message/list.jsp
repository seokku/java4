<%@page import="com.webjjang.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



String url = request.getServletPath();
@SuppressWarnings("unchecked")
List<MessageVO> list = (List<MessageVO>) ExeService.execute(Beans.get(url), id);

request.setAttribute("list", list);

%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 리스트</title>
</head>
<body>
<div class="container">
<h1>메시지 리스트</h1>
<table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>보낸이</th>
			<th>보낸날짜</th>
			<th>받는이</th>
			<th>받은날짜</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 시작 부분 -->
		<c:forEach items="${list }" var="vo">
		<tr class="dataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.content }</td>
			<td>${vo.sender }</td>
			<td>${vo.sendDate }</td>
			<td>${vo.accepter }</td>
			<td>${vo.acceptDate }</td>
		</tr>
		</c:forEach>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 끝 부분 -->
	</tbody>
</table>
</div>
</body>
</html>
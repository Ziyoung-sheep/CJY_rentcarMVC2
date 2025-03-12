<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<form action="${ctx}/userDelete.do" method="post">
	<h1> 정말 탈퇴하시겠습니까? </h1>
	<table>
	<tr>
	<td>탈퇴하시려면 PASSWORD를 한 번 더 입력해주세요</td>
	</tr>
	<tr>
	<td><input type="password" name="pw" id="pw" placeholder="PASSWORD를 입력해주세요"></td>
	</tr>
	<tr>
	<td><button class="btn-quit">QUIT</button> </td>
	</tr>
	</table>

<%@ include file="../../part/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 로그인 </h1>
	<form action="${ctx}/login.do" method="post">
	<table>
	<tr>
	<td>ID</td>
	<td><input type="text" name="id" id="id" placeholder="ID를 입력해주세요" value=""></td>
	</tr>
	<tr>
	<td>PASSWORD</td>
	<td><input type="password" name="pw" id="pw" placeholder="PASSWORD를 입력해주세요"></td>
	</tr>
	<tr>
	<td colspan="2"><button class="btn-submit">LOGIN</button> </td>
	</tr>
	</table>
	</form>

<%@ include file="../../part/footer.jsp" %>
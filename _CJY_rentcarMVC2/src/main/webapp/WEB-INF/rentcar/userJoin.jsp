<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 회원가입 </h1>
	
	<form action="${ctx}/userJoin.do" method="post">
	<table>
	<tr>
	<td>ID</td>
	<td><input type="text" name="id" id="id" required></td>
	<td><button class="btn-idCheck" name="btn-idCheck" id="btn-idCheck">아이디 중복검사</button></td>
	</tr>
	<tr>
	<td>PASSWORD</td>
	<td colspan="2"><input type="password" name="pw" id="pw" required></td>
	</tr>
	<tr>
	<td>이름</td>
	<td colspan="2"><input type="text" name="name" id="name" required></td>
	</tr>
	<tr>
	<td>email</td>
	<td colspan="2"><input type="text" name="email" id="email" required></td>
	</tr>
	<tr>
	<td>phone</td>
	<td colspan="2"><input type="text" name="phone" id="phone" required></td>
	</tr>
	<tr>
	<td colspan="3"><button class="btn-submit" name="btn-submit" id="btn-submit">회원가입</button></td>
	</tr>
	</table>
	</form>

<script src="${ctx}/js/insert.js"> </script>
<%@ include file="../../part/footer.jsp" %>
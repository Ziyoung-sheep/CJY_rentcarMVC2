<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 고객센터 글쓰기 </h1>
	
	<form action="${ctx}/customerServiceWriting.do">
	<table>
	<tr>
	<td>제목</td>
	<td><input type="text" name="title" id="title" required/></td>
	</tr>
	<tr>
	<td colspan="2"> 본문 </td>
	</tr>
	<tr>
	<td colspan="2"> <input type="textarea" name="main" id="main" required/> </td>
	</tr>
	<tr>
	<td colspan="2"> <button name="submit" id="submit">작성완료</button> </td>
	</tr>
	</table>
	</form>

<%@ include file="../../part/footer.jsp" %>
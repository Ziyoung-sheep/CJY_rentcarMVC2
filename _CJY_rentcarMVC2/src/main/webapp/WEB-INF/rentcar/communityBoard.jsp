<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 자유게시판 </h1>
	
	<div class="searchBox">
	<form action="${ctx}/communityBoard.do">
	<input type="text" name="boardSearch" id="boardSearch">
	<button>search</button>
	</form>
	</div>
	
	<div class="communityBoardList">
	<table>
	<c:forEach var="cb" items="${list}">
	<tr>
	<td>
	<a href="${ctx}/communityBoardReading.do?num=${cb.num_commuboard}">
	${cb.title}
	</a>
	<td>${cb.userid}</td>
	<c:if test="${log==1}">
	<td><button name="del" id="del" onclick="location.href='${ctx}/communityBoardDelete.do?num=${cb.num_commuboard}'"> 삭제 </button></td>
	</c:if>
	<td>
	</tr>
	</c:forEach>
	<c:if test="${log ne null && log ne 1}">
	<td><button name='commuSubmit' id='commuSubmit' onclick="location.href='${ctx}/communityBoardWriting.do'">글쓰기</button> </td>
	</c:if>
	</table>
	</div>
	

<%@ include file="../../part/footer.jsp" %>
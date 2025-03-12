<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 자유게시판 읽기 </h1>
	<c:if test="${CBreading==null}">
  	<p> 해당 글은 존재하지 않습니다 </p>
	</c:if>
	<c:if test="${CBreading ne null}">
	<table>
	<tr>
	<td colspan="3">${CBreading.title}</td>
	</tr>
	<c:if test="${not empty CBreading.img}">
		<tr>
		<td colspan="3"><img class="boardImg" src="${ctx}/img/${CBreading.img}" alt="boardImg"></td>
		</tr>
	</c:if>
	<tr>
	<td colspan="3">${CBreading.main}</td>
	</tr>
	<tr>
	<c:choose>
	<c:when test="${CBreading.userid==loginId||log==1}"> <!-- 관리인이거나 내 게시물일때 : 목록버튼과 수정, 삭제 버튼이 존재 -->
	<td><button name="list" id="list" onclick="location.href='${ctx}/communityBoard.do'"> 목록 </button></td>
	<td><button name="update" id="update" onclick="location.href='${ctx}/communityBoardUpdate.do?num=${CBreading.num_commuboard}'"> 수정 </button></td>
	<td><button name="del" id="del" onclick="location.href='${ctx}/communityBoardDelete.do?num=${CBreading.num_commuboard}'"> 삭제 </button></td>
	</c:when>
	<c:otherwise> 
	<td colspan="3"><button name="list" id="list" onclick="location.href='${ctx}/communityBoard.do'"> 목록 </button></td>
	</c:otherwise>
	</c:choose>
	</tr>
	</table>
	</c:if>

<%@ include file="../../part/footer.jsp" %>
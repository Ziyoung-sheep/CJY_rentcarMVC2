<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 문의글 답변 달기 </h1>
	<c:if test="${CS==null}">
  	<p> 해당 글은 존재하지 않습니다 </p>
	</c:if>
	<c:if test="${CS ne null}">
	<form action="${ctx}/admin_CSanswer.do?num=${CS.num_qna}" method="post">
	<table>
  <tr>
    <td> ${CS.title} </td>
  </tr>
  <tr>
    <td>${CS.main}</td>
  </tr>
  <tr>
    <td>답변글</td>
  </tr>
  <tr>
    <td><input type="textarea" name="cs_answerText" id="cs_answerText"></td>
  </tr>
  <tr>
  <td><button name="submit_btn" id="submit_btn">등록</button> </td>
  </tr>
  </form>
</c:if>
</table>


<%@ include file="../../part/footer.jsp" %>
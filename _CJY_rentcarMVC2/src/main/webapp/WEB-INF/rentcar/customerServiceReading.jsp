<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 문의글 읽기 </h1>
		<c:if test="${CSreading==null}">
  	<p> 해당 글은 존재하지 않습니다 </p>
	</c:if>
	<c:if test="${CSreading ne null}">
	<table>
  <tr>
    <td colspan="2"> ${CSreading.title} </td>
  </tr>
  <tr>
    <td colspan="2">${CSreading.main}</td>
  </tr>
  <c:if test="${CSreading.answer} != null">
  <tr>
    <td>상담원: </td>
    <td>{CSreading.answer}</td>
  </tr>
  </c:if>
  <c:if test="${log == 1}">
  <tr>
  <td><button name="csUpdate" id="csUpdate" href="${ctx}/admin_CSanswer.do?num=${CSreading.num_qna}">답변입력</button> </td>
  </tr>
  </c:if>
</table>
  </c:if>


<%@ include file="../../part/footer.jsp" %>
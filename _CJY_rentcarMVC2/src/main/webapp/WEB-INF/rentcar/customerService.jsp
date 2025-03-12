<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 고객센터 </h1>
	
	 <c:if test="${empty list}">
  <p>문의사항이 없습니다</p>
  </c:if>
  <c:if test="${not empty list}">
 <table>
  <c:forEach var="qna" items="${list}">
  <tr>
  <td>
	<a href="${ctx}/customerServiceReading.do?num=${qna.num_qna}">
	${qna.title}
	</a>
  </td>
  <td>
  <c:if test="${not empty qna.answer}">
  답변완료
  </c:if>
  </td>
  </tr>
  </c:forEach>
  <c:if test="${log ne 1}">
  <tr>
	<td colspan="2"><button name='csSubmit' id='csSubmit' onclick="location.href='${ctx}/customerServiceWriting.do'">글쓰기</button> </td>
  </tr>
  </c:if>
</table>
  </c:if>

<%@ include file="../../part/footer.jsp" %>
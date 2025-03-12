<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 예약확인 </h1>
  <c:if test="${empty list}">
  <p>예약 내역이 없습니다</p>
  </c:if>
  <c:if test="${not empty list}">
 <table>
  <tr>
    <td>대여 차종</td>
    <td>대여 수</td>
    <td>대여일</td>
    <td>대여 날짜</td>
    <td>보험적용</td>
    <td>wifi</td>
    <td>네비게이션</td>
    <td>유아시트</td>
    <c:if test="${log == 1}">
	<td>회원아이디</td>
	</c:if>
	<td>삭제</td>
  </tr>
  <c:forEach var="res" items="${list}">
  <tr>
  <td>
	${res.num}
  </td>
  <td>
	${res.qty}
  </td>
  <td>
	${res.dday}
  </td>
  <td>
	${res.rday}
  </td>
  <td>
    <c:if test="${res.usein == 1}">
  	적용
  	</c:if>
  	<c:if test="${res.usein != 1}">
  	미적용
  	</c:if>
  </td>
  <td>
      <c:if test="${res.usewifi == 1}">
  	적용
  	</c:if>
  	<c:if test="${res.usewifi != 1}">
  	미적용
  	</c:if>
  </td>
  <td>
      <c:if test="${res.usenavi == 1}">
  	적용
  	</c:if>
  	<c:if test="${res.usenavi != 1}">
  	미적용
  	</c:if>
  </td>
  <td>
      <c:if test="${res.useseat == 1}">
  	적용
  	</c:if>
  	<c:if test="${res.useseat != 1}">
  	미적용
  	</c:if>
  </td>
  <c:if test="${log == 1}">
  <td>${res.userid}</td>
  </c:if>
  <td>
  <button name="btn-delete" id="btn-delete" onclick="location.href='${ctx}/myReservationDelete.do?num=${res.reserve_seq}'"> 삭제 </button>
  </td>
  </tr>
  </c:forEach>
</table>
  </c:if>
<%@ include file="../../part/footer.jsp" %>
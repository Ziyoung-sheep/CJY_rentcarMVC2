<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>
<table>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>아이디</th>
    <th>이메일</th>
    <th>번호</th>
    <th>삭제</th>
  </tr>
  <c:forEach var="user" items="${list}">
  <tr>
    <th>${user.num}</th>
    <th>${user.name}</th>
    <th>${user.userid}</th>
    <th>${user.email}</th>
    <th>${user.phone}</th>
    <th>
    <c:choose>
    <c:when test="${user.num==1}">
    삭제불가
    </c:when>
    <c:otherwise>
    <button name="btn-delete" id="btn-delete" onclick="location.href='${ctx}/admin_userDelete.do?id=${user.userid}'"> 삭제 </button>
    </c:otherwise>
    </c:choose>
    </th>
  </tr>
  </c:forEach>
</table>
<%@ include file="../../part/footer.jsp" %>
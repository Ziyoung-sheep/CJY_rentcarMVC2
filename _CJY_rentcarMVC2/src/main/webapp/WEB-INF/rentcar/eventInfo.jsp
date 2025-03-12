<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>
<table>
  <tr>
    <th><h1> ${nowEvent.title} </h1></th>
  </tr>
  <tr>
    <td>${nowEvent.start_date} ~ ${nowEvent.end_date}</td>
  </tr>
  <tr>
    <td><img class="event" src="${ctx}/img/${nowEvent.event_img}" alt="event"></td>
  </tr>
  <c:if test="${not empty log&&log==1}">
  <tr>
     <th><button name="submit" id="submit" onclick="location.href='${ctx}/admin_eventInsert.do'">새 이벤트 등록</button></th>
  </tr>
  </c:if>
</table>
<%@ include file="../../part/footer.jsp" %>
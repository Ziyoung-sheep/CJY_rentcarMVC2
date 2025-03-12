<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>
<form action="${ctx}/admin_eventInsert.do" method="post" enctype="multipart/form-data">
<table>
  <tr>
    <td>이벤트 명</td>
    <td><input type="text" name="eventTitle" id="eventTitle" required></td>
  </tr>
  <tr>
    <td>시작 날짜</td>
    <td><input type="date" name="eventStartDay" id="eventStartDay" required/></td><!-- 형식지정 -->
  </tr>
  <tr>
    <td>종료 날짜</td>
    <td><input type="date" name="eventEndDay" id="eventEndDay" required></td><!-- 형식지정 -->
  </tr>
  <tr>
    <td>이벤트 페이지</td>
    <td><input type="file" name="uploadFile" accept="image/*" required></td><!-- 형식지정 -->
  </tr>
  <tr>
    <td colspan="2"><button name="submit" id="submit">등록</button></td>
  </tr>
</table>
</form>
<%@ include file="../../part/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>
<%-- <form action="${ctx}/admin_rentCarInsert.do" method="post" enctype="multipart/form-data"> --%>
<table>
<tr>
<td colspan="9"><button name="newCar_btn" id="newCar_btn" onclick="location.href='${ctx}/admin_rentCarInsert.do'" >차량등록</button> </td>
</tr>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>종류</th>
    <th>가격</th>
    <th>승차인원</th>
    <th>보유수량</th>
    <th>회사</th>
    <th>이미지</th>
    <th>정보</th>
    <th>삭제</th>
  </tr>
  <c:forEach var="car" items="${list}">
  <tr>
    <td>${car.num}</td>
    <td>${car.name}</td>
    <td>${car.category}</td>
    <td>${car.price}</td>
    <td>${car.usepeople}</td>
    <td>${car.total_qty}</td>
    <td>${car.company}</td>
    <td><img class="adminCarImg" src="${ctx}/img/${car.img}" alt="car${car.num}"></td>
    <td>${car.info}</td>
    <th>
    <button name="btn-delete" id="btn-delete" onclick="location.href='${ctx}/admin_rentCarDelete.do?num=${car.num}'"> 삭제 </button>
    </th>
  </tr>
  </c:forEach>
</table>
<!-- </form> -->
<%@ include file="../../part/footer.jsp" %>
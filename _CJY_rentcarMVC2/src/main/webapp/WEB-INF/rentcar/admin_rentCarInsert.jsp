<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>
	<form action="${ctx}/admin_rentCarInsert.do" method="post" enctype="multipart/form-data">
<table>
  <tr>
    <th>차량이름</th>
    <td><input type="text" name="carName" id="carName" required/></td>
  </tr>
  <tr>
    <th>차량 종류</th>
    <td>
    <select name="carCategory" id="carCategory" required>
		<option value="1">소형</option>
		<option value="2">중형</option>
		<option value="3">대형</option>
	</select></td>
  </tr>
  <tr>
    <th>가격</th>
    <td><input type="number" name="carPrice" id="carPrice" required/>원</td>
  </tr>
  <tr>
    <th>승차인원</th>
    <td><input type="number" name="carUsePeople" id="carUsePeople" required/></td>
  </tr>
  <tr>
    <th>총 수량</th>
    <td><input type="number" name="carTotalQty" id="carTotalQty" required/></td>
  </tr>
  <tr>
    <th>회사</th>
    <td>
    <select name="carCompany" id="carCompany" required>
		<option value="기아">기아</option>
		<option value="현대">현대</option>
		<option value="BMW">BMW</option>
	</select>
	</td>
  </tr>
  <tr>
    <th>이미지</th>
    <td><input type="file" name="uploadFile" accept="image/*"></td>
  </tr>
  <tr>
    <th>차량 정보</th>
    <td><input type="text" name="carInfo" id="carInfo" required/></td>
  </tr>
    <tr>
    <td colspan="2"><button name="submit" id="submit">등록</button></td>
  </tr>
</table>
</form>
<%@ include file="../../part/footer.jsp" %>
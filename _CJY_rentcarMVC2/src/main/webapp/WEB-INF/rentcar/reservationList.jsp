<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 예약 </h1>
	<form action="${ctx}/reservationList.do" method="post">
	<div class="searchBox">
	<select name="category">
		<option value="">전체</option>
		<option value="1">소형</option>
		<option value="2">중형</option>
		<option value="3">대형</option>
	</select>
	<select name="company">
		<option value="">전체</option>
		<option value="기아">기아</option>
		<option value="현대">현대</option>
		<option value="BMW">BMW</option>
	</select>
<!-- 	<button name="priceDown-btn" id="priceDown-btn">가격 내림차순</button>
	<button name="priceUp-btn" id="priceUp-btn">가격 오름차순</button> -->
	<%-- <button name="search-btn" id="search-btn" onclick="location.href='${ctx}/reservationList.do'">검색</button> --%>
	<button name="search-btn" id="search-btn">검색</button>
	</form>
	
	<!-- 위의 값에서 가져온 것으로 리스트를 만들 수 있을...까? -->
	</div>
	<div class="carList">
	<table>
	<c:forEach var="car" items="${list}">
	<tr>
	<td>
	<a href="${ctx}/rentCarContent.do?num=${car.num}">
	<img class="carImg" src="${ctx}/img/${car.img}" alt="car">
	</a>
	<td>
	<a href="${ctx}/rentCarContent.do?num=${car.num}">
	${car.name}
	</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	</div>

<%@ include file="../../part/footer.jsp" %>
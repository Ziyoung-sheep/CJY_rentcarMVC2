<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

	<h1> 차랑 상세보기 </h1>
	<div class="rentCatContent">
		<div class="rentCarImg">
			<img src="${ctx}/img/${rentCar.img}"/>
		</div>
		<div class="carContent">

			<table>
				<tr>
					<td>차량 번호 : ${rentCar.num}</td>
				</tr>
				<tr>
					<td>차량 이름 : ${rentCar.name}</td>
				</tr>
				<tr>
					<td>
					<c:choose>
					<c:when test="${rentCar.category == 1}">소형</c:when>
					<c:when test="${rentCar.category == 2}">중형</c:when>
					<c:otherwise>대형</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<td>1 일 대여 ${rentCar.price}원</td>
				</tr>
				<tr>
					<td>${rentCar.usepeople}인승</td>
				</tr>
				<tr>
					<td>${rentCar.company}</td>
				</tr>
				<tr>
					<td>${rentCar.info}</td>
				</tr>
			</table>
			<c:choose>
			<c:when test="${log == null}"><p>예약은 <a href="${ctx}/userJoin.do">회원가입</a> 또는 <a href="${ctx}/login.do">로그인</a> 후 진행해주세요</p></c:when>
			<c:otherwise>
			<form action="${ctx}/reservation.do?carNum=${rentCar.num}" method="post">
			<div class="submit">
			<button type="submit" class="btn-submit">예약하기</button>
			</div>
			</form>
			</c:otherwise>
			</c:choose>
		</div>
	</div>

<%@ include file="../../part/footer.jsp" %>
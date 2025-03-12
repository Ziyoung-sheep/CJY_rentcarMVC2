<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고양이 빌려드립니다</title>
<script src="
https://cdn.jsdelivr.net/npm/sweetalert2@11.17.2/dist/sweetalert2.all.min.js
"></script>
<link href="
https://cdn.jsdelivr.net/npm/sweetalert2@11.17.2/dist/sweetalert2.min.css
" rel="stylesheet">


<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
</head>
<body>

	<header>
		<div class="inner">
			<div class="log"> <!-- 로고 이미지, 로그인 로그아웃 버튼 -->
			
			<a href="${ctx}/index.jsp">
			<img class="logo" src="https://i.namu.wiki/i/d1A_wD4kuLHmOOFqJdVlOXVt1TWA9NfNt_HA0CS0Y_N0zayUAX8olMuv7odG2FiDLDQZIRBqbPQwBSArXfEJlQ.webp" alt="LOGO">
			</a>
				<c:if test="${log eq null}"> <!-- 로그인 아닐 때 -->
				<p> GUEST님 </p>
                <a href="${ctx}/login.do">로그인</a>
                <a href="${ctx}/userJoin.do">회원가입</a>
				</c:if>
				<c:if test="${log ne null && log ne 1}"> <!-- 로그인 중일때 -->
				<!-- 나중에 관리자 추가 -->
				<p> ${loginId}님 </p>
                <a href="${ctx}/logout.do">로그아웃</a>
                <a href="${ctx}/userDelete.do">회원탈퇴</a>
				</c:if>
				<c:if test="${log eq 1}"> <!-- 관리자 중일때 -->
				<!-- 나중에 관리자 추가 -->
				<p> 관리자님 </p>
                <a href="${ctx}/logout.do">로그아웃</a>
				</c:if>
			</div>
			<div class="gnb">
				<c:if test="${log ne 1}"> 
				<a href="${ctx}/reservationList.do">예약하기</a>
				<a href="${ctx}/myReservation.do">예약확인</a>
				</c:if>
				<c:if test="${log eq 1}"> 
				<a href="${ctx}/admin_user.do">회원관리</a>
				<a href="${ctx}/myReservation.do">예약관리</a>
				<a href="${ctx}/admin_rentCarList.do">차량관리</a>
				</c:if>
				<a href="${ctx}/communityBoard.do">자유게시판</a>
				<a href="${ctx}/eventInfo.do">EVENT</a>
				<a href="${ctx}/customerService.do">고객센터</a>
			</div>
		</div>
		<hr>
	</header>
	<main>
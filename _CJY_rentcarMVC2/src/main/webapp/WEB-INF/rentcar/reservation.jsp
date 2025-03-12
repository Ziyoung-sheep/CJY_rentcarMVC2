<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../part/header.jsp" %>

    <h1> ${thisCar.name} 예약 페이지 </h1>
    <form action="${ctx}/reservation.do" method="post">
    <input type="hidden" name="carNum" value="${param.carNum}">
    <table>
    <tr>
    <td colspan="2"> 예약일 </td>
    </tr>
    <tr>
    <td colspan="2">
    <input type="date" name="startDay" id="startDay" required/>
    </td>
    </tr>
    <tr>
    <td>총 대여일수</td>
    <td><input type="number" name="rentDay" id="rentDay" required>일</td>
    </tr>
    <tr>
    <td>총 대 수</td>
    <td><input type="number" name="qty" id="qty" min="1" max="${thisCar.total_qty}" required>대</td>
    </tr>
    <tr>
    <td>옵션</td>
    <td>
    <input type="checkbox" name="opt-in" id="opt-in" />보험적용
    <input type="checkbox" name="opt-navi" id="opt-navi"/>네비게이션
    <input type="checkbox" name="opt-wifi" id="opt-wifi"/>와이파이
    <input type="checkbox" name="opt-seat" id="opt-seat"/>유아시트
    </td>
    </tr>
    <tr>
    <td colspan="2"><button name="submit_btn" id="submit_btn">예약하기</button></td>
    </tr>
    </table>
    </form>

<script src="${ctx}/js/rentCarReservation.js"> </script>
<%@ include file="../../part/footer.jsp" %>
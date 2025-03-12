package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.ReservationDAO;
import kr.basic.model.ReservationVO;

public class MyReservationDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("예약 삭제 컨트롤러 진입");
		//리스트 불러오기
		//리스트가 없으면 예약이 없습니다 출력하기
//		HttpSession session = request.getSession();
		String ctx=request.getContextPath();
		
		int num=Integer.parseInt(request.getParameter("num"));
		Boolean pass= ReservationDAO.getInstance().reservationDelete(num);
		if (pass) {
			System.out.println("예약 삭제 성공");
		}else {
			System.out.println("예약 삭제 실패");
		}
		return "redirect:" + ctx + "/myReservation.do";
	}
}

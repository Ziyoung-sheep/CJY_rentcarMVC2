package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.ReservationDAO;
import kr.basic.model.ReservationVO;

public class MyReservationController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("예약확인 컨트롤러 진입");
		//리스트 불러오기
		//리스트가 없으면 예약이 없습니다 출력하기
		HttpSession session = request.getSession();
		String ctx=request.getContextPath();
		
		if (session.getAttribute("log") == null) { 
			System.out.println("로그인상태 아님");
			return "redirect:" + ctx + "/login.do";
		} else {
			int num = (int) session.getAttribute("log");
			ArrayList<ReservationVO> list=null;
			if (num==1) { //어드민모드: 모든 예약을 리스트로 만들기
				list = ReservationDAO.getInstance().makeMyReservationList();
			}else {
				//num 넣어서 아이디 뽑아내기
				String id=(String) session.getAttribute("loginId");
				//아이디로 리스트 만들기
				list = ReservationDAO.getInstance().makeMyReservationList(id);
			}
			
			if(list.size()==0) {
				System.out.println("예약이 없습니다.");
			}else {
				System.out.println("예약이 있습니다.");
				request.setAttribute("list", list);
			}
		}
		return "myReservation";
	}
}

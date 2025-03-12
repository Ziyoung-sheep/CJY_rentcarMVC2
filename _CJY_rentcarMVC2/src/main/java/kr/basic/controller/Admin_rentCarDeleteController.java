package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.RentCarDAO;
import kr.basic.model.ReservationDAO;

public class Admin_rentCarDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" 관리자 랜트카 삭제 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		int num=Integer.parseInt(request.getParameter("num"));
		Boolean pass= RentCarDAO.getInstance().deleteRentCar(num);
		if (pass) {
			System.out.println("랜트카 삭제 성공");
		}else {
			System.out.println("랜트카 삭제 실패");
		}
		return "redirect:" + ctx + "/admin_rentCarList.do";
	}

}

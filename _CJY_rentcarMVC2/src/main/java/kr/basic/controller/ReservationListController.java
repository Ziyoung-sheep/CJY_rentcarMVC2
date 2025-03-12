package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.frontcontroller.RentCarFrontController;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;

public class ReservationListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("예약하기 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		
		//값이 놀이 아니면 입력하기
		String preCategory=request.getParameter("category");
		System.out.println(preCategory);
		String company=request.getParameter("company");
		System.out.println(company);
		
		if (preCategory!=null&&preCategory.equals("")) {
			preCategory=null;
			System.out.println("프리카테고리 null만듬"+preCategory);
		}
		if (company!=null&&company.equals("")) {
			company=null;
			System.out.println("컴퍼니 null만듬"+company);
		}
		
		
		ArrayList<RentCarVO>list=null;
		if(preCategory==null&&company==null) {
			list=RentCarDAO.getInstance().makeRentCarList();
		}else if(preCategory==null&&company!=null) {
			list=RentCarDAO.getInstance().makeRentCarList(company);
		}else if(preCategory!=null&&company==null){
			Integer category=Integer.parseInt(preCategory);
			list=RentCarDAO.getInstance().makeRentCarList(category);
		}else {
			Integer category=Integer.parseInt(preCategory);
			list=RentCarDAO.getInstance().makeRentCarList(category,company);
		}
		request.setAttribute("list", list);
		
		return "reservationList";
	}

}

package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;
import kr.basic.model.UserDAO;
import kr.basic.model.UserVO;

public class Admin_rentCarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("관리자 랜트카 리스트 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		ArrayList<RentCarVO>list=RentCarDAO.getInstance().makeRentCarList();
		request.setAttribute("list", list);
		return "admin_rentCarList";
	}

}

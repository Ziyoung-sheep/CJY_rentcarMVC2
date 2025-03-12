package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;
import kr.basic.model.ReservationDAO;
import kr.basic.model.UserDAO;

public class Admin_userDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" 관리자 유저 삭제 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		String id=request.getParameter("id");
		Boolean pass= UserDAO.getInstance().deleteUser(id);
		if (pass) {
			System.out.println("유저 삭제 성공");
		}else {
			System.out.println("유저 삭제 실패");
		}
		return "redirect:" + ctx + "/admin_user.do";
	}

}

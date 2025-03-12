package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;
import kr.basic.model.UserDAO;
import kr.basic.model.UserVO;

public class Admin_userController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" 관리자 유저 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		ArrayList<UserVO>list=UserDAO.getInstance().makeUserList();
		request.setAttribute("list", list);
		return "admin_userList";
	}

}

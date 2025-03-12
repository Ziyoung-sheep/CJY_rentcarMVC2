package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.UserDAO;

public class UserJoinController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("회원가입 컨트롤러 진입");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pw");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		if(id==null) {
			return "userJoin";
		}
		
		String ctx=request.getContextPath();
//		if(UserDAO.getInstance().checkId(id)) {
//		}else {
//			System.out.println("중복아이디");
//			return "userJoin";
//		}
		UserDAO.getInstance().newUserJoin(id, pwd, name, email, phone);
		return "redirect:" + ctx + "/index.jsp";
	}
}

package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그아웃 컨트롤러 진입");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String ctx=request.getContextPath();
		return "redirect:" + ctx + "/index.jsp";
//		response.sendRedirect(ctx + "/index.jsp");
//		return null;
	}

}

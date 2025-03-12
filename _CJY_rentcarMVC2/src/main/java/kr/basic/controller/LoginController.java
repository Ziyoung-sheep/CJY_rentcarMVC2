package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.UserDAO;

public class LoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("로그인 컨트롤러 진입");
		
		String id = request.getParameter("id");
		if (request.getParameter("id") == null) {
			return "login";
		}
		//주소 가져오기
		String ctx=request.getContextPath();
		String pw = request.getParameter("pw");
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		Integer log= UserDAO.getInstance().checkLogin(id, pw);
		
		System.out.println("log="+log);
		if (log==0) { //로그인 실패
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter writer = response.getWriter();
//			writer.println("<script>alert('로그인 실패'); history.back(); </script>");
		//	writer.println("<script>swal.fire('로그인 실패');</script>");
//			writer.close();
			System.out.println("로그인 실패");
			return "login";
		}else { //로그인 성공
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("log", log);
			session.setAttribute("loginId", id);
			session.setAttribute("loginPw", pw);
			return "redirect:" + ctx + "/index.jsp";
		}

		
	}

}

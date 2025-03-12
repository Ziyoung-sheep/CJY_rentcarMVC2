package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.UserDAO;

public class UserDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("삭제 컨트롤러 진입");
		
		String pw = request.getParameter("pw");
		if (request.getParameter("pw") == null) {
			return "quit";
		}
		System.out.println("pw="+pw);
		//주소 가져오기
		String ctx=request.getContextPath();
		HttpSession session = request.getSession();
		
		if (pw.equals(session.getAttribute("loginPw"))) {
			System.out.println(session.getAttribute("loginId"));
			System.out.println(session.getAttribute("loginPw"));
			Boolean pass=UserDAO.getInstance().deleteUser((String)session.getAttribute("loginId"));
			//삭제 완료
			if (pass) {
				System.out.println("삭제 성공");
				//유저 로그아웃
				return "redirect:" + ctx + "/logout.do";
			}else {
				System.out.println("삭제 실패");
				return "redirect:" + ctx + "/index.jsp";
			}
		}else {
			System.out.println("삭제 실패, 비밀번호 틀림");
			return "redirect:" + ctx + "/index.jsp";
		}
	}
}

package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.CustomerServiceDAO;

public class CustomerServiceDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("고객센터 컨트롤러 진입");
		
		return null;
		/*
		 * String title=request.getParameter("title"); String
		 * main=request.getParameter("main");
		 * 
		 * if(title==null||main==null) { System.out.println("본문 또는 메인 안채워짐"); return
		 * "customerSurviceWrite"; }
		 * 
		 * String ctx=request.getContextPath();
		 * 
		 * HttpSession session = request.getSession(); String
		 * loginId=(String)session.getAttribute("loginId");
		 * 
		 * int pass=CustomerServiceDAO.getInstance().insertNewCS(loginId, title, main);
		 * if (pass==1) { System.out.println("게시글 등록 성공"); return "redirect:" + ctx +
		 * "/customerSurvice.do"; }else { System.out.println("게시글 등록 실패"); return
		 * "customerSurviceWrite"; }
		 */
		
		
	}

}

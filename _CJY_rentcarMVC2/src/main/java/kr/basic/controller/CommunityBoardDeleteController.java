package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;

public class CommunityBoardDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("자유게시판 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		int num=Integer.parseInt(request.getParameter("num"));
		Boolean pass= CommunityBoardDAO.getInstance().communityBoardDelete(num);
		System.out.println("pass="+pass);
		if (pass) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 실패");
		}
		return "redirect:" + ctx + "/communityBoard.do";
	}

}

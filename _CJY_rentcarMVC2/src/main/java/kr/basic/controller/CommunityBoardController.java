package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;

public class CommunityBoardController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("자유게시판 컨트롤러 진입");
		
		String ctx=request.getContextPath();
			ArrayList<CommunityBoardVO>list=CommunityBoardDAO.getInstance().makeCommunityBoardList();

		request.setAttribute("list", list);
		
		return "communityBoard";
	}

}

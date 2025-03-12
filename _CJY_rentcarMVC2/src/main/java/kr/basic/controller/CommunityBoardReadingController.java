package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;

public class CommunityBoardReadingController implements Controller{

	

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("자유게시판 컨트롤러 진입");
		
	    String ctx=request.getContextPath();
	  int num =-1;
	  if(request.getParameter("num")==null){
		  return "redirect:"+ctx+"/communityBoard.do";
	  }else{
		  num = Integer.parseInt(request.getParameter("num"));
	  }
	  CommunityBoardVO vo=CommunityBoardDAO.getInstance().communityBoardContent(num);
	  request.setAttribute("CBreading", vo);
	  return "communityBoardReading";
	}

}

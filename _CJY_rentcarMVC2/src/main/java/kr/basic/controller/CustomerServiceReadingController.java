package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;
import kr.basic.model.CustomerServiceDAO;
import kr.basic.model.CustomerServiceVO;

public class CustomerServiceReadingController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("고객센터 컨트롤러 진입");
		
	    String ctx=request.getContextPath();
	  int num =-1;
	  System.out.println("num="+num);
	  if(request.getParameter("num")==null){
		  return "redirect:"+ctx+"/customerService.do";
	  }else{
		  System.out.println("num="+num);
		  num = Integer.parseInt(request.getParameter("num"));
	  }
	  CustomerServiceVO vo=CustomerServiceDAO.getInstance().customerServiceContent(num);
	  System.out.println("num="+num);
	  request.setAttribute("CSreading", vo);
	  return "customerServiceReading";
		
	}

}

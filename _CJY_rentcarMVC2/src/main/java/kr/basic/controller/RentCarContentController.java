package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;

public class RentCarContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("렌트카 상세보기 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		int num =-1;
		if(request.getParameter("num")==null){
			return "redirect:"+ctx+"/raservationList.do";
		}else{
			num = Integer.parseInt(request.getParameter("num"));
		}
		RentCarVO vo=RentCarDAO.getInstance().rentCarContent(num);
		request.setAttribute("rentCar", vo);
		return "rentCarContent";
	}
}

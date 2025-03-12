package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.EventDAO;
import kr.basic.model.EventVO;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;

public class EventInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("이벤트 인포 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		
		EventVO nowEvent=EventDAO.getInstance().takeEvent();
		request.setAttribute("nowEvent", nowEvent);
		
		return "eventInfo";
	}

}

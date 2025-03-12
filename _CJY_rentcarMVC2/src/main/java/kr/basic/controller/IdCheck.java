package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.CommunityBoardDAO;
import kr.basic.model.CommunityBoardVO;
import kr.basic.model.UserDAO;

public class IdCheck implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("아이디 검사");
		
		String id=request.getParameter("id"); // { "id" : id  }
		String passData = UserDAO.getInstance().checkId(id)? "valid" : "notValid";
		System.out.println(passData);
		
		response.getWriter().print(passData);
		
		return null;
	}

}

package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.CustomerServiceDAO;
import kr.basic.model.CustomerServiceVO;

public class CustomerServiceController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("고객센터 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		
		HttpSession session = request.getSession();
		if (session.getAttribute("log") == null) { 
			System.out.println("로그인상태 아님");
			return "redirect:" + ctx + "/login.do";
		} else {
			int log=Integer.parseInt((String)session.getAttribute("log"));
			ArrayList<CustomerServiceVO> list=null;
			if (log==1) {
				list = CustomerServiceDAO.getInstance().makeMyCustomerServiceList();
			}else {
				//아이디로 리스트 만들기
				String id=(String) session.getAttribute("loginId");
				list = CustomerServiceDAO.getInstance().makeMyCustomerServiceList(id);
			}
				if(list==null) {
					System.out.println("문의사항이 없습니다.");
				}else {
					System.out.println("문의사항이 있습니다.");
					request.setAttribute("list", list);
				}
		}
		return "customerService";
	}
}

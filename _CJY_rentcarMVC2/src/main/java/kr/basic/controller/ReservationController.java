package kr.basic.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.frontcontroller.RentCarFrontController;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;
import kr.basic.model.ReservationDAO;
import kr.basic.model.UserDAO;

public class ReservationController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("예약 진행 컨트롤러 진입");
		
		HttpSession session = request.getSession();
		if (request.getParameter("carNum")==null) {
			System.out.println("num 오류");
			return "reservation";
		}
		int carNum=Integer.parseInt(request.getParameter("carNum"));
		System.out.println("carNum="+carNum);
		RentCarVO thisCar=RentCarDAO.getInstance().rentCarContent(carNum);
		session.setAttribute("thisCar", thisCar);
		
		String rday = request.getParameter("startDay");
		
		if (rday == null) {
			System.out.println("첫 시작 리턴");
		    return "reservation";
		}
			
		int dday=Integer.parseInt(request.getParameter("rentDay"));
		System.out.println(dday);
		int qty=Integer.parseInt(request.getParameter("qty"));
		System.out.println(qty);
		int usein=request.getParameter("opt-in")==null?0:1;
		System.out.println(usein);
		int usewifi=request.getParameter("opt-wifi")==null?0:1;
		System.out.println(usewifi);
		int usenavi=request.getParameter("opt-navi")==null?0:1;
		System.out.println(usenavi);
		int useseat=request.getParameter("opt-seat")==null?0:1;
		System.out.println(useseat);
		
		String userid=(String)session.getAttribute("loginId");
		System.out.println("userId="+userid);
		
		//대여 가능 로직
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(rday, formatter);
        LocalDate endDate = startDate.plusDays(dday);
        
        boolean carCheck = true;
        //오늘 날짜 이전
    	LocalDate today = LocalDate.now();
		if (today.isBefore(startDate)) {
			System.out.println("오늘 날짜가 시작 날짜보다 앞섭니다.");
		} else if (today.isAfter(startDate)) {
			System.out.println("오눌 날짜가 시작 날짜보다 늦습니다.");
			carCheck=false;
		} else {
			System.out.println("오늘 날짜와 시작 날짜가 같습니다.");
			carCheck=false;
		}
        
        
        //대여 숫자 따지기


        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            String formattedDate = date.format(formatter);
            System.out.println(formattedDate);
            Map<String, Object> map = new HashMap<>();
            map.put("num", (Integer) thisCar.getNum());
            map.put("startDate", formattedDate);

            int qty_rentCar = RentCarDAO.getInstance().rentCarQyt(thisCar.getNum());
            int areadyRent = ReservationDAO.getInstance().areadyRent(map);

            if (qty_rentCar - areadyRent <= 0) {
            	carCheck = false;
                System.out.println("이미 다 대여됨");
                break;
            }

            if (qty_rentCar - areadyRent - qty < 0) {
                System.out.println("남은 차량 대수가 대여 희망 대수보다 부족함");
                carCheck = false;
                break;
            }
        }
		
		if (!carCheck) {
			System.out.println("대여 실패");
			return "reservation";
		}else {
			String ctx=request.getContextPath();
			int pass=ReservationDAO.getInstance().makeNewReservation(carNum, userid, qty, dday, rday, usein, usewifi, usenavi, useseat);
			if (pass==1) {
				System.out.println("예약 성공");
				return "redirect:"+ctx+"/myReservation.do";
			}else {
				System.out.println("예약 실패");
				return "reservation";
			}
		}
	}
}

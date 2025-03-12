package kr.basic.frontcontroller;

import java.util.HashMap;

import kr.basic.controller.IdCheck;
import kr.basic.controller.Admin_eventInsertController;
import kr.basic.controller.Admin_rentCarDeleteController;
import kr.basic.controller.Admin_rentCarInsertController;
import kr.basic.controller.Admin_rentCarListController;
import kr.basic.controller.Admin_userController;
import kr.basic.controller.Admin_userDeleteController;
import kr.basic.controller.CommunityBoardController;
import kr.basic.controller.CommunityBoardDeleteController;
import kr.basic.controller.CommunityBoardReadingController;
import kr.basic.controller.CommunityBoardUpdateController;
import kr.basic.controller.CommunityBoardWritingController;
import kr.basic.controller.Controller;
import kr.basic.controller.CustomerServiceController;
import kr.basic.controller.CustomerServiceDeleteController;
import kr.basic.controller.CustomerServiceReadingController;
import kr.basic.controller.CustomerServiceUpdateController;
import kr.basic.controller.CustomerServiceWritingController;
import kr.basic.controller.EventInfoController;
import kr.basic.controller.LoginController;
import kr.basic.controller.LogoutController;
import kr.basic.controller.MyReservationController;
import kr.basic.controller.MyReservationDeleteController;
import kr.basic.controller.MyReservationInsertController;
import kr.basic.controller.RentCarCheck;
import kr.basic.controller.RentCarContentController;
import kr.basic.controller.ReservationController;
import kr.basic.controller.ReservationListController;
import kr.basic.controller.UserDeleteController;
import kr.basic.controller.UserJoinController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/userJoin.do", new UserJoinController());
		mappings.put("/userDelete.do", new UserDeleteController());
		mappings.put("/reservationList.do", new ReservationListController());
		mappings.put("/reservation.do", new ReservationController());
		mappings.put("/rentCarContent.do", new RentCarContentController());
		mappings.put("/myReservation.do", new MyReservationController());
		mappings.put("/myReservationInsert.do", new MyReservationInsertController());
		mappings.put("/myReservationDelete.do", new MyReservationDeleteController());
		mappings.put("/communityBoard.do", new CommunityBoardController());
		mappings.put("/communityBoardWriting.do", new CommunityBoardWritingController());
		mappings.put("/communityBoardReading.do", new CommunityBoardReadingController());
		mappings.put("/communityBoardUpdate.do", new CommunityBoardUpdateController());
		mappings.put("/communityBoardDelete.do", new CommunityBoardDeleteController());
		mappings.put("/customerService.do", new CustomerServiceController());
		mappings.put("/customerServiceWriting.do", new CustomerServiceWritingController());
		mappings.put("/customerServiceReading.do", new CustomerServiceReadingController());
		mappings.put("/customerServiceUpdate.do", new CustomerServiceUpdateController());
		mappings.put("/customerServiceDelete.do", new CustomerServiceDeleteController());
		mappings.put("/eventInfo.do", new EventInfoController());
		mappings.put("/admin_user.do", new Admin_userController());
		mappings.put("/admin_userDelete.do", new Admin_userDeleteController());
		mappings.put("/admin_eventInsert.do", new Admin_eventInsertController());
		mappings.put("/admin_rentCarList.do", new Admin_rentCarListController());
		mappings.put("/admin_rentCarInsert.do", new Admin_rentCarInsertController());
		mappings.put("/admin_rentCarDelete.do", new Admin_rentCarDeleteController());
//		mappings.put("/admin_CSanswer.do", new Admin_CSanswerController());
		mappings.put("/idCheck.do", new IdCheck());
		mappings.put("/rentCarCheck.do", new RentCarCheck());
	}

	public Controller getController(String key) {
		System.out.println("key: " + key);
		System.out.println("Controller: " + mappings.get(key));
		return mappings.get(key);
	}
}

package kr.basic.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.RentCarDAO;
import kr.basic.model.RentCarVO;
import kr.basic.model.ReservationDAO;

public class RentCarCheck implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("랜트카 검사");

        HttpSession session = request.getSession();
        RentCarVO thisCar = (RentCarVO) session.getAttribute("thisCar");

        if (thisCar == null) {
            response.getWriter().print("notValid");
            return null;
        }

        System.out.println(thisCar);

        String rday = request.getParameter("startDay");
        int dday = Integer.parseInt(request.getParameter("rentDay"));
        int qty = Integer.parseInt(request.getParameter("qty")); // qty를 루프 밖으로 이동

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(rday, formatter);
        LocalDate endDate = startDate.plusDays(dday);

        boolean pass = true;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            String formattedDate = date.format(formatter);
            System.out.println(formattedDate);
            Map<String, Object> map = new HashMap<>();
            map.put("num", (Integer) thisCar.getNum());
            map.put("startDate", formattedDate);
            
            // 빌릴 수 있는 대수
            int qty_rentCar = RentCarDAO.getInstance().rentCarQyt(thisCar.getNum());
            // 해당 날짜에 이미 빌려진 수
            int areadyRent = ReservationDAO.getInstance().areadyRent(map);
            System.out.println("qty_rentCar:"+qty_rentCar);
            System.out.println(areadyRent);
            System.out.println(qty);

            if (qty_rentCar - areadyRent <= 0) {
                pass = false;
                System.out.println("이미 다 대여됨");
                break;
            }

            if (qty_rentCar - areadyRent - qty < 0) {
                System.out.println("남은 차량 대수가 대여 희망 대수보다 부족함");
                pass = false;
                break;
            }
        }

        String passData = pass ? "valid" : "notValid";
        System.out.println(passData);

        response.getWriter().print(passData);

        return null;
    }
}
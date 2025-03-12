package kr.basic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import kr.basic.model.EventDAO;

public class Admin_eventInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("관리자 모드 이벤트 삽입 컨트롤러 진입");
		
		String ctx=request.getContextPath();
		String eventTitle=request.getParameter("eventTitle");
		
		if(eventTitle==null) {
			System.out.println("폼으로 이동하기");
			return "admin_eventInsert";
		}
		
		String eventStartDay=request.getParameter("eventStartDay");
		String eventEndDay=request.getParameter("eventEndDay");
		
		//비교할 date와 today를데이터 포맷으로 변경


        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(eventStartDay, formatter);
            LocalDate endDate = LocalDate.parse(eventEndDay, formatter);
    		LocalDate today = LocalDate.now();
    		
    		boolean check1=false;
    		boolean check2=false;

    		if (today.isBefore(startDate)) {
    			System.out.println("오늘 날짜가 시작 날짜보다 앞섭니다.");
    			check1=true;
    		} else if (today.isAfter(startDate)) {
    			System.out.println("오눌 날짜가 시작 날짜보다 늦습니다.");
    		} else {
    			System.out.println("오늘 날짜와 시작 날짜가 같습니다.");
    			check1=true;
    		}
    		
    		if (startDate.isBefore(endDate)) {
    			System.out.println("시작 날짜가 종료 날짜보다 앞섭니다.");
    			check2=true;
    		} else if (startDate.isAfter(endDate)) {
    			System.out.println("시작 날짜가 종료 날짜보다 늦습니다.");
    		} else {
    			check2=true;
    			System.out.println("시작 날짜와 종료 날짜가 같습니다.");
    		}
    		
    		if (!check1||!check2) {
				System.out.println("날짜 설정 오류");
				return "admin_eventInsert";
			}
    		
    		
        } catch (Exception e) {
            System.err.println("날짜 계산 ERR");
            e.printStackTrace();
        }
		
		//이미지 업로드 로직 만들기
		String saveDirectory = request.getServletContext().getRealPath("/img");
//				String saveDirectory = UPLOAD_DIR;

		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectory = " + saveDirectory);
		
		String sFileName = null;
		String oFileName = null;
		Part filePart = request.getPart("uploadFile");
        if (filePart != null && filePart.getSize() > 0) {
         	oFileName = extractFileName(filePart);
            sFileName =  System.currentTimeMillis() +"_"+oFileName ;
            
            filePart.write(saveDirPath.resolve(sFileName).toString());
            String fileType = filePart.getContentType();
            System.out.println("fileType= " + fileType);
        }
		
        //새 이벤트 삽입
        String img=sFileName;
        
		HttpSession session = request.getSession();
		boolean pass=EventDAO.getInstance().makeNewEvent(eventTitle,eventStartDay,eventEndDay,img);
		
		if (pass) {
			System.out.println("이벤트 등록 성공");
			return "redirect:" + ctx + "/eventInfo.do";
		}else {
			System.out.println("이벤트 등록 실패");
			return "admin_eventInsert";
		}
	}

	private String extractFileName(Part filePart) {
	       String contentDisposition = filePart.getHeader("content-disposition");
	        String[] items = contentDisposition.split(";");
	        
	        System.out.println("items =" + Arrays.toString(items));
	        
	        for (String item : items) {
	            if (item.trim().startsWith("filename")) {
	                String fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
	                return Paths.get(fileName).getFileName().toString();
	            }
	        }
		return null;
	}

}

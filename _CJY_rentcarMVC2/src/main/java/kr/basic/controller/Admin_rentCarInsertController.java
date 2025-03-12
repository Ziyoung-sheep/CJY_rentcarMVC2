package kr.basic.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.basic.model.RentCarDAO;

public class Admin_rentCarInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("랜트카 등록 컨트롤러 진입");
		
		String carName=request.getParameter("carName");
		
		if(carName==null) {
			return "admin_rentCarInsert";
		}
		
		int carCategory=Integer.parseInt(request.getParameter("carCategory"));
		int carPrice=Integer.parseInt(request.getParameter("carPrice"));
		int carUsePeople=Integer.parseInt(request.getParameter("carUsePeople"));
		int carTotalQty=Integer.parseInt(request.getParameter("carTotalQty"));
		String carCompany=request.getParameter("carCompany");
		String carInfo=request.getParameter("carInfo");
		
		String ctx=request.getContextPath();
		String saveDirectory = request.getServletContext().getRealPath("/img");
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

		String img=sFileName;
		
		boolean pass=RentCarDAO.getInstance().insertNewRentCar(carName, carCategory, carPrice, carUsePeople, carTotalQty, carCompany, img, carInfo);
		if (pass) {
			System.out.println("차량 등록 성공");
			return "redirect:" + ctx + "/admin_rentCarList.do";
		}else {
			System.out.println("차량 등록 실패");
			return "admin_rentCarInsert";
		}
		
	}

	private String extractFileName(Part filePart) {
        String contentDisposition = filePart.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        
        System.out.println("items =" + Arrays.toString(items));
        
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                String fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
                return Paths.get(fileName).getFileName().toString(); // Extract just the filename
            }
        }
        return null;
	}

}

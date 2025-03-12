package kr.basic.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import kr.basic.model.CommunityBoardDAO;

public class CommunityBoardWritingController implements Controller{
	
//	private static final String UPLOAD_DIR = "C:\\CJY\\JspWorkspace\\CJY_rentcarMVC2\\_CJY_rentcarMVC2\\src\\main\\webapp\\img";
//	private static final String UPLOAD_DIR = "img"; 
//	private static final String UPLOAD_DIR = "C:"+File.separator+"img";
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("자유게시판 컨트롤러 진입");
		String ctx=request.getContextPath();
		System.out.println(ctx);
//		System.out.println(UPLOAD_DIR);
		
		String title=request.getParameter("title");
		String main=request.getParameter("main");
		
		if(title==null||main==null) {
			System.out.println("본문 또는 메인 안채워짐");
			return "communityBoardWrite";
		}
		
		//이미지 업로드 로직 만들기
		String saveDirectory = request.getServletContext().getRealPath("/img");
//		String saveDirectory = UPLOAD_DIR;

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

		
		System.out.println(title);
		System.out.println(main);
		String img=sFileName;
		
		HttpSession session = request.getSession();
		String loginId=(String)session.getAttribute("loginId");
		
		int pass=CommunityBoardDAO.getInstance().insertNewCB(loginId, title, main, img);
		if (pass==1) {
			System.out.println("게시글 등록 성공");
			return "redirect:" + ctx + "/communityBoard.do";
		}else {
			System.out.println("게시글 등록 실패");
			return "communityBoardWrite";
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

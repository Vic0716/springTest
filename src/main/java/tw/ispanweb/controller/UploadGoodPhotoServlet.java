package tw.ispanweb.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.ispanweb.model.GoodPhoto;
import tw.ispanweb.service.GoodPhotoService;

@WebServlet("/upload")
@MultipartConfig
public class UploadGoodPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UploadGoodPhotoServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String photoName = request.getParameter("photoName");
		Part filePart =  request.getPart("photoFile");
		
		InputStream inputStream = filePart.getInputStream();//轉為inputstream
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		GoodPhotoService gpService = context.getBean("goodPhotoService",GoodPhotoService.class);
		
		GoodPhoto gp = new GoodPhoto();
		gp.setPhotoName(photoName);
		gp.setPhotoFile(inputStream.readAllBytes());//將inputStream轉為byte
		
		gpService.inserPhoto(gp);
		
		request.setAttribute("msg","上傳OK");
		
		RequestDispatcher rd = request.getRequestDispatcher("uploadPage.jsp");
		rd.forward(request, response);
				
	}

}

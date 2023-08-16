package tw.ispanweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.ispanweb.model.GoodPhoto;
import tw.ispanweb.service.GoodPhotoService;


@WebServlet("/download")
public class DownLoadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DownLoadPhotoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestId = request.getParameter("id");
		
		response.setContentType("image/jpeg");
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		GoodPhotoService gpService = context.getBean("goodPhotoService",GoodPhotoService.class);
		
		GoodPhoto gp = gpService.findPhotoById(Integer.parseInt(requestId));
		
		byte[] photoByte = gp.getPhotoFile();
		
		ServletOutputStream ops =response.getOutputStream();
		ops.write(photoByte);
			
	}

}

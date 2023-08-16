package tw.ispanweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.ispanweb.model.GoodPhoto;
import tw.ispanweb.service.GoodPhotoService;


@WebServlet("/listPhoto")
public class GoodPhotoSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GoodPhotoSelectAllServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		GoodPhotoService gpService = context.getBean("goodPhotoService",GoodPhotoService.class);
		
		List<GoodPhoto> allPhoto = gpService.findAllPhoto();
		
		request.setAttribute("photoList", allPhoto);
		
		RequestDispatcher rd = request.getRequestDispatcher("allPhoto.jsp");
		rd.forward(request, response);
		
		
	}

	

}

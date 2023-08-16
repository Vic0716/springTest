package tw.ispanweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.ispanweb.model.Member;
import tw.ispanweb.service.MemberService;



@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberLoginServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService mService = context.getBean("memberService", MemberService.class);
		
		Member tempMember = mService.checkLogin(loginName, loginPwd);
		
		if(tempMember != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginMember", tempMember);
			
			RequestDispatcher rd = request.getRequestDispatcher("login_success.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errorMsg", "請重新登入");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}

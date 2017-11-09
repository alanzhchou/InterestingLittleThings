package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.UserinfoService;
import service.UserinfoServiceImpl;

@WebServlet(name = " LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID =	1L;
    protected void doGet(HttpServletRequest	request,	HttpServletResponse	response)
            throws ServletException,	IOException	{
        request.setCharacterEncoding("UTF-8");
        String	username=request.getParameter("username");
        String	password=request.getParameter("password");
        if((username==null||username.equals(""))&&(password==null||password.equals(""))
                ){
            request.setAttribute("msg_username",	"user	name	shouldn't	be	none");
            request.setAttribute("msg_password",	"password	shouldn't	be	none");
            request.getRequestDispatcher("Login.jsp").forward(request,	response);
        }else if(password==null||password.equals("")){
            request.setAttribute("username",	username);
            request.setAttribute("msg_password",	"password	shouldn't	be	none");
            request.getRequestDispatcher("Login.jsp").forward(request,	response);
        }else if(username==null||username.equals("")){
            request.setAttribute("password",	password);
            request.setAttribute("msg_username",	"user	name	shouldn't	be	none");
            request.getRequestDispatcher("Login.jsp").forward(request,	response);
        }else{
            System.out.println("success");
            UserinfoService	userinfoservice=new UserinfoServiceImpl();
            int result=userinfoservice.login(username,password);
            if(result==1){
                System.out.println("有这个人");
                request.getRequestDispatcher("success.jsp").forward(request,	response);
            }else{
                System.out.println("查无此人，或连接失败");
                request.setAttribute("msg",	"the	username	or	password	is	wrong");
                request.getRequestDispatcher("Login.jsp").forward(request,	response);
            }
        }
    }

    protected void doPost(HttpServletRequest	request,	HttpServletResponse	response)
            throws ServletException,	IOException	{
        doGet(request,	response);
    }
}

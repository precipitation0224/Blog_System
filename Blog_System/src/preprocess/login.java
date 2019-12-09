package preprocess;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String login_name=request.getParameter("user_name");
		String login_pwd=request.getParameter("user_password");
		if(login_name == "") {
			String script = "<script>alert('用户名不能为空！！！');location.href='login.jsp'</script>";
			response.getWriter().println(script);
		} else if (login_pwd == "") {
			String script = "<script>alert('密码不能为空！！！');location.href='login.jsp'</script>";
			response.getWriter().println(script);
		} else {
			DataMethod method = new DataMethod();
			try {
				if(method.isSuccess(method.DataConn(), login_name, login_pwd)) {
					/* 绑定session */
					HttpSession session = request.getSession();
					session.setAttribute("login_name","username");
					response.sendRedirect("BlogManager.jsp");
				} else {
					String script = "<script>alert('用户名或密码错误，请重新登陆');location.href='login.jsp'</script>";
					response.getWriter().println(script);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

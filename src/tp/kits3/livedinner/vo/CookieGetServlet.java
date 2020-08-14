package tp.kits3.livedinner.vo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieGetServlet
 */
@WebServlet("/cookie/get")
public class CookieGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookie = request.getCookies();
		for(int i=0;i<cookie.length;++i) {
			Cookie eachCK = cookie[i];
			System.out.println("--------------------");
			System.out.println(eachCK.getComment());
			System.out.println(eachCK.getDomain());
			System.out.println(eachCK.getMaxAge());
			System.out.println(eachCK.getName());
			System.out.println(eachCK.getPath());
			System.out.println(eachCK.getSecure());
			System.out.println(eachCK.getValue());
			System.out.println(eachCK.getVersion());
			System.out.println(eachCK.getClass());
			System.out.println("--------------------");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

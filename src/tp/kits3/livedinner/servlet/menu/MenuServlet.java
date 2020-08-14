package tp.kits3.livedinner.servlet.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.MenuDAO;
import tp.kits3.livedinner.service.MenuService;
import tp.kits3.livedinner.vo.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private MenuDAO dao;
	private MenuService menuService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
		
		super();
		menuService = new MenuService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/livedinner", "root",
//					"20121996");
//			System.out.println(conn);
//			System.out.println("connection menu");
//			Statement stmt = conn.createStatement();
//			String sql = "select * from menu";
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				int muid = rs.getInt("muid");
//				int ctgid = rs.getInt("ctgid");
//				String muname = rs.getString("muname");
//				String intro = rs.getString("intro");
//				Double price = rs.getDouble("price");
//				String currency = rs.getString("currency");
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		response.setContentType("text/html;chartset:UTF-8");
		List<Menu> menuList = menuService.findAll();
		request.setAttribute("MenuList", menuList);

		String prefix = "/WEB-INF/views/menu";
		String postfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "/menu" + postfix);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

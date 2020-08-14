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
 * Servlet implementation class MenuListServlet
 */
@WebServlet("/menu/list")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuListServlet() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = new MenuService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * // toString() Menu menu = new Menu(); menu.setMuid(1); menu.setCtgid(1); Gson
		 * gson = new Gson(); String json = gson.toJson(menu); // object to String
		 * gson.fromJson(json, Menu.class);// json to Object
		 * response.getWriter().append(json);// println()
		 */
		response.setContentType("text/html;chartset:UTF-8");
		List<Menu> menuList = dao.findAll();
		request.setAttribute("MenuList", menuList);		

		String prefix = "/WEB-INF/views/menu";
		String postfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "/menuList" + postfix);

		dispatcher.forward(request, response);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/menuList.jsp");
//		request.setAttribute("menuName", new Menu());
//		dispatcher.forward(request, response);
//		response.getWriter().append("");// println()
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

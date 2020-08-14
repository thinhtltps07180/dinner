package tp.kits3.livedinner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.CategoryDAO;
import tp.kits3.livedinner.vo.Category;

/**
 * Servlet implementation class CategoryAddServlet
 */
@WebServlet("/category/save")
public class CategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String form = "<div>";
		form += "<form method='post' action='save'>";
		form += "Category.name <input type='text' name='ctgname' require />";
		form += "Category.service <input type='text' name='service' require />";
		form += "<input type='submit' value ='Add'/>";
		form += "</form></div>";
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(form);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		Category category = new Category();
		category.setCtname(request.getParameter("ctgname"));
		category.setService(request.getParameter("service"));
		if(request.getParameter("service").length() == 1) {
			category.setService(request.getParameter("service"));
			dao.save(category);
		}else {
			System.out.println("not vilid data : must be 1 char");
		}
		
		response.sendRedirect("/livedinner/category/list");
	}

}

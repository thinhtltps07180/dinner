package tp.kits3.livedinner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.CategoryDAO;
import tp.kits3.livedinner.vo.Category;

@WebServlet("/category/update")
public class CategoryUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: show form to
		int ctgid = Integer.parseInt(request.getParameter("ctgid"));

		CategoryDAO dao = new CategoryDAO();
		Category category = dao.findOne(ctgid);
		if (category == null) {
			System.out.println("Khong co category");
		} else {

			String form = "<div>";
			form += "<form method='post' action='update'>";
			form += "Category.id <input type='text' name='ctgid' value='" + category.getCtgid() + "' readonly />";
			form += "Category.name <input type='text' name='ctgname' value='" + category.getCtname() + "' />";
			form += "Category.service <input type='text' name='service' value='" + category.getService() + "' />";
			form += "<input type='submit' value='Add' />";
			form += "</form></div>";

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().append(form);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDAO=new CategoryDAO();
		Category category=new Category();
		category.setCtgid(Integer.parseInt(request.getParameter("ctgid")));
		
		category.setCtname(request.getParameter("ctgname"));

		if(request.getParameter("service").length()==1) {
			category.setService(request.getParameter("service"));
			categoryDAO.update(category);
			
		}else {
			System.out.println("not valid data: must be a char");
		}
		
		
		doGet(request, response);
	}

}
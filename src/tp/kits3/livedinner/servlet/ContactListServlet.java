package tp.kits3.livedinner.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactListServlet
 */
@WebServlet("/contact/list")
public class ContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ContactDAO dao = new ContactDAO();
//		List<Contact> list = dao.findAll();
//		
//		if(list.size()==0) {
//			System.out.println("Have no entries");
//		}
//		
//
//		String divList = "<div class='ctgList'>";
//		
//		for(Contact ct:list) {
//			divList+="<p><a href='update?ctgid="+ct.getCtgid()+"'>"+ct.toString()+"</a></p>";
//			divList+="<p><a href='update?coid="+ct.getCoid()+"'>" + ct.toString() + "</a></p>";
//		}
//		
//		divList += "</div>";
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().append(divList);
		
		response.setContentType("text/html;chartset:UTF-8");
//		List<Menu> menuList = dao.findAll();
//		request.setAttribute("MenuList", menuList);
		
		String prefix = "/WEB-INF/views";
		String postfix = ".jsp";
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(prefix+"/contact"+postfix);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

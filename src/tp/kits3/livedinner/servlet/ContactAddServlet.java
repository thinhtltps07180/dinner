package tp.kits3.livedinner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.ContactDAO;
import tp.kits3.livedinner.vo.Contact;

/**
 * Servlet implementation class ContactAddServlet
 */
@WebServlet("/contact/add")
public class ContactAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String form = "<div>";
		form += "<form method='post' action='add'>";
		form += "Contact Name <input type='text' name='coname' require />";
		form += "<br/>";
		form += "Contact Priphone <input type='text' name='priphone' require />";
		form += "<br/>";
		form += "Contact Subphone <input type='text' name='subphone' require />";
		form += "<br/>";
		form += "Contact Email <input type='text' name='email' require />";
		form += "<br/>";
		form += "Contact Address <input type='text' name='address' require />";
		form += "<br/>";
		form += "Contact Unused <input type='radio' name='unused' value='1' />True";
		form += "<input type='radio' name='unused' value='0' />Fasle";
		form += "<br/>";
		form += "Contact Opening <input type='text' name='opening' require />";
		form += "<br/>";
		form += "Contact weekday <input type='text' name='weekday' require />";
		form += "<br/>";
		form += "Contact weekend <input type='text' name='weekend' require />";
		form += "<br/>";
		form += "Contact aboutus <input type='text' name='aboutus' require />";
		form += "<br/>";
		form += "Contact latitude <input type='text' name='latitude' require />";
		form += "<br/>";
		form += "Contact logitude <input type='text' name='logitude' require />";
		form += "<br/>";
		form += "<input type='submit' value ='Add'/>";
		form += "</form></div>";
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(form);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactDAO dao = new ContactDAO();
		Contact contact = new Contact();
		contact.setConame(request.getParameter("coname"));
		contact.setPriphone(request.getParameter("priphone"));
		contact.setSubphone(request.getParameter("subphone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		contact.setUnused(Boolean.parseBoolean(request.getParameter("unused")));
		contact.setOpening(request.getParameter("opening"));
		contact.setWeekday(request.getParameter("weekday"));
		contact.setOpening(request.getParameter("opening"));
		contact.setAboutus(request.getParameter("aboutus"));
		contact.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		contact.setLogitude(Double.parseDouble(request.getParameter("logitude")));
		dao.save(contact);
//		if (request.getParameter("service").length() == 1) {
//			category.setService(request.getParameter("service"));
//			dao.save(category);
//		} else {
//			System.out.println("not vilid data : must be 1 char");
//		}

		response.sendRedirect("/livedinner/contact/list");
	}

}

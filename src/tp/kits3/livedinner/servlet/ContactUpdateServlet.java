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
 * Servlet implementation class ContactUpdateServlet
 */
@WebServlet("/contact/update")
public class ContactUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int contactId = Integer.parseInt(request.getParameter("coid"));
		ContactDAO dao = new ContactDAO();
		Contact contact = dao.findOne(contactId);
		if (contact == null) {
			System.out.println("Contact not found");
		} else {

			String form = "<div>";
			form += "<form method='post' action='update'>";
			form += "Contact Name <input type='text' name='coid'  value='" + contact.getCoid() + "' readonly />";
			form += "<br/>";
			form += "Contact Priphone <input type='text' name='priphone' value='"+contact.getPriphone()+"' />";
			form += "<br/>";
			form += "Contact Conname <input type='text' name='coname' value='"+contact.getConame()+"' />";
			form += "<br/>";
			form += "Contact Subphone <input type='text' name='subphone' value = '" + contact.getSubphone()
					+ "' require />";
			form += "<br/>";
			form += "Contact Email <input type='text' name='email' value='" + contact.getEmail() + "' require />";
			form += "<br/>";
			form += "Contact Address <input type='text' name='address' value='" + contact.getAddress() + "' require />";
			form += "<br/>";
			if(contact.getUnused()) {
				form += "Contact Unused <input type='radio' name='unused' value='1' checked/>True";
				form += "<input type='radio' name='unused' value='0' />Fasle";
			}else {
				form += "Contact Unused <input type='radio' name='unused' value='1' />True";
				form += "<input type='radio' name='unused' value='0' checked/>Fasle";
			}
			form += "<br/>";
			form += "Contact Opening <input type='text' name='opening' value='" + contact.getOpening() + "' require />";
			form += "<br/>";
			form += "Contact weekday <input type='text' name='weekday' value='" + contact.getWeekday() + "' require />";
			form += "<br/>";
			form += "Contact weekend <input type='text' name='weekend' value='" + contact.getWeekend() + "' require />";
			form += "<br/>";
			form += "Contact aboutus <input type='text' name='aboutus' value='" + contact.getAboutus() + "' require />";
			form += "<br/>";
			form += "Contact latitude <input type='text' name='latitude' value='" + contact.getLatitude()
					+ "' require />";
			form += "<br/>";
			form += "Contact logitude <input type='text' name='logitude' value='" + contact.getLogitude()
					+ "' require />";
			form += "<br/>";
			form += "<input type='submit' value ='Update'/>";
			form += "</form></div>";

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().append(form);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactDAO dao = new ContactDAO();
		Contact contact = new Contact();
		contact.setCoid(Integer.parseInt(request.getParameter("coid")));
		contact.setConame(request.getParameter("coname"));
		contact.setPriphone(request.getParameter("priphone"));
		contact.setSubphone(request.getParameter("subphone"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		contact.setUnused(request.getParameter("unused").equals("1")? true:false);
		contact.setOpening(request.getParameter("opening"));
		contact.setWeekday(request.getParameter("weekday"));
		contact.setWeekend(request.getParameter("weekend"));
		contact.setAboutus(request.getParameter("aboutus"));
		contact.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		contact.setLogitude(Double.parseDouble(request.getParameter("logitude")));
		dao.update(contact);
//		if (request.getParameter("service").length() == 1) {
//			category.setService(request.getParameter("service"));
//			dao.save(category);
//		} else {
//			System.out.println("not vilid data : must be 1 char");
//		}

		response.sendRedirect("/livedinner/contact/list");
	}

}

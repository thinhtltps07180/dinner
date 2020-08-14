package tp.kits3.livedinner.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.TagDao;
import tp.kits3.livedinner.vo.Tag;

/*
 amazing
  url:
 /tag/ -> means show tag list
 /tag/insert -> means add tag 
 /tag/edit -> means edit tag 
 *
 * wild tag
 * */

@WebServlet("/tag/*")
public class TagServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		TagDao dao = new TagDao();
		String command = uri[uri.length - 1]; // what comment
		// String comand = request.getParameter("cmd");
		if ("insert".equals(command)) {
			Tag tag = new Tag();// field tagid , tgname
			// tag.setTagid(tagid); <-- primary key auto increment
			String tgname = request.getParameter("tgname");
			tag.setTgname(tgname);
			dao.save(tag);
		}
		if ("list".equals(command)) {
			List<Tag> list = dao.findAll(); // seclect all
			// make HTML to respone
			String table = "<table> ";
			// for or for-each
			for (Tag t : list) {
				// get column of DB
				int tid = t.getTagid();
				String tname = t.getTgname();
				table += "<tr><td>" + tid + "</td><td>" + tname + "</td></tr>";

				table += "</table>";
				response.getWriter().print(table);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
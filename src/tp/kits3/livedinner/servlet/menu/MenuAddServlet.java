package tp.kits3.livedinner.servlet.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tp.kits3.livedinner.service.MenuService;
import tp.kits3.livedinner.vo.Menu;

/**
 * Servlet implementation class MenuAddServlet
 */
@WebServlet("/menu/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService service;

	public MenuAddServlet() {
		super();
		this.service = new MenuService();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;chartset:UTF-8");

		String prefix = "/WEB-INF/views/menu";
		String postfix = ".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "/menuAdd" + postfix);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("Nothing to upload");
			return;
		}

		Part p = request.getPart("up_photo");
		if (p != null) {
			System.out.println(p.getContentType());
			System.out.println(p.getName());
			System.out.println(p.getSubmittedFileName());
			System.out.println(p.getInputStream());
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;

			try {
				items = upload.parseRequest(request);
				System.out.println("items: " + items);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			Menu menu = new Menu();
			menu.setCtgid(Integer.parseInt(request.getParameter("ctgid")));
			menu.setMuname(request.getParameter("muname"));
			menu.setIntro(request.getParameter("intro"));
			menu.setDetails(request.getParameter("details"));
			menu.setPrice(Double.parseDouble(request.getParameter("price")));
			menu.setCurrency(request.getParameter("currency"));
			service.save(menu);

			response.setContentType("text/html;chartset:UTF-8");

//		String prefix = "/WEB-INF/views";
//		String postfix = ".jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "/menu" + postfix);
//
//		dispatcher.forward(request, response);
		}
	}
}

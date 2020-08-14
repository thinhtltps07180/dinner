package tp.kits3.livedinner.vo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FirstServletContactext
 */
@WebServlet("/first-contactext")
public class FirstServletContactext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServletContactext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx=getServletContext();
		ctx.setAttribute("first", "i am come to fisrt servlet");
		/*
//		ctx.setAttribute("pm", "Helllo context");	
		response.getWriter().append("Served at: ");
		*/
		// truyền đi
//		RequestDispatcher dis=request.getRequestDispatcher("/Gugu.html");
		RequestDispatcher dis=request.getRequestDispatcher("/second-contactext");
		request.setAttribute("pm", "wilicam");
		dis.forward(request, response);
		
		response.getWriter().append("Hello aa");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




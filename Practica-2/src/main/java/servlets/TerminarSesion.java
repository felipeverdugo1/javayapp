package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TerminarSesion
 */
@WebServlet(name = "/TerminarSesion", urlPatterns = "/terminarsesion")
public class TerminarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TerminarSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<HTML>");
		out.print("<HEAD><BODY>");
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			out.print("<H1>Gracias por su compra!!</H1>");
			ses.invalidate();
			out.print("<a href=\"login.html\">Salir</a>");
		} else
			response.sendRedirect("login.html");

		out.print("</HEAD></BODY>");
		out.print("<HTML>");
		out.close();
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

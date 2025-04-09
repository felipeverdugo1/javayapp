package misservlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContadorDeVisitas
 */
@WebServlet(description = "Cuenta las veces que alguien accede al servlet", urlPatterns = {
		"/ContadorDeVisitas" }, initParams = { @WebInitParam(name = "count", value = "0") })
public class ContadorDeVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int cant = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContadorDeVisitas() {

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

		response.getWriter().append("Este servlet lo visitaron: " + cant++ + " usuario/s ");
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

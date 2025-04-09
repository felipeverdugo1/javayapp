package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> usuarios;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUsr() {
		super();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		usuarios = new HashMap<>();
		usuarios.put("admin", "1234");
		usuarios.put("usuario1", "clave1");
		usuarios.put("usuario2", "clave2");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("userName");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if ((usuarios.containsKey(usuario)) && usuarios.get(usuario).equals(password)) {
			request.getSession(true); // Crea o recupera la sesión.
			response.sendRedirect("productos");
		} else
			response.sendRedirect("/compras/login.html");
		out.close();
	}

}

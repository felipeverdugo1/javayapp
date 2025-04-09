package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Productos
 */

@WebServlet(name = "Productos", urlPatterns = "/productos")
//@WebServlet(name = "Productos", urlPatterns = "/productos", initParams = {
//		@WebInitParam(name = "cantTotal", value = "4"), @WebInitParam(name = "golo0", value = "chupetin"),
//		@WebInitParam(name = "pu0", value = "2"), @WebInitParam(name = "golo1", value = "chocolate"),
//		@WebInitParam(name = "pu1", value = "3"), @WebInitParam(name = "golo2", value = "chicle"),
//		@WebInitParam(name = "pu2", value = "1"), @WebInitParam(name = "golo3", value = "alfajor"),
//		@WebInitParam(name = "pu3", value = "10"), @WebInitParam(name = "golo4", value = "turron"),
//		@WebInitParam(name = "pu4", value = "7") })
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Productos() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Prodcutos</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; margin: 20px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<form action=\"facturar\" method=\"post\">");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Golosina</th>");
		out.println("<th>Precio Unitario</th>");
		out.println("<th>Cantidad</th>");
		out.println("</tr>");
		out.println("</thead>");

		HttpSession sesion = request.getSession(false);

		if (sesion == null) {
			response.sendRedirect("login.html");
		} else {

			// tabla
			int cantTotalDeGolosinas = Integer.parseInt(getInitParameter("cantTotal"));

			ServletContext context = getServletContext();
			@SuppressWarnings("unchecked")
			HashMap<String, Double> catalogo = (HashMap<String, Double>) context.getAttribute("catalogo");
			System.out.println(catalogo);

			// filas
			out.println("<tbody>");
			out.println("<tr>");
			String golosina;
			Integer cant;
			double precioUnidad;
			for (int i = 0; i < cantTotalDeGolosinas; i++) {
				golosina = getInitParameter("golo" + i);
				precioUnidad = Double.parseDouble(getInitParameter("pu" + i));

				if (sesion.getAttribute("cant" + i) == null) {
					sesion.setAttribute("golo" + i, golosina);
					sesion.setAttribute("pu" + i, precioUnidad);
					sesion.setAttribute("cant" + i, 0);
				}

				cant = (Integer) sesion.getAttribute("cant" + i);

				out.println("<tr>");
				out.println("<td> " + golosina + " <td>");
				out.println("<td> " + precioUnidad + "$ <td>");
				out.println("<td><input type='number' name='cant' min='0' max='100' value='" + cant + "'></td>");
				out.println("</tr>");

			}

			out.println("</tbody>");
			out.println("</table>");

			out.println("</div>");

			out.println("<button type=\"submit\">Facturar</button>");
			out.println("</form>");
			out.print("<a href=\"terminarsesion\">Salir</a>");
			out.println("</body>");
			out.println("</html>");
		}
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

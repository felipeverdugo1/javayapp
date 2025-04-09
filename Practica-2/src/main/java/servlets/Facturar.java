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
 * Servlet implementation class Facturar
 */
@WebServlet(name = "/Facturar", urlPatterns = "/facturar")
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Facturar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Facturar</title>");
		out.println("<style>");
		out.println("body { font-family: Arial; margin: 20px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Golosina</th>");
		out.println("<th>Cantidad</th>");
		out.println("<th>PrecioTotal </th>");
		out.println("</tr>");
		out.println("</thead>");

		HttpSession sesion = request.getSession(false);

		if (sesion == null)
			response.sendRedirect("login.html");
		else {

			String[] cantidadesSeleccionadas = request.getParameterValues("cant");
			// filas
			out.println("<tbody>");
			out.println("<tr>");
			String golosina;
			Integer cant = 0;
			double precioUnidad;
			for (int i = 0; i < cantidadesSeleccionadas.length; i++) {
				sesion.setAttribute("cant" + i, Integer.parseInt(cantidadesSeleccionadas[i]));
				cant = Integer.parseInt(cantidadesSeleccionadas[i]);
				if (cant > 0) {
					golosina = (String) sesion.getAttribute("golo" + i);
					precioUnidad = (Double) sesion.getAttribute("pu" + i);

					out.println("<tr>");
					out.println("<td> " + golosina + " <td>");
					out.println("<td> " + cant + " <td>");
					out.println("<td> " + precioUnidad * cant + "$ </td>");
					out.println("</tr>");

				}

			}

			out.println("</tbody>");
			out.println("</table>");

			out.println("</div>");

			out.print("<a href=\"productos\">Seguir Comprando</a>");
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

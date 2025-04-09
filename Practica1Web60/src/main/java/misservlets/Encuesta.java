package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Integer> mascotas = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Encuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		mascotas.put("perro", 0);
		mascotas.put("gato", 0);
		mascotas.put("hamster", 0);
		mascotas.put("tortuga", 0);
		mascotas.put("conejo", 0);
		mascotas.put("pez", 0);

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

		String[] seleccionados = request.getParameterValues("mascota");
		if (seleccionados != null) {
			for (String mascota : seleccionados) {
				mascotas.put(mascota, mascotas.get(mascota) + 1);
			}
//				
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Resultados de Votación</title></head><body>");
		out.println("<h1>Resultados de la Votación</h1>");
		out.println("<table border='1'><tr><th>Mascota</th><th>Votos</th></tr>");

		// Determinar la mascota más votada
		Optional<Map.Entry<String, Integer>> maxEntry = mascotas.entrySet().stream().max(Map.Entry.comparingByValue());

		String mascotaMasVotada = maxEntry.map(Map.Entry::getKey).orElse("Ninguna");
		int votosMaximos = maxEntry.map(Map.Entry::getValue).orElse(0);
		int totalVotos = mascotas.values().stream().mapToInt(Integer::intValue).sum();
		double porcentaje = totalVotos > 0 ? (votosMaximos * 100.0 / totalVotos) : 0;

		out.println("<html><head><title>Resultados de Votación</title></head><body>");
		out.println("<h1>Resultados de la Votación</h1>");
		out.println("<table border='1'><tr><th>Mascota</th><th>Votos</th></tr>");

		// Mostrar la tabla de votos
		for (Map.Entry<String, Integer> entry : mascotas.entrySet()) {
			out.println("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
		}
		out.println("</table>");

		// Mostrar la mascota más votada
		out.printf("<p>La mascota más votada es: <strong>%s</strong> con %.2f%% de los votos.</p>", mascotaMasVotada,
				porcentaje);

		// Link para volver a votar
		out.println("<p><a href='mascotas.html'>Volver a votar</a></p>");
		out.println("</body></html>");

//	}
	}

}

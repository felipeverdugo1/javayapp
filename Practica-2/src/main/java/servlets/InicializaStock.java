package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
@WebListener
public class InicializaStock implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InicializaStock() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext contexto = sce.getServletContext();

		try (InputStream is = contexto.getResourceAsStream("/WEB-INF/stock.txt");
				BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

			Map<String, Double> catalogo = new HashMap<>();
			String linea;

			while ((linea = reader.readLine()) != null) {
				String[] partes = linea.split(",");
				if (partes.length == 2) {
					String producto = partes[0].trim();
					double precio = Double.parseDouble(partes[1].trim());
					catalogo.put(producto, precio);
				}
			}

			// Guarda el catálogo en el contexto de la aplicación
			contexto.setAttribute("catalogo", catalogo);
			contexto.log("Catálogo de golosinas cargado correctamente.");

		} catch (IOException e) {
			contexto.log("Error al leer el archivo catalogo.txt: " + e.getMessage(), e);
		} catch (NumberFormatException e) {
			contexto.log("Formato de precio inválido en catalogo.txt: " + e.getMessage(), e);
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}

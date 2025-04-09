package misservlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class controla
 */
@WebServlet("/controla")
public class controla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controla() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion = request.getParameter("opcion");
		String nombre = request.getParameter("name");
		RequestDispatcher dispatcher;
		ServletContext context = request.getServletContext();
		if (opcion.equals("hola")) {
			//Parametros de contexto
			// En cualquier servlet:
			
			context.setAttribute("name", nombre); // Todos los servlets ven este valor.

			//RequestDispatcher
			request.setAttribute("name", nombre);
	        dispatcher = context.getRequestDispatcher("/holaservlet");
	        dispatcher.forward(request, response);
		}else if (opcion.equals("productos")) {
			// Acceso Cross-Context
//			 RequestDispatcher rd = request.getServletContext()
//                     .getContext("/compras")
//                     .getRequestDispatcher("/productos");
//			 rd.forward(request, response);
			
			//Include
//			getServletContext().getContext("/compras")
//            .getRequestDispatcher("/productos")
//            .include(request, response);
			
			
			response.sendRedirect("/compras/productos");
			
			
		} else  if (opcion.equals("google")) 
			response.sendRedirect("https://www.google.com.ar/");
		
		else {
        dispatcher = context.getRequestDispatcher("/inicio.html");
        dispatcher.forward(request, response);
		}
		

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.PersonaDAO;
import dao.PersonaDAOImpl;
import dao.ProductoDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Item;
import model.Persona;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenerarFormulario
 */
@WebServlet("/GenerarPresupuesto")
public class GenerarPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDAO;

    /**
     * Default constructor. 
     */
    public GenerarPresupuesto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
			HttpSession sesion = request.getSession(false);
	        try {
//	        	personaDAO = new PersonaDAOImpl();
//	        	List<Persona> personas = personaDAO.listarTodos();
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Calculadora de Costos para Boda</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Calculadora de Costos para Boda</h1>");
	            out.println("<form action='Salir' method='post'>");
	    		out.println("<table>");
	    		out.println("<thead>");
	    		out.println("<tr>");
	    		out.println("<th>Item  </th>");
	    		out.println("<th>Cantidad       </th>");
	    		out.println("<th>PrecioTotal</th>");
	    		out.println("</tr>");
	    		out.println("</thead>");


				String[] cantidadesSeleccionadas = request.getParameterValues("cant");
	        	ItemDAOImpl itemDao = new ItemDAOImpl();
	        	List<Item> items = itemDao.listarTodos();
	     
	            double precioFinal = 0,precioTotal = 0;
	            int i = 0;
	            int cantI = 0;
	            for (String cant: cantidadesSeleccionadas) {
	            	cantI = Integer.parseInt(cant);
	            	
	            	if (cantI > 0) {
	            	Item item = items.get(i);
	            	sesion.setAttribute("cant" +item.getNombre() ,cantI);
	            	precioTotal = item.getPrecio() * cantI;
	            	precioFinal += precioTotal; 
					out.println("<tr>");
					out.println("<td> " + item.getNombre() + " <td>");
					out.println("<td> " + cantI + " <td>");
					out.println("<td> " +precioTotal+ "$ </td>");
					out.println("</tr>");
	            	
	            	}

	          
	            	i++;
	            }
	            out.println("<table border='1'>");
				out.println("</tbody>");
				out.println("</table>");

				out.println("</div>");
	            
				out.println("<td> Total a pagar : " +precioFinal+ "$ </td>");
				out.println("<td>nombre<input type='text' name='nombre' required></td>");
				out.println("<td>email<input type='text' name='email' required></td>");

				out.print("<a href=\"GenerarFormulario\">Seguir Comprando</a>");
	            out.println("<p><input type='submit' value='Comprar'></p>");

	            out.println("</form>");

	            
	            out.println("</body>");
	            out.println("</html>");
	        } finally {
	            out.close();
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

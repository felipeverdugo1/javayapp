package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.ProductoDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Item;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenerarFormulario
 */
@WebServlet("/GenerarFormulario")
public class GenerarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDao;

    /**
     * Default constructor. 
     */
    public GenerarFormulario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        try {
	        	itemDao = new ItemDAOImpl();
	        	List<Item> items = itemDao.listarTodos();
	        	HttpSession sesion = request.getSession(true);
				
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Calculadora de Costos para Boda</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Calculadora de Costos para Boda</h1>");
	            out.println("<form action='GenerarPresupuesto' method='post'>");
	            
	            
	            // Campos para cada ítem con sus precios


	            
	            out.println("<table border='1'>");
	            int cant;
	            String nombre;
	            Double precio;
	            for (Item item : items) {
	            	nombre = item.getNombre();
	            	precio = item.getPrecio();
	            	
	                out.println("<tr><td>" + nombre + " </td>");
	                out.println("<tr><td>" + precio+ " ($):</td>");
	     
	             ;
	            	
	            	
					if (sesion.getAttribute("cant" +nombre) == null) {
						sesion.setAttribute("cant" +nombre, 0);
					}

					cant = (Integer) sesion.getAttribute("cant" + nombre);
	            	



	    			out.println("<td><input type='number' name='cant' min='0' max='100' value='" + cant + "'></td>");    
	            }
	            out.println("</table>");
	            
	            out.println("<p><input type='submit' value='Calcular Costo Total'></p>");
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

package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Producto;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import dao.ProductoDAOImpl;



@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private ProductoDAOImpl productoDao = new ProductoDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Producto> productos = productoDao.listarTodos();
        request.setAttribute("productos", productos);
        for (Iterator<Producto> iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			System.out.println(producto);
			
		}
    }
}
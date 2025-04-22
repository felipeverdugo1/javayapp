package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Persona;

import java.io.IOException;
import java.io.PrintWriter;

import dao.PersonaDAO;
import dao.PersonaDAOImpl;

/**
 * Servlet implementation class Salir
 */
@WebServlet("/Salir")
public class Salir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PersonaDAO personaDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<HTML>");
		out.print("<HEAD><BODY>");
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			personaDAO = new PersonaDAOImpl();
			personaDAO.guardar(new Persona(nombre,email));
			out.print("<H1>Gracias por su compra!!</H1>");
			
			ses.invalidate();
			out.print("<a href='GenerarFormulario'>Salir</a>");
		} else
			response.sendRedirect("GenerarFormulario");

		out.print("</HEAD></BODY>");
		out.print("<HTML>");
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

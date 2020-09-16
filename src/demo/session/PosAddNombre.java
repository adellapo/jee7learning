package demo.session;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/posAddNombre")
public class PosAddNombre extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PosAddNombre() {
		super();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String nombre;
		HttpSession session;
		ArrayList<String> nombres;
		RequestDispatcher rd;

		// obtengo el input de nombre 'nombre'
		nombre = request.getParameter("nombre");
		
		// obtengo la sesion actual
		session = request.getSession();

		// obtengo la lista de nombres a partir de la sesion actual
		nombres = (ArrayList) session.getAttribute("nombres");

		// agrego el nuevo nombre a la lista
		nombres.add(nombre);
		
		// obtengo el RequestDispatcher del Servlet
		rd = request.getRequestDispatcher("preNombres");
		
		// lo redirecciono
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

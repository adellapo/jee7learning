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

@WebServlet("/posDelNombre")
public class PosDelNombre extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public PosDelNombre() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// variables
		int pos;
		HttpSession session;
		RequestDispatcher rd;
		ArrayList<String>nombres;
		
		// obtengo la posicion a borrar
		pos =Integer.parseInt( request.getParameter("pos") );
		
		// obtengo la sesion
		session = request.getSession();
		
		// obtengo el arraylist
		nombres = (ArrayList) session.getAttribute("nombres");
		
		// borro la posicion
		nombres.remove(pos);
		
		// devuelvo el ArrayList a la sesion
		session.setAttribute("nombres", nombres);
		
		// obtengo el RequestDispatcher
		rd = request.getRequestDispatcher("preNombres");
		
		// redirecciono
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

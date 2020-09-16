package demo.session;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/preNombres")
public class PreNombres extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public PreNombres() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//variables
		HttpSession session;
		ArrayList<String>nombres;
		
		// obtengo la sesion
		session = request.getSession();
		
		// obtengo los nombres para la sesion
		nombres = (ArrayList) session.getAttribute("nombres");
		
		// adjunto la lista al request
		request.setAttribute("nombres", nombres);
		
		// redirecciono
		request.getRequestDispatcher("nombres.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

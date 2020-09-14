package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesaForm
 */
@WebServlet("/ProcesaForm")
public class ProcesaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesaForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		
		pw.println("solo por POST amigo...");
		
		pw.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usr = request.getParameter("usr");
		String pwd = request.getParameter("pwd");
		String otro = request.getParameter("otroParam");

		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		
		pw.println("-- Recibi estos parametros --<br>");
		
		pw.println("user=" + usr + "<br>");
		
		pw.println("password=" + pwd + "<br>");

		pw.println("otroParam=" + otro + "<br>");
		
		pw.println("</body></html>");
	}

}

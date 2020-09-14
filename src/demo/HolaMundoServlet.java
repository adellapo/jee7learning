package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolaMundoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter w = response.getWriter();

		w.println("<html><body>");

		w.println("<h3>Hoy es: " + new Date() + "</h3>");

		w.println("<br/>");

		w.println("</p>" + request.getAuthType() + "</p>");
		w.println("</p>" + request.getCharacterEncoding() + "</p>");
		w.println("</p>" + request.getContentLength() + "</p>");
		w.println("</p>" + request.getContextPath()+ "</p>");
		Enumeration<String>e=request.getHeaderNames();
		while(e.hasMoreElements()) {
			w.println("</p>" + e.nextElement() + "</p>");
			
		}

		w.println("<br/>");

		w.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

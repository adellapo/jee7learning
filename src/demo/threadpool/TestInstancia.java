package demo.threadpool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testInstancia")
public class TestInstancia extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private int cont = 0;
	
    public TestInstancia() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		
		pw.println("Contador: " + cont++ + "<br>");
		
		pw.println("Instancia: " + this + "<br>");
		
		long threadID = Thread.currentThread().getId();
		
		pw.println("Thread ID: " + threadID + "<br>");

		pw.println("</body></html>");
	
		pw.close();
	}

}
//package demo.threadpool;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("testInstancia")
//public class TestInstancia extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	private int cont = 0;
//	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		PrintWriter pw = response.getWriter();
//		
//		pw.println("<html><body>");
//		
//		pw.println("Contador: " + cont++ + "<br>");
//		
//		pw.println("Instancia: " + this + "<br>");
//		
//		long threadID = Thread.currentThread().getId();
//		
//		pw.println("Thread ID: " + threadID + "<br>");
//
//		pw.println("</body></html>");
//	
//		pw.close();
//		
//	}
//	
//}

package demo.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "BackupFilter", urlPatterns = { "/*" })
public class BackupFilter implements Filter {

	public BackupFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// obtengo el calendario con la hora actual
		GregorianCalendar gc = new GregorianCalendar();

		// obtengo las horas
		int h = gc.get(GregorianCalendar.HOUR);
		
		// paso la hora de AM/PM a 00-24 hs, si es PM le agrego 12
		int offset = gc.get(GregorianCalendar.AM_PM) == Calendar.PM ? 12 : 0;
		
		// hora en formato 00-24hs
		int hora = h + offset;
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		if(hora >=10 && hora <=11) {
			request.getRequestDispatcher("EnMantenimiento.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	
	}

	public void destroy() {
	}

}

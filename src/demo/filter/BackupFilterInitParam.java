package demo.filter;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "desde", value = "15"),
		@WebInitParam(name = "hasta", value = "16") })
public class BackupFilterInitParam implements Filter {

	private int horaDesde;
	private int horaHasta;

	public BackupFilterInitParam() {
	}

	public void init(FilterConfig fConfig) throws ServletException {

		String desde = fConfig.getInitParameter("desde");
		String hasta = fConfig.getInitParameter("hasta");

		horaDesde = Integer.parseInt(desde);
		horaHasta = Integer.parseInt(hasta);

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		GregorianCalendar gc = new GregorianCalendar();

		int h = gc.get(GregorianCalendar.HOUR);

		int offset = gc.get(GregorianCalendar.AM_PM) == GregorianCalendar.PM ? 12 : 0;

		int hour = h + offset;

		if (hour >= horaDesde && hour <= horaHasta) {
			request.getRequestDispatcher("EnMantenimiento.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}

	}

}

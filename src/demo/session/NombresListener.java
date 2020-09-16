package demo.session;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class NombresListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ArrayList<String>nombres  = new ArrayList<String>();
		session.setAttribute("nombres", nombres);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}

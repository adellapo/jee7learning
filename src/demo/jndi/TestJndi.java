package demo.jndi;

import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class TestJndi {

	public static void main(String[] args) throws Exception {

		Context ctx = getInitialContext();
		
		JndiTreeInspector.inspect(ctx, "", new PrintWriter(System.out));
	
	}

	public static Context getInitialContext() throws Exception{
	
		Hashtable<String, String>p = new Hashtable<String, String>();
		
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		
		p.put(Context.PROVIDER_URL, "http://localhost:8080/tomee/ejb");

		p.put(Context.SECURITY_CREDENTIALS, "tomee");
		
		return new InitialContext(p);
	
	}
	
}

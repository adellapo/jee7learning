package demo.jndi;

import java.io.PrintWriter;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

public class JndiTreeInspector {

	public static void inspect(Context ctx, String name, PrintWriter pw) {

		pw.println(name);

		pw.flush();

		try {

			NamingEnumeration<Binding> e;

			e = ctx.listBindings(name);

			while (e.hasMoreElements()) {

				NameClassPair pair = e.next();

				inspect(ctx, name + pair.getName() + "/", pw);

			}
			
		} catch (Exception e) {

			return;
			
		}

	}

}

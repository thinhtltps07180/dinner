package tp.kits3.livedinner.connection;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionS {
	private static DataSource datasource;
	public static Connection conn;
	
	public ConnectionS() {
		conn = null;
		try {
			Context ctx = new InitialContext();
			// get info of Tomcat
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			// get info in context.xml
			datasource = (DataSource) envCtx.lookup("jdbc/mariadb");
			conn = datasource.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



 public class PSQLConnection{
public static final String DS_JNDI_NAME = "java:comp/env/jdbc/mallaDS";
 	public static Connection getConn() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DS_JNDI_NAME);
			conn = ds.getConnection();
		}
 catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs) {
		if (rs == null) {
			return;
		}
		try {
			rs.close();
		}
 catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		if (stmt == null) {
			return;
		}
		try {
			stmt.close();
		}
 catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		if (pstmt == null) {
			return;
		}
		try {
			pstmt.close();
		}
 catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		}
 catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollbackTransaction(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			if (!conn.isClosed()) {
				conn.rollback();
			}
		}
 catch (Exception e) {
			e.printStackTrace();
		}
	}

}

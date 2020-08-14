package tp.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.kits3.livedinner.vo.Tag;

public class TagDao {

	// Connection
	// CRUD
	// request to DB
	// return to Servlet

	private final String driver = "org.mariadb.jdbc.Driver";
	private final String url = "jdbc:mariadb://localhost:3306/livedinner";
	private final String id = "root";
	private final String pass = "20121996";
	Connection conn;

	// if you make default constructor
	// so make
	public TagDao() {
		super();
	}

	/*
	 * // public TagDao(String driver, String url) { // this.driver = driver; // //
	 * }
	 */
	protected void connectDB() {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			// e.printStackTrace();
			String message = "";
			message += TagDao.class.getSimpleName();
			message += " : connectDB()";
			System.out.println(message);
		}
	}

	public List<Tag> findAll() {
		// connect DB
		connectDB();
		//
		Statement stmt = null;
		ResultSet rs = null;
		String sql_selecAll = "select * from tag";
		List<Tag> list = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_selecAll);
			list = new ArrayList<Tag>();
			while (rs.next()) {
				Tag tag = new Tag();
				tag.setTagid(rs.getInt("tagid"));
				tag.setTgname(rs.getString("tgname"));
				list.add(tag);
			}
		} catch (Exception e) {
			e.printStackTrace();// show message about SQL error
		} finally {
			// if(rs != null) { rs.close(); }
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		// return to Servlet
		return list;
	}

	public void save(Tag tag) {
		// connect DB
		connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		String sql_insert = "insert into tag(tgname) values ('" + tag.getTgname() + "')";
		try {
			stmt = conn.createStatement();
			stmt.execute(sql_insert);
		} catch (Exception e) {
			e.printStackTrace();// show message about SQL error
		} finally {
			// if(rs != null) { rs.close(); }
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		// return to Servlet

	}

	public void update(Tag tag) {
		// insert , update
		if (tag.getTagid() == null || tag.getTagid() == 0) {
			System.out.println("can invok update stament");
			save(tag);
			return;
		}
		// connect DB
		connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		String sql_update = "update tag set tgbane = '" + tag.getTgname() + "'" + "where tagid = '" + tag.getTagid()
				+ "'";
		try {
			stmt = conn.createStatement();
			stmt.execute(sql_update);
		} catch (Exception e) {
			e.printStackTrace();// show message about SQL error
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		// return to Servlet

	}
}

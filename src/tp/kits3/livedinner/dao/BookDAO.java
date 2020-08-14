package tp.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// JNDI (Java Naming DI )
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tp.kits3.livedinner.vo.Book;

public class BookDAO {

	/*
	 * use DataSource and ConnectionPool
	 * 
	 */

	DataSource datasource;
	Connection conn;

	public BookDAO() {

		try {
			Context ctx = new InitialContext();
			// get info of Tomcat
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			// get info in context.xml
			this.datasource = (DataSource) envCtx.lookup("jdbc/mariadb");
			this.conn = this.datasource.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Book> findAll() {
		// if you don't close, your app die
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Book> list = new ArrayList<Book>();
		try {
			Connection conn = this.datasource.getConnection();
			String selectAll = "select * from book";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setBkid(rs.getInt("bkid"));
				book.setBkname(rs.getString("book"));
				book.setBkemail(rs.getString("bkemail"));
				book.setBkphone(rs.getString("bkphone"));
				book.setBktime(rs.getTimestamp("bktime"));
				book.setBknum(rs.getInt("bknum"));
				book.setBooking(rs.getString("booking"));
				book.setBkmemo(rs.getString("bkmemo"));

				list.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			rs.close();
			pstmt.close();
			conn.close(); // maxTotal="50"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // not null check .size() == 0 means empty list
	}

	public void save(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		try {

			conn = datasource.getConnection();
			String insert = "insert into book (bkname,bkemail,bkphone,bktime,bknum,booking,bkmemo) value(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getBkname());
			pstmt.setString(2, book.getBkemail());
			pstmt.setString(3, book.getBkphone());
			pstmt.setTimestamp(4, book.getBktime());
			pstmt.setInt(5, book.getBknum());
			pstmt.setString(6, book.getBooking());
			pstmt.setString(7, book.getBkmemo());

			pstmt.executeUpdate();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			try {
//				rs.close();
				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public Book findOne(int bkid) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Book book = null;
		try {
			Connection conn = this.datasource.getConnection();
			String selectOne = "select * from book where bkid=?";
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, bkid);
			rs = pstmt.executeQuery();

			// select one so use if
			if (rs.next()) {
				book = new Book();
				book.setBkid(rs.getInt("bkid"));
				book.setBkname(rs.getString("book"));
				book.setBkemail(rs.getString("bkemail"));
				book.setBkphone(rs.getString("bkphone"));
				book.setBktime(rs.getTimestamp("bktime"));
				book.setBknum(rs.getInt("bknum"));
				book.setBooking(rs.getString("booking"));
				book.setBkmemo(rs.getString("bkmemo"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return book;
	}

	public void update(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql_update = "Update book SET bkname=?, bkemail =?, bkphone=?, bktime=? , bknum=? ,booking=?,bkmemo=? WHERE bkid=?";
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, book.getBkname());
			pstmt.setString(2, book.getBkemail());
			pstmt.setString(3, book.getBkphone());
			pstmt.setTimestamp(4, book.getBktime());
			pstmt.setInt(5, book.getBknum());
			pstmt.setString(6, book.getBooking());
			pstmt.setString(7, book.getBkmemo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
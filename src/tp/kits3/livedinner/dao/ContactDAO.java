package tp.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tp.kits3.livedinner.vo.Contact;

public class ContactDAO {
	DataSource datasource;
	Connection conn;

	public ContactDAO() {

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

	public void save(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		try {

			conn = datasource.getConnection();
			String insert = "insert into contact (coname,priphone,subphone,email,address,unused,opening,weekday,weekend,aboutus,latitude,logitude) "
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, contact.getConame());
			pstmt.setString(2, contact.getPriphone());
			pstmt.setString(3, contact.getSubphone());
			pstmt.setString(4, contact.getEmail());
			pstmt.setString(5, contact.getAddress());
			pstmt.setBoolean(6, contact.getUnused());
			pstmt.setString(7, contact.getOpening());
			pstmt.setString(8, contact.getWeekday());
			pstmt.setString(9, contact.getWeekend());
			pstmt.setString(10, contact.getAboutus());
			pstmt.setDouble(11, contact.getLatitude());
			pstmt.setDouble(12, contact.getLogitude());
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

	public List<Contact> findAll() {
		// if you don't close, your app die
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Contact> list = new ArrayList<Contact>();
		try {
			Connection conn = this.datasource.getConnection();
			String selectAll = "select * from contact";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();
				contact.setCoid(rs.getInt("coid"));
				contact.setConame(rs.getString("coname"));
				contact.setPriphone(rs.getString("priphone"));		
				contact.setSubphone(rs.getString("subphone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setUnused(rs.getBoolean("unused"));
				contact.setOpening(rs.getString("opening"));
				contact.setWeekday(rs.getString("weekday"));
				contact.setWeekend(rs.getString("weekend"));
				contact.setAboutus(rs.getString("aboutus"));
				contact.setLatitude(rs.getDouble("latitude"));
				contact.setLogitude(rs.getDouble("logitude"));
				list.add(contact);

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

	public Contact findOne(int contactId) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Contact contact = null;
		try {
			Connection conn = this.datasource.getConnection();
			String selectOne = "select * from contact where coid=?";
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, contactId);
			rs = pstmt.executeQuery();

			// select one so use if
			if (rs.next()) {
				contact = new Contact();
				contact.setCoid(rs.getInt("coid"));
				contact.setConame(rs.getString("coname"));
				contact.setPriphone(rs.getString("priphone"));
				contact.setSubphone(rs.getString("subphone"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setUnused(rs.getBoolean("unused"));
				contact.setOpening(rs.getString("opening"));
				contact.setWeekday(rs.getString("weekday"));
				contact.setWeekend(rs.getString("weekend"));
				contact.setAboutus(rs.getString("aboutus"));
				contact.setLatitude(rs.getDouble("latitude"));
				contact.setLogitude(rs.getDouble("logitude"));
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
		return contact;
	}

	public void update(Contact contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql_update = "Update contact SET coname=?, priphone =? , subphone=? , email=? , address=?,unused=?,opening=?,weekday=?,"
					+ "weekend=?,aboutus=?,latitude=?,logitude=? WHERE coid=?";
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, contact.getConame());
			pstmt.setString(2, contact.getPriphone());
			pstmt.setString(3, contact.getSubphone());
			pstmt.setString(4, contact.getEmail());
			pstmt.setString(5, contact.getAddress());
			pstmt.setBoolean(6, contact.getUnused());
			pstmt.setString(7, contact.getOpening());
			pstmt.setString(8, contact.getWeekday());
			pstmt.setString(9, contact.getWeekend());
			pstmt.setString(10, contact.getAboutus());
			pstmt.setDouble(11, contact.getLatitude());
			pstmt.setDouble(12, contact.getLogitude());
			pstmt.setInt(13, contact.getCoid());
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

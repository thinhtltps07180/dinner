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

import tp.kits3.livedinner.vo.Category;
import tp.kits3.livedinner.vo.Menu;

public class MenuDAO {
//
//	/*
//	 * use DataSource and ConnectionPool
//	 * 
//	 */
//
//	
//
//	public List<Menu> findAll() {
//		// if you don't close, your app die
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		List<Menu> list = new ArrayList<Menu>();
//		try {
//			Connection conn = this.datasource.getConnection();
//			String selectAll = "select * from menu";
//			pstmt = conn.prepareStatement(selectAll);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				Menu menu = new Menu();
//				menu.setMuid(rs.getInt("muid"));
//				menu.setCtgid(rs.getInt("ctgid"));
//				menu.setMuname(rs.getString("muname"));
//				menu.setIntro(rs.getString("intro"));
//				menu.setDetails(rs.getString("details"));
//				menu.setPrice(rs.getDouble("price"));
//				menu.setCurrency(rs.getString("currency"));
//				list.add(menu);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			rs.close();
//			pstmt.close();
//			conn.close(); // maxTotal="50"
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list; // not null check .size() == 0 means empty list
//	}
//
//	public void save(Menu menu) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
////		ResultSet rs = null;
//		try {
//
//			conn = datasource.getConnection();
//			String insert = "insert into menu (ctgid,muname,intro,details,price,currency) value(?,?,?,?,?,?)";
//			pstmt = conn.prepareStatement(insert);
//			pstmt.setInt(1, menu.getCtgid());
//			pstmt.setString(2, menu.getMuname());
//			pstmt.setString(3, menu.getIntro());
//			pstmt.setString(4, menu.getDetails());
//			pstmt.setDouble(5, menu.getPrice());
//			pstmt.setString(6, menu.getCurrency());
//			pstmt.executeUpdate();
//
//		} catch (Exception ex) {
//
//			ex.printStackTrace();
//		} finally {
//			try {
////				rs.close();
//				pstmt.close();
//				conn.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	public Category findOne(int muid) {
//
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		Category category = null;
//		try {
//			Connection conn = this.datasource.getConnection();
//			String selectOne = "select * from menu where muid=?";
//			pstmt = conn.prepareStatement(selectOne);
//			pstmt.setInt(1, muid);
//			rs = pstmt.executeQuery();
//
//			// select one so use if
//			if (rs.next()) {
//				Menu menu = new Menu();
//				menu.setMuid(rs.getInt("muid"));
//				menu.setCtgid(rs.getInt("ctgid"));
//				menu.setMuname(rs.getString("muname"));
//				menu.setIntro(rs.getString("intro"));
//				menu.setDetails(rs.getString("details"));
//				menu.setPrice(rs.getDouble("price"));
//				menu.setCurrency(rs.getString("currency"));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				rs.close();
//				pstmt.close();
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return category;
//	}
//
//	public void update(Menu menu) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = datasource.getConnection();
//			String sql_update = "Update cateory SET ctgid=?, muname =? , intro=? , details=? price=? currency=? WHERE muid=?";
//			pstmt = conn.prepareStatement(sql_update);
//			pstmt.setInt(1, menu.getCtgid());
//			pstmt.setString(2, menu.getMuname());
//			pstmt.setString(3, menu.getIntro());
//			pstmt.setString(4, menu.getDetails());
//			pstmt.setDouble(5, menu.getPrice());
//			pstmt.setString(6, menu.getCurrency());
//			pstmt.setInt(7, menu.getMuid());
//			pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

}
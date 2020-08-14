package tp.kits3.livedinner.dao.IDaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import tp.kits3.livedinner.connection.ConnectionS;
import tp.kits3.livedinner.dao.IDao.IMenu;
import tp.kits3.livedinner.vo.Menu;

public class MenuImpl extends ConnectionS implements IMenu {

	@Override
	public List<Menu> findAll() {
		// if you don't close, your app die
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Menu> list = new ArrayList<Menu>();
		try {
			String selectAll = "select * from menu";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();
				menu.setMuid(rs.getInt("muid"));
				menu.setCtgid(rs.getInt("ctgid"));
				menu.setMuname(rs.getString("muname"));
				menu.setIntro(rs.getString("intro"));
				menu.setDetails(rs.getString("details"));
				menu.setPrice(rs.getDouble("price"));
				menu.setCurrency(rs.getString("currency"));
				list.add(menu);

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

	@Override
	public void save(Menu menu) {
		ServletContext app ;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			String insert = "insert into menu (ctgid,muname,intro,details,price,currency,img) value(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, menu.getCtgid());
			pstmt.setString(2, menu.getMuname());
			pstmt.setString(3, menu.getIntro());
			pstmt.setString(4, menu.getDetails());
			pstmt.setDouble(5, menu.getPrice());
			pstmt.setString(6, menu.getCurrency());
			pstmt.setString(7, menu.getImg());
			pstmt.executeUpdate();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public Menu findOne(int muid) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Menu menu = null;
		try {
			String selectOne = "select * from menu where muid=?";
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, muid);
			rs = pstmt.executeQuery();

			// select one so use if
			if (rs.next()) {
				menu = new Menu();
				menu.setMuid(rs.getInt("muid"));
				menu.setCtgid(rs.getInt("ctgid"));
				menu.setMuname(rs.getString("muname"));
				menu.setIntro(rs.getString("intro"));
				menu.setDetails(rs.getString("details"));
				menu.setPrice(rs.getDouble("price"));
				menu.setCurrency(rs.getString("currency"));

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
		return menu;
	}

	@Override
	public void update(Menu menu) {
		PreparedStatement pstmt = null;

		try {
			String sql_update = "Update cateory SET ctgid=?, muname =? , intro=? , details=? price=? currency=? WHERE muid=?";
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, menu.getCtgid());
			pstmt.setString(2, menu.getMuname());
			pstmt.setString(3, menu.getIntro());
			pstmt.setString(4, menu.getDetails());
			pstmt.setDouble(5, menu.getPrice());
			pstmt.setString(6, menu.getCurrency());
			pstmt.setInt(7, menu.getMuid());
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

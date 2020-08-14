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
import tp.kits3.livedinner.vo.Post;

public class PostDAO {

	/*
	 * use DataSource and ConnectionPool
	 * 
	 */

	DataSource datasource;
	Connection conn;

	public PostDAO() {

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

	public List<Post> findAll() {
		// if you don't close, your app die
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Post> list = new ArrayList<Post>();
		try {
			Connection conn = this.datasource.getConnection();
			String selectAll = "select * from post";
			pstmt = conn.prepareStatement(selectAll);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Post Post = new Post();
				Post.setPid(rs.getInt("pid"));
				Post.setTitle(rs.getString("title"));
				Post.setByname(rs.getString("byname"));
				Post.setRegdate(rs.getTimestamp("regdate"));
				Post.setContent(rs.getString("content"));
				Post.setVisible(rs.getBoolean("visible"));
				Post.setTagid(rs.getInt("tagid"));
				list.add(Post);

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

	public void save(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		try {

			conn = datasource.getConnection();
			String insert = "insert into post (title,byname,regdate,content,visible,tagid) value(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getByname());
			pstmt.setTimestamp(3, post.getRegdate());
			pstmt.setString(4, post.getContent());
			pstmt.setBoolean(5, post.getVisible());
			pstmt.setInt(6, post.getTagid());
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

	public Category findOne(int pid) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Category category = null;
		try {
			Connection conn = this.datasource.getConnection();
			String selectOne = "select * from post where pid=?";
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			// select one so use if
			if (rs.next()) {
				Post Post = new Post();
				Post.setPid(rs.getInt("pid"));
				Post.setTitle(rs.getString("title"));
				Post.setByname(rs.getString("byname"));
				Post.setRegdate(rs.getTimestamp("regdate"));
				Post.setContent(rs.getString("content"));
				Post.setVisible(rs.getBoolean("visible"));
				Post.setTagid(rs.getInt("tagid"));

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
		return category;
	}

	public void update(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql_update = "Update post SET title=?, byname =? , regdate=? , content=? visible=? tagid=? WHERE pid=?";
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getByname());
			pstmt.setTimestamp(3, post.getRegdate());
			pstmt.setString(4, post.getContent());
			pstmt.setBoolean(5, post.getVisible());
			pstmt.setInt(6, post.getTagid());
			pstmt.setInt(7, post.getPid());
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
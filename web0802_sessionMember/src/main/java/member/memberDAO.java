package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class memberDAO {
	private PreparedStatement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	String member_LOGIN = "select count(*) from member where id=? and pw=?";
	String member_SIGNUP = "insert into member(id, pw, name) values(?, ?, ?)";
	String member_IDCHECK = "select * from member where id=?";
	
	public void insertIdCheck(String id) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_IDCHECK);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs);
		}
	}
	
	public void insertMember(memberDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_SIGNUP);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs);
		}
	}
	
	public boolean loginMember(String id, String pw) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

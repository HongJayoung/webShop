package com.kosta.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosta.dto.UserVO;
import com.kosta.util.DBUtil;
import com.kosta.util.LogPreparedStatement;

public class UserDAO {
	Connection conn;
	LogPreparedStatement pst;
	ResultSet rs;
	
	public UserVO selectById(String user_id, String user_pass) {
		UserVO user = null;
		conn = DBUtil.getConnection();
		try {
			pst = new LogPreparedStatement(conn, "select user_name, phone from tbl_users where user_id = ? and user_pass = ?");
			pst.setString(1, user_id);
			pst.setString(2, user_pass);
			//System.out.println(pst);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				user = new UserVO(user_id, rs.getString(1), user_pass, rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
	
		return user;
	}
}

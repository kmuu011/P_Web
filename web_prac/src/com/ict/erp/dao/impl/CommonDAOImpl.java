package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.CommonDAO;

public class CommonDAOImpl implements CommonDAO{
	
	protected Connection con;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	
	@Override
	public void setConnection(Connection con) {
		this.con = con;		
	}
	
	@Override
	public void close() throws SQLException{
		
			if(ps != null) {
				ps.close();
			}
			
			if(rs != null) {
				rs.close();
			}

	}

	@Override
	public int totalCnt(String tableName, String sch, String op) throws SQLException {
		
		
		String sql = "select count(1) from " + tableName;
		
		try {
			
		if(sch !=null && !sch.trim().equals("")) {
			if(op.equals("diNum")) {
				sql = "select count(1) from "+ tableName + " where dinum like '%' || ? || '%'";
			} else if(op.equals("diCode")) {
				sql = "select count(1) from "+ tableName + " where dicode like '%' || ? || '%'";
			} else if(op.equals("diName")) {
				sql = "select count(1) from "+ tableName + " where diname like '%' || ? || '%'";
			} else if(op.equals("diDesc")) {
				sql = "select count(1) from "+ tableName + " where didesc like '%' || ? || '%'";
			} 
			
			ps = con.prepareStatement(sql);
			
			if(op.equals("diNum")) {
				ps.setInt(1, Integer.parseInt(sch));
			} else if(op.equals("diCode")) {
				ps.setString(1, sch);
			} else if(op.equals("diName")) {
				ps.setString(1, sch);
			} else if(op.equals("diDesc")) {
				ps.setString(1, sch);
			}
			
		}else {
			ps = con.prepareStatement(sql);
		}
		
			rs = ps.executeQuery();
			rs.next();
			
			return rs.getInt(1);
			
			
		}catch(SQLException e) {
			throw e;
		} finally {
			if(ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		
		
	}



}

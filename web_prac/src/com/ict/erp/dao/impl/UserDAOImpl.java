package com.ict.erp.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ict.erp.dao.UserDAO;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class UserDAOImpl extends CommonDAOImpl implements UserDAO{
	
	@Override
	public List<DepartInfo> selectDepartInfo(DepartInfo di) throws SQLException {
		List<DepartInfo> departInfo = null; 
		PageInfo pi = di.getPageInfo();
		
		
		try {
			
			String sql = "select * from("
					+ "select di.*, rownum as rNum from("
					+ "select * from p_depart_info order by dinum desc)"
					+ "di where rownum<=?)"
					+ " where rNum>=?";
			if(pi.getSch() !=null && !pi.getSch().trim().equals("")) {
				sql = "select * from("
						+ "select * from("
						+ "select di.*, rownum as rNum from("
						+ "select * from p_depart_info order by dinum desc) ";
				
				if(pi.getOp().equals("diNum")) {
					sql += "di where dinum like '%' || ? || '%') where rNum<=?) where rNum>=?";
				} else if(pi.getOp().equals("diCode")) {
					sql += "di where dicode like '%' || ? || '%') where rNum<=?) where rNum>=?";
				} else if(pi.getOp().equals("diName")) {
					sql += "di where diname like '%' || ? || '%') where rNum<=?) where rNum>=?";
				} else if(pi.getOp().equals("diDesc")) {
					sql += "di where didesc like '%' || ? || '%') where rNum<=?) where rNum>=?";
				}
				
				ps = con.prepareStatement(sql);
				
				if(pi.getOp().equals("diNum")) {
					ps.setInt(1, Integer.parseInt(pi.getSch()));
				} else if(pi.getOp().equals("diCode")) {
					ps.setString(1, pi.getSch());
				} else if(pi.getOp().equals("diName")) {
					ps.setString(1, pi.getSch());
				} else if(pi.getOp().equals("diDesc")) {
					ps.setString(1, pi.getSch());
				}
				
				ps.setInt(2, pi.getLastData());
				ps.setInt(3, pi.getFirstData());
				
				
			}else {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pi.getLastData());
			ps.setInt(2, pi.getFirstData());
			}
			
			rs = ps.executeQuery();
			
			departInfo = new ArrayList<DepartInfo>();
			
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"), rs.getString("didesc"));
				departInfo.add(di);
				
			}
		
		} catch(SQLException e) {
			throw e;
		} finally {
			close();
		}

		return departInfo;
	}

	@Override
	public int insertDepartInfo(List<DepartInfo> departInfoList) throws SQLException {
		
		String sql = "insert into p_depart_info values(p_di_seq.nextval, ?, ?, ?)";
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			for(DepartInfo di : departInfoList) {
				ps.setString(1, di.getDiCode());
				ps.setString(2, di.getDiName());
				ps.setString(3, di.getDiDesc());
				
				result += ps.executeUpdate();
			}
			
			
		}catch (SQLException e) {
			throw e;
		} finally {
			
			close();
			
		}
		
		return result;
	}

	@Override
	public int deleteDepartInfo(List<Integer> chkNum) throws SQLException {
		
		int result = 0;
		int cnt = chkNum.size();
		String sql = "delete from p_depart_info where dinum=?";
		
		try {
			ps = con.prepareStatement(sql);
			
			for(int num:chkNum) {
				ps.setInt(1, num);
				result += ps.executeUpdate();
			}
			
		}catch(SQLException e) {
			throw e;
			
		} finally {

			close();
		}
		
		if(result == cnt) {
			return result;
		}
		
		return -1;
	}

	@Override
	public DepartInfo selectDepartView(int diNum) throws SQLException {
		String sql = "select * from p_depart_info where dinum=?";
		DepartInfo di = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"), rs.getString("didesc"));
			}
			
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
		
		return di;
	}

}

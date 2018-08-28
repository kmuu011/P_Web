package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.UserDAO;
import com.ict.erp.dao.impl.UserDAOImpl;
import com.ict.erp.service.UserService;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class UserServiceImpl implements UserService{
	UserDAO ud = new UserDAOImpl();

	@Override
	public List<DepartInfo> getDepartInfo(DepartInfo di) throws SQLException {
		PageInfo pi = di.getPageInfo();
		ud.setConnection(DBCon.getCon());
		List<DepartInfo> dil = null;
		try {
			if(pi.getSch() !=null && !pi.getSch().trim().equals("")) {
				pi.paging(ud.totalCnt("p_depart_info", pi.getSch(), pi.getOp()), 5, 5);
			}else {
				pi.paging(ud.totalCnt("p_depart_info", null, null), 5, 5);
			}
			
			dil = ud.selectDepartInfo(di);
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
		return dil;
	}

	@Override
	public int getInsertResult(List<DepartInfo> departInfoList) throws SQLException {
		ud.setConnection(DBCon.getCon());
		int result = 0; 
		
		try {
			result = ud.insertDepartInfo(departInfoList);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}

		return result;
	}

	@Override
	public int getRemoveResult(String[] chk) throws SQLException {
		List<Integer> chkNum = new ArrayList<Integer>();
		ud.setConnection(DBCon.getCon());
		int result = 0;
		
		try {
			
			for(String c : chk) {
				chkNum.add(Integer.parseInt(c));
			}
			
			result = ud.deleteDepartInfo(chkNum);
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		return result;
	}

	@Override
	public DepartInfo getView(int diNum) throws SQLException {
		ud.setConnection(DBCon.getCon());
		DepartInfo di = null;
		try {
			di = ud.selectDepartView(diNum);
			
		}catch(SQLException e) {
			throw e;
			
		}finally {
			DBCon.closeCon();
		}
		
		return di;
	}

}

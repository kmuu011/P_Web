package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.DepartInfo;

public interface UserDAO extends CommonDAO{
	public List<DepartInfo> selectDepartInfo(DepartInfo di) throws SQLException;
	public int insertDepartInfo(List<DepartInfo> departInfoList) throws SQLException;
	public int deleteDepartInfo(List<Integer> chkNum) throws SQLException;
	public DepartInfo selectDepartView(int diNum) throws SQLException;

}

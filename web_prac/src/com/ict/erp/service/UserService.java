package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.DepartInfo;

public interface UserService {
	public List<DepartInfo> getDepartInfo(DepartInfo di) throws SQLException;
	public int getInsertResult(List<DepartInfo> departInfoList) throws SQLException;
	public int getRemoveResult(String[] chk) throws SQLException;
	public DepartInfo getView(int diNum) throws SQLException;

}

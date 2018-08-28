package com.ict.erp.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface CommonDAO {
	public void setConnection(Connection con);
	public void close() throws SQLException;
	public int totalCnt(String tableName, String sch, String op) throws SQLException;

}

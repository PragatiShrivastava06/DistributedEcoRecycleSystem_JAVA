/**
 * @author Pragati Shrivastava
 * @version 1.0
 */
package com.project.connections;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.event.batch.Event;


public class ScuDbConn {

	public boolean deleteFromDB(String sql) {
		Statement stmt;
		boolean isDeleted;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.execute(sql);
			isDeleted = true;
		} catch (Exception e) {
			isDeleted = false;
			System.out.println("Error at deleteFromDB() in ScuDbConn.java");
			e.printStackTrace();
		}
		return isDeleted;
	}

	public boolean updateToDB(String sql) {
		Statement stmt;
		boolean isUpdate;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.executeUpdate(sql);
			isUpdate = true;
		} catch (Exception e) {
			isUpdate = false;
			System.out.println("Error at updateToDB() in ScuDbConn.java");
			e.printStackTrace();
		}
		return isUpdate;
	}

	public boolean insertIntoDB(String sql) {
		Statement stmt;
		boolean isInsert;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.execute(sql);
			isInsert = true;
		} catch (Exception e) {
			isInsert = false;
			System.out.println("Error at insertIntoDB() in ScuDbConn.java");
		}
		return isInsert;
	}

	public String getValueFromSql(String sql) {
		String output = null;
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				output = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	public Map<String, String> getKeyValueFromSql(String sqlavailability) {

		Map<String, String> output = new HashMap<String, String>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlavailability);
			while (rs.next()) {
				output.put("\n"+rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;

	}

	public ResultSet getResultSet(String sql) {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = DBConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * Desc : This method will give list of first column
	 * @param sql
	 * @return List
	 */
	public List<String> getListOfFirstClm(String sql) {
		ArrayList<String> outList = new ArrayList<String>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				outList.add(rs.getString(1));//adds all rows for first column (rcmid)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

	/**
	 * @param sql
	 * @return List
	 */
	public List<Event> getEventList(String sql) {
		ArrayList<Event> outList = new ArrayList<Event>();
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Event tempEvent = new Event();
				tempEvent.setId(rs.getInt("ID"));
				tempEvent.setRcmId(rs.getInt("RCMID"));
				tempEvent.setEvent(rs.getString("EVENT"));
				tempEvent.setDetails(rs.getString("DETAILS"));
				outList.add(tempEvent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outList;
	}

}

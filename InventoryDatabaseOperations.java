package com.cmr.prj.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.util.DBConnection;
public class InventoryDatabaseOperations {

	public List<InventoryRecord> getallrecords() {

		List<InventoryRecord> Inventorylist = new ArrayList<InventoryRecord>();

		try {
			Connection con = DBConnection.getConnection();
			// Step 3: create a statement
			// Statement stmt = con.createStatement(); --> syntax to create statement

			final String SQLQUERY = "select * from Inventory";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			System.out.println("Prepared Statement is created successfully........");

			// Step 4: Execute statement
			// Problem statement : fetch the data from database
			// we are using SELECT statement
			// DRL ---> call executeQuery() method
			// final String SQLQUERY = "select * from coursestudent";
			// ResultSet rs = stmt.executeQuery(SQLQUERY);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Statement executed successfully.......");

			// Step 5: Process the ResultSet
			// Result set conains multiple rows,
			// that is why we are using while loop to retrieve the data from individual row
			// Every row contains list of columns,
			// to retrieve the value from an individual column, we are using getX(Y) Methods
			// where X is the Java datatype
			// Y is the argument we need to pass which refers the index of column or name of
			// the column

			while (rs.next()) {
				InventoryRecord stud = new InventoryRecord();
				stud.setId(rs.getInt(1));
				stud.setSupplierid(rs.getInt(2));
				stud.setItemid(rs.getInt(3));
				stud.setItemssupplied(rs.getInt(4));

				Inventorylist.add(stud);

			}

			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return Inventorylist;

	}	
	
public int insertrecord(int id,int supplierid,int itemsid,int itemsleft) {
		
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		
		try {
			// Step 3:
			final String SQLQUERY = "insert into Inventory values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			
			// step 4:
			
			// Step 4.1 ---> Inject the value of ? to prepared statement query
			pstmt.setInt(1, id);
			pstmt.setInt(2,supplierid);
			pstmt.setInt(3,itemsid);
			pstmt.setInt(4,itemsleft);
			
			// Step 4.2 ---> call executeQuery()
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}

public int updateinventory(InventoryRecord stud) {

	int res=0;

	try {
		Connection con = DBConnection.getConnection();
		// Step 3: create a statement
		// Statement stmt = con.createStatement(); --> syntax to create statement

		final String SQLQUERY = "update inventory set supplierid=?,itemid=?,itemssupplied=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
		System.out.println("Prepared Statement is created successfully........");

		// Step 4: Execute statement
		// Problem statement : fetch the data from database
		// we are using SELECT statement
		// DRL ---> call executeQuery() method
		// final String SQLQUERY = "select * from coursestudent";
		// ResultSet rs = stmt.executeQuery(SQLQUERY);
		
		// Injected the values to prepared statement
		//pstmt.setInt(1,stud.getId());
		pstmt.setInt(1, stud.getSupplierid());
		pstmt.setInt(2,stud.getItemid());
		pstmt.setInt(3, stud.getItemssupplied());
		pstmt.setInt(4,stud.getId());
		
		// Call the Execute Update method
		res = pstmt.executeUpdate();
		System.out.println("Statement executed successfully.......");

		

		
	} catch (SQLException e) {
		System.out.println(e);
	}
	System.out.println(res);
	return res;

}

public int deleterecord(int sid) {

	int res=0;

	try {
		Connection con = DBConnection.getConnection();
		// Step 3: create a statement
		// Statement stmt = con.createStatement(); --> syntax to create statement

		final String SQLQUERY = "delete from inventory where id=?";
		PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
		System.out.println("Prepared Statement is created successfully........");

		// Step 4: Execute statement
		// Problem statement : fetch the data from database
		// we are using SELECT statement
		// DRL ---> call executeQuery() method
		// final String SQLQUERY = "select * from coursestudent";
		// ResultSet rs = stmt.executeQuery(SQLQUERY);
		
		// Injected the values to prepared statement
		pstmt.setInt(1, sid);
		
		
		// Call the Execute Update method
		res = pstmt.executeUpdate();
		System.out.println("Statement executed successfully.......");

		

		
	} catch (SQLException e) {
		System.out.println(e);
	}
	return res;

}


}

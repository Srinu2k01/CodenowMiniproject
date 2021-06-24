package com.cmr.prj.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cmr.prj.util.SupplierRecord;
import com.cmr.prj.util.DBConnection;
//import com.cmr.prj.util.InventoryRecord;
//import com.cmr.prj.util.InventoryRecord;

public class SupplierDatabaseOperations {
	
	public List<SupplierRecord> getallrecords() {

		List<SupplierRecord> Supplierlist = new ArrayList<SupplierRecord>();

		try {
			Connection con = DBConnection.getConnection();
			// Step 3: create a statement
			// Statement stmt = con.createStatement(); --> syntax to create statement

			final String SQLQUERY = "select * from Supplier";
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
				SupplierRecord stud = new SupplierRecord();
				stud.setSupplierid(rs.getInt(1));
				stud.setSuppliername(rs.getString(2));
				

				Supplierlist.add(stud);

			}

			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return Supplierlist;

	}		
	
public int insertrecord(int supplierid,String suppliername) {
		
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		
		try {
			// Step 3:
			final String SQLQUERY = "insert into Supplier values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			
			// step 4:
			
			// Step 4.1 ---> Inject the value of ? to prepared statement query
			pstmt.setInt(1, supplierid);
			pstmt.setString(2,suppliername);
			
			
			// Step 4.2 ---> call executeQuery()
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}
	

public int updatesupplier(SupplierRecord stud) {

	int res=0;

	try {
		Connection con = DBConnection.getConnection();
		// Step 3: create a statement
		// Statement stmt = con.createStatement(); --> syntax to create statement

		final String SQLQUERY = "update supplier set sname=? where supplierid=?";
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
		pstmt.setString(1, stud.getSuppliername());
		pstmt.setInt(2,stud.getSupplierid());
		
		
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

		final String SQLQUERY = "delete from supplier where supplierid=?";
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

package com.git.apiautomation.cancel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDBRecords extends CancelService {

	
	public static ResultSet runquery() throws Exception { 
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		System.out.println("Connecting to DB...........");  
  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(ENV.CONSTRING(), ENV.USR(), ENV.PWD());  
		System.out.println("Connected to DB");  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		System.out.println("Executing the Query...........");  

		ResultSet rs=stmt.executeQuery(ENV.CANCELQUERY());  
		System.out.println("Query Executed...........");  

			return rs;
			  
			} 

			}  


package com.git.apiautomation.cancel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CancelService

{
	public static Environment ENV;

	@BeforeTest(alwaysRun = true)
	@Parameters({ "environment" })
	public void beforeTest(String environment) {
		System.out.println(environment);
		ConfigFactory.setProperty("env", environment);
		System.out.println(ConfigFactory.setProperty("env", environment));
		ENV = ConfigFactory.create(Environment.class);
	}

	@Test
	public void cancelres() throws SQLException, Exception

	{
		RestAssured.baseURI = ENV.HOST();
		RestAssured.port = ENV.PORT();
		

		ResultSet result= GetDBRecords.runquery();
			
		while(result.next())
		{
		String record = result.getString(3);
		System.out.println("record::::::  " + record);
		RestAssured.given()
				.contentType(ContentType.JSON)
				.headers("Key1","Value1","Key2","Value2")
				.patch(ENV.PATH()+record+ENV.CLPARAM())
				.then().log().all();
		}
	}
}

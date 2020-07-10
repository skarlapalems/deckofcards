package com.swetha.deckofcards.test;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.swetha.deckofcards.util.DataUtil;

import io.restassured.RestAssured;

public class TestSuiteSetup {

	@BeforeSuite
	public void init() {
		Reporter.log("Initializing Test Suite ...",true);
		String serverUrl = DataUtil.getValue("serverurl");
		RestAssured.baseURI = serverUrl;
		
	}
}

package com.login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
	@BeforeClass
	private void tc1() {
		System.out.println("B");
	}
	@BeforeMethod
	private void tc2() {
		System.out.println("a");
	}
	@Test
	private void tc3() {
		System.out.println("l");
	}
	@AfterMethod
	private void tc4() {
		System.out.println("m");
	}
	@AfterClass
	private void tc5() {
		System.out.println("u");
	}
}

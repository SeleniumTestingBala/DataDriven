package com.login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit {
	@BeforeClass
	public static void tc1() {
		System.out.println("Apple");
	
	}
	@Before
	public void tc2() {
		System.out.println("Baby");
	}
	@Test
	public void tc3() {
		System.out.println("car");
	}
	@After
	public void tc4() {
		System.out.println("Driver");
	}
	@AfterClass
	public static void tc5() {
		System.out.println("Ego");
	}

}

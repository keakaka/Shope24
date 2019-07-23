package com.cafe24.shope24.controller.api;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	MemberControllerTest.class
})
public class TestCaller {
	
	@AfterClass
    public static void globalAfterClass() {
		
    }
}

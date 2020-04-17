package com.bhoomi.userServices;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppTestBase {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
    @BeforeEach
    public void setUp() throws Exception {
		try {
			log("Test Case started");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error Occurred while initiating the test");
		}
    }
    
   

    @AfterEach
    public void tearDown() throws Exception {
    	log("Test Case Ended");
    }

    public void log(String format,Object ... args){
    	logger.info(String.format(format, args));
    }
    
    public void error(Exception e) {
    	logger.error("",e);
	}
    
    public void error(Throwable e,String format,Object ... args) {
    	logger.error(String.format(format, args),e);
	}
}

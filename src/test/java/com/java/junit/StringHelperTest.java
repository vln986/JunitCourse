package com.java.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class StringHelperTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(StringHelper.class);
	
	StringHelper sh;
	
	@BeforeTestClass
	public static void beforeClass() {
		LOGGER.info("*************** Before class ************");
	}
	public static void afterClass() {
		LOGGER.info("*************** After class **************");
	}
	
	@BeforeEach
	public void setup() {
		LOGGER.info("***********  Creating instance for StringHelper **************");
		sh = new StringHelper();
	}

	@Test
	public void truncateAInFirst2PositionsTest() {
	//	fail("Not yet implemented");
		assertEquals("CD", sh.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", sh.truncateAInFirst2Positions("ACD"));
	}
	@Test
	public void areFirstAndLastTwoCharactersTheSameTest() {
		assertFalse(sh.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	@Test
	public void areFirstAndLastTwoCharactersTheSameTrueTest() {
		assertTrue(sh.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void arrayTest() {
		int[] expected = {1,2,3,4,5};
		int[] numbers = {2,4,3,1,5};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	@Test//(expected = NullPointerException.class)
	public void arrayNPETest() {
		int[] expected = {1,2,3,4,5};
		int[] numbers = {2,4,3,1,5};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}


}

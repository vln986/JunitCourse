package com.java.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(StringHelperParameterizedTest.class);

	StringHelper sh;

	private String input;
	private String expectedOutput;

	public StringHelperParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = { { "AACD", "CD" }, { "ACD", "CD" } };
		return Arrays.asList(expectedOutputs);
	}

	@BeforeTestClass
	public static void beforeClass() {
		LOGGER.info("*************** Before class ************");
	}

	@AfterClass
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
		// fail("Not yet implemented");
		assertEquals(expectedOutput, sh.truncateAInFirst2Positions(input));
		assertEquals(expectedOutput, sh.truncateAInFirst2Positions(input));
	}
}

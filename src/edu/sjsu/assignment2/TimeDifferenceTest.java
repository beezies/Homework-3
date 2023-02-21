package edu.sjsu.assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class TimeDifferenceTest {

	@Test
	public void test_calc_time_diff() {
		int time1 = 1230;
		int time2 = 2345;
		String expected = "11 hour(s) 15 minute(s)";

		assertEquals(expected, TimeDifference.calculateTimeDifference(time1, time2));
	}

	@Test
	public void test_calc_time_diff_second_time_larger() {
		int time1 = 2345;
		int time2 = 1230;
		String expected = "12 hour(s) 45 minute(s)";

		assertEquals(expected, TimeDifference.calculateTimeDifference(time1, time2));
	}

	@Test
	public void test_time_formatted() {
		String time = "2345";
		boolean exceptionThrown = true;
		int intTime = 0;

		try {
			intTime = TimeDifference.timeFormatted(time);
			exceptionThrown = false;
		} catch (Exception e) {
		}

		assertEquals(intTime, 2345);
		assertFalse(exceptionThrown);
	}

	@Test
	public void test_time_formatted_nan() {
		String nan = "hi";
		boolean exceptionThrown = false;
		try {
			TimeDifference.timeFormatted(nan);
		} catch (NumberFormatException e) {
			exceptionThrown = true;
		} catch (Exception e) {
		}
		assertTrue(exceptionThrown);
	}

	@Test
	public void test_time_formatted_invalid_formats() {
		String tooLarge = "2400";
		String negative = "-1000";
		String invalidMinutes = "2361";

		assertTrue(illegal_arg_thrown(tooLarge));
		assertTrue(illegal_arg_thrown(negative));
		assertTrue(illegal_arg_thrown(invalidMinutes));
	}

	public boolean illegal_arg_thrown(String time) {
		boolean exceptionThrown = false;
		try {
			TimeDifference.timeFormatted(time);
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		} catch (Exception e) {
		}

		return exceptionThrown;
	}

}

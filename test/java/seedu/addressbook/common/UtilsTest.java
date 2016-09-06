package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

	private Object itemIsNull;
	private Object itemIsNotNull = new Object();

	@Test
	public void isAnyNull_checksCorrectlyWithNoArguments() {
		assertFalse(Utils.isAnyNull());
	}

	@Test
	public void isAnyNull_checksAnItemCorrectly() {
		assertTrue(Utils.isAnyNull(itemIsNull));
		assertFalse(Utils.isAnyNull(itemIsNotNull));
	}
	
	@Test
	public void isAnyNull_checksMultipleItemsCorrectly() {
		assertTrue(Utils.isAnyNull(itemIsNull, itemIsNotNull));
	}
}

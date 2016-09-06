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

	@Test
	public void elementsAreUnique_checksCorrectlyWithEmptyCollection() {
		assertTrue(Utils.elementsAreUnique(new ArrayList<Integer>()));
	}

	@Test
	public void elementsAreUnique_checksCorrectlyUniqueCollection() {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		assertTrue(Utils.elementsAreUnique(integers));
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		assertTrue(Utils.elementsAreUnique(strings));
	}

	@Test
	public void elementsAreUnique_checksCorrectlyDuplicateCollection() {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(1);
		assertFalse(Utils.elementsAreUnique(integers));
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("a");
		assertFalse(Utils.elementsAreUnique(strings));
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class BirthdayBookTest {

	@Test
	public void test_01() {
		Birthday bd01 = new Birthday(1, 11);
		assertEquals(1, bd01.getMonth()); // expected vs actual
		assertEquals(11, bd01.getDay());
	}

	@Test
	public void test_02() {
		Birthday bd01 = new Birthday(1, 11);
		Birthday bd02 = new Birthday(2, 12);
		Birthday bd03 = new Birthday(3, 13);
		Birthday bd04 = new Birthday(4, 14);
		Birthday bd05 = new Birthday(5, 15);
		Birthday bd06 = new Birthday(6, 16);
		Birthday bd07 = new Birthday(7, 17);
		Birthday bd08 = new Birthday(8, 18);
		Birthday bd09 = new Birthday(9, 19);
		Birthday bd10 = new Birthday(10, 20);
		Birthday bd11 = new Birthday(11, 21);
		Birthday bd12 = new Birthday(12, 22);
		assertEquals("January 11", bd01.toString());
		assertEquals("February 12", bd02.toString());
		assertEquals("March 13", bd03.toString());
		assertEquals("April 14", bd04.toString());
		assertEquals("May 15", bd05.toString());
		assertEquals("June 16", bd06.toString());
		assertEquals("July 17", bd07.toString());
		assertEquals("August 18", bd08.toString());
		assertEquals("September 19", bd09.toString());
		assertEquals("October 20", bd10.toString());
		assertEquals("November 21", bd11.toString());
		assertEquals("December 22", bd12.toString());
	}

	@SuppressWarnings("unused")
	@Test
	public void test_02_violation() {
		try {
			Birthday invalidBD = new Birthday(13, 38);
			fail("Expected precondition violation did not occur");
		} catch (IllegalArgumentException e) {
			// expected, do nothing
		}
	}

	@Test
	public void test_03() {
		Birthday bd06 = new Birthday(6, 16);
		Birthday bd07 = new Birthday(7, 17);
		Birthday bd13 = new Birthday(6, 16);

		assertEquals("June 16", bd06.toString());
		assertEquals("July 17", bd07.toString());
		assertEquals("June 16", bd13.toString());
		assertTrue(bd06.equals(bd13));
		assertFalse(bd07.equals(bd13));
	}

	@Test
	public void test_04() {
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		assertEquals("A", e1.getName());
		assertEquals("January 11", e1.getBirthday().toString());
		assertEquals("A was born on January 11", e1.toString());
	}

	@Test
	public void test_05() {
		Birthday bd02 = new Birthday(2, 12);
		Entry e2 = new Entry("B", bd02);
		assertEquals("B", e2.getName());
		assertEquals("February 12", e2.getBirthday().toString());
		assertEquals("B was born on February 12", e2.toString());
	}

	@Test
	public void test_06() {
		Entry e1 = new Entry("A", 1, 11);
		Entry e2 = new Entry("A", 2, 12);
		Entry e3 = new Entry("A", 1, 11);
		assertFalse(e1.equals(e2));
		assertTrue(e1.equals(e3));
	}

	@Test
	public void test_07() {
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Entry e2 = new Entry("B", 2, 12);
		Entry e3 = new Entry("A", 1, 11);
		e2.setName("A");
		e2.setBirthday(1, 11);
		assertEquals("A was born on January 11", e1.toString());
		assertEquals("A was born on January 11", e2.toString());
		assertEquals("A was born on January 11", e3.toString());
		assertTrue(e1.equals(e2));
		assertTrue(e1.equals(e3));
	}

	@Test
	public void test_08() {
		Birthday bd01 = new Birthday(1, 11);
		Birthday bd03 = new Birthday(3, 13);
		Entry e1 = new Entry("A", bd01);
		Entry e2 = new Entry("A", 1, 11);
		Entry e3 = new Entry("A", 1, 11);
		e3.setBirthday(bd03);
		assertEquals("A was born on January 11", e1.toString());
		assertEquals("A was born on January 11", e2.toString());
		assertEquals("A was born on March 13", e3.toString());
		assertTrue(e1.equals(e2));
		assertFalse(e1.equals(e3));
	}

	@Test
	public void test_09() {
		BirthdayBook bb = new BirthdayBook();
		assertEquals(0, bb.getNumberOfEntries());
		assertEquals(0, bb.getEntries().length);
	}

	@Test
	public void test_10() {
		BirthdayBook bb = new BirthdayBook();
		assertEquals("There are 0 entries in the book", bb.toString());
	}

	@Test
	public void test_11() {
		BirthdayBook bb = new BirthdayBook();
		assertFalse(bb.nameExists("A"));
		assertFalse(bb.nameExists("B"));
		assertFalse(bb.nameExists("C"));
	}

	@Test
	public void test_12() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bdOfA = bb.getBirthday("A");
		Birthday bdOfB = bb.getBirthday("B");
		Birthday bdOfC = bb.getBirthday("C");
		/*
		 * Return birthdays on names. When names are non-existing, their associated
		 * birthdays are nulls.
		 */
		assertEquals(null, bdOfA);
		assertEquals(null, bdOfB);
		assertEquals(null, bdOfC);
	}

	@Test
	public void test_13() {
		/*
		 * Get reminders on birthdays. When birthdays are non-existing, no persons will
		 * be reminded.
		 */
		BirthdayBook bb = new BirthdayBook();
		Birthday bd13 = new Birthday(6, 16);
		String[] toRemind = bb.getReminders(bd13);
		assertEquals(0, toRemind.length);
		toRemind = bb.getReminders(6, 16);
		assertEquals(0, toRemind.length);
	}

	@Test
	public void test_14() {
		/*
		 * Remove entries from the book. When names are non-existing name, removing
		 * their associated entries have no effect.
		 */
		BirthdayBook bb = new BirthdayBook();
		bb.removeEntry("A");
		bb.removeEntry("B");
		bb.removeEntry("C");
		bb.removeEntry("D");
		assertEquals(0, bb.getNumberOfEntries());
		assertEquals(0, bb.getEntries().length);
	}

	@Test
	public void test_15() {
		/*
		 * Add new entries to the book. When names are non-existing, new entries are
		 * added to the book.
		 */
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		bb.addEntry("B", bd13);
		bb.addEntry("C", 6, 16);
		assertEquals(3, bb.getNumberOfEntries());
		assertEquals(3, bb.getEntries().length);
		assertEquals("A was born on January 11", bb.getEntries()[0].toString());
		assertEquals("B was born on June 16", bb.getEntries()[1].toString());
		assertEquals("C was born on June 16", bb.getEntries()[2].toString());
	}

	@Test
	public void test_16() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		bb.addEntry("B", bd13);
		bb.addEntry("C", 6, 16);
		assertEquals("There are 3 entries in the book\nA was born on January 11\n"
				+ "B was born on June 16\nC was born on June 16", bb.toString());
	}

	@Test
	public void test_17() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		bb.addEntry("B", bd13);
		bb.addEntry("C", 6, 16);

		assertTrue(bb.nameExists("A"));
		assertTrue(bb.nameExists("B"));
		assertTrue(bb.nameExists("C"));
	}

	@Test
	public void test_18() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		bb.addEntry("B", bd13);
		bb.addEntry("C", 6, 16);

		Birthday bdOfA = bb.getBirthday("A");
		Birthday bdOfB = bb.getBirthday("B");
		Birthday bdOfC = bb.getBirthday("C");
		
		/* Birthdays of existing names are not nulls */
		assertEquals("January 11", bdOfA.toString());
		assertEquals("June 16", bdOfB.toString());
		assertEquals("June 16", bdOfC.toString());
	}
	
	@Test
	public void test_19() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 11);
		Entry e1 = new Entry("A", bd01);
		Birthday bd13 = new Birthday(6, 16);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		bb.addEntry("B", bd13);
		bb.addEntry("C", 6, 16);
		/*
		 * Return names of persons whose birthdays are January 16. No entries added so
		 * far have this birthday.
		 */
		String[] toRemind;
		toRemind = bb.getReminders(1, 16);
		assertEquals(0, toRemind.length);
	}
	
	@Test
	public void test_20() {
		BirthdayBook bb = new BirthdayBook();
		Birthday bd01 = new Birthday(1, 16);
		Entry e1 = new Entry("A", bd01);

		bb.addEntry(e1.getName(), e1.getBirthday().getMonth(), e1.getBirthday().getDay());
		
		String[] toRemind;
		toRemind = bb.getReminders(1, 16);
		assertEquals(1, toRemind.length);
		assertEquals("A", toRemind[0]);
	}
	
	@Test
	public void test_21(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("B", 6, 16);
		bb.addEntry("C", 6, 16);
		
		String [] toRemind = bb.getReminders(6, 16);
		/*
		 * Return names of persons whose birthdays are June 16. Two entries added so far
		 * have this birthday.
		 */
		assertEquals(2, toRemind.length);
		assertEquals("B",toRemind[0]);
		assertEquals("C", toRemind[1]);
	}
	
	@Test
	public void test_22(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("A", 1, 11);
		bb.addEntry("B", 6, 16);
		bb.addEntry("C", 6, 16);
		bb.addEntry("D", 1, 11);
		
		bb.removeEntry("D");
		assertEquals("There are 3 entries in the book\nA was born on January 11\n"
				+ "B was born on June 16\nC was born on June 16", bb.toString());
	}
	
	@Test
	public void test_23(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("A", 1, 11);
		bb.addEntry("B", 6, 16);
		bb.addEntry("C", 6, 16);
		/* removing existing name: remove the associated entry */
		bb.removeEntry("A");
		assertEquals("There are 2 entries in the book\nB was born on June 16\nC " + "was born on June 16",bb.toString());
	}
	
	@Test
	public void test_24(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("B", 6, 16);
		bb.addEntry("C", 6, 16);
		String [] toRemind = bb.getReminders(1, 11);
		
		assertEquals(0, toRemind.length);
	}
	
	@Test
	public void test_25(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("B", 6, 16);
		bb.addEntry("C", 6, 16);
		/* removing existing name: remove the associated entry */
		bb.removeEntry("C");
		assertEquals("There are 1 entries in the book\nB was born on June 16",bb.toString());
	}
	
	@Test
	public void test_26(){
		BirthdayBook bb = new BirthdayBook();
		bb.addEntry("B", 6, 16);
		assertEquals("June 16", bb.getBirthday("B").toString());
		assertEquals(null, bb.getBirthday("C"));
	}
	
	@Test
	public void test_27(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd = new Birthday(6, 16);
		bb.addEntry("B", bd);

		String [] toRemind = bb.getReminders(bd);
		/*
		 * After the entry associated with "C" is deleted, only the entry associated
		 * with "B" has this birthday.
		 */
		assertEquals(1, toRemind.length);
		assertEquals("B", toRemind[0]);

	}
	
	@Test
	public void test_28(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 9, 19);
		assertEquals("There are 3 entries in the book\nB was born on June 16\nD "
				+ "was born on April 14\nE was born on September 19", bb.toString());
	}
	
	@Test
	public void test_29(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 9, 19);
		String [] toRemind = bb.getReminders(bd04);
		
		assertEquals(1, toRemind.length);
		assertEquals("D", toRemind[0]);
	}
	
	@Test
	public void test_30(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 9, 19);
		/*
		 * Adding an entry whose name already exists replaces the associated entry's
		 * birthday.
		 */
		bb.addEntry("E", 4, 14);
		assertEquals("There are 3 entries in the book\nB was born on June 16\nD "
				+ "was born on April 14\nE was born on April 14", bb.toString());
	}
	
	@Test
	public void test_31(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 4, 14);
		String [] toRemind = bb.getReminders(4, 14);
		
		assertEquals(2, toRemind.length);
		assertEquals("D", toRemind[0]);
		assertEquals("E", toRemind[1]);
	}
	
	@Test
	public void test_32(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 4, 14);
		/* Non-empty and empty books are not equal. */
		BirthdayBook bb2 = new BirthdayBook();
		assertFalse(bb.equals(bb2));
	}
	
	@Test
	public void test_33(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 4, 14);
		/* Non-empty books of different sizes are not equal. */
		BirthdayBook bb2 = new BirthdayBook();
		bb2.addEntry("B", 6, 16);
		bb2.addEntry("D", 4, 14);
		assertFalse(bb.equals(bb2));
	}
	
	@Test
	public void test_34(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 4, 14);
		/*
		 * Non-empty books, of same sizes and where entries at corresponding positions
		 * are equal, are equal.
		 */
		BirthdayBook bb2 = new BirthdayBook();
		bb2.addEntry("B", 6, 16);
		bb2.addEntry("D", 4, 14);
		bb2.addEntry("E", bd04);
		assertTrue(bb.equals(bb2));
	}
	
	@Test
	public void test_35(){
		BirthdayBook bb = new BirthdayBook();
		Birthday bd04 = new Birthday(4, 14);
		bb.addEntry("B", 6, 16);
		bb.addEntry("D", bd04);
		bb.addEntry("E", 4, 14);
		/* Non-empty books of different sizes are not equal. */
		BirthdayBook bb2 = new BirthdayBook();
		bb2.addEntry("B", 6, 16);
		bb2.addEntry("D", 4, 14);
		bb2.addEntry("E", bd04);
		bb2.addEntry("F", 10, 15);
		assertFalse(bb.equals(bb2));
	}
	
}
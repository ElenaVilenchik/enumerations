package telran.measure.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.measure.*;

class LengthTests {
	Length length1 = new Length(1, LengthUnit.KM);
	Length lengthFloat = new Length(1.005f, LengthUnit.KM);
	Length length2 = new Length(500, LengthUnit.M);
	Length l3 = new Length(50000, LengthUnit.CM);
	Length l4 = new Length(50000, LengthUnit.KM);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		assertEquals(length2, l3);
		assertNotEquals(length1, length2);
	}

	@Test
	void testCompareTo() {
		assertTrue(length2.compareTo(length1) < 0);
		assertTrue(length1.compareTo(length2) > 0);
		assertTrue(length2.compareTo(l3) == 0);
		assertTrue(l4.compareTo(length1) > 0);
	}

	@Test
	void testConvert() {
		Length l = l3.convert(LengthUnit.M);
		assertEquals(length2.getAmount(), l.getAmount());
		assertEquals(length2.getUnit(), l.getUnit());
	}

	@Test
	void testToString() {
		assertEquals("500M", length2.toString());
		assertEquals("1KM", length1.toString());
		
		//my test
		assertEquals("1.005KM", lengthFloat.toString());
	}

	@Test
	void testBetween() {
		Length l = LengthUnit.M.between(length2, length1);
		assertEquals(l.getAmount(), length2.getAmount());
		assertEquals(l.getUnit(), length2.getUnit());
		assertEquals(l.getUnit(), LengthUnit.M);
		
//		Length l1 = LengthUnit.M.between(length1, length2);
//		assertNotEquals(l1.getAmount(), length1.getAmount());
//		assertNotEquals(l1.getUnit(), length1.getUnit());
//		assertEquals(l1.getUnit(), LengthUnit.M);
	}

}

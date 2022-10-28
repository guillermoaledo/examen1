package es.iesvegademijas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.hibernate.mapping.Set;
import org.junit.jupiter.api.Test;

import es.iesvegademijas.genericos.Bag;

class BagTests {

	@Test
	void testBag() {
		Bag<Integer> bag = new Bag();
	}

	@Test
	void testAddT() {
		Bag<Integer> bag = new Bag();
		bag.add(6);
		assertEquals(bag.toString(), "[6]");
		
	}

	@Test
	void testAddTInt() {
		Bag<Integer> bag = new Bag();
		bag.add(1, 3);
		assertEquals(bag.toString(), "[1, 1, 1]");
	}

	@Test
	void testGetCount() {
		Bag<Integer> bag = new Bag();
		bag.add(5, 7);
		assertEquals(bag.getCount(5), 7);
	}

	@Test
	void testRemoveT() {
		Bag<Integer> bag = new Bag();
		bag.add(14, 5);
		bag.add(2);
		bag.remove(14);
		assertEquals(bag.toString(), "[2]");
	}

	@Test
	void testRemoveTInt() {
		Bag<Integer> bag = new Bag();
		bag.add(7, 3);
		bag.remove(7, 2);
		assertEquals(bag.toString(), "[7]");
	}

	@Test
	void testSize() {
		Bag<Integer> bag = new Bag();
		bag.add(1, 27);
		assertEquals(bag.size(), 27);
	}

	@Test
	void testUniqueSet() {
		Bag<Integer> bag = new Bag();
		bag.add(5, 3);
		bag.add(1, 5);
		bag.add(2, 2);
		java.util.Set<Integer> set = new HashSet<>();
	    set = bag.uniqueSet();
	    //Hay que tener en cuenta que el set está ordenado
	    assertEquals(set.toString(), "[1, 2, 5]");
	}

}

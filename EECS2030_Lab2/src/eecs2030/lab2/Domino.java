package eecs2030.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents domino tiles. A domino is a rectangular tile with a
 * line dividing its playing face into two sides. Each side of the playing face
 * is marked with pips (dots) similar to a standard 6-sided die. The number of
 * pips on each side of the playing face ranges from Domino.MIN_VALUE to
 * Domino.MAX_VALUE (inclusive).
 * 
 * <p>
 * In simpler terms, each domino tile has two integer values that range from
 * Domino.MIN_VALUE to Domino.MAX_VALUE (inclusive).
 *
 */
public class Domino implements Comparable<Domino> {

	// YOU NEED TO ADD SOME public static final FIELDS HERE
	public static final int MAX_VALUE = 6;
	public static final int MIN_VALUE = 0;

	// YOU NEED TO ADD SOME FIELDS FOR THE STATE OF A DOMINO HERE
	int d1;
	int d2;

	/**
	 * Initializes this domino so that both of its values are equal to
	 * <code>Domino.MIN_VALUE</code>.
	 */
	public Domino() {
		d1 = MIN_VALUE;
		d2 = MIN_VALUE;
	}

	/**
	 * Initializes this domino to have the specified values.
	 * 
	 * @param value1
	 *            a value
	 * @param value2
	 *            another value @pre. Domino.isValueOK(value1) &&
	 *            Domino.isValueOK(value2)
	 * @throws IllegalArgumentException
	 *             if value1 or value2 is not a legal domino value
	 */
	public Domino(int value1, int value2) throws IllegalArgumentException {
		if (isValueOK(value1) && isValueOK(value2)) {
			d1 = value1;
			d2 = value2;
		} else {
			throw new IllegalArgumentException("Value is not a legal domino value");
		}
		/*
		 * } }catch (IllegalArgumentException e) { e.printStackTrace(); }
		 */
	}

	/**
	 * Initializes this domino so that its values are the same as the specified
	 * other domino.
	 * 
	 * @param other
	 *            a domino
	 */
	public Domino(Domino other) {
		d1 = other.getValue1();
		d2 = other.getValue2();
	}

	/**
	 * Returns true if the specified value is a legal domino value, and false
	 * otherwise.
	 * 
	 * @param value
	 *            a value to check
	 * @return true if the specified value is a legal domino value, and false
	 *         otherwise
	 */
	public static boolean isValueOK(int value) {
		if (value >= MIN_VALUE && value <= MAX_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a list of size 28 containing all of the tiles of the double-six set
	 * (see test document for details).
	 * 
	 * @return a list of size 28 containing all of the tiles of the double-six set
	 */
	public static List<Domino> allDominoes() {
		ArrayList<Domino> dominos = new ArrayList<Domino>();

		for (int i = 0; i <= MAX_VALUE; i++) {
			for (int j = i; j <= MAX_VALUE; j++) {
				Domino d = new Domino(i, j);
				dominos.add(d);
			}
		}

		return dominos;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue2</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue1() {
		return d1;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue1</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue2() {
		return d2;
	}

	/**
	 * Returns the smaller of the two values of this domino. If both values of this
	 * domino are equal to the same value then that value is returned.
	 * 
	 * @return the smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		if (d1 < d2) {
			return d1;
		}
		return d2;

	}

	/**
	 * Returns the larger of the two values of this domino. If both values of this
	 * domino are equal to the same value then that value is returned.
	 * 
	 * @return the larger of the two values of this domino
	 */
	public int getLargerValue() {
		if (d1 > d2) {
			return d1;
		}
		return d2;
	}

	/**
	 * Returns true if this domino matches the specified domino, and false
	 * otherwise.
	 *
	 * <p>
	 * Two dominoes match if they have at least one value in common. Note that the
	 * side on which a value appears is not considered for the purposes of matches;
	 * for instance, <code>m</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 2); // a and b have the value 4 in common
	 * boolean m = a.matches(b);
	 * </pre>
	 * 
	 * @param other
	 *            a domino
	 * @return true if this domino matches the specified domino, and false otherwise
	 */
	public boolean matches(Domino other) {
		if (d1 == other.getValue1() || d1 == other.getValue2() || d2 == other.getValue1() || d2 == other.getValue2()) {
			return true;
		}
		return false;
	}

	/**
	 * Compares two dominoes by their values. The smaller values on the two dominoes
	 * are compared first; if the smaller values of both dominoes are equal then the
	 * larger values of the two dominoes are compared.
	 * 
	 * <p>
	 * If the two dominoes are equal then {@code 0} is returned.
	 * 
	 * <p>
	 * This domino is less than the other domino if the smaller value of this domino
	 * is less than the smaller value of the other domino, or if the larger value of
	 * this domino is less than the larger value of the other domino and the smaller
	 * values of both dominoes are equal.
	 * 
	 * <p>
	 * This domino is greater than the other domino if the smaller value of this
	 * domino is greater than the smaller value of the other domino, or if the
	 * larger value of this domino is greater than the larger value of the other
	 * domino and the smaller values of both dominoes are equal.
	 * 
	 * @param other
	 *            the other domino to compare to this domino
	 * @return the value 0 if this domino is equal to other; a value less than 0 if
	 *         this domino is less than the other domino; and a value greater than 0
	 *         if this domino is greater than the other domino
	 */
	@Override
	public int compareTo(Domino other) {
		if (this.getSmallerValue() == other.getSmallerValue() && this.getLargerValue() == other.getLargerValue()) {
			return 0; // dominos are equal
		} else if (this.getSmallerValue() < other.getSmallerValue() || (this.getLargerValue() < other.getLargerValue()
				&& this.getSmallerValue() == other.getSmallerValue())) {
			return -1; // other domino greater than this domino
		}
		return 1; // this domino greater than other domino
	}

	/**
	 * Compares this domino to the specified object. The result is true if and only
	 * if the argument is a Domino object having the same values as this domino
	 * object. Note that the side on which a value appears is not considered for the
	 * purposes of equals; for instance, <code>eq</code> will be true in the example
	 * below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 1);
	 * boolean eq = a.equals(b);
	 * </pre>
	 * 
	 * @param obj
	 *            an object to compare
	 * @return true if this domino is equal to the specified object, and false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) { // if its empty
			return false;
		} else if (this.getLargerValue() == ((Domino) obj).getLargerValue()
				&& this.getSmallerValue() == ((Domino) obj).getSmallerValue()) {
			// if the larger vales and smaller values are both equal then return true
			return true;
		} else {
			// values are not equal so return false
			return false;
		}
	}

	/**
	 * Returns a hash code for this domino. The hash code value is equal to the
	 * smaller value of this domino plus eleven times the larger value of this
	 * domino.
	 * 
	 * @return the smaller value of this domino plus eleven times the larger value
	 *         of this domino
	 */
	@Override
	public int hashCode() {
		return this.getSmallerValue() + this.getLargerValue() * 11;
	}

	/**
	 * Returns a string representation of this domino. The returned string is the
	 * smaller value of this domino followed by a space, a colon, a space, and
	 * finally the larger value of this domino all inside a pair of square brackets;
	 * for example, if {@code d = new Domino(5, 3)} then {@code d.toString()}
	 * returns the string {@code "[3 : 5]"}.
	 * 
	 * @return a string representation of this domino
	 */
	@Override
	public String toString() {
		return "[" + this.getSmallerValue() + " : " + this.getLargerValue() + "]";
	}

}
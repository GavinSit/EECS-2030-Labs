package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. A piggy bank owns a
 * collection (or possibly collections) of coins, but does not own the coins
 * themselves. In other words, the piggy bank and its collection of coins form a
 * composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins from the piggy bank.
 * The piggy bank does own its owner. In other words, the piggy bank and its
 * owner form an aggregation.
 */
public class OwnedPiggyBank {
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */
	List<Coin> coin;

	/**
	 * The owner of this pigyg bank.
	 */
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner and its
	 * collection of coins is empty.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		coin = new ArrayList<Coin>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy bank
	 * will have the same owner and the same number and type of coins as the other
	 * piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.getOwner();
		coin = other.deepCopy();
	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning the owner of this
	 * piggy bank allows any user to remove coins from the piggy bank (because any
	 * user can get the owner of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}

	/**
	 * Allows the current owner of this piggy bank to give this piggy bank to a new
	 * owner.
	 * 
	 * @param currentOwner
	 *            the current owner of this piggy bank
	 * @param newOwner
	 *            the new owner of this piggy bank
	 * @throws IllegalArgumentException
	 *             if currentOwner is not the current owner of this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) {
		if (this.owner.equals(currentOwner)) {
			this.owner = newOwner;
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		coin.addAll(coins);
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		if (this.coin.contains(coin)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value of
	 * the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank, then the
	 * coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy bank,
	 *         or null if user is not the owner of this piggy bank @pre. the piggy
	 *         bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		int coinIndex;

		if (this.owner.getName().equals(user.getName())) {
			coinIndex = this.coin.indexOf(coin);
			this.coin.remove(coinIndex);
			return coin;
		} else {
			return null;
		}
	}

	/**
	 * Allows the owner of this piggy bank to remove the smallest number of coins
	 * whose total value in cents is equal to the specified value in cents from this
	 * piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to the owner of
	 * this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal to
	 *         the specified value in cents from this piggy bank @pre. the piggy
	 *         bank contains a group of coins whose total value is equal to
	 *         specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> coinsRemoved = new ArrayList<Coin>();
		if (user.equals(this.owner)) {
			while (value != 0) {
				if (value >= 200 && this.coin.contains(Coin.TOONIE)) {
					this.coin.remove(Coin.TOONIE);
					value -= 200;
					coinsRemoved.add(Coin.TOONIE);
				} else if (value >= 100 && this.coin.contains(Coin.LOONIE)) {
					this.coin.remove(Coin.LOONIE);
					value -= 100;
					coinsRemoved.add(Coin.LOONIE);
				} else if (value >= 25 && this.coin.contains(Coin.QUARTER)) {
					this.coin.remove(Coin.QUARTER);
					value -= 25;
					coinsRemoved.add(Coin.QUARTER);
				} else if (value >= 10 && this.coin.contains(Coin.DIME)) {
					this.coin.remove(Coin.DIME);
					value -= 10;
					coinsRemoved.add(Coin.DIME);
				} else if (value >= 5 && this.coin.contains(Coin.NICKEL)) {
					this.coin.remove(Coin.NICKEL);
					value -= 5;
					coinsRemoved.add(Coin.NICKEL);
				} else if (value >= 1 && this.coin.contains(Coin.PENNY)) {
					this.coin.remove(Coin.PENNY);
					value -= 1;
					coinsRemoved.add(Coin.PENNY);
				}
				System.out.println(value);
			}
			return coinsRemoved;
		} else {
			return coinsRemoved;
		}

	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list has
	 * its coins in sorted order (from smallest value to largest value; i.e.,
	 * pennies first, followed by nickels, dimes, quarters, loonies, and toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		List<Coin> copiedCoin = new ArrayList<Coin>();
		int j = 1;
		boolean swap = false;

		for (int i = 0; i < this.coin.size(); i++) {
			copiedCoin.add(new Coin(this.coin.get(i)));
		}

		// System.out.print(copiedCoin.size() + "copiedCoin: ");
		// for(int i = 0; i < copiedCoin.size(); i ++) {
		// System.out.print(copiedCoin.get(i) + " ");
		// }

		// Bubble Sort
		do {
			swap = false;
			for (int i = 0; i < copiedCoin.size() - j; i++) {
				if (copiedCoin.get(i).compareTo(copiedCoin.get(i + 1)) > 0) {
					swap = true;
					Coin temp = new Coin(copiedCoin.get(i));
					copiedCoin.remove(i);
					copiedCoin.add(i + 1, new Coin(temp));
				}
			}
		} while (swap);

		return copiedCoin;
	}
}

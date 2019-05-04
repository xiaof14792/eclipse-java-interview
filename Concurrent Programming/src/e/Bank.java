package e;

import java.util.Arrays;
/**
 * 系统的同步机制 和 条件对象
 * synchronized 关键字  wait —— notify 、notifyAll方法
 * @author 14792
 *
 */
public class Bank {
	private final double[] accounts;

	/**
	 * Constructs the bank.
	 * 
	 * @param n
	 *            the number of accounts
	 * @param initialBalance
	 *            the initial balance for each account
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
	}

	/**
	 * Transfers money from one account to another.
	 * 
	 * @param from
	 *            the account to transfer from
	 * @param to
	 *            the account to transfer to
	 * @param amount
	 *            the amount to transfer
	 * @throws InterruptedException 
	 */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while (accounts[from] < amount) {
			//不满足条件对象，阻塞
			wait();
		}
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		//提醒其它的因不满足条件对象阻塞的线程重新检查是否满足条件
		notifyAll();
	}

	/**
	 * Gets the sum of all account balances.
	 * 
	 * @return the total balance
	 */
	public double getTotalBalance() {
		double sum = 0;

		for (double a : accounts)
			sum += a;

		return sum;
	}

	/**
	 * Gets the number of accounts in the bank.
	 * 
	 * @return the number of accounts
	 */
	public int size() {
		return accounts.length;
	}
}

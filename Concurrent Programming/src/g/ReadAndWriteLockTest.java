package g;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {
	double balance;
	
	
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	//��ȡ������д��
	private Lock readLock = rwl.readLock();
	private Lock writeLock = rwl.writeLock();
	
	
	//�����еĻ�ȡ�����Ӷ���
	public double getBalance() {
		readLock.lock();
		try {
			return balance;
		} finally {
			readLock.unlock();
		}
	}
	
	//�����е��޸ķ�����д��
	public void setBalance(double balance) {
		writeLock.lock();
		
		try {
			this.balance = balance;
		} finally {
			writeLock.unlock();
		}
	}
}

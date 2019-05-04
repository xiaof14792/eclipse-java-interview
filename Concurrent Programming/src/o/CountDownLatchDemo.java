package o;

import java.util.concurrent.CountDownLatch;
/**
 * ����ʱ��˨-CountDownLatch
 * �����̵߳ȴ�һ���¼����������ִ��
 * @author 14792
 *
 */
public class CountDownLatchDemo {
	public static void main(String[] args) {
		try {
			new CountDownLatchDemo().go();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void go() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		//���δ���3���̣߳�������
		new Thread(new Task(countDownLatch),"Thread-1").start();
		Thread.sleep(1000);
		new Thread(new Task(countDownLatch),"Thread-2").start();
		Thread.sleep(1000);
		new Thread(new Task(countDownLatch),"Thread-3").start();
		countDownLatch.await();
		
		//
		System.out.println("�����̶߳��ѵ�����߳̿�ʼִ��." + System.currentTimeMillis());
	}
	
	class Task implements Runnable{
		private CountDownLatch countDownLatch;
		
		
		public Task(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}


		@Override
		public void run() {
			System.out.println("�߳�" + Thread.currentThread().getName() + "�Ѿ����" + System.currentTimeMillis());
			countDownLatch.countDown();
		}
		
	}
}
 
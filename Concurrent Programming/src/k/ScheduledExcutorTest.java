package k;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExcutorTest {
	//ScheduledExecutorService �ӿھ���ΪԤ��ִ�л��ظ�ִ���������Ƶķ���
	public static void main(String[] args) {
		ScheduledExecutorService scheduledPool = Executors.newSingleThreadScheduledExecutor();
		
		
		
		Runnable r = () ->{
			System.out.println("�ҵļ��ں����찲��");
		};
		
		//ֻҪ����ThreadPool��ִ���߼�������ִ��
		scheduledPool.scheduleAtFixedRate(r, 1000, 1000, TimeUnit.MILLISECONDS);
	}
}

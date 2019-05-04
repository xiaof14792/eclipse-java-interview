package o;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * ������-Exchanger
 * �����̵߳���ͬ������໥��������
 * @author 14792
 *
 */
public class ExchangerDemo {
	
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		//����������Ů��
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(() -> {
			try {
				//������Ů��˵�Ļ�
				String girl = exchanger.exchange("����ʵ������ܾ���");
				System.out.println("Ů��˵��" + girl);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		});
		
		service.execute(() -> {
			try {
				System.out.println("Ů�������ӽ������߳���...");
				TimeUnit.SECONDS.sleep(3);
				
				//������Ů��˵�Ļ�
				String boy = exchanger.exchange("�Һ�ϲ����...");
				System.out.println("����˵��" + boy);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		});
	}
}

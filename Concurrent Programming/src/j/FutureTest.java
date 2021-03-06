package j;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;

public class FutureTest {
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Entry the ditectory(eg: /opt/jdk 1.8.0/src):");
			String directory = in.nextLine();
			System.out.println("Entry the keyword(eg: volatile):");
			String keyword = in.nextLine();
			
			ExecutorService pool = Executors.newCachedThreadPool();
			
			MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
			Future<Integer> result = pool.submit(counter);
			
			//开多线程处理程序，并不是异步！！！
			try {
				//意思就是这里会阻塞，知道返回结果
				System.out.println(result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("看看谁先执行到?");
		}
	}
}

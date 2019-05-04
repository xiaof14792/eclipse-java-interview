package i;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			System.out.println("Entry the ditectory(eg: /opt/jdk 1.8.0/src):");
			String directory = in.nextLine();
			System.out.println("Entry the keyword(eg: volatile):");
			String keyword = in.nextLine();
			
			MatchCounter counter = new MatchCounter(new File(directory), keyword);
			FutureTask<Integer> task = new FutureTask<>(counter);
			Thread t = new Thread(task);
			t.start();
			
			try {
				//意思就是这里会阻塞，知道返回结果
				System.out.println(task.get());
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

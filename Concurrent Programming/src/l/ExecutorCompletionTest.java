package l;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制任务组
 * 将结果按可获得的顺序保存起来
 * @author 14792
 *
 */
public class ExecutorCompletionTest {
	public static void main(String[] args) {
		Callable<Integer> c1 = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("第一个线程");
			return 1;
		};

		Callable<Integer> c2 = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("第二个线程");
			return 2;
		};
		List<Callable<Integer>> callables = new ArrayList<>();
		callables.add(c1);
		callables.add(c2);

		//将结果按可获得的顺序保存起来
		ExecutorService pool = Executors.newCachedThreadPool();
		// pool.invokeAll(callables);
		ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(pool);
		service.submit(c1);
		service.submit(c2);

		try {
			for (int i = 0; i < 2; i++) {
				System.out.println(service.take().get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}

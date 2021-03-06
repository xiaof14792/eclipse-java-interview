package m;

import java.util.concurrent.ForkJoinPool;
/**
 * Fork-Join���
 * @author 14792
 *
 */
public class ForkJoinTest {
	public static void main(String[] args) {
		final int SIZE = 10000000;
		double[] numbers = new double[SIZE];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Math.random();
		}
		
//		DoublePredicate filter = new DoublePredicate() {
//			
//			@Override
//			public boolean test(double value) {
//				
//				return value > 0.5 ;
//			}
//		};
		Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println(counter.join());
	}

}

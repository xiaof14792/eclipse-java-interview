package j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer> {
	private File directory;
	private String keyword;
	private ExecutorService pool;

	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	@Override
	public Integer call() throws Exception {
		int count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter matchCounter = new MatchCounter(file, keyword,pool);
					Future<Integer> result = pool.submit(matchCounter);
					results.add(result);
				} else {
					if (search(file)) {
						count++;
					}
				}
			}

			for (int i = 0; i < results.size(); i++) {
				count += results.get(i).get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public boolean search(File file) {
		try (Scanner scanner = new Scanner(file, "UTF-8")) {
			boolean found = false;
			while (!found && scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains(keyword)) {
					found = true;
				}
			}
			return found;
		} catch (IOException e) {
			return false;
		}
	}

}

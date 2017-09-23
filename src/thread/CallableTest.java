package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		
		for(int i=0; i<5; i++){
			list.add(executor.submit(new MyCallable()));
		}
		executor.shutdown();
		
		Thread.sleep(1000);
		System.out.println("*****");
		
		for(Future<Integer> future: list){
			System.out.println(future.get());
		}
		
	}

}

class MyCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		for(int i=1; i<=3; i++){
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
		return new Random().nextInt(100);
	}
	
}

package co.herni.concurrency;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.cactoos.matchers.RunsInThreads;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class BooksTest {
	  //@Test
	  public void addsAndRetrieves() {
	    Books books = new Books();
	    String title = "Elegant Objects";
	    int id = books.add(title);
	    assert books.title(id).equals(title);
	  }
	

//@Test
public void addsAndRetrievesConcurrent() {
  Books books = new Books();
  int threads = 10;
  ExecutorService service = Executors.newFixedThreadPool(threads);
  Collection<Future<Integer>> futures = new LinkedList<>();
  for (int t = 0; t < threads; ++t) {
    final String title = String.format("Book #%d", t);
    futures.add(service.submit(() -> books.add(title)));
  }
  Set<Integer> ids = new HashSet<>();
  for (Future<Integer> f : futures) {
    try {
		ids.add(f.get());
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
  }
  assertThat(ids.size(), equalTo(threads));
  //System.out.println(ids.size());
}

	//@Test
	public void addsAndRetrievesConcurrent2() {
		Books books = new Books();
		  int threads = 10;
		  ExecutorService service = Executors.newFixedThreadPool(threads);
		CountDownLatch latch = new CountDownLatch(1);
		AtomicBoolean running = new AtomicBoolean();
		AtomicInteger overlaps = new AtomicInteger();
		Collection<Future<Integer>> futures = new LinkedList<>();
		for (int t = 0; t < threads; ++t) {
		  final String title = String.format("Book #%d", t);
		  futures.add(
		    service.submit(
		      () -> {
		        latch.await();
		        if (running.get()) {
		          overlaps.incrementAndGet();
		        }
		        running.set(true);
		        int id = books.add(title);
		        running.set(false);
		        return id;
		      }
		    )
		  );
		}
		latch.countDown();
		Set<Integer> ids = new HashSet<>();
		for (Future<Integer> f : futures) {
		  try {
			ids.add(f.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		}
		assertThat(overlaps.get(), greaterThan(0));
	}
	
	@Test
	public void ad(){
			    Books books = new Books();
			    MatcherAssert.assertThat(
			      t -> {
			        String title = String.format(
			          "Book #%d", t.getAndIncrement()
			        );
			        int id = books.add(title);
			        return books.title(id).equals(title);
			      },
			      new RunsInThreads<>(new AtomicInteger(), 10)
			    );
			  }
	@Test
	public void conc(){
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}
}
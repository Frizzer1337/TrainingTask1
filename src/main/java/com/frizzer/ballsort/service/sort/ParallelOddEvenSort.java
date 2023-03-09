package com.frizzer.ballsort.service.sort;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.OddEvenParallelThread;
import com.frizzer.ballsort.service.Sort;
import com.frizzer.ballsort.service.SortBy;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParallelOddEvenSort implements Sort {
  private final Logger logger = LogManager.getLogger();

  @Override
  public void sort(List<Ball> list, SortBy sortBy) {
    parallelOddEvenSortBody(list,sortBy);
  }

  public void parallelOddEvenSortBody(List<Ball> list, SortBy sortBy) {
    int threadAmount = list.size() / 2;
    CyclicBarrier barrier = new CyclicBarrier(threadAmount);
    ExecutorService executor = Executors.newFixedThreadPool(threadAmount);
    Future<?>[] awaits = new Future<?>[threadAmount];
    for (int i = 0; i < threadAmount; i++) {
      int splitIndex = 2 * i + 1;
      awaits[i] = executor.submit(new OddEvenParallelThread(list, splitIndex, barrier, sortBy));
    }
    for (int i = 0; i < threadAmount; i++) {
      try {
        awaits[i].get();
      } catch (InterruptedException | ExecutionException e) {
        logger.error(e);
        Thread.currentThread().interrupt();
      }
    }
  }
}

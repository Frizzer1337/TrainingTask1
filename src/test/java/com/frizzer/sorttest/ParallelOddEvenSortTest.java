package com.frizzer.sorttest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.OddEvenParallelThread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

class ParallelOddEvenSortTest extends AbstractTest {

  @Test
  void testParallelOddEvenSortBySize() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    int threadAmount = balls.size() / 2;
    CyclicBarrier barrier = new CyclicBarrier(threadAmount);
    ExecutorService executor = Executors.newFixedThreadPool(threadAmount);
    Future<?>[] awaits = new Future<?>[threadAmount];
    for (int i = 0; i < threadAmount; i++) {
      awaits[i] = executor.submit(new OddEvenParallelThread(balls, 2 * i + 1, barrier).bySize());
    }
    for (int i = 0; i < threadAmount; i++) {
      try {
        awaits[i].get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    ballsSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(balls.stream().map(Ball::getSize).toList(),
        is(ballsSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testParallelOddEvenSortByColor() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    int threadAmount = balls.size() / 2;
    CyclicBarrier barrier = new CyclicBarrier(threadAmount);
    ExecutorService executor = Executors.newFixedThreadPool(threadAmount);
    Future<?>[] awaits = new Future<?>[threadAmount];
    for (int i = 0; i < threadAmount; i++) {
      awaits[i] = executor.submit(new OddEvenParallelThread(balls, 2 * i + 1, barrier).byColor());
    }
    for (int i = 0; i < threadAmount; i++) {
      try {
        awaits[i].get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    ballsSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(balls.stream().map(Ball::getColor).toList(),
        is(ballsSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testParallelOddEvenSortByType() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    int threadAmount = balls.size() / 2;
    CyclicBarrier barrier = new CyclicBarrier(threadAmount);
    ExecutorService executor = Executors.newFixedThreadPool(threadAmount);
    Future<?>[] awaits = new Future<?>[threadAmount];
    for (int i = 0; i < threadAmount; i++) {
      awaits[i] = executor.submit(new OddEvenParallelThread(balls, 2 * i + 1, barrier).byType());
    }
    for (int i = 0; i < threadAmount; i++) {
      try {
        awaits[i].get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    ballsSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(balls.stream().map(Ball::getType).toList(),
        is(ballsSortedByJava.stream().map(Ball::getType).toList()));
  }
}

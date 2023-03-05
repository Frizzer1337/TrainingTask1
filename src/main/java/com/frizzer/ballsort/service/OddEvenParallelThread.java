package com.frizzer.ballsort.service;

import com.frizzer.ballsort.entity.Ball;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OddEvenParallelThread implements Runnable {

  private final List<Ball> list;
  private final int index;
  private final CyclicBarrier barrier;
  private SortBy sortBy = SortBy.SIZE;

  private static Logger logger = LogManager.getLogger();

  public OddEvenParallelThread(List<Ball> list, int index, CyclicBarrier barrier) {
    this.list = list;
    this.index = index;
    this.barrier = barrier;
  }

  public OddEvenParallelThread bySize() {
    sortBy = SortBy.SIZE;
    return this;
  }

  public OddEvenParallelThread byColor() {
    sortBy = SortBy.COLOR;
    return this;
  }

  public OddEvenParallelThread byType() {
    sortBy = SortBy.TYPE;
    return this;
  }

  private int compare(Ball leftBall, Ball rightBall) {
    switch (sortBy) {
      case SIZE -> {
        return leftBall.getSize() - rightBall.getSize();
      }
      case TYPE -> {
        return leftBall.getType().compareTo(rightBall.getType());
      }
      case COLOR -> {
        return leftBall.getColor().compareTo(rightBall.getColor());
      }
    }
    return 0;
  }

  @Override
  public void run() {
    for (int i = 0; i < list.size(); i++) {
      if (compare(list.get(index - 1), list.get(index)) > 0) {
        Collections.swap(list, index, index - 1);
      }
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        logger.error("Thread was interrupted" + e);
        Thread.currentThread().interrupt();
      }
      if (index + 1 < list.size() && compare(list.get(index), list.get(index + 1)) > 0) {
        Collections.swap(list, index, index + 1);
      }
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        logger.error("Thread was interrupted" + e);
        Thread.currentThread().interrupt();
      }
    }
  }

}

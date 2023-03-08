package com.frizzer.ballsort.service;

import com.frizzer.ballsort.entity.Ball;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortService {

  private final Logger logger = LogManager.getLogger();
  private SortBy sortBy = SortBy.SIZE;

  public SortService bySize() {
    sortBy = SortBy.SIZE;
    return this;
  }

  public SortService byColor() {
    sortBy = SortBy.COLOR;
    return this;
  }

  public SortService byType() {
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

  public SortService parallelOddEvenSort(List<Ball> list) {
    int threadAmount = list.size() / 2;
    CyclicBarrier barrier = new CyclicBarrier(threadAmount);
    ExecutorService executor = Executors.newFixedThreadPool(threadAmount);
    Future<?>[] awaits = new Future<?>[threadAmount];
    for (int i = 0; i < threadAmount; i++) {
      int splitIndex = 2 * i + 1;
      awaits[i] = executor.submit(new OddEvenParallelThread(list, splitIndex, barrier, this.sortBy));
    }
    for (int i = 0; i < threadAmount; i++) {
      try {
        awaits[i].get();
      } catch (InterruptedException | ExecutionException e) {
        logger.error(e);
        Thread.currentThread().interrupt();
      }
    }
    return this;
  }

  public SortService mergeSort(List<Ball> list) {
    mergeSortRealization(list);
    return this;
  }

  private void mergeSortRealization(List<Ball> list) {
    List<Ball> left = new ArrayList<>();
    List<Ball> right = new ArrayList<>();
    int center;
    if (list.size() != 1) {
      center = list.size() / 2;
      for (int i = 0; i < center; i++) {
        left.add(list.get(i));
      }
      for (int i = center; i < list.size(); i++) {
        right.add(list.get(i));
      }
      mergeSortRealization(left);
      mergeSortRealization(right);
      merge(left, right, list);
    }
  }

  private void merge(List<Ball> left, List<Ball> right, List<Ball> list) {
    int leftIndex = 0;
    int rightIndex = 0;
    int originalIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {

      if (compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
        list.set(originalIndex, left.get(leftIndex));
        leftIndex++;
      } else {
        list.set(originalIndex, right.get(rightIndex));
        rightIndex++;
      }
      originalIndex++;
    }

    while (leftIndex < left.size()) {
      list.set(originalIndex, left.get(leftIndex));
      originalIndex++;
      leftIndex++;
    }
    while (rightIndex < right.size()) {
      list.set(originalIndex, right.get(rightIndex));
      originalIndex++;
      rightIndex++;
    }
  }

  public SortService quickSort(List<Ball> list) {
    quickSort(list, 0, list.size() - 1);
    return this;
  }

  private void quickSort(List<Ball> list, int begin, int end) {
    if (begin < end) {
      int partitionIndex = partition(list, begin, end);
      quickSort(list, begin, partitionIndex - 1);
      quickSort(list, partitionIndex + 1, end);
    }
  }

  private int partition(List<Ball> list, int begin, int end) {
    Ball pivot = list.get(end);
    int i = (begin - 1);
    for (int j = begin; j < end; j++) {
      if (compare(list.get(j), pivot) <= 0) {
        i++;
        Collections.swap(list, i, j);
      }
    }
    Collections.swap(list, i + 1, end);
    return i + 1;
  }


  public SortService heapSort(List<Ball> list) {
    int n = list.size();

    for (int i = n / 2 - 1; i >= 0; i--) {
      divideHeap(list, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      Collections.swap(list, i, 0);
      divideHeap(list, i, 0);
    }
    return this;
  }

  private void divideHeap(List<Ball> list, int n, int i) {
    int largest = i;
    int leftPartOfHeap = 2 * i ;
    int rightPartOfHeap = 2 * i + 1;

    if (leftPartOfHeap < n && compare(list.get(leftPartOfHeap), list.get(largest)) > 0) {
      largest = leftPartOfHeap;
    }

    if (rightPartOfHeap < n && compare(list.get(rightPartOfHeap), list.get(largest)) > 0) {
      largest = rightPartOfHeap;
    }

    if (largest != i) {
      Collections.swap(list, i, largest);
      divideHeap(list, n, largest);
    }
  }

  public SortService oddEvenSort(List<Ball> list) {
    boolean sorted = false;
    int n = list.size();
    while (!sorted) {
      sorted = true;
      for (int i = 1; i < n - 1; i += 2) {
        if (compare(list.get(i), list.get(i + 1)) > 0) {
          Collections.swap(list, i, i + 1);
          sorted = false;
        }
      }

      for (int i = 0; i < n - 1; i += 2) {
        if (compare(list.get(i), list.get(i + 1)) > 0) {
          Collections.swap(list, i, i + 1);
          sorted = false;
        }
      }
    }
    return this;
  }
}

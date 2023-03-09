package com.frizzer.ballsort.service;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.sort.HeapSort;
import com.frizzer.ballsort.service.sort.MergeSort;
import com.frizzer.ballsort.service.sort.OddEvenSort;
import com.frizzer.ballsort.service.sort.ParallelOddEvenSort;
import com.frizzer.ballsort.service.sort.QuickSort;
import java.util.List;

public class SortService {

  protected SortBy sortBy = SortBy.SIZE;

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

  public SortService parallelOddEvenSort(List<Ball> list) {
    if(preconditions(list)) {
      new ParallelOddEvenSort().sort(list, sortBy);
    }
    return this;
  }

  public SortService mergeSort(List<Ball> list) {
    if(preconditions(list)) {
      new MergeSort().sort(list, sortBy);
    }
    return this;
  }

  public SortService quickSort(List<Ball> list) {
    if(preconditions(list)) {
      new QuickSort().sort(list, sortBy);
    }
    return this;
  }

  public SortService heapSort(List<Ball> list) {
    if(preconditions(list)) {
      new HeapSort().sort(list, sortBy);
    }
    return this;
  }


  public SortService oddEvenSort(List<Ball> list) {
    if(preconditions(list)) {
      new OddEvenSort().sort(list, sortBy);
    }
    return this;
  }

  private boolean preconditions(List<Ball> list) {
    boolean preconditions = true;
    if (list == null) {
      throw new IllegalArgumentException("Null is not allowed");
    } else if (list.size() <= 1){
      preconditions = false;
    }
    return preconditions;
  }
}

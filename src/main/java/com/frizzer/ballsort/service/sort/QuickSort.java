package com.frizzer.ballsort.service.sort;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.Sort;
import com.frizzer.ballsort.service.SortBy;
import java.util.Collections;
import java.util.List;

public class QuickSort implements Sort {

  @Override
  public void sort(List<Ball> list, SortBy sortBy) {
    quickSortBody(list, 0, list.size() - 1,sortBy);
  }

  private void quickSortBody(List<Ball> list, int begin, int end, SortBy sortBy) {
    if (begin < end) {
      int partitionIndex = partition(list, begin, end,sortBy);
      quickSortBody(list, begin, partitionIndex - 1,sortBy);
      quickSortBody(list, partitionIndex + 1, end,sortBy);
    }
  }

  private int partition(List<Ball> list, int begin, int end,SortBy sortBy) {
    Ball pivot = list.get(end);
    int i = (begin - 1);
    for (int j = begin; j < end; j++) {
      if (compare(list.get(j), pivot,sortBy) <= 0) {
        i++;
        Collections.swap(list, i, j);
      }
    }
    Collections.swap(list, i + 1, end);
    return i + 1;
  }

}

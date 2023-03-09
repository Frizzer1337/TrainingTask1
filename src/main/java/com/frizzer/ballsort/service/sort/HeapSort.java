package com.frizzer.ballsort.service.sort;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.Sort;
import com.frizzer.ballsort.service.SortBy;
import java.util.Collections;
import java.util.List;

public class HeapSort implements Sort {

  @Override
  public void sort(List<Ball> list, SortBy sortBy) {
    heapSortBody(list, sortBy);
  }

  public void heapSortBody(List<Ball> list, SortBy sortBy) {
    int n = list.size();

    for (int i = n / 2 - 1; i >= 0; i--) {
      divideHeap(list, n, i ,sortBy);
    }

    for (int i = n - 1; i > 0; i--) {
      Collections.swap(list, i, 0);
      divideHeap(list, i, 0, sortBy);
    }
  }

  private void divideHeap(List<Ball> list, int n, int i, SortBy sortBy) {
    int largest = i;
    int leftPartOfHeap = 2 * i ;
    int rightPartOfHeap = 2 * i + 1;

    if (leftPartOfHeap < n && compare(list.get(leftPartOfHeap), list.get(largest),sortBy) > 0) {
      largest = leftPartOfHeap;
    }

    if (rightPartOfHeap < n && compare(list.get(rightPartOfHeap), list.get(largest),sortBy) > 0) {
      largest = rightPartOfHeap;
    }

    if (largest != i) {
      Collections.swap(list, i, largest);
      divideHeap(list, n, largest, sortBy);
    }
  }
}

package com.frizzer.ballsort.service.sort;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.Sort;
import com.frizzer.ballsort.service.SortBy;
import java.util.Collections;
import java.util.List;

public class OddEvenSort implements Sort {

  @Override
  public void sort(List<Ball> list, SortBy sortBy) {
    oddEvenSortBody(list, sortBy);
  }

  public void oddEvenSortBody(List<Ball> list, SortBy sortBy) {
    boolean sorted = false;
    int n = list.size();
    while (!sorted) {
      sorted = true;
      for (int i = 1; i < n - 1; i += 2) {
        if (compare(list.get(i), list.get(i + 1),sortBy) > 0) {
          Collections.swap(list, i, i + 1);
          sorted = false;
        }
      }

      for (int i = 0; i < n - 1; i += 2) {
        if (compare(list.get(i), list.get(i + 1),sortBy) > 0) {
          Collections.swap(list, i, i + 1);
          sorted = false;
        }
      }
    }
  }

}

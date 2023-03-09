package com.frizzer.ballsort.service.sort;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.service.Sort;
import com.frizzer.ballsort.service.SortBy;
import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {

  @Override
  public void sort(List<Ball> list, SortBy sortBy) {
    mergeSortBody(list,sortBy);
  }
  private void mergeSortBody(List<Ball> list,SortBy sortBy) {
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
      mergeSortBody(left,sortBy);
      mergeSortBody(right,sortBy);
      merge(left, right, list, sortBy);
    }
  }

  private void merge(List<Ball> left, List<Ball> right, List<Ball> list, SortBy sortBy) {
    int leftIndex = 0;
    int rightIndex = 0;
    int originalIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {

      if (compare(left.get(leftIndex), right.get(rightIndex),sortBy) < 0) {
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

}

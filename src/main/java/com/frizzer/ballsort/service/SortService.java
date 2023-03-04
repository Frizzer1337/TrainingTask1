package com.frizzer.ballsort.service;

import com.frizzer.ballsort.entity.Ball;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortService {

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

  public List<Ball> mergeSort(List<Ball> balls) {

    List<Ball> left = new ArrayList<>();
    List<Ball> right = new ArrayList<>();
    int center;

    if (balls.size() == 1) {
      return balls;
    } else {
      center = balls.size() / 2;
      for (int i = 0; i < center; i++) {
        left.add(balls.get(i));
      }
      for (int i = center; i < balls.size(); i++) {
        right.add(balls.get(i));
      }
      left = mergeSort(left);
      right = mergeSort(right);
      merge(left, right, balls);
    }
    return balls;
  }

  public int compare(Ball leftBall, Ball rightBall) {
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

  public void merge(List<Ball> left, List<Ball> right, List<Ball> balls) {
    int leftIndex = 0;
    int rightIndex = 0;
    int wholeIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
        balls.set(wholeIndex, left.get(leftIndex));
        leftIndex++;
      } else {
        balls.set(wholeIndex, right.get(rightIndex));
        rightIndex++;
      }
      wholeIndex++;
    }

    List<Ball> rest;
    int restIndex;
    if (leftIndex >= left.size()) {
      rest = right;
      restIndex = rightIndex;
    } else {
      rest = left;
      restIndex = leftIndex;
    }

    for (int i = restIndex; i < rest.size(); i++) {
      balls.set(wholeIndex, rest.get(i));
      wholeIndex++;
    }
  }

  public void quickSort(List<Ball> list){
    quickSort(list,0,list.size()-1);
  }

  public void quickSort(List<Ball> list, int begin, int end) {
    if (begin < end) {
      int partitionIndex = partition(list, begin, end);
      quickSort(list, begin, partitionIndex-1);
      quickSort(list, partitionIndex+1, end);
    }
  }

  private int partition(List<Ball> list, int begin, int end) {
    Ball pivot = list.get(end);
    int i = (begin-1);
    for (int j = begin; j < end; j++) {
      if (compare(list.get(j),pivot) <= 0) {
        i++;
        Collections.swap(list,i,j);
      }
    }
    Collections.swap(list,i+1,end);
    return i+1;
  }

}

enum SortBy {
  SIZE,
  COLOR,
  TYPE
}

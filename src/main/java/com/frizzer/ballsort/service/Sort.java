package com.frizzer.ballsort.service;

import com.frizzer.ballsort.entity.Ball;
import java.util.List;

public interface Sort {
  void sort(List<Ball> list, SortBy sortBy);

  default int compare(Ball leftBall, Ball rightBall, SortBy sortBy){
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
}

package com.frizzer.ballsort.entity.ball;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.Color;

public class TennisBall extends Ball {

  public TennisBall(int size, Color color) {
    super(BallType.TENNIS);
    this.color = color;
    this.size = size;
  }

  @Override
  public String toString() {
    return "TennisBall{" +
        "size=" + size +
        ", color=" + color +
        ", type=" + type +
        '}';
  }
}

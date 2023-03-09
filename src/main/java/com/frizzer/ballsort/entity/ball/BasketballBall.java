package com.frizzer.ballsort.entity.ball;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.Color;

public class BasketballBall extends Ball {

  public BasketballBall(int size, Color color) {
    super(BallType.BASKETBALL);
    this.color = color;
    this.size = size;
  }

  @Override
  public String toString() {
    return "BasketballBall{" +
        "size=" + size +
        ", color=" + color +
        ", type=" + type +
        '}';
  }
}

package com.frizzer.ballsort.entity.ball;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.Color;

public class VolleyballBall extends Ball {

  public VolleyballBall(int size, Color color) {
    super(BallType.VOLLEYBALL);
    this.color = color;
    this.size = size;
  }

  @Override
  public String toString() {
    return "VolleyballBall{" +
        "size=" + size +
        ", color=" + color +
        ", type=" + type +
        '}';
  }
}

package com.frizzer.ballsort.entity.ball;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.Color;

public class FootballBall extends Ball {

  public FootballBall(int size, Color color) {
    super(BallType.FOOTBALL);
    this.color = color;
    this.size = size;
  }

  @Override
  public String toString() {
    return "FootballBall{" +
        "size=" + size +
        ", color=" + color +
        ", type=" + type +
        '}';
  }
}

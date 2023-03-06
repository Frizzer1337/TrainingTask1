package com.frizzer.ballsort.entity;

public class BasketballBall extends Ball{
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

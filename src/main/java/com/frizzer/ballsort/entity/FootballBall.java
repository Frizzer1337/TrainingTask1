package com.frizzer.ballsort.entity;

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

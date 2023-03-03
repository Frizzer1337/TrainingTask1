package com.frizzer.ballsort.entity;

public abstract class Ball{
  private int size;
  private Color color;
  private BallType type;

  protected Ball(int size, Color color,BallType type){
    this.size = size;
    this.color = color;
    this.type = type;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public BallType getType() {
    return type;
  }

  public void setType(BallType type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Ball ball = (Ball) o;

    if (size != ball.size) {
      return false;
    }
    if (!color.equals(ball.color)) {
      return false;
    }
    return type == ball.type;
  }

  @Override
  public int hashCode() {
    int result = size;
    result = 31 * result + color.hashCode();
    result = 31 * result + type.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Ball{" +
        "size=" + size +
        ", color=" + color +
        ", type=" + type +
        '}';
  }

}

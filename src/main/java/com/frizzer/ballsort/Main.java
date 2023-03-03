package com.frizzer.ballsort;


import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.Color;

public class Main {

  public static void main(String[] args) {

    Ball basketBall = new BasketballBall(10,new Color("red","deep"), BallType.BASKETBALL);
    System.out.println(basketBall);

  }
}
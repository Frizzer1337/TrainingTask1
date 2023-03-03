package com.frizzer.ballsort;

import com.frizzer.ballsort.factory.BallFactory;

public class Main {

  public static void main(String[] args) {
    BallFactory ballFactory = new BallFactory();
    System.out.println(ballFactory.createBall("BASKETBALL").getClass());

  }
}